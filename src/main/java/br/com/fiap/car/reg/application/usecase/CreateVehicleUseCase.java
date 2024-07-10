package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.application.port.CreateVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateVehicleUseCase implements CreateVehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public CreateVehicleResponse createVehicle(CreateVehicleDto dto) {
        Vehicle vehicle = Vehicle.builder()
                .marca(dto.getMarca())
                .modelo(dto.getModelo())
                .ano(dto.getAno())
                .cor(dto.getCor())
                .preco(dto.getPreco())
                .quilometragem(dto.getQuilometragem())
                .tipoCombustivel(dto.getTipoCombustivel())
                .numeroPortas(dto.getNumeroPortas())
                .tipoTransmissao(dto.getTipoTransmissao())
                .numeroChassi(dto.getNumeroChassi())
                .placa(dto.getPlaca())
                .descricao(dto.getDescricao())
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build();

        return modelMapper.map(vehicleRepositoryPort.save(vehicle), CreateVehicleResponse.class);
    }
}
