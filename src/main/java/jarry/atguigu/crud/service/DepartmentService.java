package jarry.atguigu.crud.service;

import jarry.atguigu.crud.bean.Department;
import jarry.atguigu.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询所有的部门
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts(){

        List<Department> list = departmentMapper.selectByExample(null);

        return list;
    }


}
