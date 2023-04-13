package web.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.project.business.abstracts.CompanyService;
import web.project.core.results.DataResult;
import web.project.core.results.Result;
import web.project.entities.concretes.Company;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin
public class CompanyController {

	private CompanyService companyService;

    @Autowired
    public  CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Company>> getAll() {
        return this.companyService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Company> getById(@RequestParam int companyId) {
        return this.companyService.getById(companyId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Company company) {
        return this.companyService.add(company);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Company company) {
        return this.companyService.update(company);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int companyId) {
        return this.companyService.delete(companyId);
    }
}
