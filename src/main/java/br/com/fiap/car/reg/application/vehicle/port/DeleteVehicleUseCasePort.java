package br.com.fiap.car.reg.application.vehicle.port;

import org.webjars.NotFoundException;

public interface DeleteVehicleUseCasePort {

    void deleteVehicleById(Long id) throws NotFoundException;
}
