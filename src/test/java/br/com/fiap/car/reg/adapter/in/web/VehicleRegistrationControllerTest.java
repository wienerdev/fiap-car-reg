package br.com.fiap.car.reg.adapter.in.web;

import br.com.fiap.car.reg.utils.VehicleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;
import br.com.fiap.car.reg.application.vehicle.port.CreateVehicleUseCasePort;
import br.com.fiap.car.reg.application.vehicle.port.DeleteVehicleUseCasePort;
import br.com.fiap.car.reg.application.vehicle.port.FindVehicleUseCasePort;
import br.com.fiap.car.reg.application.vehicle.port.UpdateVehicleUseCasePort;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class VehicleRegistrationControllerTest {

    @Mock
    private CreateVehicleUseCasePort createVehicleUseCase;
    @Mock
    private UpdateVehicleUseCasePort updateVehicleUseCase;
    @Mock
    private FindVehicleUseCasePort findVehicleUseCase;
    @Mock
    private DeleteVehicleUseCasePort deleteVehicleUseCase;

    @InjectMocks
    private VehicleRegistrationController vehicleRegistrationController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllVehiclesReturnsOkWithVehicleList() {
        when(findVehicleUseCase.findAllVehicles())
                .thenReturn(Arrays.asList(new FindVehicleResponse(VehicleTestUtils.generateFindVehicleResponse())));

        ResponseEntity<List<FindVehicleResponse>> response = vehicleRegistrationController.findAllVehicles();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void findVehicleByIdReturnsOkWithVehicle() {
        FindVehicleResponse findVehicleResponse = new FindVehicleResponse(VehicleTestUtils.generateFindVehicleResponse());
        when(findVehicleUseCase.findVehicleById(1L)).thenReturn(findVehicleResponse);

        ResponseEntity<FindVehicleResponse> response = vehicleRegistrationController.findVehicleById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(findVehicleResponse, response.getBody());
    }

    @Test
    void createVehicleReturnsCreatedWithVehicleResponse() {
        CreateVehicleDto createVehicleDto = new CreateVehicleDto(VehicleTestUtils.generateCreateVehicleDto());
        CreateVehicleResponse createVehicleResponse = new CreateVehicleResponse(VehicleTestUtils.generateCreateVehicleResponse());
        when(createVehicleUseCase.createVehicle(createVehicleDto)).thenReturn(createVehicleResponse);

        ResponseEntity<CreateVehicleResponse> response = vehicleRegistrationController.createVehicle(createVehicleDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createVehicleResponse, response.getBody());
    }

    @Test
    void updateVehicleReturnsOkWithUpdatedVehicle() throws Exception {
        UpdateVehicleDto updateVehicleDto = new UpdateVehicleDto(VehicleTestUtils.generateUpdateVehicleDto());
        UpdateVehicleResponse updateVehicleResponse = new UpdateVehicleResponse(VehicleTestUtils.generateUpdateVehicleResponse());
        when(updateVehicleUseCase.updateVehicle(updateVehicleDto)).thenReturn(updateVehicleResponse);

        ResponseEntity<UpdateVehicleResponse> response = vehicleRegistrationController.updateVehicle(updateVehicleDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updateVehicleResponse, response.getBody());
    }

    @Test
    void deleteVehicleByIdReturnsOk() {
        doNothing().when(deleteVehicleUseCase).deleteVehicleById(1L);

        ResponseEntity<Void> response = vehicleRegistrationController.deleteVehicleById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(deleteVehicleUseCase, times(1)).deleteVehicleById(1L);
    }
}