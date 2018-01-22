package jarry.atguigu.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.MSUtils;
import jarry.atguigu.crud.bean.Employee;
import jarry.atguigu.crud.bean.Msg;
import jarry.atguigu.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SocketUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工crud请求
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    /**
     *  @ResponseBody 可以直接将返回的数据转换成json 数据
     *  导入jackson 包，负责将
     */
    /**
     * 保存新增员工信息
     * @return
     */
    @RequestMapping(value="/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee,BindingResult result){
        if(result.hasErrors()){
            // 校验失败，应该返回失败，在模态框中显示校验失败的错误信息
            List<FieldError> errors = result.getFieldErrors();
            Map<String,Object> map = new HashMap<String, Object>();
            for(FieldError fieldError:errors){
                System.out.println("错误的字段名：" + fieldError.getField());

                System.out.println("错误信息：" + fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields",map);

        }else {
            employeeService.saveEmp(employee);
            return Msg.success();
        }
    }


    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
            PageHelper.startPage(pn, 5);
            List<Employee> emps = employeeService.getAll();
            PageInfo page = new PageInfo(emps, 5);

            return Msg.success().add("pageInfo",page);
        }
    /**
     * 查询员工数据（分页查询）
     * @return
     */
//    @RequestMapping("/emps")
//    public String getEmps(@RequestParam(value="pn",defaultValue = "1") Integer pn, Model model){
//        // 这不是一个分页查询
//        // 引入pageHelper 分页插件
////        在查询之前只需要调用,传入页码以及每页的大小
//        PageHelper.startPage(pn,5);
//        // startPage 后面紧跟的这个查询就是一个分页查询
//
//        List<Employee> emps = employeeService.getAll();
//        // 使用pageinfo 包装查询后的结果  只需要将pageinfo 交给页面就行了
//        // 封装了详细的信息，包括有查询出来的数据  传入连续显示的页数
//        PageInfo page = new PageInfo(emps,5);
//        model.addAttribute("pageInfo",page);
//
//        return "list";
//    }

    /**
     * 检查用户名是否可用
     * @param empName
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/checkuser",method = RequestMethod.POST)
    public Msg checkuser(@RequestParam("empName") String empName){
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else {
            return Msg.fail();
        }
    }


}
