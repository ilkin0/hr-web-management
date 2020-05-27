package az.hrm.controller;

import az.hrm.model.DataTableResponse;
import az.hrm.repo.department.DepartmentRepoJDBCImpl;
import az.hrm.service.Department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/department", "/department/"})
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepoJDBCImpl departmentRepoJDBC;

    @GetMapping("/")
    public String index(){
        return "department/department-list";
    }

    @GetMapping("/department-list-ajax")
    @ResponseBody
    public DataTableResponse getDepartmetDataTable(
            @RequestParam("draw") String draw,
            @RequestParam("start") int start,
            @RequestParam("length") int length,
            @RequestParam(name = "order[0][column]") int sortColumn,
            @RequestParam(name = "order[0][dir]") String sortDirection,
            @RequestParam(name = "search[value]") String searchValue
    ){

        return departmentService.getDepartmentDataTable(draw, start, length, sortColumn, sortDirection, searchValue);
    }
}
