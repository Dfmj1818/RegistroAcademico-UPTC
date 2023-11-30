package Exceptions;

public class EmptyQueueException extends RuntimeException{

	public EmptyQueueException() {
		super("No hay estudiantes en una de las colas");
	}
}
