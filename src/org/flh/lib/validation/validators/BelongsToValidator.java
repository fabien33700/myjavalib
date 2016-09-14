package org.flh.lib.validation.validators;

import org.flh.lib.validation.Validator;

public class BelongsToValidator<T> implements Validator<T> {
	
	private Iterable<T> collection = null;

	@Override
	public boolean validate(T value) {
		boolean found = false;
		
		for (T item : this.collection)
			if (item.equals(value)) found = true;
		
		return found;			
	}
	
	public BelongsToValidator(Iterable<T> collection) {
		this.collection = collection;
	}

	/**
	 * @return the collection
	 */
	public Iterable<T> getCollection() {
		return collection;
	}

	/**
	 * @param collection the collection to set
	 */
	public void setCollection(Iterable<T> collection) {
		this.collection = collection;
	}
	
	

}
