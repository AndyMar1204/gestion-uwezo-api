package com.andy.gestion_uai.service;

import com.andy.gestion_uai.model.Employee;
import com.andy.gestion_uai.repos.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements Crud<Employee> {
    private final EmployeeRepository repository;


    /**
     * @param employee
     * @return id
     */
    @Override
    public Long create(Employee employee) {
        return repository.save(employee).getId();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Employee> read(Long id) {
        return repository.findById(id);
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public Employee Update(Employee employee) {
        return repository.save(employee);
    }

    /**
     * @param id
     */
    @Override
    public void deleteById(Long id)  {
        deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}
