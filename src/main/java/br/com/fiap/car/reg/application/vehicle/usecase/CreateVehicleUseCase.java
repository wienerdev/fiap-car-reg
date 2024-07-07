package br.com.fiap.car.reg.application.vehicle.usecase;

import br.com.fiap.car.reg.application.interfaces.VehicleRepository;
import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.application.vehicle.port.CreateVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateVehicleUseCase implements CreateVehicleUseCasePort {

    private final VehicleRepository vehicleRepository;
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

        return modelMapper.map(vehicleRepository.save(vehicle), CreateVehicleResponse.class);
    }
}
