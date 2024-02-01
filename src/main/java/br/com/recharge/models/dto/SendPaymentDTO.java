package br.com.recharge.models.dto;

import java.math.BigDecimal;

import br.com.recharge.enums.PaymentMethod;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SendPaymentDTO {
	
	private BigDecimal value;
	private PaymentMethod paymentoMethod;

}
