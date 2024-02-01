package br.com.recharge.models.dto.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.recharge.models.Recharge;
import br.com.recharge.models.dto.RechargeDTO;

@Component
public class RechargeDTOConverter implements Converter<Recharge, RechargeDTO> {

	@Override
	public RechargeDTO convert(Recharge recharge) {
		return RechargeDTO.builder().numCellPhone(recharge.getNumCellPhone()).value(recharge.getValue())
				.paymentMethod(recharge.getPaymentMethod()).operator(recharge.getOperator()).build();
	}

}
