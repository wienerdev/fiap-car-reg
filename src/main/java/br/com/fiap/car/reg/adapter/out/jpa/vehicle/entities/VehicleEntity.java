package br.com.fiap.car.reg.adapter.out.jpa.vehicle.entities;

import br.com.fiap.car.reg.domain.Vehicle;
import br.com.fiap.car.reg.domain.enums.VehicleStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "cor")
    private String cor;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "quilometragem")
    private Integer quilometragem;

    @Column(name = "tipo_combustivel")
    private String tipoCombustivel;

    @Column(name = "numero_portas")
    private Integer numeroPortas;

    @Column(name = "tipo_transmissao")
    private String tipoTransmissao;

    @Column(name = "numero_chassi")
    private String numeroChassi;

    @Column(name = "placa")
    private String placa;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private VehicleStatusEnum status;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    public Vehicle toDomain() {
        return Vehicle.builder()
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
}
