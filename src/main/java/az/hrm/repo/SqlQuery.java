package az.hrm.repo;

public class SqlQuery {
    public final static String GET_EMPLOYEE_LIST = "select employee_id, first_name, last_name, salary  from employees " +
            " order by %SORT_COLUMN% %SORT_DIRECTION% ";

    public final static String GET_EMPLOYEE_LIST_FILTERED = "select employee_id, first_name, last_name, salary " +
            " from employees\n where lower(concat(employee_id, first_name, last_name, salary)) like :searchValue " +
            " order by %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";

    public final static String GET_EMPLOYEE_BY_ID = "select employee_id, first_name, last_name, salary, email, job_id, " +
            "phone_numeric from employees where employee_id = ?";

    public final static String UPDATE_EMPLOYEE = "UPDATE employees  SET first_name = ?, last_name = ?, email = ?, " +
            "phone_numeric = ?, salary = ?  WHERE employee_id = ?";

    public final static String DELETE_EMPLOYEE = "delete from employees where employee_id = ?";

    public final static String ADD_EMPLOYEE = "insert into employees (first_name, last_name, email, phone_numeric, " +
            "hire_date ,job_id, salary) values (:first_name, :last_name, :email, :phone_numeric, :hire_date, :job_id, :salary)";

    public final static String GET_EMPLOYEE_COUNT = "select count(employee_id) as emp_count from employees";

    public final static String GET_EMPLOYEE_COUNT_FILTERED = "select count(employee_id) emp_count from employees where " +
            "concat(employee_id, first_name, last_name, salary) like lower(:searchValue)";

    public final static String GET_DEPARTMENT_LIST = "select department_id, department_name, manager_id, location_id" +
            " from departments order by %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";

    public final static String GET_DEPARTMENT_LIST_FILTERED  = "select department_id, department_name, manager_id, location_id from departments where " +
            "concat(department_id, department_name, manager_id, location_id) like :searchValue " +
            "order by %SORT_COLUMN% %SORT_DIRECTION% limit :length offset :start";

    public final static String GET_DEPARTMENT_COUNT = "select count(department_id) as dept_count from departments";

    public final static String GET_DEPARTMENT_COUNT_FILTERED = "select count(department_id) emp_count from departments " +
            "where concat(department_id, department_name, manager_id, location_id) like lower(:searchValue)";

}
