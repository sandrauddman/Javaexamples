package src;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesExamples {

	public static void main(String[] args) {
	
		try {
			
			Path temp = Path.of("src/temp");
			
			Path studentFile= Files.createTempFile(temp, "Students", ".txt");
			
			String content= "name, ID, enrollment";
		
			Files.writeString(studentFile, content);
			
			String data= Files.readString(studentFile);
			System.out.println("Data in file_:"+data);
			
		} catch (Exception e) {
			System.out.println("exception "+ e);
		}
		
	}
}
