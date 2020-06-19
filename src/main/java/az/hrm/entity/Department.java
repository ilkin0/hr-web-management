package az.hrm.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Department {

    private long departmentID;
    private String departmentName;
    private long managerID;
    private long locationID;


//    public Department() {
//
//    }
//
//    public long getDepartmentID() {
//        return departmentID;
//    }
//
//    public void setDepartmentID(long departmentID) {
//        this.departmentID = departmentID;
//    }
//
//    public String getDepartmentName() {
//        return departmentName;
//    }
//
//    public void setDepartmentName(String departmentName) {
//        this.departmentName = departmentName;
//    }
//
//    public long getManagerID() {
//        return managerID;
//    }
//
//    public void setManagerID(long managerID) {
//        this.managerID = managerID;
//    }
//
//    public long getLocationID() {
//        return locationID;
//    }
//
//    public void setLocationID(long locationID) {
//        this.locationID = locationID;
//    }
//
//    @Override
//    public String toString() {
//        return "Department{" +
//                "id=" + departmentID +
//                ", departmentName='" + departmentName + '\'' +
//                ", managerID=" + managerID +
//                ", locationID=" + locationID +
//                '}';
//    }
}
