package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.utils.VehicleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.webjars.NotFoundException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class DeleteVehicleUseCaseTest {

    @Mock
    private VehicleRepositoryPort vehicleRepositoryPort;

    @InjectMocks
    private DeleteVehicleUseCase deleteVehicleUseCase;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void deletionSucceedsWithExistingVehicle() {
        Long vehicleId = 1L;
        Vehicle vehicle = new Vehicle(VehicleTestUtils.generateVehicle());
        when(vehicleRepositoryPort.findById(vehicleId)).thenReturn(Optional.of(vehicle));

        assertDoesNotThrow(() -> deleteVehicleUseCase.deleteVehicleById(vehicleId));

        verify(vehicleRepositoryPort).deleteById(vehicleId);
    }

    @Test
    void throwsNotFoundExceptionForNonexistentVehicle() {
        Long invalidVehicleId = 999L;
        when(vehicleRepositoryPort.findById(invalidVehicleId)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> deleteVehicleUseCase.deleteVehicleById(invalidVehicleId));
    }
}