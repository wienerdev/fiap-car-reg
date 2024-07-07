package br.com.fiap.car.reg.application.vehicle.port;

import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;

import java.util.List;

public interface FindVehicleUseCasePort {

    List<FindVehicleResponse> findAllVehicles();
    FindVehicleResponse findVehicleById(Long id);
}
