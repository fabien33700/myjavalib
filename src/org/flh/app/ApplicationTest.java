package org.flh.app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.flh.lib.validation.ValidationScanner;
import org.flh.lib.validation.validators.BelongsToValidator;
import org.flh.lib.validation.validators.NumericRangeValidator;

public class ApplicationTest {

	public static void main(String[] args) {
		ValidationScanner vsc = new ValidationScanner(new Scanner(System.in));
		
		/*String[] tabFruits = {"pomme", "poire", "fraise", "kiwi", "citron", "banane"};
		List<String> fruits = Arrays.asList(tabFruits);
		
		vsc.setMessage("Tapez le nom d'un fruit " + fruits + " : ", "Ce n'est pas un fruit de la liste !");
		
		String fruit = vsc.nextString(
			new BelongsToValidator<String>(fruits)
		);*/
		
		int a = vsc.nextInteger(
			new NumericRangeValidator<Integer>(0, 10));
		
		//System.out.println("Vous avez choisi : " + fruit);
	}

}
