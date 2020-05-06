package az.hrm.controller;

import az.hrm.model.DataTableResponse;
import az.hrm.model.Employee;
import az.hrm.repo.EmployeeRepo;
import az.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping({"/employee", "/employee/"})
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeController() {
    }

    @GetMapping({"/"})
    public String index() {
        return "employee/employee-list";
    }

    @GetMapping({"/employee-list-ajax"})
    @ResponseBody
    public DataTableResponse getEmployeeDataTable(@RequestParam(name = "draw") String draw,
                                                  @RequestParam(name = "start") int start,
                                                  @RequestParam(name = "length") int length,
                                                  @RequestParam(name = "order[0][column]") int sortColumn,
                                                  @RequestParam(name = "order[0][dir]") String sortDirection,
                                                  @RequestParam(name = "search[value]") String searchValue) {
        return this.employeeService.getEmployeeDataTable(draw, start, length, sortColumn, sortDirection, searchValue);
    }

    @GetMapping({"/employee-view"})
    public ModelAndView viewEmployee(@RequestParam(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("employee/employee");
        Optional<Employee> optionalEmployee = employeeRepo.getEmployeeById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = (Employee) optionalEmployee.get();
            modelAndView.addObject("employeeView", employee);
        }

        return modelAndView;
    }

    @GetMapping({"/employee-edit"})
    public ModelAndView editEmployee(@RequestParam(name = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("employee/employee-edit");
        Optional<Employee> optionalEmployee = employeeRepo.getEmployeeById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = (Employee) optionalEmployee.get();
            Map<String, Object> map = new HashMap();
            map.put("employee", employee);
            map.put("id", id);
            modelAndView.addAllObjects(map);
        }

        return modelAndView;
    }

    @PostMapping({"/employee-edit"})
    public ModelAndView saveEmployee(@RequestParam(name = "id") long id,
                                     @RequestParam(name = "firstName") String firstName,
                                     @RequestParam(name = "lastName") String lastName,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "phoneNumber") String phoneNumber,
                                     @RequestParam(name = "salary") BigDecimal salary) {
        ModelAndView modelAndView = new ModelAndView("redirect:/employee/employee-view?id=" + id);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setSalary(salary);
        employeeRepo.updateEmployee(employee);
        return modelAndView;
    }

    @GetMapping({"/employee-add"})
    public String indexAddEmployee() {
        return "employee/employee-add";
    }

    @PostMapping({"employee-add"})
    public ModelAndView addeEmployee(@RequestParam(name = "id") long id,
                                     @RequestParam(name = "firstName") String firstName,
                                     @RequestParam(name = "lastName") String lastName,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "phoneNumber") String phoneNumber,
                                     @RequestParam(name = "hireDate") Date hireDate,
                                     @RequestParam(name = "jobId") String jobId,
                                     @RequestParam(name = "salary") BigDecimal salary) {
        ModelAndView modelAndView = new ModelAndView("redirect://employee/employee-view?id=" + id);
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setHireDate(hireDate);
        employee.setJobID(jobId);
        employee.setSalary(salary);
        employeeRepo.addEmployee(employee);
        return modelAndView;
    }

    @GetMapping({"employee-delete"})
    public String indexDeleteEmployee(@RequestParam(name = "id") long id) {
        employeeRepo.deleteEmployeeById(id);
        return "employee/employee-list";
    }
}

