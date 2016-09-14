package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class IntRangeValidator implements Validator<Integer> {

	private int min, max;
	
	@Override
	public boolean validate(Integer value) {
		return (value >= min) && (value <= max);
	}
	
	public IntRangeValidator(int min, int max) {
		if (min > max) {
			this.max = min;
			this.min = max;
		} else {
			this.min = min;
			this.max = max;			
		}
	}

}
