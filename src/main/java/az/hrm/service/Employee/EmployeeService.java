package az.hrm.service.Employee;

import az.hrm.entity.DataTableResponse;

public interface EmployeeService {

    DataTableResponse getEmployeeDataTable(String draw, int start, int length, int sortColumn, String sortDirection, String searchValue);

}
