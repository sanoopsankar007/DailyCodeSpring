package com.dailyCodeBuffer.springBootTutorialDailyCode.repository;

import com.dailyCodeBuffer.springBootTutorialDailyCode.DTO.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentName(String name);

    public Department findByDepartmentNameIgnoreCase(String name);
    public Department findByDepartmentNameAndDepartmentCode(String name,String code);
    public Department findByDepartmentNameIgnoreCaseAndDepartmentCodeIgnoreCase(String name,String code);
    public List<Department> findByIdBetween(Long l1, Long l2);
}
