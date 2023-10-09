package ApplicationMain;


import java.io.IOException;
import java.util.Scanner;

import ProductManagement.ProductManagement;
import UserManagement.UserManagement;


public class ApplicationMain {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		System.out.println("!!!! WELCOME TO SHOP MANAGEMENT !!!!");
		System.out.print("--Login Page--");
		System.out.println("\n");
		System.out.println("Enter login name :");
		String loginName = sc.nextLine();
		System.out.println("Enter Password :");
		String password = sc.nextLine();
	
		if(!UserManagement.validateUserAndPassword(loginName, password)) {
			System.out.println("!!!! LOGIN FAILED. Closing the Application !!!!");
			return;       
		}                       
		
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("!!! WELCOME TO SHOP MANAGEMENT !!!");
			System.out.println("\n");
			
			System.out.println("WHAT WOULD YOU LIKE TO DO?");
			System.out.println("1. User Management");
			System.out.println("2. Product Management");
			System.out.println("3. Quit");
			
			int  OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == 1)
			{
				UserManagement.UserManagement();
			}
			else if(OptionSelectedByUser == 2)
			{
				ProductManagement.ProductManagement();
			}
			else if(OptionSelectedByUser == 3)
			{
				break;
			}
			
		}
	}

}