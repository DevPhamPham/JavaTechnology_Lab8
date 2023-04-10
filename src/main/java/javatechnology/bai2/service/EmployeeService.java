package javatechnology.bai2.service;

import javatechnology.bai2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getALlEmployee();
    Employee addOrUpdateEmployee(Employee employee);
    boolean removeEmployee(Long id);
    Employee getEmployeeById(Long id);
}
