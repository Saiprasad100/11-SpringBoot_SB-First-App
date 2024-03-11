package in.sai;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import in.sai.entity.Employee;
import in.sai.entity.repo.EmployeeRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeRepository repo = context.getBean(EmployeeRepository.class);
		/*
		 * 
		 * System.out.println(repo.getClass().getName());
		 * 
		 * Employee e1=new Employee(101,"Sai",15000.00,"male","Admin"); Employee e2=new
		 * Employee(103,"Priyanka",19000.00,"female","Developer"); Employee e3=new
		 * Employee(102,"Hitesh",7000.00,"male","DevOOPS"); Employee e4=new
		 * Employee(105,"Namita",25000.00,"female","Testing"); Employee e5=new
		 * Employee(106,"Bibhu",5000.00,"male","HR"); Employee e6=new
		 * Employee(104,"Swagat",25000.00,"male","Admin");
		 * 
		 * List<Employee> all = repo.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6));
		 * 
		 * System.out.println("Records Inserted.....");
		 * 
		 */
		//    #2 Ascending By Employee Name
		Sort ascending1 = Sort.by("empName").ascending();
		List<Employee> emps = repo.findAll(ascending1);
		emps.forEach(System.out::println);

		/*
		 * int pageNO=2;
		 * 
		 * PageRequest request = PageRequest.of(pageNO-1, 2);
		 * 
		 * //Sort ascending = Sort.by("empName").ascending();
		 * 
		 * Page<Employee> emps = repo.findAll(request);
		 * 
		 * 
		 * emps.forEach(System.out::println);
		 * 
		 */

		Employee emp = new Employee();
		emp.setEmpGender("Male");
		emp.setEmpDept("Admin");

		Example<Employee> exmp = Example.of(emp);

		List<Employee> all = repo.findAll(exmp);

		all.forEach(System.out::println);

	}

}
