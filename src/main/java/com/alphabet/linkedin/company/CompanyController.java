package com.alphabet.linkedin.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private ComapnyService companyService;


    //    Get => /companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    //    get => /companies/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id){
        Company company = companyService.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    post => /companies

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        boolean status = companyService.createCompany(company);
        if(status){
            return new ResponseEntity<>("company created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("failed to create company", HttpStatus.NOT_FOUND);
        }

    }
    //    Put => /companies/{id}

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable long id, @RequestBody Company company){

        boolean status = companyService.updateCompany(id,company);
        if(status){
            return new ResponseEntity<>("company updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed to update company.", HttpStatus.OK);
        }

    }
//    delete => /companies/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id){
        boolean status = companyService.deleteCompanyById(id);
        if(status){
            return new ResponseEntity<>("company delete successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("failed to delete company.", HttpStatus.OK);
        }

    }



}
