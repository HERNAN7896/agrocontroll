package com.agrocontroll;

import com.agrocontroll.predio.domain.Predio;
import com.agrocontroll.predio.domain.Parcela;
import com.agrocontroll.usuario.domain.Usuario;
import com.agrocontroll.usuario.domain.Rol;
import com.agrocontroll.labor.domain.Labor;
import com.agrocontroll.labor.domain.EstadoLabor;
import com.agrocontroll.predio.PredioService;
import com.agrocontroll.predio.port.PredioRepository;
import com.agrocontroll.predio.infraestructure.memory.PredioRepositoryEnMemoria;
public class Main {
    public static void main(String[] args) {
        // 1. Crear un predio y agregarle una parcela
        Predio miPredio = new Predio(1L, "Finca San José", "Santa Cruz");
        Parcela miParcela = new Parcela(101L, "PAR-01", 50.5);
        miPredio.agregarParcela(miParcela);

        // 2. Crear un usuario
        Usuario usuario = new Usuario(1L, "Carlos Perez", "carlos@agro.com", Rol.ADMIN);

        // 3. Crear una labor usando el Enum
        Labor labor = new Labor(1001L, "Fumigación de Soya", "Aplicación de plaguicida", EstadoLabor.PLANIFICADA);

        // 4. Imprimir los datos en la consola
        System.out.println("=== PRUEBA DE SISTEMA AGROCONTROL ===");
        System.out.println("Predio: " + miPredio.getNombre() + " (" + miPredio.getUbicacion() + ")");
        System.out.println("Parcelas asociadas: " + miPredio.getParcelas().size());
        System.out.println("Usuario Creado: " + usuario.getNombre() + " | Rol: " + usuario.getRol());
        System.out.println("Labor: " + labor.getNombre() + " | Estado: " + labor.getEstado());

        //
        // === CAPÍTULO 2: PRUEBAS DE SERVICIO Y REPOSITORIO ========
        // ==========================================================
        System.out.println("\n\n=== INICIANDO PRUEBAS CAPÍTULO 2 ===");

        // 1. Instanciamos la "Base de Datos" en RAM
        PredioRepository repositorioEnMemoria = new PredioRepositoryEnMemoria();

        // 2. Inyectamos la base de datos al cerebro (Servicio)
        PredioService predioService = new PredioService(repositorioEnMemoria);

        try {
            // 3. Prueba de Éxito: Registrar un predio nuevo
            Predio finca1 = new Predio(10L, "Finca La Esperanza", "Santa Cruz");
            predioService.registrarPredio(finca1);
            System.out.println("✅ ÉXITO: Predio registrado -> " + finca1.getNombre());

            // 4. Prueba de Falla 1: Intentar registrar un nombre duplicado
            System.out.println("\n--- Intentando registrar duplicado ---");
            Predio finca2 = new Predio(11L, "Finca La Esperanza", "Beni");
            predioService.registrarPredio(finca2); // Esto debe disparar la excepción

        } catch (RuntimeException e) {
            System.out.println("❌ ERROR DE NEGOCIO ATRAPADO: " + e.getMessage());
        }

        try {
            // 5. Prueba de Falla 2: Buscar un ID que no existe (ejemplo: ID 99)
            System.out.println("\n--- Intentando buscar un ID inexistente ---");
            predioService.obtenerPorId(99L); // Esto debe disparar la excepción

        } catch (RuntimeException e) {
            System.out.println("❌ ERROR DE BÚSQUEDA ATRAPADO: " + e.getMessage());
        }
    }

}
