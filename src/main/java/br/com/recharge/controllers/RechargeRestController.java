package br.com.recharge.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.recharge.models.dto.RechargeDTO;
import br.com.recharge.services.RechargeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/recharge")
@RequiredArgsConstructor
public class RechargeRestController {

	private final RechargeService rService;

	@PostMapping
	public ResponseEntity<Object> recharge(@RequestBody @Valid RechargeDTO dto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(rService.register(dto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}
