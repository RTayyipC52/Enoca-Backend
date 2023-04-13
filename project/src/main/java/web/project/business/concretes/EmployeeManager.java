package web.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.EmployeeService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.EmployeeDao;
import web.project.entities.concretes.Employee;
import web.project.entities.dtos.EmployeeWithCompanyDto;

@Service
public class EmployeeManager implements EmployeeService{
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),"Çalışanlar listelendi");
	}

	@Override
	public Result add(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan eklendi");
	}

	@Override
	public Result update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("Çalışan güncellendi");
	}

	@Override
	public DataResult<Employee> getById(int employeeId) {
		if (this.employeeDao.findById(employeeId).isEmpty()){
            return new ErrorDataResult<Employee>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Employee>(this.employeeDao.getById(employeeId), "Id'ye göre data listelendi");
        }
	}

	@Override
	public Result delete(int employeeId) {
		this.employeeDao.deleteById(employeeId);
		return new SuccessResult("Çalışan silindi");
	}

	@Override
	public DataResult<List<EmployeeWithCompanyDto>> getEmployeeWithCompanyDetails() {
		return new SuccessDataResult<List<EmployeeWithCompanyDto>>
		(this.employeeDao.getEmployeeWithCompanyDetails(),"Data listelendi.");
	}
}
