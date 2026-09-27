package com.agrocontroll.predio.port;

import com.agrocontroll.predio.domain.Predio;
import java.util.List;
import java.util.Optional;

public interface PredioRepository {
     Predio guardar(Predio predio);
     Optional<Predio> buscarPorId(Long id);
     List<Predio> listarTodos();
     boolean existePorNombre(String nombre);
}