package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class NumericRangeValidator<T extends Number> implements Validator<Number> {

	private Number min, max;
	
	@Override
	public boolean validate(Number value) {
		System.out.println(value.getClass().toString()); 
		return false;
	}
	
	public NumericRangeValidator(Number min, Number max) {
		/*if (min > max) {
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;			
		}*/
	}

}
