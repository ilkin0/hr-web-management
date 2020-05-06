package az.hrm.service;

import az.hrm.model.DataTableResponse;

public interface EmployeeService {
    DataTableResponse getEmployeeDataTable(String draw, int start, int length, int sortColumn, String sortDirection, String searchValue);
}
