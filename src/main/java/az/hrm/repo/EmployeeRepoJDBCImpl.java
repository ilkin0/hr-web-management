package az.hrm.repo;

import az.hrm.model.Employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoJDBCImpl implements EmployeeRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private EmployeeRawMapper employeeRawMapper;
    @Autowired
    private EmployeeDetailedRawMapper employeeDetailedRawMapper;

    public EmployeeRepoJDBCImpl() {
    }

    public List<Employee> getEmployeeList(int start, int length, String sortColumn, String sortDirection, String searchValue) {
        MapSqlParameterSource mapSqlParameterSource = (new MapSqlParameterSource("searchValue", "%" + searchValue + "%"))
                .addValue("length", length)
                .addValue("start", start);

        String query = "select employee_id, first_name, last_name, salary " +
                " from employees " +
                " order by %SORT_COLUMN% %SORT_DIRECTION% " +
                " limit :length offset :start";
        if (!searchValue.isEmpty()) {
            query = "select employee_id, first_name, last_name, salary " +
                    " from employees\n where concat(employee_id, first_name, last_name, salary) like :searchValue " +
                    " order by %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";
        }

        query = query.replace("%SORT_COLUMN%", sortColumn).replace("%SORT_DIRECTION%", sortDirection);
        return namedParameterJdbcTemplate.query(query, mapSqlParameterSource, employeeRawMapper);
    }

    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = Optional.empty();
        String query = "select employee_id, first_name, last_name, salary, email, job_id, phone_numeric " +
                "from employees where employee_id = ?";
        Object[] args = new Object[]{id};
        Employee employee = jdbcTemplate.queryForObject(query, args, employeeDetailedRawMapper);
        if (employee != null) {
            optionalEmployee = Optional.of(employee);
        }

        return optionalEmployee;
    }

    public Employee updateEmployee(Employee employee) {
        String query = "UPDATE employees  SET first_name = ?, last_name = ?, email = ?, phone_numeric = ?, salary = ?  WHERE employee_id = ?";
        Object[] args = new Object[]{employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getSalary(),
                employee.getId()};
        jdbcTemplate.update(query, args);
        return employee;
    }

    public void deleteEmployeeById(long id) {
        String query = "delete from employees where employee_id = ?";
        Object[] args = new Object[]{id};
        jdbcTemplate.update(query, args);
    }

    public void addEmployee(Employee employee) {
        String query = "insert into employees (employee_id, first_name, last_name, email, phone_numeric,hire_date ,job_id, salary)  Values (?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = new Object[]{employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJobID(),
                employee.getSalary()};
        jdbcTemplate.update(query, args);
    }

    public long getEmployeeCount() {
        String query = "select count(employee_id) as emp_count from employees";
        Long count = jdbcTemplate.queryForObject(query, Long.class);
        return count != null ? count : 0L;
    }

    public long getEmployeeFilteredCount(String searchValue) {
        String query = "select count(employee_id) emp_count\nfrom employees\nwhere concat(employee_id, first_name, last_name, salary) like :searchValue";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("searchValue", "%" + searchValue + "%");
        return namedParameterJdbcTemplate.queryForObject(query, mapSqlParameterSource, Long.class);
    }
}

