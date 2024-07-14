package br.com.fiap.car.reg.application.port;

import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;

import java.util.List;

public interface FindVehicleUseCasePort {

    List<FindVehicleResponse> findAllVehicles() throws Exception;
    FindVehicleResponse findVehicleById(Long id);
}
