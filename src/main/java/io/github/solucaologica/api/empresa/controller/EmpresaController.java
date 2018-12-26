package io.github.solucaologica.api.empresa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.solucaologica.api.core.dto.EmpresaDTO;
import io.github.solucaologica.api.core.response.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	
	@PostMapping
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@RequestBody EmpresaDTO empresadto) {
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		response.setData(empresadto);
		return ResponseEntity.ok(response);
	}
}
