package az.hrm.repo;

import az.hrm.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRawMapper implements RowMapper<Employee> {
    public EmployeeRawMapper() {
    }

    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setSalary(resultSet.getBigDecimal("salary"));
        return employee;
    }
}
