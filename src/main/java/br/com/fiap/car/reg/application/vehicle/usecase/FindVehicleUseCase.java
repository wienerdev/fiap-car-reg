package br.com.fiap.car.reg.application.vehicle.usecase;

import br.com.fiap.car.reg.application.interfaces.VehicleRepository;
import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.vehicle.port.FindVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindVehicleUseCase implements FindVehicleUseCasePort {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FindVehicleResponse> findAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(entity -> modelMapper.map(entity, FindVehicleResponse.class)).toList();}

    @Override
    public FindVehicleResponse findVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));
        return modelMapper.map(vehicle, FindVehicleResponse.class);
    }
}
