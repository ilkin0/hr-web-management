package az.hrm.service;



import az.hrm.model.DataTableResponse;
import az.hrm.model.Employee;
import az.hrm.repo.EmployeeRepoJDBCImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepoJDBCImpl employeeRepo;

    public EmployeeServiceImpl() {
    }

    public DataTableResponse getEmployeeDataTable(String draw, int start, int length, int sortColumn, String sortDirection, String searchValue) {
        DataTableResponse dataTableResponse = new DataTableResponse();
        dataTableResponse.setRecordsTotal(employeeRepo.getEmployeeCount());
        if (searchValue != null && !searchValue.isEmpty()) {
            dataTableResponse.setRecordsFiltered(employeeRepo.getEmployeeFilteredCount(searchValue));
        } else {
            dataTableResponse.setRecordsFiltered(dataTableResponse.getRecordsTotal());
        }

        Map<Integer, String> columnMap = new HashMap();
        columnMap.put(1, "employee_id");
        columnMap.put(2, "first_name");
        columnMap.put(3, "last_name");
        columnMap.put(4, "salary");
        List<Employee> employeeList = this.employeeRepo.getEmployeeList(start, length, (String)columnMap.getOrDefault(sortColumn, "employee_id"), sortDirection, searchValue);
        Object[][] data = new Object[employeeList.size()][6];

        for(int i = 0; i < employeeList.size(); ++i) {
            data[i][0] = i + 1;
            data[i][1] = (employeeList.get(i)).getId();
            data[i][2] = (employeeList.get(i)).getFirstName();
            data[i][3] = (employeeList.get(i)).getLastName();
            data[i][4] = (employeeList.get(i)).getSalary();
            data[i][5] = String.format("<a href='employee-view?id=%d'>View</a>", (employeeList.get(i)).getId());
        }

        dataTableResponse.setData(data);
        return dataTableResponse;
    }
}
