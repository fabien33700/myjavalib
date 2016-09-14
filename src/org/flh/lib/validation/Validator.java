package org.flh.lib.validation;

public interface Validator<T> {
	public boolean validate(T value);
}
