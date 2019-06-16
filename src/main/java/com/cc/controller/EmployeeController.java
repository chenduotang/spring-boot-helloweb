package com.cc.controller;

import com.cc.dao.DepartmentDao;
import com.cc.dao.EmployeeDao;
import com.cc.entities.Department;
import com.cc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询返回员工列表页面
    @GetMapping("/emps")
    public String list(Model model){
       Collection<Employee> employees=employeeDao.getAll();
       //放在请求域中
        model.addAttribute("emps",employees);
        //默认就会拼串，拼到classpath:/templates/xxx.html
        return "emp/list";
    }

    /**
     * 跳转添加员工页面
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面
        //获取部门编号
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/emp/add";
    }
    /***
     * 员工添加功能
     */
    @PostMapping("/emp")
    //自动将请求参数和入参对象属性进行一一绑定
    public String addEmp(Employee employee){
        System.out.println("save is succsess");
        employeeDao.save(employee);
        //来到员工列表页面 /代表当前项目路径
        return "redirect:/emps";
    }
    /***
     * 修改和添加员工信息页面
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //查询员工在页面回显
        Employee employee=employeeDao.get(id);
        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("employee",employee);
        model.addAttribute("departments",departments);
        //回到修改页面,修改和添加页面一体
        return "emp/add";
    }

    /**
     * 员工修改功能
     */
    @PutMapping("/emp")
    public String updateEmploee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 创建删除员工的方法
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String delteEmploee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
