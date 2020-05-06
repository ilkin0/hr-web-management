package az.hrm.repo;


import az.hrm.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo {
    List<Employee> getEmployeeList(int start, int length, String sortColumn, String sortDirection, String searchValue);

    Optional<Employee> getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(long id);

    void addEmployee(Employee employee);

    long getEmployeeCount();

    long getEmployeeFilteredCount(String searchValue);
}

