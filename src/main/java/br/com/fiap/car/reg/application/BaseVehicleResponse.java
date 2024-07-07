package br.com.fiap.car.reg.application;

import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseVehicleResponse {

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

    public BaseVehicleResponse(BaseVehicleResponse response) {
        this.id = response.getId();
        this.marca = response.getMarca();
        this.modelo = response.getModelo();
        this.ano = response.getAno();
        this.cor = response.getCor();
        this.preco = response.getPreco();
        this.quilometragem = response.getQuilometragem();
        this.tipoCombustivel = response.getTipoCombustivel();
        this.numeroPortas = response.getNumeroPortas();
        this.tipoTransmissao = response.getTipoTransmissao();
        this.numeroChassi = response.getNumeroChassi();
        this.placa = response.getPlaca();
        this.descricao = response.getDescricao();
        this.status = response.getStatus();
        this.dataCadastro = response.getDataCadastro();
    }
}
