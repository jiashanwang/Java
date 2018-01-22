package jarry.atguigu.crud.bean;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import java.util.concurrent.Executors;

public class Employee {
    private Integer empId;
    // 利用jsr303 做的自定义的检验规则
    @Pattern(regexp = "/(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]+$)/",message = "用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String empName;

    private String gender;

    public Employee(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }


    public Employee(){}
//  JSR303 是一个后端校验标准，  @Email  是一个默认的邮箱验证的写法，@Pattern 是用来自定义验证规则的一个注解符号
    @Pattern(regexp = "/^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$/",message = "邮箱格式不正确")
    private String email;

    private Integer dId;
    // 希望查询员工的同时部门信息也是查询好的
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}