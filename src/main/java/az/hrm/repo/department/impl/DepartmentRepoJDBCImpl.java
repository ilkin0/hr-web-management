package az.hrm.repo.department.impl;

import az.hrm.entity.Department;
import az.hrm.repo.SqlQuery;
import az.hrm.repo.department.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepoJDBCImpl implements DepartmentRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private DepartmentRowMapper departmentRowMapper;
    @Override
    public List<Department> getDepartmentList(int start, int length, String sortColumn, String sortDirection, String searchValue) {


        String query = SqlQuery.GET_DEPARTMENT_LIST;
//                "select department_id, department_name, manager_id, location_id from departments order by" +
//                " %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";

        if (!searchValue.isEmpty()){
            query = SqlQuery.GET_DEPARTMENT_LIST_FILTERED;
//                    "select department_id, department_name, manager_id, location_id from departments where " +
//                    "concat(department_id, department_name, manager_id, location_id) like :searchValue " +
//                    "order by %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";
        }

        query = query.replace("%SORT_COLUMN%", sortColumn).replace("%SORT_DIRECTION%", sortDirection);

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("searchValue", "%" + searchValue + "%");
        mapSqlParameterSource.addValue("length", length);
        mapSqlParameterSource.addValue("start", start);

        return namedParameterJdbcTemplate.query(query, mapSqlParameterSource, departmentRowMapper);
    }

    @Override
    public long getDepartmentCount() {
        String query = SqlQuery.GET_DEPARTMENT_COUNT;
//                "select count(department_id) as dept_count from departments";
        Long count = jdbcTemplate.queryForObject(query, Long.class);
        return count != null ? count : 0L;
    }

    @Override
    public long getDepartmentFilteredCount(String searchValue) {
        String query = SqlQuery.GET_EMPLOYEE_COUNT_FILTERED;
//                "select count(department_id) emp_count\nfrom departments\nwhere concat(department_id, department_name, manager_id, location_id) like lower(:searchValue)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource("searchValue", "%" + searchValue + "%");
        return namedParameterJdbcTemplate.queryForObject(query, mapSqlParameterSource, Long.class);
    }
}
