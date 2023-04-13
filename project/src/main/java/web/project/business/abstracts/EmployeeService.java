package web.project.business.abstracts;

import java.util.List;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Employee;
import web.project.entities.dtos.EmployeeWithCompanyDto;

public interface EmployeeService extends BaseEntityService<Employee>{
	DataResult<Employee> getById(int employeeId);
	Result delete(int employeeId);
	DataResult<List<EmployeeWithCompanyDto>> getEmployeeWithCompanyDetails();
}
