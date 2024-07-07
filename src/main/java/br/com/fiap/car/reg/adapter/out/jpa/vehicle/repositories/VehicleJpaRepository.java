package br.com.fiap.car.reg.adapter.out.jpa.vehicle.repositories;

import br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleJpaRepository extends JpaRepository<VehicleEntity, Long> {
}
