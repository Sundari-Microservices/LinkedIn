package com.alphabet.linkedin.company;

import com.alphabet.linkedin.company.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComapnyService implements CompanyServiceImpl {

    @Autowired
    private CompanyRepository companyRepository;
    /**
     * @return
     */
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * @param company
     * @return
     */
    @Override
    public boolean createCompany(Company company) {
        companyRepository.save(company);
        return true;
    }

    /**
     * @param id
     * @param updatedcompany
     * @return
     */
    @Override
    public boolean updateCompany(long id, Company updatedcompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if( company != null){
           company.setCompanyName(updatedcompany.getCompanyName());
           company.setCompanyDescription(updatedcompany.getCompanyDescription());
           company.setJobs(updatedcompany.getJobs());
           company.setCompanyLocation(updatedcompany.getCompanyLocation());
           companyRepository.save(company);
           return true;
        } else {
            return false;
        }
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteCompanyById(long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
