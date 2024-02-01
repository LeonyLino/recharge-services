package br.com.recharge.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.recharge.clients.ValidationClient;
import br.com.recharge.models.Recharge;
import br.com.recharge.models.dto.RechargeDTO;
import br.com.recharge.models.dto.SendPaymentDTO;
import br.com.recharge.models.dto.converters.RechargeDTOConverter;
import br.com.recharge.repositorys.RechargeRespository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RechargeServiceImpl implements RechargeService {

    private final RechargeRespository rRepository;
    private final RechargeDTOConverter rDTOConverter;
    private final ValidationClient validationClient;
    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String paymentExchange;
    @Value("${rabbitmq.payment.request.routing-key.main}")
    private String paymentResquestRoutingKey;

    @Override
    public RechargeDTO register(RechargeDTO dto) {
        if (validationNumber(dto.getNumCellPhone()))
            sendToPayment(
                    SendPaymentDTO.builder().value(dto.getValue()).paymentoMethod(dto.getPaymentMethod()).build());

        return rDTOConverter.convert(rRepository.save(
                new Recharge(null, dto.getNumCellPhone(), dto.getValue(), dto.getPaymentMethod(), dto.getOperator())));

    }

    private boolean validationNumber(String number) {
        return validationClient.validateNumber(number);
    }

    private void sendToPayment(SendPaymentDTO dto) {
        rabbitTemplate.convertAndSend(paymentExchange, paymentResquestRoutingKey, dto);
    }

}
