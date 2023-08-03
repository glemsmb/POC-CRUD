package com.example.demo.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping()
    public List<Employees> getEmployees() {
        return employeesService.getEmployees();
    }

    @PostMapping
    public void NewEmployees(@RequestBody Employees employees){
        employeesService.addNewEmployees(employees);
    }

    @DeleteMapping(path="{employeesId}")
    public void deleteEmployees(@PathVariable("employeesId") Long employeesId){
        employeesService.deleteEmployees(employeesId);
    }

    @PutMapping(path="{employeesId}")
    public void updateEmployees(
            @PathVariable("employeesId") Long employeesId,
            @RequestParam(required = false) String lastName){
        employeesService.updateEmployees(employeesId, lastName);
    }




}
