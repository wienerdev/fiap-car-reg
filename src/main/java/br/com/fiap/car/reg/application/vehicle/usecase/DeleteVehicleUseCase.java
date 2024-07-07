package br.com.fiap.car.reg.application.vehicle.usecase;

import br.com.fiap.car.reg.application.interfaces.VehicleRepository;
import br.com.fiap.car.reg.application.vehicle.port.DeleteVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class DeleteVehicleUseCase implements DeleteVehicleUseCasePort {

    private final VehicleRepository vehicleRepository;

    @Override
    public void deleteVehicleById(Long id) throws NotFoundException {
        Vehicle vehicle =  vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));
        vehicleRepository.deleteById(vehicle.getId());
    }
}
