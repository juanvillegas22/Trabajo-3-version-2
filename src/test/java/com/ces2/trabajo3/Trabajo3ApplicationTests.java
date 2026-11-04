package com.ces2.trabajo3;

import com.ces2.trabajo3.controlador.ControladorAtaque;
import com.ces2.trabajo3.modelo.Ataque;
import com.ces2.trabajo3.repositories.RepositorioAtaques;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class Trabajo3ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private RepositorioAtaques repositorioAtaques;

	@Test
	void contextLoadsAndEndpointsWork() throws Exception {
		assertEquals(5, repositorioAtaques.getPilaDeAtaques().size());
		assertEquals(5, repositorioAtaques.getOleadaDeAtaques().getAtaques().size());

		Ataque primerAtaque = repositorioAtaques.getPilaDeAtaques().get(0);
		assertEquals(110, ControladorAtaque.funcionSumaConteo.apply(primerAtaque));
		assertTrue(primerAtaque.verTotales(ControladorAtaque.funcionSumaConteo).contains("110"));

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("ataques"));
		mockMvc.perform(get("/punto1")).andExpect(status().isOk()).andExpect(view().name("punto1"));
		mockMvc.perform(get("/punto2")).andExpect(status().isOk()).andExpect(view().name("punto2"));
		mockMvc.perform(get("/punto3")).andExpect(status().isOk()).andExpect(view().name("punto3"));
		mockMvc.perform(get("/punto4")).andExpect(status().isOk()).andExpect(view().name("punto4"));
		mockMvc.perform(get("/punto5")).andExpect(status().isOk()).andExpect(view().name("punto5"));
	}

}
