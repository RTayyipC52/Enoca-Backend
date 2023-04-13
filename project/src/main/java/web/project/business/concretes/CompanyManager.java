package web.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.project.business.abstracts.CompanyService;
import web.project.core.results.DataResult;
import web.project.core.results.ErrorDataResult;
import web.project.core.results.Result;
import web.project.core.results.SuccessDataResult;
import web.project.core.results.SuccessResult;
import web.project.dataAccess.abstracts.CompanyDao;
import web.project.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService{
	private CompanyDao companyDao;

	@Autowired
	public CompanyManager(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Override
	public DataResult<List<Company>> getAll() {
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"Şirketler listelendi");
	}

	@Override
	public Result add(Company company) {
		this.companyDao.save(company);
		return new SuccessResult("Şirket eklendi");
	}

	@Override
	public Result update(Company company) {
		this.companyDao.save(company);
		return new SuccessResult("Şirket güncellendi");
	}

	@Override
	public DataResult<Company> getById(int companyId) {
		if (this.companyDao.findById(companyId).isEmpty()){
            return new ErrorDataResult<Company>("Bu Id'ye ait bir kayıt yoktur");
        }else {
            return new SuccessDataResult<Company>(this.companyDao.getById(companyId), "Id'ye göre data listelendi");
        }
	}

	@Override
	public Result delete(int companyId) {
		this.companyDao.deleteById(companyId);
		return new SuccessResult("Şirket silindi");
	}
}
