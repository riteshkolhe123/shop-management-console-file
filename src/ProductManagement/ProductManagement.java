package ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import UserManagement.UserOptions;
public class ProductManagement {
	static ArrayList<Product> array = new ArrayList();
	public static void ProductManagement() throws IOException
	{
		loadDataFromFileToArrayList();
		Scanner sc = new Scanner(System.in);
		
		boolean CanIKeepRunningTheProgram = true;
		while(CanIKeepRunningTheProgram == true)
		{
			System.out.println("!!!!! Welcome To Product Management System !!!!!");
			System.out.println("\n");
			System.out.println("What Would like to do ?");
			System.out.println("1. Add Product");
			System.out.println("2. Edit Product");
			System.out.println("3. Search Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Quit");
			
			int OptionSelectedByUser = sc.nextInt();
			
			if(OptionSelectedByUser == ProductOptions.Productoption.QUIT.options)
			{
				File file = new File("C:\\Users\\rites\\eclipse-workspace\\shopManagementWithLogin02\\src\\ProductManagement\\Products");
				FileWriter fileWriter = new FileWriter(file,false);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for(Product product:array)
				{
					System.out.println(product.Productname+","+product.Productid+","+product.Productprice+","+product.Productquantity+","+product.Productcategory+"\n");
					bufferedWriter.write(product.Productname+","+product.Productid+","+product.Productprice+","+product.Productquantity+","+product.Productcategory+"\n");
				}
				
				
				bufferedWriter.close();
				fileWriter.close();
				file=null;
				
				
				System.out.println("!! Program Closed !!");
				CanIKeepRunningTheProgram = false;
			}
			else if(OptionSelectedByUser == ProductOptions.Productoption.ADD_PRODUCT.options)
			{
				AddProduct();
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == ProductOptions.Productoption.EDIT_PRODUCT.options)
			{
				System.out.println("Enter the name of product which you want to edit :");
				sc.nextLine();
				String Productname = sc.nextLine();
				EditProduct(Productname);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == ProductOptions.Productoption.SEARCH_PRODUCT.options)
			{
				System.out.println("Enter Product name which you want to search :");
				sc.nextLine();
				String Productname = sc.nextLine();
				SearchProduct(Productname);
				System.out.println("\n");
			}
			else if(OptionSelectedByUser == ProductOptions.Productoption.DELETE_PRODUCT.options)
			{
				System.out.println("Enter Product name which you want to delete");
				sc.nextLine();
				String Productname = sc.nextLine();
				DeleteProduct(Productname);
				System.out.println("\n");
			}
		}
		System.out.println("\n");
		System.out.println("!!! After While Loop !!!");
		for(Product u:array) 
		{
			System.out.println("Product Name is :"+u.Productname);
			System.out.println("Product ID is :"+u.Productid);
			System.out.println("Product Price is :"+u.Productprice);
			System.out.println("Product Quantity is :"+u.Productquantity);
			System.out.println("Product Category is :"+u.Productcategory);
		}
		
		
		
	}
	public static void AddProduct()
	{
		Scanner sc = new Scanner(System.in);
		Product u = new Product();
		System.out.println("Enter Product name :");
		u.Productname = sc.nextLine();
		System.out.println("Enter Product ID :");
		u.Productid = sc.nextLine();
		System.out.println("Enter Product Price :");
		u.Productprice = sc.nextLine();
		System.out.println("Enter Product Quantity :");
		u.Productquantity = sc.nextLine();
		System.out.println("Enter Product Category :");
		u.Productcategory = sc.nextLine();
		
		array.add(u);
		
		System.out.println("Product Name is :"+u.Productname);
		System.out.println("Product ID is :"+u.Productid);
		System.out.println("Product Price is :"+u.Productprice);
		System.out.println("Product Quantity is :"+u.Productquantity);
		System.out.println("Product Category is :"+u.Productcategory);
	}
	public static void EditProduct(String Productname)
	{
		for (Product u : array)
		{
		    if(u.Productname.equalsIgnoreCase(Productname))
		    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Current Product name is :"+u.Productname);
		System.out.println("Enter new Product name :");
		u.Productname = sc.nextLine();
		System.out.println("Enter new Product ID :");
		u.Productid = sc.nextLine();
		System.out.println("Enter new price of product :");
		u.Productprice = sc.nextLine();
		System.out.println("Enter new qantity of product :");
		u.Productquantity = sc.nextLine();
		System.out.println("Enter new category of product :");
		u.Productcategory = sc.nextLine();
		
		System.out.println("New Product Name is :"+u.Productname);
		System.out.println("New Product ID is :"+u.Productid);
		System.out.println("New Product Price is :"+u.Productprice);
		System.out.println("New Product Quantity is :"+u.Productquantity);
		System.out.println("New Product Category is :"+u.Productcategory);
		return;
		}
		}
		System.out.println("!!!!! Product Not Found !!!!!");	
	}
	public static void SearchProduct(String Productname)
	{
		for(Product u :array )
		{
			if(u.Productname.equalsIgnoreCase(Productname))
			{
				System.out.println("Product Name is :"+u.Productname);
				System.out.println("Product ID is :"+u.Productid);
				System.out.println("Product Price is :"+u.Productprice);
				System.out.println("Product Quantity is :"+u.Productquantity);
				System.out.println("Product Category is :"+u.Productcategory);
			}
		}
		System.out.println("!!!!! Product Not Found !!!!!");
	}
	public static void DeleteProduct(String Productname)
	{
		Iterator<Product> itr = array.iterator();
		while(itr.hasNext())
		{
			Product u = itr.next();
			if(u.Productname.equalsIgnoreCase(Productname))
			{
				itr.remove();
				System.out.println("Product "+u.Productname +"has been deleted");
				break;
			}
		}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\rites\\eclipse-workspace\\shopManagementWithLogin02\\src\\ProductManagement\\Products");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while((line = br.readLine())!=null)
		{
			Product product = new Product();
			String [] userDataArray = line.split(",");
			if(userDataArray.length>3)
			{
				product.Productname = userDataArray[0];
				product.Productid = userDataArray[1];
				product.Productprice = userDataArray[2];
				product.Productquantity = userDataArray[3];
				product.Productcategory = userDataArray[4];
				
				array.add(product);
				
			}
			
		}
		br.close();
		fr.close();
		file=null;
	}

}