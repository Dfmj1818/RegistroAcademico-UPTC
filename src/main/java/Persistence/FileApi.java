package Persistence;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import Model.Student;
import View.View;

public class FileApi {
	private final Gson gson;
	private final String pcRoute;
	private final View view;

	public FileApi() {
		gson=new Gson();
		pcRoute="C:\\Users\\pepeg\\eclipse-workspace\\RegistroAcademicoUptc";
		view=new View();
	}

	public Queue<Student>convertJsonToObjects(String fileName) {
		Queue<Student>deserializedQueue=null;
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(pcRoute+File.separator+fileName));
			deserializedQueue=gson.fromJson(bufferedReader, new TypeToken<Queue<Book>>(){}.getType());
		}catch(FileNotFoundException e){
			view.showMessage(e.getMessage());
		}catch(JsonSyntaxException e){
			view.showMessage(e.getMessage());
		}

		return deserializedQueue;
	}

	public void convertToJson(Queue<Student>queue,String fileName){
		try {
			FileWriter fileWriter=new FileWriter(pcRoute+File.separator+fileName+".json");
			String queueAsJson= gson.toJson(queue);
			fileWriter.write(queueAsJson);
			fileWriter.close();
		}catch(IOException e){
			view.showMessage(e.getMessage());
		}


	}

}
