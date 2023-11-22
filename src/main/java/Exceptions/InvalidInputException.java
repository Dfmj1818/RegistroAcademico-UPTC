package Exceptions;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException() {
		super("No puedes digitar Numero Negativos");
	}
}
