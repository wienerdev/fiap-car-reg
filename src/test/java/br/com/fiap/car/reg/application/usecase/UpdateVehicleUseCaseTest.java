package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;
import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import br.com.fiap.car.reg.utils.VehicleTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UpdateVehicleUseCaseTest {

    @Mock
    private VehicleRepositoryPort vehicleRepositoryPort;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UpdateVehicleUseCase updateVehicleUseCase;

    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void updatesVehicleSuccessfully() {
        UpdateVehicleDto dto = new UpdateVehicleDto(VehicleTestUtils.generateUpdateVehicleDto());
        Vehicle existingVehicle = new Vehicle(VehicleTestUtils.generateVehicle());
        Vehicle updatedVehicle = new Vehicle(VehicleTestUtils.generateUpdatedVehicle());
        UpdateVehicleResponse expectedResponse = new UpdateVehicleResponse(VehicleTestUtils.generateUpdateVehicleResponse());

        when(vehicleRepositoryPort.findById(dto.getId())).thenReturn(Optional.of(existingVehicle));
        when(vehicleRepositoryPort.save(any(Vehicle.class))).thenReturn(updatedVehicle);
        when(modelMapper.map(any(Vehicle.class), eq(UpdateVehicleResponse.class))).thenReturn(expectedResponse);

        UpdateVehicleResponse actualResponse = updateVehicleUseCase.updateVehicle(dto);

        assertEquals(expectedResponse, actualResponse);
        verify(vehicleRepositoryPort).findById(dto.getId());
        verify(vehicleRepositoryPort).save(any(Vehicle.class));
        verify(modelMapper).map(any(Vehicle.class), eq(UpdateVehicleResponse.class));
    }

    @Test
    void throwsNotFoundExceptionWhenVehicleDoesNotExist() {
        UpdateVehicleDto dto = new UpdateVehicleDto(VehicleTestUtils.generateUpdateVehicleDto());

        when(vehicleRepositoryPort.findById(dto.getId())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> updateVehicleUseCase.updateVehicle(dto));
    }

    @Test
    void setUpdateVehicleDto() {
        UpdateVehicleDto dto = new UpdateVehicleDto();
        LocalDateTime now = LocalDateTime.now();
        dto.setId(1L);
        dto.setMarca("Ford");
        dto.setModelo("Ka");
        dto.setAno(2021);
        dto.setPreco(new BigDecimal(50000));
        dto.setPlaca("ABC1234");
        dto.setStatus(VehicleStatusEnum.DISPONIVEL);
        dto.setDataCadastro(now);
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getMarca()).isEqualTo("Ford");
        assertThat(dto.getModelo()).isEqualTo("Ka");
        assertThat(dto.getAno()).isEqualTo(2021);
        assertThat(dto.getPreco()).isEqualTo(new BigDecimal(50000));
        assertThat(dto.getPlaca()).isEqualTo("ABC1234");
        assertThat(dto.getStatus()).isEqualTo(VehicleStatusEnum.DISPONIVEL);
        assertThat(dto.getDataCadastro()).isEqualTo(now);
    }


}