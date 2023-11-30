package Presenter;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.Queue;

import Exceptions.EmptyQueueException;
import Model.Student;
import Model.StudentsManager;
import Persistence.FileApi;
import View.View;

public class Presenter {
	private final View view;
	private final StudentsManager studentsManager;
    private final FileApi fileApi;

	public Presenter() {
		view=new View();
		studentsManager=new StudentsManager();
		fileApi=new FileApi();
	}

	public static void main(String[]args) {
		Presenter presenter=new Presenter();
		presenter.studentsCreation();
		presenter.getStudentsQueue();
		presenter.studentsAttention();

	}



	public void studentsCreation(){
		int digitedStudents = 0;
		boolean correctFormat=false;
		while(!correctFormat){
			view.showMessage("Ingrese La Cantidad de estudiantes que seran atendidos");
			digitedStudents=view.readInt();
			if(digitedStudents>0){
				studentsManager.studentsCreation(digitedStudents);
				correctFormat=true;
			}
		}

	}

    public void getStudentsQueue() {
    	Queue<Student>tuitionQueue=studentsManager.getTuitionQueue();
    	Queue<Student>academicRequestType=studentsManager.getAcademicRequestQueue();
    	setStudentsAtributes(tuitionQueue);
    	setStudentsAtributes(academicRequestType);
    	exportStudentsToJson(tuitionQueue,"Estudiantes Solicitud Academica");
    	exportStudentsToJson(academicRequestType,"Estudiantes Solicitud de Matricula");
    }
	
	public void setStudentsAtributes(Queue<Student>queue) {
	 
       if(!studentsManager.verifyIfQueueIsEmpty(queue)){
    	   studentsManager.assignIdToStudents(queue);
    	   studentsManager.assignNameToStudents(queue);
       }
       else {
    	   view.showMessage("La cola de Matriculas esta vacia");
       }
       
	}

	
	
	public void exportStudentsToJson(Queue<Student>queue,String fileName) {
	
		if(!studentsManager.verifyIfQueueIsEmpty(queue)){
			fileApi.convertToJson(queue, fileName);
		}
		else {
			view.showMessage("La cola no tiene Estudiantes");
		}
		
	}
	
	public void studentsAttention() {
		studentsManager.selectionOfStudents();
	}



}
