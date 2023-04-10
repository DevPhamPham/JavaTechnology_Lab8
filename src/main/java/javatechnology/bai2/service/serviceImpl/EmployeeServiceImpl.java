package javatechnology.bai2.service.serviceImpl;


import javatechnology.bai2.model.Employee;
import javatechnology.bai2.repository.EmployeeRepository;
import javatechnology.bai2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getALlEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addOrUpdateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public boolean removeEmployee(Long id) {
        Optional<Employee> optionalProduct = employeeRepository.findById(id);
        if (optionalProduct.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }
}
