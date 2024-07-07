package br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities;

import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleEntityTest {


    @InjectMocks
    private VehicleEntity vehicleEntity;

    private LocalDateTime localDateTimeNow = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        vehicleEntity = VehicleEntity.builder()
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
                .dataCadastro(localDateTimeNow)
                .build();
    }

    @Test
    void toDomainConvertsEntityToDomainCorrectly() {
        var domainVehicle = vehicleEntity.toDomain();

        assertAll("vehicleEntity toDomain",
                () -> assertEquals(vehicleEntity.getId(), domainVehicle.getId()),
                () -> assertEquals(vehicleEntity.getMarca(), domainVehicle.getMarca()),
                () -> assertEquals(vehicleEntity.getModelo(), domainVehicle.getModelo()),
                () -> assertEquals(vehicleEntity.getAno(), domainVehicle.getAno()),
                () -> assertEquals(vehicleEntity.getCor(), domainVehicle.getCor()),
                () -> assertEquals(0, vehicleEntity.getPreco().compareTo(domainVehicle.getPreco())),
                () -> assertEquals(vehicleEntity.getQuilometragem(), domainVehicle.getQuilometragem()),
                () -> assertEquals(vehicleEntity.getTipoCombustivel(), domainVehicle.getTipoCombustivel()),
                () -> assertEquals(vehicleEntity.getNumeroPortas(), domainVehicle.getNumeroPortas()),
                () -> assertEquals(vehicleEntity.getTipoTransmissao(), domainVehicle.getTipoTransmissao()),
                () -> assertEquals(vehicleEntity.getNumeroChassi(), domainVehicle.getNumeroChassi()),
                () -> assertEquals(vehicleEntity.getPlaca(), domainVehicle.getPlaca()),
                () -> assertEquals(vehicleEntity.getDescricao(), domainVehicle.getDescricao()),
                () -> assertEquals(vehicleEntity.getStatus(), domainVehicle.getStatus()),
                () -> assertEquals(vehicleEntity.getDataCadastro(), domainVehicle.getDataCadastro())
        );
    }

    @Test
    void setVehicleEntity() {
        Vehicle vehicle = new Vehicle();
        vehicle.setAno(2020);
        vehicle.setCor("Preto");
        vehicle.setDescricao("Veículo em excelente estado");
        vehicle.setId(1L);
        vehicle.setMarca("Toyota");
        vehicle.setModelo("Corolla");
        vehicle.setNumeroChassi("9BWZZZ377VT004251");
        vehicle.setNumeroPortas(4);
        vehicle.setPlaca("ABC1234");
        vehicle.setPreco(new BigDecimal("80000.00"));
        vehicle.setQuilometragem(10000);
        vehicle.setStatus(VehicleStatusEnum.DISPONIVEL);
        vehicle.setDataCadastro(localDateTimeNow);
        vehicle.setTipoCombustivel("Gasolina");
        vehicle.setTipoTransmissao("Automático");

        assertAll("vehicleEntity set methods",
                () -> assertEquals(vehicleEntity.getId(), vehicle.getId()),
                () -> assertEquals(vehicleEntity.getMarca(), vehicle.getMarca()),
                () -> assertEquals(vehicleEntity.getModelo(), vehicle.getModelo()),
                () -> assertEquals(vehicleEntity.getAno(), vehicle.getAno()),
                () -> assertEquals(vehicleEntity.getCor(), vehicle.getCor()),
                () -> assertEquals(0, vehicleEntity.getPreco().compareTo(vehicle.getPreco())),
                () -> assertEquals(vehicleEntity.getQuilometragem(), vehicle.getQuilometragem()),
                () -> assertEquals(vehicleEntity.getTipoCombustivel(), vehicle.getTipoCombustivel()),
                () -> assertEquals(vehicleEntity.getNumeroPortas(), vehicle.getNumeroPortas()),
                () -> assertEquals(vehicleEntity.getTipoTransmissao(), vehicle.getTipoTransmissao()),
                () -> assertEquals(vehicleEntity.getNumeroChassi(), vehicle.getNumeroChassi()),
                () -> assertEquals(vehicleEntity.getPlaca(), vehicle.getPlaca()),
                () -> assertEquals(vehicleEntity.getDescricao(), vehicle.getDescricao()),
                () -> assertEquals(vehicleEntity.getStatus(), vehicle.getStatus()),
                () -> assertEquals(vehicleEntity.getDataCadastro(), vehicle.getDataCadastro())
        );
    }
}