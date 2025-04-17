package br.com.micsistemas.ordem_carregamento.controller;

import br.com.micsistemas.ordem_carregamento.model.OrdemCarregamento;
import br.com.micsistemas.ordem_carregamento.repository.OrdemCarregamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordem-carregamento")
@RequiredArgsConstructor
public class OrdemCarregamentoController {

    private final OrdemCarregamentoRepository ordemCarregamentoRepository;

    @PostMapping
    public ResponseEntity<Void> createOrdemCarregamento(@RequestBody OrdemCarregamento ordemCarregamento) {
        ordemCarregamentoRepository.save(ordemCarregamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
