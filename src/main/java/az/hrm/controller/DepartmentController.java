package az.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/department", "/department/"})
public class DepartmentController {


    @GetMapping("/")
    public String index(){
        return "department/department-list";
    }
}
