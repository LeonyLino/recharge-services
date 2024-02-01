package br.com.recharge.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "auth-service", url = "${service.url-local}:${service.auth.port}")
public interface AuthClient {

	@GetMapping("${service.endpoints.auth-filter}")
	boolean validate();

}
