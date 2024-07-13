package br.com.fiap.car.reg.application.port;

import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;

public interface CreateVehicleUseCasePort {

    CreateVehicleResponse createVehicle(CreateVehicleDto dto);
}