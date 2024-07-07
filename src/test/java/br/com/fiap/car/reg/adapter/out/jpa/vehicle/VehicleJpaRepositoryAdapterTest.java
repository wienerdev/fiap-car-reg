package br.com.fiap.car.reg.adapter.out.jpa.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.fiap.car.reg.adapter.out.jpa.VehicleJpaRepositoryAdapter;
import br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities.VehicleEntity;
import br.com.fiap.car.reg.adapter.out.jpa.vehicle.repositories.VehicleJpaRepository;
import br.com.fiap.car.reg.domain.Vehicle;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class VehicleJpaRepositoryAdapterTest {

    @Mock
    private VehicleJpaRepository vehicleJpaRepository;

    @InjectMocks
    private VehicleJpaRepositoryAdapter vehicleJpaRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllReturnsListOfVehicles() {
        VehicleEntity vehicleEntity1 = mock(VehicleEntity.class);
        VehicleEntity vehicleEntity2 = mock(VehicleEntity.class);
        when(vehicleJpaRepository.findAll()).thenReturn(Arrays.asList(vehicleEntity1, vehicleEntity2));
        when(vehicleEntity1.toDomain()).thenReturn(new Vehicle());
        when(vehicleEntity2.toDomain()).thenReturn(new Vehicle());

        List<Vehicle> vehicles = vehicleJpaRepositoryAdapter.findAll();

        assertEquals(2, vehicles.size());
    }

    @Test
    void findByIdReturnsVehicleForValidId() {
        Long validId = 1L;
        VehicleEntity vehicleEntity = mock(VehicleEntity.class);
        when(vehicleJpaRepository.findById(validId)).thenReturn(Optional.of(vehicleEntity));
        when(vehicleEntity.toDomain()).thenReturn(new Vehicle());

        Optional<Vehicle> vehicle = vehicleJpaRepositoryAdapter.findById(validId);

        assertTrue(vehicle.isPresent());
    }

    @Test
    void findByIdReturnsEmptyForInvalidId() {
        Long invalidId = 999L;
        when(vehicleJpaRepository.findById(invalidId)).thenReturn(Optional.empty());

        Optional<Vehicle> vehicle = vehicleJpaRepositoryAdapter.findById(invalidId);

        assertTrue(vehicle.isEmpty());
    }

    @Test
    void savePersistsVehicleAndReturnsIt() {
        Vehicle vehicle = mock(Vehicle.class);
        VehicleEntity vehicleEntity = mock(VehicleEntity.class);
        when(vehicle.toEntity()).thenReturn(vehicleEntity);
        when(vehicleJpaRepository.save(vehicleEntity)).thenReturn(vehicleEntity);
        when(vehicleEntity.toDomain()).thenReturn(vehicle);

        Vehicle savedVehicle = vehicleJpaRepositoryAdapter.save(vehicle);

        assertEquals(vehicle, savedVehicle);
    }

    @Test
    void deleteByIdDeletesVehicle() {
        Long vehicleId = 1L;
        doNothing().when(vehicleJpaRepository).deleteById(vehicleId);

        vehicleJpaRepositoryAdapter.deleteById(vehicleId);

        verify(vehicleJpaRepository).deleteById(vehicleId);
    }
}