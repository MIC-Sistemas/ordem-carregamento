package br.com.micsistemas.ordem_carregamento.repository;

import br.com.micsistemas.ordem_carregamento.model.OrdemCarregamento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Repository
public class FileOrdemCarregamentoRepository implements OrdemCarregamentoRepository {

    private final Path filePath = Paths.get("ordens_carregamento.txt");
    private final ObjectMapper objectMapper = new ObjectMapper();


    public FileOrdemCarregamentoRepository() {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create orders file", e);
        }
    }

    @Override
    public void save(OrdemCarregamento ordemCarregamento) {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            String json = objectMapper.writeValueAsString(ordemCarregamento);
            writer.write(json);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to save order", e);
        }
    }

}
