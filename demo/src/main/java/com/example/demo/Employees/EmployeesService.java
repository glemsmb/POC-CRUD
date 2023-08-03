package com.example.demo.Employees;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> getEmployees() {
        return employeesRepository.findAll();
    }


    public void addNewEmployees(Employees employees) {
        System.out.println(employees);
    }

    public void deleteEmployees(Long employeesId) {
        boolean exist = employeesRepository.existsById(employeesId);
            if (!exist){
                throw new IllegalStateException(
                        "employee with id" + employeesId + "cannot find");
            }
            employeesRepository.deleteById(employeesId);

    }
    @Transactional
    public void updateEmployees(Long employeesId, String lastName) {
        Employees employees = employeesRepository.findById(employeesId)
                .orElseThrow(() -> new IllegalStateException(
                        "employees with id " + employeesId + "cannot find")
                );
        if (lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(employees.getLastName(), lastName)){
            employees.setLastName(lastName);
        }
    }
}

