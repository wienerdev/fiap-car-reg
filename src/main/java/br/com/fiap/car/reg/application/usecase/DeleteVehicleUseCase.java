package br.com.fiap.car.reg.application.usecase;

import br.com.fiap.car.reg.application.port.VehicleRepositoryPort;
import br.com.fiap.car.reg.application.port.DeleteVehicleUseCasePort;
import br.com.fiap.car.reg.domain.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class DeleteVehicleUseCase implements DeleteVehicleUseCasePort {

    private final VehicleRepositoryPort vehicleRepositoryPort;

    @Override
    public void deleteVehicleById(Long id) throws NotFoundException {
        Vehicle vehicle =  vehicleRepositoryPort.findById(id).orElseThrow(() -> new NotFoundException("Veículo não existente na base de dados."));
        vehicleRepositoryPort.deleteById(vehicle.getId());
    }
}
