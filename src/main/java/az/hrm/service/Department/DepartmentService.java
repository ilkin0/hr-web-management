package az.hrm.service.Department;

import az.hrm.model.DataTableResponse;

public interface DepartmentService {
    DataTableResponse getDepartmentDataTable(String draw, int start, int length, int sortColumn, String sortDirection, String searchValue);
}
