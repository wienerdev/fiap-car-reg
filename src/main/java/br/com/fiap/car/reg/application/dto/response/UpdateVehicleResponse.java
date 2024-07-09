package br.com.fiap.car.reg.application.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UpdateVehicleResponse extends BaseVehicleResponse {

    public UpdateVehicleResponse(BaseVehicleResponse updateVehicleResponse) {
        super(updateVehicleResponse);
    }
}
