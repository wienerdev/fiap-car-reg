package br.com.fiap.car.reg.utils;

import br.com.fiap.car.reg.application.dto.request.CreateVehicleDto;
import br.com.fiap.car.reg.application.dto.request.UpdateVehicleDto;
import br.com.fiap.car.reg.application.dto.response.BaseVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.CreateVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.FindVehicleResponse;
import br.com.fiap.car.reg.application.dto.response.UpdateVehicleResponse;
import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VehicleTestUtils {

    private VehicleTestUtils() {
    }

    public static CreateVehicleDto generateCreateVehicleDto() {
        return CreateVehicleDto.builder()
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .build();
    }

    public static CreateVehicleResponse generateCreateVehicleResponse() {
        return new CreateVehicleResponse(BaseVehicleResponse.builder()
                .id(1L)
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build());
    }

    public static Vehicle generateVehicle() {
        return Vehicle.builder()
                .id(1L)
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public static UpdateVehicleResponse generateUpdateVehicleResponse() {
        return new UpdateVehicleResponse(BaseVehicleResponse.builder()
                .id(1L)
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado com pneus novos")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build());
    }

    public static Vehicle generateUpdatedVehicle() {
        return Vehicle.builder()
                .id(1L)
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado com pneus novos")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public static UpdateVehicleDto generateUpdateVehicleDto() {
        return UpdateVehicleDto.builder()
                .id(1L)
                .marca("Toyota")
                .modelo("Corolla")
                .ano(2020)
                .cor("Preto")
                .preco(new BigDecimal("80000.00"))
                .quilometragem(10000)
                .tipoCombustivel("Gasolina")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9BWZZZ377VT004251")
                .placa("ABC1234")
                .descricao("Veículo em excelente estado")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build();
    }

    public static FindVehicleResponse generateFindVehicleResponse() {
        return new FindVehicleResponse(BaseVehicleResponse.builder()
                .id(1L)
                .marca("Chevrolet")
                .modelo("Onix")
                .ano(2021)
                .cor("Preto")
                .preco(BigDecimal.valueOf(62000.00))
                .quilometragem(32450)
                .tipoCombustivel("Flex")
                .numeroPortas(4)
                .tipoTransmissao("Automático")
                .numeroChassi("9B9B9SS88J")
                .placa("ABC1234")
                .descricao("Veículo em ótimo estado")
                .status(VehicleStatusEnum.DISPONIVEL)
                .dataCadastro(LocalDateTime.now())
                .build());
    }
}
