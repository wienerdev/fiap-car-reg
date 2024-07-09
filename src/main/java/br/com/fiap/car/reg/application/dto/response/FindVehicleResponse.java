package br.com.fiap.car.reg.application.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FindVehicleResponse extends BaseVehicleResponse {

    public FindVehicleResponse(BaseVehicleResponse createVehicleResponse) {
        super(createVehicleResponse);
    }
}
