package az.hrm.repo.department.impl;

import az.hrm.entity.Department;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DepartmentRowMapper implements RowMapper<Department> {

    public DepartmentRowMapper() {
    }

    @Override
    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();

        department.setDepartmentID(resultSet.getLong("department_id"));
        department.setDepartmentName(resultSet.getString("department_name"));
        department.setManagerID(resultSet.getLong("manager_id"));
        department.setLocationID(resultSet.getLong("location_id"));

        return department;
    }


}
