package br.com.fiap.car.reg.application.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateVehicleDto {
    
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

    public CreateVehicleDto(CreateVehicleDto createVehicleDto) {
        this.marca = createVehicleDto.getMarca();
        this.modelo = createVehicleDto.getModelo();
        this.ano = createVehicleDto.getAno();
        this.cor = createVehicleDto.getCor();
        this.preco = createVehicleDto.getPreco();
        this.quilometragem = createVehicleDto.getQuilometragem();
        this.tipoCombustivel = createVehicleDto.getTipoCombustivel();
        this.numeroPortas = createVehicleDto.getNumeroPortas();
        this.tipoTransmissao = createVehicleDto.getTipoTransmissao();
        this.numeroChassi = createVehicleDto.getNumeroChassi();
        this.placa = createVehicleDto.getPlaca();
        this.descricao = createVehicleDto.getDescricao();
    }
}
