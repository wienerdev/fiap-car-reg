package br.com.fiap.car.reg.application.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CreateVehicleResponse extends BaseVehicleResponse {

    public CreateVehicleResponse(BaseVehicleResponse createVehicleResponse) {
        super(createVehicleResponse);
    }
}
