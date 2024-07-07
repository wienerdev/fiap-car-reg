package br.com.fiap.car.reg.adapter.out.jpa;

import br.com.fiap.car.reg.application.interfaces.VehicleRepository;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities.VehicleEntity;
import br.com.fiap.car.reg.adapter.out.jpa.vehicle.repositories.VehicleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleJpaRepositoryAdapter implements VehicleRepository {

    private final VehicleJpaRepository vehicleJpaRepository;


    @Override
    public List<Vehicle> findAll() {
        return vehicleJpaRepository.findAll().stream().map(VehicleEntity::toDomain).toList();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleJpaRepository.findById(id)
                .map(VehicleEntity::toDomain);
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleJpaRepository.save(vehicle.toEntity()).toDomain();
    }

    @Override
    public void deleteById(Long id) {
        vehicleJpaRepository.deleteById(id);
    }
}
