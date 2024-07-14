package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.port.FindVehicleUseCasePort;
import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindVehicleUseCase implements FindVehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepositoryPort;
    private final ModelMapper modelMapper;

    @Override
    public List<FindVehicleResponse> findAllVehicles() throws Exception {
        try {
            return vehicleRepositoryPort.findAll().stream()
                    .map(entity -> modelMapper.map(entity, FindVehicleResponse.class)).toList();
        } catch (Exception e) {
            log.error("Error while executing findAllVehicles: ", e);
            throw new Exception(e);
        }
    }


    @Override
    public FindVehicleResponse findVehicleById(Long id) {
        Vehicle vehicle = vehicleRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));
        return modelMapper.map(vehicle, FindVehicleResponse.class);
    }
}
