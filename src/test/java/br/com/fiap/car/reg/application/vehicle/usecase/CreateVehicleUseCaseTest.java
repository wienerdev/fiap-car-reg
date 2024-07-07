package br.com.fiap.car.reg.application.vehicle.usecase;

import br.com.fiap.car.reg.application.interfaces.VehicleRepository;
import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import br.com.fiap.car.reg.utils.VehicleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class CreateVehicleUseCaseTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private CreateVehicleUseCase createVehicleUseCase;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void shouldCreateVehicleSuccessfully() {
        CreateVehicleDto dto = new CreateVehicleDto(VehicleTestUtils.generateCreateVehicleDto());
        Vehicle vehicle = new Vehicle(VehicleTestUtils.generateVehicle());
        CreateVehicleResponse expectedResponse = new CreateVehicleResponse(VehicleTestUtils.generateCreateVehicleResponse());

        when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicle);
        when(modelMapper.map(any(Vehicle.class), eq(CreateVehicleResponse.class))).thenReturn(expectedResponse);

        CreateVehicleResponse actualResponse = createVehicleUseCase.createVehicle(dto);

        assertEquals(expectedResponse, actualResponse);
        assertEquals(VehicleStatusEnum.DISPONIVEL, actualResponse.getStatus());
        verify(vehicleRepository).save(any(Vehicle.class));
        verify(modelMapper).map(any(Vehicle.class), eq(CreateVehicleResponse.class));
    }
}