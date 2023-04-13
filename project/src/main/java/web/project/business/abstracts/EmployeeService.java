package web.project.business.abstracts;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Employee;

public interface EmployeeService extends BaseEntityService<Employee>{
	DataResult<Employee> getById(int employeeId);
	Result delete(int employeeId);
}
