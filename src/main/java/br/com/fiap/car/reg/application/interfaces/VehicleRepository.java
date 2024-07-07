package br.com.fiap.car.reg.application.interfaces;

import br.com.fiap.car.reg.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {

    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    Vehicle save(Vehicle vehicle);
    void deleteById(Long id);
}
