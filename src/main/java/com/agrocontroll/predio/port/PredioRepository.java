package com.agrocontroll.predio.domain;
import java.util. Optional;
public interface PredioRepository {
     Predio guardar(Predio predio);
     Optional<Predio> buscarPorId(long id);

}
