package br.com.recharge.listeners;

import org.springframework.stereotype.Component;

import br.com.recharge.models.Recharge;
import jakarta.persistence.PostPersist;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuditRechargeListener {

	@PostPersist
	private void afterPostPersist(Recharge recharge) {
		log.info("salvando auditoria.");
	}

}
