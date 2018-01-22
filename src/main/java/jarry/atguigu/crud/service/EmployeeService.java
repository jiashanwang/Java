package jarry.atguigu.crud.service;

import jarry.atguigu.crud.bean.Employee;
import jarry.atguigu.crud.bean.EmployeeExample;
import jarry.atguigu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有
     * @return
     */
    public List<Employee> getAll(){
      return employeeMapper.selectByExampleWithDept(null);
    };

    /**
     * 员工保存
     * @param employee
     */
    public void saveEmp(Employee employee) {
       employeeMapper.insertSelective(employee);
    }

    /**
     * 检验用户名是否存在
     * 如果当前数据库没有这个用户名，返回==0 为true,可以用
     * @param empName
     * @return
     */
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
       EmployeeExample.Criteria criteria  = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }
}
