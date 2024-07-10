package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;
import br.com.fiap.car.reg.application.port.UpdateVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class UpdateVehicleUseCase implements UpdateVehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public UpdateVehicleResponse updateVehicle(UpdateVehicleDto dto) {
        Vehicle existingVehicle = vehicleRepositoryPort.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));

        modelMapper.map(dto, existingVehicle);

        Vehicle updatedVehicle = vehicleRepositoryPort.save(existingVehicle);
        return modelMapper.map(updatedVehicle, UpdateVehicleResponse.class);
    }
}
