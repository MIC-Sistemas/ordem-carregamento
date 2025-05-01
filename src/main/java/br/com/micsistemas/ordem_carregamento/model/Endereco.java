package br.com.micsistemas.ordem_carregamento.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Endereco")
public class Endereco {

    @Schema(description = "logradouro", example = "QUADRA SAUN QUADRA 5 BLOCO B TORRE I II III SN", maxLength = 50)
    private String logradouro;

    @Schema(description = "complemento", example = "ANDAR T I SL S101 A S", maxLength = 60)
    private String complemento;

    @Schema(description = "bairro", example = "Asa Norte", maxLength = 60)
    private String bairro;

    @Schema(description = "cidade", example = "Brasilia", maxLength = 60)
    private String cidade;

    @Schema(description = "uf", example = "DF", maxLength = 2)
    private String uf;

    @Schema(description = "cep", example = "70040-912", maxLength = 9)
    private String cep;

}
