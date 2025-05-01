package br.com.micsistemas.ordem_carregamento.repository;

import br.com.micsistemas.ordem_carregamento.model.OrdemCarregamento;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileOrdemCarregamentoRepositoryTest {

    private FileOrdemCarregamentoRepository repository;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = mock(ObjectMapper.class);
        repository = new FileOrdemCarregamentoRepository();
    }

    @Test
    void testConstructor_FileCreationFails() {
        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.exists(any(Path.class))).thenReturn(false);
            mockedFiles.when(() -> Files.createFile(any(Path.class))).thenThrow(IOException.class);

            RuntimeException exception = assertThrows(RuntimeException.class, FileOrdemCarregamentoRepository::new);
            assertEquals("Failed to create orders file", exception.getMessage());
        }
    }

    @Test
    void testSave_Success() throws IOException {
        OrdemCarregamento ordemCarregamento = new OrdemCarregamento();
        ordemCarregamento.setNumeroOc(12345);

        when(objectMapper.writeValueAsString(ordemCarregamento)).thenReturn("{\"nrOc\":\"12345\"}");

        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.newBufferedWriter(any(Path.class), eq(StandardOpenOption.APPEND)))
                    .thenReturn(mock(BufferedWriter.class));

            repository.save(ordemCarregamento);
        }
    }

    @Test
    void testSave_WriteIOException() {
        OrdemCarregamento ordemCarregamento = new OrdemCarregamento();
        ordemCarregamento.setNumeroOc(12345);

        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.newBufferedWriter(any(Path.class), eq(StandardOpenOption.APPEND)))
                    .thenThrow(IOException.class);

            RuntimeException exception = assertThrows(RuntimeException.class,
                    () -> repository.save(ordemCarregamento));
            assertEquals("Failed to save order", exception.getMessage());
        }
    }
}