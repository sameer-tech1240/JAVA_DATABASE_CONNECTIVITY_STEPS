package Jdbc2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestMain {
  public static void main(String[] args) throws IOException {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Employee employee = new Employee();
      System.out.println("enter the id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("enter name");
		String name=br.readLine();
		System.out.println("enter adress");
      String address=br.readLine();
		employee.setId(id);
		employee.setName(name);	
		employee.setAdress(address);
		Operate o = new Operate();
		o.save(employee);
	
}
}
