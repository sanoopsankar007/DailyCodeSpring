package com.dailyCodeBuffer.springBootTutorialDailyCode.controller;

import ch.qos.logback.core.CoreConstants;
import com.dailyCodeBuffer.springBootTutorialDailyCode.DTO.Department;
import com.dailyCodeBuffer.springBootTutorialDailyCode.service.impl.DepartmentServiceImpl;
import com.dailyCodeBuffer.springBootTutorialDailyCode.service.impl.sampleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.lang.constant.Constable;
import java.util.List;

@RestController
@RequestMapping(path="department")
public class DepartmentController {

    @Autowired
    private sampleServiceImpl sample;
    private  DepartmentServiceImpl service;
    @Autowired
    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/save")
    public  String saveDept(@RequestBody Department dept)
    {

        //can also return  department
        return service.saveDepartment(dept);


    }
    @GetMapping("/getById/{id}")
    public Department getDptById(@PathVariable("id") Long id)
    {

        return service.getDepartmentById(id);

    }
    @GetMapping("/fetchAll")
    public List<Department> fetchAll()
    {
        return service.fetchAllDepts();
    }
    @DeleteMapping("/deleteById/{id}")
    public String dltbyId(@PathVariable("id") Long id)
    {
        return service.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public Department updateDept(@PathVariable Long id)
    {
        return service.updateDepartment(id);
    }

    @GetMapping("/fetchByname/{name}")
    public Department fetchByName(@PathVariable("name") String name)
    {
        System.out.println(service.fetchDepartmentByName(name).getDepartmentCode());
        return service.fetchDepartmentByName(name);
    }

    @GetMapping("/fetchByNameAndCode/{name}/{code}")
    public Department fetchByNameAndCode(@PathVariable("name") String name,@PathVariable("code") String code)
    {
        return service.fetchDepartmentByNameAndCode(name,code);
    }

    @GetMapping("/between/{l1}/{l2}")
    public  List<Department> fetchIdBetween(@PathVariable Long l1,@PathVariable Long l2)
    {
        return  service.fetchBetween(l1,l2);
    }

    @GetMapping("/sample")
    public String sampleMethod()
    {
        return sample.hello();
    }

}
