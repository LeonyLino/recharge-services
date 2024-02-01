package br.com.recharge.models.dto;

import java.math.BigDecimal;

import br.com.recharge.enums.Operator;
import br.com.recharge.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RechargeDTO {

	@NotNull
	@Size(min = 11, max = 11)
	private String numCellPhone;
	private BigDecimal value;
	private PaymentMethod paymentMethod;
	private Operator operator;

}
