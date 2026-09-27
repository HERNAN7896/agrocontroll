package com.agrocontroll.predio.infraestructure.memory;

import com.agrocontroll.predio.domain.Predio;
import com.agrocontroll.predio.port.PredioRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PredioRepositoryEnMemoria implements PredioRepository {

    // Simula la tabla 'predio' en la memoria RAM
    private final Map<Long, Predio> datos = new LinkedHashMap<>();

    @Override
    public Predio guardar(Predio predio) {
        datos.put(predio.getId(), predio);
        return predio;
    }

    @Override
    public Optional<Predio> buscarPorId(Long id) {
        return Optional.ofNullable(datos.get(id));
    }

    @Override
    public List<Predio> listarTodos() {
        return new ArrayList<>(datos.values());
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return datos.values().stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));
    }
}