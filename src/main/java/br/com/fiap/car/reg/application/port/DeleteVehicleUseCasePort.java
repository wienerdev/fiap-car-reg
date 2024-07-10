package br.com.fiap.car.reg.application.port;

import org.webjars.NotFoundException;

public interface DeleteVehicleUseCasePort {

    void deleteVehicleById(Long id) throws NotFoundException;
}
