package Model;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Random;

import javax.naming.directory.NoSuchAttributeException;

import com.google.gson.Gson;

import Exceptions.EmptyQueueException;
import Exceptions.InvalidInputException;
import View.View;

public class StudentsManager {

	private static final int tuitionType=0;
	private static final int academicRequestsType=1;
	private Queue<Student>tuitionQueue;
	private Queue<Student>academicRequestsQueue;
	private int studentId;
	private Random random;
	private final View view;

	public StudentsManager() {
		tuitionQueue=new LinkedList<Student>();
		academicRequestsQueue=new LinkedList<Student>();
		studentId=0;
		random=new Random();
		view=new View();
	}

	public boolean verifyIfQueueIsEmpty(Queue<?>queue){
		if(queue.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}


	public Queue<Student>getTuitionQueue(){
		return tuitionQueue;
	}

	public Queue<Student>getAcademicRequestQueue(){
		return academicRequestsQueue;
	}


	public void studentsCreation(int numberOfStudents){
		if(numberOfStudents>0){
			for(int i=0;i<numberOfStudents;i++){
				Student student=new Student();
				assignStudentToQueue(student);
			}
		}
		else {
			throw new InvalidInputException();
		}
	}



	public void assignStudentToQueue(Student student) {
		int typeOfRequest=random.nextInt(2);

		if(student!=null){
			if(typeOfRequest==0){
				tuitionQueue.offer(student);
				view.showMessage("Estudiante Agregado a la cola de "+"Matriculas");
			}
			else {
				academicRequestsQueue.offer(student);
				view.showMessage("Estudiante Agregado a la cola de "+"Solicitudes Academicas");
			}
		}
		else {
			throw new NullPointerException();
		}

	}


	public void deleteStudentOfQueue(Queue<Student>queue) {
		queue.poll();
	}

	public void assignIdToStudents(Queue<Student>queue) {
		if(!verifyIfQueueIsEmpty(queue)){
			queue.forEach(student->{
				studentId++;
				student.setId(studentId);
			});

		}
		else {
			throw new EmptyQueueException();
		}

	}


	public void assignNameToStudents(Queue<Student>queue) {
		if(!verifyIfQueueIsEmpty(queue)){
			queue.stream().forEach(student->{
				if(student!=null){
					student.setUniversityName("Estudiante "+student.getId());
				}
				else{
					throw new NullPointerException();
				}
			});
		}
		else {
			throw new EmptyQueueException();
		}
	}


	public void selectionOfStudents() {
		Student studentToBeAttended;
		while(!tuitionQueue.isEmpty()||!academicRequestsQueue.isEmpty()){
           //Trae el estudiante que esta al frente de la cola y lo elimina
			if(!verifyIfQueueIsEmpty(tuitionQueue)){
				studentToBeAttended=tuitionQueue.poll();
				studentsAttention(studentToBeAttended);

			}
			if(!verifyIfQueueIsEmpty(academicRequestsQueue)){	
				studentToBeAttended=academicRequestsQueue.poll();
				studentsAttention(studentToBeAttended);
			}
		}
	}

	public void studentsAttention(Student student) {
		int attentionTime=random.nextInt(300)+600;
		try {  	
			view.showMessage("Atendiendo al Estudiante "+student.getUniversityName());
			Thread.sleep(attentionTime);
			view.showMessage("Atencion Completada"+"En : "+attentionTime+" Milisegundos");
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}












