package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class GrantValidator<T> implements Validator<T> {
	@Override
	public boolean validate(T value) {
		return true;
	}
}
