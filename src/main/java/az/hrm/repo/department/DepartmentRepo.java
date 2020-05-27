package az.hrm.repo.department;

import az.hrm.model.Department;

import java.util.List;

public interface DepartmentRepo {
    List<Department> getDepartmentList(int start, int length, String sortColumn, String sortDirection, String searchValue);
    long getDepartmentCount();
    long getDepartmentFilteredCount(String searchValue);
}
