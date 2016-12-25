package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class login {
String name;
String password;

public String getMessage(){
	return "Error";
}

public static void register(String name, String password){
	PrintWriter write = null;
	try{
		write = new PrintWriter(new FileOutputStream("LoginGitHub.txt"));
		write.println(name);
		write.println(password);
		write.close();
		System.out.println("Welcome, " + name);
	}catch(InputMismatchException e){
		System.out.println(e.getMessage());
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
}
public static void oldUser(String name, String password){
	Scanner input = new Scanner(System.in);
	Scanner reader = null;
	try{
		reader = new Scanner(new FileInputStream("LoginGitHub.txt"));
		String nameC = reader.nextLine();
		String passC = reader.nextLine();
		if(nameC.equalsIgnoreCase(name) && passC.equalsIgnoreCase(password)){
			System.out.println("Welcome Back, " + name );
		}else{
			System.out.println("Incorrect Username or Password. GoodBye");	
			System.exit(0);
		}
	}catch(InputMismatchException e){
		System.out.println(e.getMessage());
	}catch(FileNotFoundException e){
		System.out.println(e.getMessage());
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
}
public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	System.out.println("Register or Login");
	String first = input.nextLine();
	if(first.equalsIgnoreCase("Register")){
		System.out.println("Enter Name: ");
		String name = input.nextLine();
		System.out.println("Enter Password: ");
		String password = input.nextLine();
		register(name,password);
		System.out.println("You are logged In, try your username and password on login now");
	}else if (first.equalsIgnoreCase("Login")){
		System.out.println("Enter Name: ");
		String name = input.nextLine();
		System.out.println("Enter Password: ");
		String password = input.nextLine();
		oldUser(name,password);
	}else{
		System.out.println("Error, Goodbye");
	}
}
}
