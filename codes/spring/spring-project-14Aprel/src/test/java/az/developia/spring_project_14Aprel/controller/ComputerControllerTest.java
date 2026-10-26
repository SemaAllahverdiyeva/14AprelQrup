package az.developia.spring_project_14Aprel.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import az.developia.spring_project_14Aprel.requestDto.ComputerRequestDto;
import az.developia.spring_project_14Aprel.responseDto.ComputerResponseDto;
import az.developia.spring_project_14Aprel.service.ComputerService;
import az.developia.spring_project_14Aprel.util.JwtUtil;

@WebMvcTest(ComputerController.class)
public class ComputerControllerTest {

	@MockitoBean
	private ComputerService computerService;

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private JwtUtil jwtUtil;

	@MockitoBean
	private CacheManager cacheManager;

	@Test
	void getComputerById_shouldReturnWhenIsOk() throws Exception {

		ComputerResponseDto responseDto = mock(ComputerResponseDto.class);

		when(computerService.getComputerById(1))
				.thenReturn(responseDto);

		mockMvc.perform(
				get("/computers/getComputer/1"))
				.andExpect(status().isOk());

		verify(computerService)
				.getComputerById(1);
	}

	@Test
	void addComputer_shouldReturnOk() throws Exception {

		doNothing().when(computerService)
				.addComputer(any(ComputerRequestDto.class));

		mockMvc.perform(
				post("/computers/addComputer")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
									"brand": "Dell",
									"model": "XPS 13",
									"price": 1299.99
								}
								"""))
				.andExpect(status().isOk());

		verify(computerService)
				.addComputer(any(ComputerRequestDto.class));
	}
}