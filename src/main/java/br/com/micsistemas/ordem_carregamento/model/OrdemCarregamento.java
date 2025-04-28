package br.com.micsistemas.ordem_carregamento.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Schema(description = "Modelo de Ordem de Carregamento")
public class OrdemCarregamento implements Serializable {

    @Schema(description = "ID da Ordem de Carregamento", example = "12345")
    @NotNull(message = "ID da Ordem de Carregamento não pode ser nulo")
    @Min(value = 1, message = "ID da Ordem de Carregamento deve ser maior que 0")
    private Integer nrOc;

    @Schema(description = "Nome da empresa", example = "YARA BRASIL FERTILIZANTES SA", maxLength = 50)
    @Size(max = 50, message = "Nome da empresa nao deve ultrapassar 50 caracteres")
    private String nomeEmpresa;

    @CNPJ
    private String cnpjEmpresa;
    private String enderecoEmpresa;
    private String numeroPedido;
    private String numeroDi;
    private String codigoProduto;
    private String nomeProduto;
    private String nomeTransportadora;
    private String cnpjTransportadora;
    private String placaCavalo;
    private String placaCarreta1;
    private String placaCarreta2;
    private String placaCarreta3;
    private String dataHoraOc;
    private String situacaoOc;
    private String nomeNavio;
    private String nomeMotorista;
    private String cpfMotorista;
    private BigDecimal pesoMaximo;
    private String nomeEmpresaEnvio;
    private String cnpjEmpresaEnvio;
    private String enderecoEmpresaEnvio;
    private String obsOc;
    private String pdfO;

}
