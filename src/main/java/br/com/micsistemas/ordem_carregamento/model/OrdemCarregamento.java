package br.com.micsistemas.ordem_carregamento.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Schema(description = "Modelo de Ordem de Carregamento")
public class OrdemCarregamento implements Serializable {

    @Schema(description = "ID da Ordem de Carregamento", example = "12345")
    @Min(value = 1, message = "ID da Ordem de Carregamento deve ser maior que 0")
    private Integer numeroOc;

    @Schema(description = "Nome da empresa", example = "BANCO DO BRASIL SA", maxLength = 50)
    private String nomeEmpresa;

    @Schema(description = "CNPJ da empresa", example = "00.000.000/0001-91", maxLength = 18)
    private String cnpjEmpresa;

    private Endereco enderecoEmpresa;

    @Schema(description = "numero do pedido", example = "1234567890", maxLength = 10)
    private String numeroPedido;

    @Schema(description = "numero da DI ou DUIMP", example = "24/1234567-8", maxLength = 10)
    private String numeroDi;

    @Schema(description = "codigo do produto", example = "112233", maxLength = 15)
    private String codigoProduto;

    @Schema(description = "nome do produto", example = "Cloreto de potassio", maxLength = 700)
    private String nomeProduto;

    @Schema(description = "Nome da Transportadora", example = "AZUL LINHAS AEREAS BRASILEIRAS S.A.", maxLength = 50)
    private String nomeTransportadora;

    @Schema(description = "CPF ou CNPJ da transportadora", example = "09.296.295/0001-60", maxLength = 18)
    private String cpfCnpjTransportadora;

    @Schema(description = "Placa do Cavalo", example = "ABC1234", maxLength = 10)
    private String placaCavalo;

    @Schema(description = "Placa da Carreta1", example = "ABC1234", maxLength = 10)
    private String placaCarreta1;

    @Schema(description = "Placa da Carreta2", example = "ABC1234", maxLength = 10)
    private String placaCarreta2;

    @Schema(description = "Placa da Carreta3", example = "ABC1234", maxLength = 10)
    private String placaCarreta3;

    @Schema(description = "Data Hora da OC", example = "2025-01-31T23:15:15")
    private Date dataHoraOc;

    @Schema(description = "Situacao, ATIVA / CANCELADA", example = "ATIVA")
    private String situacao;

    @Schema(description = "Navio", example = "POWER RANGER", maxLength = 50)
    private String navio;

    @Schema(description = "Nome do Motorista", example = "Franz Kafka", maxLength = 50)
    private String nomeMotorista;

    @Schema(description = "CPF do Motorista", example = "488.840.840-83", maxLength = 15)
    private String cpfMotorista;

    @Schema(description = "Peso Maximo em toneladas", example = "35.000")
    private BigDecimal pesoMaximo;

    @Schema(description = "Nome do destinatario", example = "Agropecuaria Roncador Ltda", maxLength = 50)
    private String nomeDestinatario;

    @Schema(description = "CPF ou CNPJ do destinatario", example = "03.144.060/0001-76", maxLength = 18)
    private String cpfCnpjDestinatario;

    private Endereco enderecoDestinatario;

    @Schema(description = "Observação", example = "Exemple de observacao", maxLength = 250)
    private String observacao;

    @Schema(description = "Pdf da OC em base64")
    private String pdfOc;

}
