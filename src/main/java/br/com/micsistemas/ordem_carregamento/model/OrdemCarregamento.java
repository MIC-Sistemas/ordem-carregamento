package br.com.micsistemas.ordem_carregamento.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class OrdemCarregamento implements Serializable {

    private String nrOc;
    private String nomeEmpresa;
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
