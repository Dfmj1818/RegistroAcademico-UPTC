package Exceptions;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException() {
		super("Entrada Invalida,debes digitar un numero Entero");
	}
}
