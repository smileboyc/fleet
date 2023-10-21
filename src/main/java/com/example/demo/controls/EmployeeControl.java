package com.example.demo.controls;

import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//跨域注解
public class EmployeeControl {
    @Autowired
    private EmployeeService employeeService ;
//    用户登录
    @GetMapping("/Login")
    public String Login(@RequestParam("employeeNum")String employeeNum, @RequestParam("employeePassword")String employeePassword, HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
        System.out.println(employeeNum);
       return employeeService.Login(employeeNum,employeePassword,request,response);
    }
//    预约申请
    @GetMapping("/apply")
    public int apply(@RequestParam("useCarTime")String useCarTime, @RequestParam("peopleNum")String peopleNum, @RequestParam("applyReason")String applyReason,@RequestParam("vehicleType")String vehicleType, HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
            return employeeService.apply(useCarTime,peopleNum,applyReason,vehicleType,request,response);
    }
    //    查询待审核预约
    @GetMapping("/selectApply")
    public  List<Map<String,String>> selectApply1(HttpServletRequest request){
        HttpSession session1=request.getSession();
        String applyNum=session1.getAttribute("employeeNum").toString().trim();
        System.out.println(applyNum);
        return employeeService.selectApply1(applyNum);
    }
    //    查询已通过记录
    @GetMapping("/selectApply1")
    public  List<Map<String,String>> selectApply2(HttpServletRequest request){
        HttpSession session1=request.getSession();
        String applyNum=session1.getAttribute("employeeNum").toString().trim();
        System.out.println(applyNum);
        return employeeService.selectApply2(applyNum);
    }

//    未通过的预约记录
    @GetMapping("/selectApply2")
    public  List<Map<String,String>> selectApply3(HttpServletRequest request){
        HttpSession session1=request.getSession();
        String applyNum=session1.getAttribute("employeeNum").toString().trim();
        return employeeService.selectApply3(applyNum);
    }
//    查询车辆信息
    @GetMapping("/selectVehicle")
    public  List<Map<String,String>> selectVehicle(@RequestParam("useCarTime")String useCarTime, @RequestParam("vehicleType")String vehicleType){
        return employeeService.selectVehicle(useCarTime,vehicleType);
    }
    //查询预约成功车辆信息
    @GetMapping("/selectVehicle2")
    public  List<Map<String,String>> selectVehicle2(@RequestParam("id")String id){
        return employeeService.selectVehicle2(id);
    }
}
