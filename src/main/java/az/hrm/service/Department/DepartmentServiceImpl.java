package az.hrm.service.Department;

import az.hrm.model.DataTableResponse;
import az.hrm.model.Department;
import az.hrm.repo.department.DepartmentRepoJDBCImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepoJDBCImpl departmentRepoJDBC;


    @Override
    public DataTableResponse getDepartmentDataTable(String draw, int start, int length, int sortColumn, String sortDirection, String searchValue) {
       DataTableResponse dataTableResponse = new DataTableResponse();

       dataTableResponse.setRecordsTotal(departmentRepoJDBC.getDepartmentCount());

       if (searchValue !=null && !searchValue.isEmpty()){
           dataTableResponse.setRecordsFiltered(departmentRepoJDBC.getDepartmentFilteredCount(searchValue));
       }else {
           dataTableResponse.setRecordsFiltered(dataTableResponse.getRecordsTotal());
       }

        Map<Integer, String> columnMap = new HashMap();
        columnMap.put(1, "department_id");
        columnMap.put(2, "department_name");
        columnMap.put(3, "manager_id");
        columnMap.put(4, "location_id");
        List<Department> departmentList = departmentRepoJDBC.getDepartmentList(start, length,columnMap.getOrDefault(sortColumn, "department_id"),
                sortDirection, searchValue);

        Object[][] data = new Object[departmentList.size()][6];

        for (int i = 0; i <departmentList.size(); ++i){
            data[i][0] = i+1;
            data[i][1] = departmentList.get(i).getDepartmentID();
            data[i][2] = departmentList.get(i).getDepartmentName();
            data[i][3] = departmentList.get(i).getManagerID();
            data[i][4] = departmentList.get(i).getLocationID();
            data[i][5] = String.format("<a href='employee-view?id=%d'>View</a>", (departmentList.get(i)).getDepartmentID());
        }
        dataTableResponse.setData(data);
        return dataTableResponse;
    }
}
