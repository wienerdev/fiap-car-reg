package br.com.fiap.car.reg.domain;

import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities.VehicleEntity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
    private Long id;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private BigDecimal preco;
    private Integer quilometragem;
    private String tipoCombustivel;
    private Integer numeroPortas;
    private String tipoTransmissao;
    private String numeroChassi;
    private String placa;
    private String descricao;
    private VehicleStatusEnum status;
    private LocalDateTime dataCadastro;

    public VehicleEntity toEntity() {
        return VehicleEntity.builder()
                .id(this.id)
                .marca(this.marca)
                .modelo(this.modelo)
                .ano(this.ano)
                .cor(this.cor)
                .preco(this.preco)
                .quilometragem(this.quilometragem)
                .tipoCombustivel(this.tipoCombustivel)
                .numeroPortas(this.numeroPortas)
                .tipoTransmissao(this.tipoTransmissao)
                .numeroChassi(this.numeroChassi)
                .placa(this.placa)
                .descricao(this.descricao)
                .status(this.status)
                .dataCadastro(this.dataCadastro)
                .build();
    }

    public Vehicle(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.marca = vehicle.getMarca();
        this.modelo = vehicle.getModelo();
        this.ano = vehicle.getAno();
        this.cor = vehicle.getCor();
        this.preco = vehicle.getPreco();
        this.quilometragem = vehicle.getQuilometragem();
        this.tipoCombustivel = vehicle.getTipoCombustivel();
        this.numeroPortas = vehicle.getNumeroPortas();
        this.tipoTransmissao = vehicle.getTipoTransmissao();
        this.numeroChassi = vehicle.getNumeroChassi();
        this.placa = vehicle.getPlaca();
        this.descricao = vehicle.getDescricao();
        this.status = vehicle.getStatus();
        this.dataCadastro = vehicle.getDataCadastro();
    }
}