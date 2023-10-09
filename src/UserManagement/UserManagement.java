package UserManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagement {
	static ArrayList<User> list = new ArrayList();
	
	static {
		try {
			loadDataFromFileToArrayList();
		}
		catch(IOException e){
			//TODO auto generated catch block
			e.printStackTrace();
		}
	}
		
	public static void UserManagement() throws IOException {
		
		
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		
		while(CanIKeepRunningTheProgram == true) {
			System.out.println("!!!!! WELCOME TO USER MANAGEMENT PROGRAM !!!!!!");
			
			System.out.println("\n");

			System.out.println("What Would you like to do?");
			System.out.println("1. Add User");
			System.out.println("2. Edit User");
			System.out.println("3. Delete User");
			System.out.println("4. Search User");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == UserOptions.Useroption.QUIT.options)
			{
				File file = new File("C:\\Users\\rites\\eclipse-workspace\\shopManagementWithLogin02\\src\\UserManagement\\Usres");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(User user:list)
				{
					System.out.println(user.Loginname+","+user.Password+","+user.Username+","+user.Userrole+"\n");
					bufferedWriter.write(user.Loginname+","+user.Password+","+user.Username+","+user.Userrole+"\n");
				}
				
				
				bufferedWriter.close();
				fileWriter.close();
				file=null;		
				CanIKeepRunningTheProgram = false;
				
				CanIKeepRunningTheProgram = false;
				System.out.println("!!! PROGRAM CLOSED !!!");
			}
			else if(OptionSelectedByUser == UserOptions.Useroption.ADD_USER.options) {
				AddUser();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.Useroption.EDIT_USER.options) {
				System.out.print("Enter the  User Name which you want to Edit :");
				sc.nextLine();
				String eu = sc.nextLine();
				EditUser(eu);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.Useroption.DELETE_USER.options) {
				System.out.print("Enter the  User Name which you want to Delete :");
				sc.nextLine();
				String du = sc.nextLine();
				DeleteUser(du);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == UserOptions.Useroption.SEARCH_USER.options) {
				System.out.print("Enter the  User Name which you want to Search :");
				sc.nextLine();
				String su = sc.nextLine();
				SearchUser(su);
				System.out.println("\n");
			}
		}
		System.out.println("\n");
		System.out.println("!!! After While Loop !!!");
		for(User u:list) {
			System.out.println("User Name is :"+u.Username);
			System.out.println("Login Name is :"+u.Loginname);
			System.out.println("Password is :"+u.Password);
			System.out.println("Confirm Password is :"+u.ConfirmPassword);
			System.out.println("UserRole is :"+u.Userrole);
		}

	}
	public static void AddUser() {
		Scanner sc = new Scanner(System.in);
		User u = new User();
		
		System.out.print("Enter User Name :");
		u.Username = sc.nextLine();
		
		System.out.print("Enter Login Name :");
		u.Loginname = sc.nextLine();
		
		System.out.print("Enter Password :");
		u.Password = sc.nextLine();
		
		System.out.print("Enter Confirm Password :");
		u.ConfirmPassword = sc.nextLine();
		
		System.out.print("Enter User Role :");
		u.Userrole = sc.nextLine();
		
		System.out.println("\n");
		System.out.println("User Name is :"+u.Username);
		System.out.println("Login Name is :"+u.Loginname);
		System.out.println("Password is :"+u.Password);
		System.out.println("Confirm Password is :"+u.ConfirmPassword);
		System.out.println("User Role is :"+u.Userrole);
		
		list.add(u);
	}
	public static void EditUser(String Username) {
		for(User u:list) {
			if(u.Username.equalsIgnoreCase(Username)) {
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter User Name :"+u.Username);
				
				System.out.print("New User Name is :");
				u.Username = sc.nextLine();
				
				System.out.print("New Login Name is :");
				u.Loginname = sc.nextLine();
				
				System.out.print("New password is :");
				u.Password = sc.nextLine();
				
				System.out.print("New Conform Password is :");
				u.ConfirmPassword = sc.nextLine();
				
				System.out.print("New User Role is :");
				u.Userrole = sc.nextLine();
				
				System.out.println("User Information updated");
				return;
			}
		}
		System.out.println("!!!!!User Not Found!!!!!");		
	}
	public static void SearchUser(String Username) {
		for(User u:list) {
			if(u.Username.equalsIgnoreCase(Username)) {
				System.out.println("User Name is :"+u.Username);
				System.out.println("Login Name is :"+u.Loginname);
				System.out.println("Password is :"+u.Password);
				System.out.println("Confirm Password is :"+u.ConfirmPassword);
				System.out.println("User Role is :"+u.Userrole);
				return;
			}
		}
		System.out.println("!!!!USER NOT FOUND!!!!");
	}
	public static void DeleteUser(String Username) {
		Iterator<User> itr1 = list.iterator();
		while(itr1.hasNext()) {
			User u = itr1.next();
			if(u.Username.equalsIgnoreCase(Username)) {
				itr1.remove();
				System.out.println("User "+u.Username+" has been deleted");
				break;
			}
		}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\rites\\eclipse-workspace\\shopManagementWithLogin02\\src\\UserManagement\\Usres");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			User user = new User();
			String [] userDataArray = line.split(",");
			if(userDataArray.length>3)
			{
				user.Loginname = userDataArray[0];
				user.Password = userDataArray[1];
				user.Username = userDataArray[2];
				user.Userrole = userDataArray[3];
				
				list.add(user);
				
			}
			
		}
		br.close();
		fr.close();
		file=null;
	}
	public static boolean validateUserAndPassword(String loginName,String password)
	{
		Iterator<User> itr = list.iterator();
		
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.Loginname.equalsIgnoreCase(loginName) && user.Password.equalsIgnoreCase(password) )
			{
				System.out.println("Login Successfull.");
				return true;
			}
		}
		return false;
	}

}