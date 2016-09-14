package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class FloatRangeValidator implements Validator<Float> {

	private int min, max;
	
	@Override
	public boolean validate(Float value) {
		return (value >= min) && (value <= max);
	}
	
	public FloatRangeValidator(int min, int max) {
		if (min > max) {
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;			
		}
	}

}
