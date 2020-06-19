package az.hrm.repo.employee.impl;

import az.hrm.entity.Employee;

import java.util.List;
import java.util.Optional;

import az.hrm.repo.SqlQuery;
import az.hrm.repo.employee.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoJDBCImpl implements EmployeeRepo {
    private static final Logger log = LoggerFactory.getLogger(EmployeeRepoJDBCImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private EmployeeRowMapper employeeRawMapper;
    @Autowired
    private EmployeeDetailedRowMapper employeeDetailedRowMapper;

    public EmployeeRepoJDBCImpl() {
    }

    public List<Employee> getEmployeeList(int start, int length, String sortColumn, String sortDirection, String searchValue) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("length", length)
                .addValue("start", start);

        String query = SqlQuery.GET_EMPLOYEE_LIST;

        if (!searchValue.isEmpty()) {
            query = SqlQuery.GET_EMPLOYEE_LIST_FILTERED;
            mapSqlParameterSource.addValue("searchValue", "%" + searchValue.toLowerCase() + "%");
        }

        query = query.replace("%SORT_COLUMN%", sortColumn).replace("%SORT_DIRECTION%", sortDirection);
        return namedParameterJdbcTemplate.query(query, mapSqlParameterSource, employeeRawMapper);
    }

    public Optional<Employee> getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = Optional.empty();
        String query = SqlQuery.GET_EMPLOYEE_BY_ID;
        Object[] args = new Object[]{id};
        Employee employee = jdbcTemplate.queryForObject(query, args, employeeDetailedRowMapper);
        if (employee != null) {
            optionalEmployee = Optional.of(employee);
        }

        return optionalEmployee;
    }

    public Employee updateEmployee(Employee employee) {
        String query = SqlQuery.UPDATE_EMPLOYEE;

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
        String query = SqlQuery.DELETE_EMPLOYEE;
//                "delete from employees where employee_id = ?";
        Object[] args = new Object[]{id};
        jdbcTemplate.update(query, args);
    }

    public Employee addEmployee(Employee employee) {
        String query = SqlQuery.ADD_EMPLOYEE;
        MapSqlParameterSource params = new MapSqlParameterSource("first_name", employee.getFirstName());
        params.addValue("last_name", employee.getLastName());
        params.addValue("email", employee.getEmail());
        params.addValue("phone_numeric", employee.getPhoneNumber());
        params.addValue("hire_date", employee.getHireDate());
        params.addValue("job_id", employee.getJobID());
        params.addValue("salary", employee.getSalary());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = namedParameterJdbcTemplate.update(query, params, keyHolder, new String[]{"employee_id"});
        if (count > 0) {
            employee.setId(keyHolder.getKey().longValue());
            log.debug("Successfully added new employee " + employee);
        } else {
            throw new RuntimeException("Error adding new employee " + employee);
        }

        return employee;
    }

    public long getEmployeeCount() {
        String query = SqlQuery.GET_EMPLOYEE_COUNT;
        Long count = jdbcTemplate.queryForObject(query, Long.class);
        return count != null ? count : 0L;
    }

    public long getEmployeeFilteredCount(String searchValue) {
        String query = SqlQuery.GET_EMPLOYEE_COUNT_FILTERED;
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("searchValue", "%" + searchValue + "%");
        return namedParameterJdbcTemplate.queryForObject(query, mapSqlParameterSource, Long.class);
    }
}

