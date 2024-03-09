package com.alphabet.linkedin.company.impl;

import com.alphabet.linkedin.company.Company;

import java.util.List;

public interface CompanyServiceImpl {

    //    Get => /companies
    //    get => /companies/{id}
    //    Put => /companies/{id}
    //    post => /companies
    //    delete => /companies/{id}


    public abstract List<Company> getAllCompanies();

    public abstract Company getCompanyById(long id);

    public abstract boolean createCompany(Company company);

    public abstract boolean updateCompany(long id, Company updatedcompany);

    public abstract boolean deleteCompanyById(long id);
}
