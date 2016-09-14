package org.flh.lib.validation;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.flh.lib.validation.validators.GrantValidator;

/**
 * AdvScanner
 * Définit un scanner qui demande perpétuellement la saisie à l'utilisateur
 * tant que celle-ci n'est pas valide.
 * @author Fabien LH
 *
 */
public class ValidationScanner {
	
	/**
	 * L'instance de java.util.Scanner utilisée
	 */
	private Scanner sc = null;
	
	/**
	 * Le message d'invite par défaut
	 */
	private String promptMessage = "";
	
	/**
	 * Le message d'erreur par défaut
	 */
	private String errorMessage = "";
	
	/**
	 * Indique si le scanneur sera sensible à la casse pour
	 * lors de tests sur les chaînes de caractères
	 */
	//private boolean caseSensitive = false;
	
	/**
	 * Constructeur par défaut de la classe
	 * @param sc Le scanneur à utiliser
	 */
	public ValidationScanner(Scanner sc) {
		this.sc = sc;
	}
	
	/**
	 * Constructeur par défaut de la classe
	 * @param sc Le scanneur à utiliser
	 * @param defaultPromptMessage Le message d'invite par défaut
	 * @param defaultErrorMessage Le message d'erreur par défaut
	 */
	public ValidationScanner(Scanner sc, String defaultPromptMessage, String defaultErrorMessage) {
		this.sc = sc;
		this.errorMessage = defaultErrorMessage;
		this.promptMessage = defaultPromptMessage;
	}
	
	/**
	 * Récupère la référence du scanneur utilisé par l'instance
	 * @return java.util.Scanner
	 */
	public Scanner getScanner() {
		return this.sc;
	}

	/**
	 * Récupère le message d'invite par défaut défini dans l'instance
	 * @return Le message d'invite
	 */
	public String getPromptMessage() {
		return promptMessage;
	}

	/**
	 * Récupère le message d'erreur par défaut défini dans l'instance
	 * @return Le message d'erreur
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Modifie le message d'invite par défaut
	 * @param defaultPromptMessage Le nouveau message d'invite
	 */
	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;
	}

	/**
	 * Modifie le message d'erreur par défaut
	 * @param defaultErrorMessage Le nouveau message d'erreur
	 */
	public void setErrorMessage(String defaultErrorMessage) {
		this.errorMessage = defaultErrorMessage;
	}

	public void setMessage(String prompt, String errMessage) {
		this.errorMessage = errMessage;
		this.promptMessage = prompt;
	}

	/*** Integer ***/
	/*public int nextInteger() {
		return nextInteger(new GrantValidator<Integer>());
	}*/
	public int nextInteger(Validator<Number> validator) {
		
		boolean first = true, error = false;
		int input = 0;
		
		while (error || first) {
			error = false;
			try {
				System.out.print(this.promptMessage);
				input = this.sc.nextInt();
				
			} catch (InputMismatchException e) {
				/* /!\ En cas d'exception, le scanner reste bloqué dans sa position,
				 * il faut lire une autre ligne pour que l'exception n'apparaisse plus
				 * à la prochaine itération de la boucle.
				 */
				this.sc.nextLine();
				
				error = true;
			}
			
			error |= (!validator.validate(input));
			
			if (error) System.err.println(this.errorMessage);
			first = false;
		}
		
		return input;
	}
	
	
	/*** Double ***/
	public double nextDouble() {
		return nextDouble(new GrantValidator<Double>());
	}
	public double nextDouble(Validator<Double> validator) {
		
		boolean first = true, error = false;
		double input = 0.0d;
		
		while (error || first) {
			error = false;
			try {
				System.out.print(this.promptMessage);
				input = this.sc.nextDouble();
				
			} catch (InputMismatchException e) {
				this.sc.nextLine();
				error = true;
			}
			
			error |= (!validator.validate(input));
			
			if (error) System.err.println(this.errorMessage);
			first = false;
		}
		
		return input;
	}
	
	public float nextFloat() {
		return nextFloat(new GrantValidator<Float>());
	}
	public float nextFloat(Validator<Float> validator) {
		
		boolean first = true, error = false;
		float input = 0.0f;
		
		while (error || first) {
			error = false;
			try {
				System.out.print(this.promptMessage);
				input = this.sc.nextFloat();
				
			} catch (InputMismatchException e) {
				this.sc.nextLine();
				error = true;
			}
			
			error |= (!validator.validate(input));
			
			if (error) System.err.println(this.errorMessage);
			first = false;
		}
		
		return input;
	}
	
	/*** String ***/
	public String nextString() {
		return nextString(new GrantValidator<String>());
	}
	public String nextString(Validator<String> validator) {
		
		boolean first = true, error = false;
		String input = "";
		
		while (error || first) {
			error = false;
			try {
				System.out.print(this.promptMessage);
				input = this.sc.nextLine();
				
			} catch (InputMismatchException e) {
				this.sc.nextLine();
				error = true;
			}
			
			error |= (input.length() == 0) || (!validator.validate(input));
			
			if (error) System.err.println(this.errorMessage);
			first = false;
		}
		
		return input;
	}
	
	public byte nextByte() {
		return nextByte(new GrantValidator<Byte>());
	}
	public byte nextByte(Validator<Byte> validator) {
		
		boolean first = true, error = false;
		byte input = 0x00;
		
		while (error || first) {
			error = false;
			try {
				System.out.print(this.promptMessage);
				input = this.sc.nextByte();
				
			} catch (InputMismatchException e) {
				this.sc.nextLine();
				error = true;
			}
			
			error |= (!validator.validate(input));
			
			if (error) System.err.println(this.errorMessage);
			first = false;
		}
		
		return input;
	}
	
	/**
	 * Destructeur
	 * Libère l'instance du scanneur
	 */
	public void finalize() {
		this.sc.close();
	}
}
