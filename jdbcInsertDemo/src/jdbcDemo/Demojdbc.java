package jdbcDemo;

import java.util.Scanner;

public class Demojdbc {
       public static void main(String[] args) {
    	   Scanner scanner= new Scanner(System.in);
    	   System.out.println("enter database name");
			String  databaseName =scanner.nextLine();
			  
			String url ="jdbc:mysql://localhost:3306/";
			url= url.concat(databaseName);
			System.out.println(url);
	}
}
