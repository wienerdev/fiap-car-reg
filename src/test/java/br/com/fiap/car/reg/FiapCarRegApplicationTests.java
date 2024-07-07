package br.com.fiap.car.reg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

@SpringBootTest
class FiapCarRegApplicationTests {
	@Autowired
	private ApplicationContext context;

	@Test
	void applicationContextLoadsSuccessfully() {
		assertThat(context).isNotNull();
	}

	@Test
	void mainApplicationRuns() {
		assertThatCode(() -> FiapCarRegApplication.main(new String[]{})).doesNotThrowAnyException();
	}
}
