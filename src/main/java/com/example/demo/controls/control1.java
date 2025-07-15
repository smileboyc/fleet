package com.example.demo.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control1 {
    @RequestMapping("/index.html")
    String  xx2()
    {return "index.html";}

    //登录界面
    @RequestMapping("/Login.html")
    String  Login()
    {return "Login.html";}

    //用户预约页面

    @RequestMapping("/employee.html")
    String employee()
    {return "employee.html";}

    //用户中心
    @RequestMapping("personalCenter.html")
    String personalCenter()
    {return "personalCenter.html";}
//预约界面
    @RequestMapping("bookRecord.html")
    String bookRecord()
    {return "bookRecord.html";}

    //管理员页面
    @RequestMapping("manage.html")
    String manage()
    {return "manage.html";}
    //队长页面
    @RequestMapping("leader.html")
    String leader()
    {return "leader.html";}

//管理员安排

    @RequestMapping("manageArrange.html")
    String manageArrange()
    {return "manageArrange.html";}
    @RequestMapping("managerTasks.html")
    String managerTasks()
    {return "managerTasks.html";}
//队长安排

    @RequestMapping("leaderArrange.html")
    String leaderArrange()
    {return "leaderArrange.html";}

    //管理员添加车辆信息

    @RequestMapping("inputVehicle.html")
    String inputVehicle()
    {return "inputVehicle.html";}

    //管理员添加员工信息
    @RequestMapping("inputEmployee.html")
    String inputEmployee()
    {return "inputEmployee.html";}

//    管理员数据分析

    @RequestMapping("indexData.html")
    String indexData()
    {return "indexData.html";}

    //用户车辆信息
    @RequestMapping("informationVe.html")
    String informationVe()
    {return "informationVe.html";}

}
