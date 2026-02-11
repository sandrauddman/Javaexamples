package src;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaLocalVar {

	public static void main(String[] args) {

		List<String> emails= Arrays.asList("peter@example.com", "sara@example.com", "john@example.com");
		System.out.println(emails);
		
		String csvData=emails.stream().map((String email)-> email.replace(".com", ".se")).collect(Collectors.joining(","));
		
		System.out.println("emails as csv");
		System.out.println(csvData);
	}

}
