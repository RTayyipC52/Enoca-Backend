package web.project.business.abstracts;

import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Company;

public interface CompanyService extends BaseEntityService<Company>{
	DataResult<Company> getById(int companyId);
	Result delete(int companyId);
}
