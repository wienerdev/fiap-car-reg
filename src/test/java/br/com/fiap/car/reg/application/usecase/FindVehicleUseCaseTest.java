package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.utils.VehicleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class FindVehicleUseCaseTest {

    @Mock
    private VehicleRepositoryPort vehicleRepositoryPort;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private FindVehicleUseCase findVehicleUseCase;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void findAllVehiclesReturnsNonEmptyList() throws Exception {
        Vehicle vehicle = VehicleTestUtils.generateVehicle();
        List<Vehicle> vehicles = Arrays.asList(vehicle);
        FindVehicleResponse response = VehicleTestUtils.generateFindVehicleResponse();

        when(vehicleRepositoryPort.findAll()).thenReturn(vehicles);
        when(modelMapper.map(vehicle, FindVehicleResponse.class)).thenReturn(response);

        List<FindVehicleResponse> responses = findVehicleUseCase.findAllVehicles();

        assertEquals(1, responses.size());
        verify(vehicleRepositoryPort).findAll();
        verify(modelMapper, times(1)).map(any(Vehicle.class), eq(FindVehicleResponse.class));
    }

    @Test
    void findAllVehiclesReturnsEmptyList() throws Exception {
        when(vehicleRepositoryPort.findAll()).thenReturn(Arrays.asList());

        List<FindVehicleResponse> responses = findVehicleUseCase.findAllVehicles();

        assertEquals(0, responses.size());
        verify(vehicleRepositoryPort).findAll();
    }

    @Test
    void findVehicleByIdReturnsCorrectVehicle() {
        Long vehicleId = 1L;
        Vehicle vehicle = VehicleTestUtils.generateVehicle();
        FindVehicleResponse expectedResponse = VehicleTestUtils.generateFindVehicleResponse();

        when(vehicleRepositoryPort.findById(vehicleId)).thenReturn(java.util.Optional.of(vehicle));
        when(modelMapper.map(vehicle, FindVehicleResponse.class)).thenReturn(expectedResponse);

        FindVehicleResponse actualResponse = findVehicleUseCase.findVehicleById(vehicleId);

        assertEquals(expectedResponse, actualResponse);
        verify(vehicleRepositoryPort).findById(vehicleId);
        verify(modelMapper).map(vehicle, FindVehicleResponse.class);
    }

    @Test
    void findVehicleByIdThrowsNotFoundException() {
        Long invalidVehicleId = 999L;
        when(vehicleRepositoryPort.findById(invalidVehicleId)).thenReturn(java.util.Optional.empty());

        assertThrows(NotFoundException.class, () -> findVehicleUseCase.findVehicleById(invalidVehicleId));
    }
}