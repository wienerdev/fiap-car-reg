package br.com.fiap.car.reg.application.vehicle.port;

import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;

public interface UpdateVehicleUseCasePort {

    UpdateVehicleResponse updateVehicle(UpdateVehicleDto dto) throws Exception;
}
