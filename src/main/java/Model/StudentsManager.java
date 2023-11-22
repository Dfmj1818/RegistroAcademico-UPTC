package Model;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import com.google.gson.Gson;
import Exceptions.InvalidInputException;
import View.View;

public class StudentsManager {
	
	private static final int tuitionType=0;
	private static final int academicRequestsType=1;
	private Queue<Student>tuition;
	private Queue<Student>academicRequests;
	private int studentId;
	private Random random;
	private final View view;
	
	public StudentsManager() {
		tuition=new LinkedList<Student>();
		academicRequests=new LinkedList<Student>();
		studentId=0;
		random=new Random();
		view=new View();
	}

	public void addStudentToQueue(Student student) {
         
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
				tuition.offer(student);
				view.showMessage("Estudiante Agregado a la cola numero "+tuitionType);
			}
			else {
				academicRequests.offer(student);
				view.showMessage("Estudiante Agregado a la cola numero "+academicRequestsType);
			}
		}
		else {
			throw new NullPointerException();
		}

	}

	public void deleteStudentOfQueue(Queue<Student>queue) {
		queue.poll();
	}

	public void assignNamesToStudents(Queue<Student>queue) {
		if(queue!=null){
			queue.stream().forEach(student->{
				studentId++;
				student.setUniversityName("Estudiante "+studentId);
			});
		}
		throw new NullPointerException();
	}










}
