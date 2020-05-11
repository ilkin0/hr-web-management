package az.hrm.controller;

import az.hrm.form.EmployeeForm;
import az.hrm.model.DataTableResponse;
import az.hrm.model.Employee;
import az.hrm.repo.EmployeeRepo;
import az.hrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public ModelAndView editEmployee(
            @RequestParam(name = "id") long id
    ) {
        ModelAndView modelAndView = new ModelAndView("employee/employee-edit");
        Optional<Employee> optionalEmployee = employeeRepo.getEmployeeById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            EmployeeForm employeeForm = parseToForm(employee);

            Map<String, Object> map = new HashMap<>();
            map.put("employeeForm", employeeForm);
            map.put("id", id);
            modelAndView.addAllObjects(map);
        }

        return modelAndView;
    }

    private static EmployeeForm parseToForm(Employee employee){
        EmployeeForm employeeForm = new EmployeeForm();

        employeeForm.setId(String.valueOf(employee.getId()));
        employeeForm.setFirstName(employee.getFirstName());
        employeeForm.setLastName(employee.getLastName());
        employeeForm.setEmail(employee.getEmail());
        employeeForm.setPhoneNumber(employee.getPhoneNumber());
        employeeForm.setHireDate(String.valueOf(employee.getHireDate()));
        employeeForm.setJobID(employee.getJobID());
        employeeForm.setSalary(String.valueOf(employee.getSalary()));

        return employeeForm;
    }

    @PostMapping({"/employee-edit"})
    public ModelAndView saveEmployee(
            @ModelAttribute("employeeForm") @Valid EmployeeForm employeeForm,
            BindingResult validationResult
    ) {
        ModelAndView modelAndView = new ModelAndView();

        if (validationResult.hasErrors()){
            modelAndView.setViewName("employee/employee-edit");
        } else {
            modelAndView.setViewName("redirect:/employee/employee");
        }
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

