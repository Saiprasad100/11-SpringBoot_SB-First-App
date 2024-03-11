package in.sai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	private Integer empId;
	private String empName;
	private Double empSalary;
	private String empGender;
	private String empDept;
	


}
