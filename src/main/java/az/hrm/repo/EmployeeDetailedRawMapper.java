package az.hrm.repo;

import az.hrm.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailedRawMapper implements RowMapper<Employee> {
    public EmployeeDetailedRawMapper() {
    }

    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        employee.setEmail(resultSet.getString("email"));
        employee.setPhoneNumber(resultSet.getString("phone_numeric"));
        employee.setJobID(resultSet.getString("job_id"));
        return employee;
    }
}
