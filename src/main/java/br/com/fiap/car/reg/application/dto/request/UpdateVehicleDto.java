package br.com.fiap.car.reg.application.dto.request;

import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateVehicleDto {

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

    public UpdateVehicleDto(UpdateVehicleDto updateVehicleDto) {
        this.id = updateVehicleDto.getId();
        this.marca = updateVehicleDto.getMarca();
        this.modelo = updateVehicleDto.getModelo();
        this.ano = updateVehicleDto.getAno();
        this.cor = updateVehicleDto.getCor();
        this.preco = updateVehicleDto.getPreco();
        this.quilometragem = updateVehicleDto.getQuilometragem();
        this.tipoCombustivel = updateVehicleDto.getTipoCombustivel();
        this.numeroPortas = updateVehicleDto.getNumeroPortas();
        this.tipoTransmissao = updateVehicleDto.getTipoTransmissao();
        this.numeroChassi = updateVehicleDto.getNumeroChassi();
        this.placa = updateVehicleDto.getPlaca();
        this.descricao = updateVehicleDto.getDescricao();
        this.status = updateVehicleDto.getStatus();
        this.dataCadastro = updateVehicleDto.getDataCadastro();
    }
}
