package com.example.demo.controls;

import com.example.demo.Tools;
import com.example.demo.service.LeaderService;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Map;
@RestController
@CrossOrigin//跨域注解
public class LeaderControl {
    @Autowired
    private LeaderService leaderService ;

    @GetMapping("/LeaderSelectAll")
    public List<Map<String,String>> selectAll(){
        return leaderService.selectAll();
    }

    //    查询空余车辆
    @GetMapping("/LeaderSelectvehicle")
    public List<Map<String,String>> selectvehicle(@RequestParam("useCarTime")String useCarTime, @RequestParam("vehicleType")String vehicleType){
        return leaderService.selectvehicle(useCarTime, vehicleType);
    }

    //    查询空余司机
    @GetMapping("/LeaderSelectdriver")
    public List<Map<String,String>> selectdriver( @RequestParam("useCarTime")String useCarTime, @RequestParam("driverType")String driverType){
        return leaderService.selectdriver(useCarTime, driverType);
    }

    //    队长给司机安排任务
    @GetMapping("/LeaderToDriver")
    public int selectdriver(@RequestParam("id")String id, @RequestParam("arrangeVehicleNum")String arrangeVehicleNum, @RequestParam("arrangeDriverNum")String arrangeDriverNum, HttpServletRequest request){
        return leaderService.LeaderToDriver( id, arrangeVehicleNum, arrangeDriverNum,request);
    }
    //查看实时任务
    @GetMapping("/getLeaderTaskNum")
    public String getLeaderTaskNum(HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
        if(request.getSession().getServletContext().getAttribute("LeaderTaskNum")==null)
            return "0";
        return request.getSession().getServletContext().getAttribute("LeaderTaskNum").toString();
    }


}
