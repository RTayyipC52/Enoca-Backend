package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.project.business.abstracts.EmployeeService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Employee;
import web.project.entities.dtos.EmployeeWithCompanyDto;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {
	
	private EmployeeService employeeService;

    @Autowired
    public  EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Employee> getById(@RequestParam int employeeId) {
        return this.employeeService.getById(employeeId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employee employee) {
        return this.employeeService.add(employee);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employee employee) {
        return this.employeeService.update(employee);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int employeeId) {
        return this.employeeService.delete(employeeId);
    }
    
    @GetMapping("/getEmployeeWithCompanyDetails")
	public DataResult<List<EmployeeWithCompanyDto>> getEmployeeWithCompanyDetails(){
		return this.employeeService.getEmployeeWithCompanyDetails();
	}
}
