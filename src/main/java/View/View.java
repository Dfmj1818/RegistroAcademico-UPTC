package View;

import java.util.Queue;
import java.util.Scanner;

public class View {
	private Scanner scanner;


	public View() {
		scanner=new Scanner(System.in);
	}

	public void showMessage(String message){
		System.out.println(message);
	}



	public int readInt() {
		int input = 0;
		boolean correctFormat=false;
		String regex="[0-9]+";

		while(!correctFormat) {
			showMessage("Digita un numero Entero :-)");
			String inputAsString=scanner.nextLine().trim();
			if(!inputAsString.isEmpty()&&inputAsString.matches(regex)){
				try {
					input=Integer.parseInt(inputAsString);
					correctFormat=true;
				}catch(NumberFormatException e){
					showMessage(e.getMessage());
				}
			}
			else {
				showMessage("Entrada Vacia o en formato Incorrecto");
			}
		}
		return input;
	}
	
	public void viewQueue(Queue<?>queue){
		queue.forEach(System.out::println);
	}


}
