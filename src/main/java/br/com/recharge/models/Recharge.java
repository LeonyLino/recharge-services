package br.com.recharge.models;

import java.math.BigDecimal;

import br.com.recharge.enums.Operator;
import br.com.recharge.enums.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "recharge")
@SequenceGenerator(name = "seqRecharge", sequenceName = "seqRecharge", initialValue = 1, allocationSize = 1)
public class Recharge {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRecharge")
	private Long id;
	@Column(nullable = false)
	private String numCellPhone;
	@Column(nullable = false)
	private BigDecimal value;
	@Column(nullable = false)
	private PaymentMethod paymentMethod;
	@Column(nullable = true)
	private Operator operator;
}
