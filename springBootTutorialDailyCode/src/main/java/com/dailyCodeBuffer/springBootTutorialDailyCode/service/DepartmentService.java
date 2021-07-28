package com.dailyCodeBuffer.springBootTutorialDailyCode.service;

import com.dailyCodeBuffer.springBootTutorialDailyCode.DTO.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public String saveDepartment(Department dept);

    public Department getDepartmentById(Long id);
    public List<Department> fetchAllDepts();

    public String deleteById(Long id);

    public Department updateDepartment(Long id);

    public  Department fetchDepartmentByName(String name);
    public Department fetchDepartmentByNameAndCode(String name,String code);

    public List<Department> fetchBetween(Long l1, Long l2);
}
