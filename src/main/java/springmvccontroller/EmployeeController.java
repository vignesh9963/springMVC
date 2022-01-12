package springmvccontroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.model.Employee;
import com.dxc.service.EmployeeService;
import com.dxc.serviceimpl.EmployeeServiceImpl;
import com.dxc.util.MyConnection;

//@Controller -which will convert class to controller to take http request
//@GetMapping --take the http get request
//@PathVariable --which will read the value in the path url /3
//@RequestParam  --request take the data from request   ?id=3

@Controller
public class EmployeeController {
	
	
	
	
	EmployeeServiceImpl employeeservice=new EmployeeServiceImpl();
	
	//----------------Edit Employee----------------------
	
	@GetMapping("/editemployee/{id}")
	public String editEmpployee(Model model, @PathVariable Integer id) 
	{
		System.out.println("@PathVariable "+id);
		Connection con=MyConnection.getConnection();
		try
		{
		Statement st=con.createStatement();
	    String querySelectByID="select * from employee where id='"+id+"'";
		ResultSet rs=st.executeQuery(querySelectByID);
		Employee employee=new Employee();
		
		while(rs.next())
		{
			employee.setiD(rs.getInt(1));
			employee.setUserName(rs.getString(2));
			employee.setFirstName(rs.getString(3));
			employee.setLastName(rs.getString(4));
			employee.setSalary(rs.getInt(5));
			employee.setPassword(rs.getString(6));
		}
		
		model.addAttribute("employee",employee);
		}
		catch(Exception e)
		{
			
		}
		finally {
			try
			{
			con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return "editemployee";
	}
	
	//---------------Insert employee--------------------
	
	@GetMapping("/addnew")
	public String addNewEmployee()
	{
		return "addnewemployee";
	}
	
	@PostMapping("/saveemployee")
	public String saveNewEmployee(Model model,@RequestParam String username,
			                    
			                    @RequestParam String fname,
			                    @RequestParam String lname,
			                    @RequestParam Integer salary,
			                    @RequestParam String password
			                    )
	{
	
		
		
		
		Employee employee =new Employee();
		
		employee.setiD(null);
		employee.setUserName(username);
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setSalary(salary);
		employee.setPassword(password);
		
		List<Employee> employeeList=employeeservice.insertEmployee(employee);
		
		model.addAttribute("employeelist",employeeList);
			
		return "home";
	}
	
	
	//--------------------Update employee--------------------------
	
	@PostMapping("/updateemployee")
	public String saveNewEmployee(Model model,@RequestParam String username,
	@RequestParam String fname,
	@RequestParam String lname,
	@RequestParam Integer salary,
	@RequestParam String password,
	@RequestParam Integer id
	)
	{

Employee employee =new Employee();
		
		employee.setiD(null);
		employee.setUserName(username);
		employee.setFirstName(fname);
		employee.setLastName(lname);
		employee.setSalary(salary);
		employee.setPassword(password);
		
		List<Employee> employeeList=employeeservice.updateEmployee(employee);


	

	//selected the employee list ends

	model.addAttribute("employeelist",employeeList);

	return "home";
	}
	
	
	
	
//	------------Delete employee---------------
	@GetMapping("/deleteemployee/{id}")
	public String deleteEmployee(Model model,@PathVariable int id)
	{
	
		
	
	
		//String query="insert into employee values(null,'"+ username+"','"+fname+"','"+lname+"','"+salary+"','"+password+"')";
	
		

Employee employee =new Employee();
		

		
		employee.setiD(id);
	
		List<Employee> employeeList=employeeservice.deleteEmployee(id);
		
		model.addAttribute("employeelist",employeeList);
			
		return "home";
	}
	
}
