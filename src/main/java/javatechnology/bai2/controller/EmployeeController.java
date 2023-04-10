package javatechnology.bai2.controller;

import javatechnology.bai2.model.Employee;
import javatechnology.bai2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/", "/employees"})
    public String home(Model model){
        List<Employee> employees = employeeService.getALlEmployee();
        model.addAttribute("employees",employees);
        return "index";
    } //index

    @GetMapping("/employees/add")
    public String addEmployee(){
        return "add";
    }

    @PostMapping("/employees/add")
    public String postAddEmployee(@ModelAttribute Employee employee) {
        // Lưu trữ thông tin của nhân viên mới vào cơ sở dữ liệu
        employeeService.addOrUpdateEmployee(employee);

        // Chuyển hướng đến /employees để hiển thị kết quả
        return "redirect:/employees";
    }

    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "edit";
    }

    @PostMapping("/employees/edit/{id}")
    public String postEditEmployee(@ModelAttribute Employee employee){
        employeeService.addOrUpdateEmployee(employee);
        // Chuyển hướng đến /employees để hiển thị kết quả
        return "redirect:/employees";
    }

    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.removeEmployee(id);
        return "redirect:/employees";
    }

}
