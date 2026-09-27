package com.agrocontroll.predio;

import com.agrocontroll.predio.domain.Predio;
import com.agrocontroll.predio.exception.NombrePredioDuplicadoException;
import com.agrocontroll.predio.exception.PredioNoEncontradoException;
import com.agrocontroll.predio.port.PredioRepository;

import java.util.List;

public class PredioService {

    private final PredioRepository predioRepository;

    // Inyección de dependencias por constructor
    public PredioService(PredioRepository predioRepository) {
        this.predioRepository = predioRepository;
    }

    // Regla de negocio 1: Registrar predio verificando que el nombre no esté duplicado
    public Predio registrarPredio(Predio predio) {
        if (predioRepository.existePorNombre(predio.getNombre())) {
            throw new NombrePredioDuplicadoException(predio.getNombre());
        }
        return predioRepository.guardar(predio);
    }

    // Regla de negocio 2: Buscar predio o lanzar excepción si no existe
    public Predio obtenerPorId(Long id) {
        return predioRepository.buscarPorId(id)
                .orElseThrow(() -> new PredioNoEncontradoException(id));
    }

    // Listar todos los predios
    public List<Predio> listarTodos() {
        return predioRepository.listarTodos();
    }
}