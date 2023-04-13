package web.project.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeWithCompanyDto {
	private int employeeId;
	private String name;
	private String surname;
	private String age;
	private String companyName;
}
