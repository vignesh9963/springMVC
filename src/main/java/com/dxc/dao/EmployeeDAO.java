package com.dxc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.model.Employee;
import com.dxc.util.MyConnection;

public class EmployeeDAO {
	
	final Connection con=MyConnection.getConnection();
	
	
	//-------SAVE EMPLYOEE----------------
	
	
	public List<Employee> insertEmployee(Employee emp)
	{
		
		
//String query="insert into employee values(null,'"+ emp.getiD()+"','"+emp.getUserName()+"','"+emp.getFirstName()+"','"+emp.getLastName()+"','"+emp.getSalary()+"','"+emp.getPassword()+"')";

		String queryInsert="insert into employee values(?,?,?,?,?,?)";
   

		try
		{
	
	    PreparedStatement stmt=con.prepareStatement(queryInsert);  
	    stmt.setString(1, null); //setting the id
	    stmt.setString(2, emp.getUserName()); //setting the username
	    stmt.setString(3, emp.getFirstName()); //setting the username
	    stmt.setString(4, emp.getLastName()); //setting the username
	    stmt.setInt(5, emp.getSalary()); //setting the username
	    stmt.setString(6, emp.getPassword()); //setting the username
	    stmt.executeUpdate();
	    
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		//adding the new employee ends
		
		
		//selected the employee list starts
		
       List<Employee> employeeList=new ArrayList<Employee>();
		
		String querySelect="select * from employee order  by id desc";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(querySelect);
		
		while(result.next())
		{
			//printing the record
			System.out.println("id "+result.getInt(1));
			System.out.println("username"+result.getString(2));
			System.out.println("First Name"+result.getString(3));
			System.out.println("Last Name "+result.getString(4));
			System.out.println("Salary "+result.getInt(5));
			System.out.println("password "+result.getString(6));
			
			//storing into variable
			int idDb=result.getInt(1);
			String usernameDb=result.getString(2);
			String fnameDb=result.getString(3);
			String lnameDb=result.getString(4);
			int salaryDb=result.getInt(5);
			String passwordDb=result.getString(6);
			//store to employee class
			Employee employee=new Employee();
			
			employee.setiD(idDb);
			employee.setUserName(usernameDb);
			employee.setFirstName(fnameDb);
			employee.setLastName(lnameDb);
			employee.setSalary(salaryDb);
			employee.setPassword(passwordDb);
			employeeList.add(employee);
			
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

		
		
			return employeeList;
	}
	
	
	
	//---------------------------UPDATE EMPLOYEE--------------------------------
	
	
	public List<Employee> updateEmployee(Employee emp)
	{
		
		
		//Connection con=MyConnection.getConnection();

		//String query="insert into employee values(null,'"+ username+"','"+password+"','"+fname+"','"+lname+"','"+salary+"')";
		

		String queryUpdate="update employee set(?,?,?,?,?,?) where id=?;" ;
		try
		{

			 PreparedStatement stmt=con.prepareStatement(queryUpdate);  
			   stmt.setString(1, null); //setting the id
			    stmt.setString(2, emp.getUserName()); //setting the username
			    stmt.setString(3, emp.getFirstName()); //setting the username
			    stmt.setString(4, emp.getLastName()); //setting the username
			    stmt.setInt(5, emp.getSalary()); //setting the username
			    stmt.setString(6, emp.getPassword()); //setting the username
			    stmt.executeUpdate();

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}

		//adding the new employee ends


		//selected the employee list starts

		List<Employee> employeeList=new ArrayList<Employee>();

		String querySelect="select * from employee order by id desc";
		try
		{
		Statement st=con.createStatement();

		ResultSet result=st.executeQuery(querySelect);

		while(result.next())
		{
		//printing the record
		System.out.println("id "+result.getInt(1));
		System.out.println("username"+result.getString(2));
		System.out.println("First Name"+result.getString(3));
		System.out.println("Last Name "+result.getString(4));
		System.out.println("Salary "+result.getInt(5));
		System.out.println("password "+result.getString(6));

		//storing into variable
		int idDb=result.getInt(1);
		String usernameDb=result.getString(2);
		String fnameDb=result.getString(3);
		String lnameDb=result.getString(4);
		int salaryDb=result.getInt(5);
		String passwordDb=result.getString(6);
		//store to employee class
		Employee employee=new Employee();

		employee.setiD(idDb);
		employee.setUserName(usernameDb);
		employee.setFirstName(fnameDb);
		employee.setLastName(lnameDb);
		employee.setSalary(salaryDb);
		employee.setPassword(passwordDb);
		employeeList.add(employee);


		}

		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return employeeList;
		
	}
	
	
	
	
//------------------------------DELETE EMPLOYEE-----------------------------
	
	
	
	
	public List<Employee> deleteEmployee(Integer id)
	{
		//String queryDelete="delete from employee where id="+id;
		
		String queryDelete="delete from employee where id(?)";
	
		try
		{
		
			PreparedStatement stmt=con.prepareStatement(queryDelete);  
		    stmt.setInt(1, id); //setting the id
		
		}
		catch(Exception e)
		{
		 e.printStackTrace();
		}
		
		
		
		
		
		
       List<Employee> employeeList=new ArrayList<Employee>();
		
		String querySelect="select * from employee order  by id desc";
		try
		{
		Statement st=con.createStatement();
		
		ResultSet result=st.executeQuery(querySelect);
		
		while(result.next())
		{
			//printing the record
			System.out.println("id "+result.getInt(1));
			System.out.println("username"+result.getString(2));
			System.out.println("First Name"+result.getString(3));
			System.out.println("Last Name "+result.getString(4));
			System.out.println("Salary "+result.getInt(5));
			System.out.println("password "+result.getString(6));
			
			//storing into variable
			int idDb=result.getInt(1);
			String usernameDb=result.getString(2);
			String fnameDb=result.getString(3);
			String lnameDb=result.getString(4);
			int salaryDb=result.getInt(5);
			String passwordDb=result.getString(6);
			//store to employee class
			Employee employee=new Employee();
			
			employee.setiD(idDb);
			employee.setUserName(usernameDb);
			employee.setFirstName(fnameDb);
			employee.setLastName(lnameDb);
			employee.setSalary(salaryDb);
			employee.setPassword(passwordDb);
			employeeList.add(employee);
			
			
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeList;
		
	}
	
	
	
	
	//-------------------------

}
