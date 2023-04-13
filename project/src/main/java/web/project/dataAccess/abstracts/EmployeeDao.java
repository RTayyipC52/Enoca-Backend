package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
