package io.github.solucaologica.api.empresa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.solucaologica.api.core.dto.EmpresaDTO;
import io.github.solucaologica.api.core.mapper.EmpresaMapper;
import io.github.solucaologica.api.core.repository.EmpresaRepository;
import io.github.solucaologica.api.core.response.Response;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaMapper empresaMapper;
	
	@PostMapping(value = "/create")
//	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Response<EmpresaDTO>> cadastrar(@Valid @RequestBody EmpresaDTO empresadto, BindingResult result) {
		Response<EmpresaDTO> response = new Response<EmpresaDTO>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		empresaRepository.save(empresaMapper.toEntity(empresadto));
		response.setData(empresadto);
		return ResponseEntity.ok(response);
	}
}
