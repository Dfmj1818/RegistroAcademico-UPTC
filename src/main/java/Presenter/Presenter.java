package Presenter;

import View.View;

public class Presenter {
	private final View view;
	
	
	public Presenter() {
		view=new View();
	}
	
	public static void main(String[]args) {
		Presenter presenter=new Presenter();
		presenter.viewTest();
	}
	
	public void () {
		int digitedNumber;
		
	   	digitedNumber=view.readInt();
	}

}
