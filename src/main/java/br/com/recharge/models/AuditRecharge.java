package br.com.recharge.models;

import br.com.recharge.enums.Operator;
import br.com.recharge.enums.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@SequenceGenerator(name = "seqAuditRecharge", sequenceName = "seqAuditRecharge", initialValue = 1, allocationSize = 1)
public class AuditRecharge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAuditRecharge")
	private Long id;
	private String numCellPhone;
	private double value;
	private PaymentMethod paymentMaMethod;
	private String user;
	private Operator operator;
}
