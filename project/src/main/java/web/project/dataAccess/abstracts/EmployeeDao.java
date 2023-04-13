package web.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import web.project.entities.concretes.Employee;
import web.project.entities.dtos.EmployeeWithCompanyDto;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	@Query("Select new web.project.entities.dtos.EmployeeWithCompanyDto(e.employeeId, e.name, e.surname, e.age, c.companyName) From Company c Inner Join c.employees e")
	List<EmployeeWithCompanyDto> getEmployeeWithCompanyDetails();
}
