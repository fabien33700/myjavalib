package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class DoubleRangeValidator implements Validator<Double> {

	private int min, max;
	
	@Override
	public boolean validate(Double value) {
		return (value >= min) && (value <= max);
	}
	
	public DoubleRangeValidator(int min, int max) {
		if (min > max) {
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;			
		}
	}

}
