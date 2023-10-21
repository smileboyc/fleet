package com.example.demo.controls;

import com.example.demo.Tools;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Vehicle;
import com.example.demo.service.DepStaService;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//跨域注解
public class ManageControl {
    @Autowired
    private ManageService manageService ;
    @Autowired
    DepStaService depStaService;
    @Value("${upload.path}")//从系统配置文件中直接取文件路径,以下的方法都共用它
    private String uploadPath;
    @Autowired
    private Tools tools;

    @GetMapping("/selectAll")
    public List<Map<String,String>> selectAll(){
        return manageService.selectAll();
    }

    @PostMapping ("/arrangeLeader")
    public void arrangeLeader(@RequestParam("useCarTime")String useCarTime, @RequestParam("fleetType")String fleetType,@RequestParam("Id")String id,@RequestParam("numOfCar")String numOfCar , HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
        System.out.println(useCarTime+fleetType+numOfCar+id);

        manageService.arrangeLeader(useCarTime,fleetType,numOfCar,id,request,response);
        }
//    管理员获取任务
    @GetMapping("/getApplyNum")
    public String getApplyNum(HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
        if(request.getSession().getServletContext().getAttribute("applyNum")==null)
            return "0";
        return request.getSession().getServletContext().getAttribute("applyNum").toString();
    }
    //管理员添加员工
    @PostMapping("/employeeaddAll")
    public int EmployeeaddAll(HttpServletRequest request) throws IOException, ServletException, NoSuchFieldException, IllegalAccessException, ParseException {
     System.out.println(uploadPath);
        Employee employee = new Employee();
        tools.requestDataAandFilesToModel(request, employee);
       return manageService.EmployeeaddAll(employee);
    }

    //车队统计
    @GetMapping("/fleetStatistics")
    public List<Map< Object, Object>> FleetStatistics(@RequestParam("month")Integer month){
        List<Map< Object, Object>> result =depStaService.getFleetStats(month);
        System.out.println(result);
        return result;
    }
    //司机统计
    @GetMapping("/diverStatistics")
    public List< Map<Object, Object>> DriverStatistics(@RequestParam("month") Integer month){
        List<Map< Object, Object>> result =depStaService.getDriverStats(month);
        System.out.println(result);
        return result;
    }
}
