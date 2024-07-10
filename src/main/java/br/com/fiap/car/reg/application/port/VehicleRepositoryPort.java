package br.com.fiap.car.reg.application.port;

import br.com.fiap.car.reg.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepositoryPort {

    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    Vehicle save(Vehicle vehicle);
    void deleteById(Long id);
}
