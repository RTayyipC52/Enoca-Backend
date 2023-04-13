package web.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.entities.concretes.Company;

public interface CompanyDao extends JpaRepository<Company, Integer>{

}
