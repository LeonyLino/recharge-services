package br.com.recharge.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "recharge-validation-service", url = "${service.url-local}:${service.validation.port}")
public interface ValidationClient {

	@GetMapping("${service.endpoints.validate}/{number:[0-9]+}")
	boolean validateNumber(@PathVariable("number") String number);

}
