package br.com.recharge.models;

import br.com.recharge.enums.Operator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NumCellPhone {

	private String number;
	private Boolean active;
	private Operator operator;
}
