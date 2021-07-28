package com.dailyCodeBuffer.springBootTutorialDailyCode.service.impl;

import com.dailyCodeBuffer.springBootTutorialDailyCode.DTO.Department;
import com.dailyCodeBuffer.springBootTutorialDailyCode.repository.DepartmentRepository;
import com.dailyCodeBuffer.springBootTutorialDailyCode.service.DepartmentService;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public DepartmentServiceImpl(DepartmentRepository repo) {
        this.repo = repo;
    }

    @Override
    public String saveDepartment(Department dept) {
        repo.save(dept);
        return "success";
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> dept=repo.findById(id);
        if(dept.isPresent())
        {
            return repo.findById(id).get();
        }
        else return  null;

    }

    @Override
    public List<Department> fetchAllDepts() {
        return repo.findAll();
    }

    @Override
    public String deleteById(Long id) {
        if(repo.findById(id).isPresent())
        {
            repo.deleteById(id);
            return "success";
        }
        else
        {
            return "User doesn't exist";
        }


    }

    @Override
    public Department updateDepartment(Long id) {
        if(repo.findById(id).isPresent()) {
            Department d=repo.findById(id).get();
            d.setDepartmentName("New department");
            return repo.save(d);
        }
        else
        {
            return null;
        }


    }

    @Override
    public Department fetchDepartmentByName(String name) {
        if (repo.findByDepartmentName(name) != null)
        {
           // return repo.findByDepartmentName(name);
            return repo.findByDepartmentNameIgnoreCase(name);

        }
        else
        {
            return null;
        }
    }

    @Override
    public Department fetchDepartmentByNameAndCode(String name, String code) {
        if(repo.findByDepartmentNameAndDepartmentCode(name,code)!=null)
        {
            //return repo.findByDepartmentNameAndDepartmentCode(name,code);
            return repo.findByDepartmentNameIgnoreCaseAndDepartmentCodeIgnoreCase(name,code);
        }
        else
        {
            return  null;
        }
    }

    @Override
    public List<Department> fetchBetween(Long l1, Long l2) {
            return repo.findByIdBetween(l1,l2);
    }


}