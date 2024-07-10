package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.port.FindVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindVehicleUseCase implements FindVehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public List<FindVehicleResponse> findAllVehicles() {
        return vehicleRepositoryPort.findAll().stream()
                .map(entity -> modelMapper.map(entity, FindVehicleResponse.class)).toList();}

    @Override
    public FindVehicleResponse findVehicleById(Long id) {
        Vehicle vehicle = vehicleRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));
        return modelMapper.map(vehicle, FindVehicleResponse.class);
    }
}
