package br.com.micsistemas.ordem_carregamento;

import br.com.micsistemas.ordem_carregamento.model.OrdemCarregamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrdemCarregamentoApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void contextLoads() {

		OrdemCarregamento oc = new OrdemCarregamento();
		oc.setNrOc("12345");

		// Prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create an HttpEntity that holds the order and the headers
		HttpEntity<OrdemCarregamento> request = new HttpEntity<>(oc, headers);

		// The TestRestTemplate.withBasicAuth() method appends our credentials
		ResponseEntity<Void> response = restTemplate.withBasicAuth("admin", "secret")
				.postForEntity("/ordem-carregamento", request, Void.class);

		// Validate that the API returns 201 CREATED
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	}

}
