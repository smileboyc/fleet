package com.example.demo.controls;


import com.example.demo.entity.Applytable;
import com.example.demo.mapper.ApplytableMapper;
import com.example.demo.service.ApproveEntryService;
import com.example.demo.service.FreeCarService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Map;

@RestController
@CrossOrigin
public class ManagerCheck {
    @Autowired
    ApplytableMapper applytableMapper;
    @Autowired
    FreeCarService freeCarService;
    @Autowired
    ApproveEntryService approveEntryService;
    //给管理员展示申请信息和空闲车辆数据
    @GetMapping("/displayManagerTask")
    public String displayTask(@RequestParam("id") Integer id) throws JSONException {

        Applytable applytable=applytableMapper.selectFromId(id);
        LocalDate useCarTime=applytable.getUseCarTime();
        Map<String,Integer> map=freeCarService.freeCarCount(useCarTime);

        JSONObject json1 = new JSONObject();
        json1.put("applyDate",applytable.getApplyDate().toString());
        json1.put("useCarTime", useCarTime.toString());
        json1.put("peopleNum", applytable.getPeopleNum());
        json1.put("applyReason", applytable.getApplyReason());

        JSONObject json2 = new JSONObject();
        json2.put("A",map.get("A"));
        json2.put("B", map.get("B"));
        json2.put("C", map.get("C"));

        JSONObject resultJson = new JSONObject();
        resultJson.put("infoJsonString",json1.toString());
        resultJson.put("freeCarCount",json2.toString());

        String jsonString= resultJson.toString();
        System.out.println(jsonString);
        return jsonString;
    }
    //录入审批表
    @GetMapping("/entry")
    public String ApprovalEntry(@RequestParam("id") Integer id, @RequestParam("approveNum") String approveNum, @RequestParam("approveDate") String approveDate, @RequestParam("pass") String pass, @RequestParam("approveReason") String approveReason, HttpServletRequest request, HttpServletResponse response)throws UnsupportedEncodingException {
        System.out.println("前端传回时间为:"+ approveDate);
        int count=approveEntryService.entry(id, approveNum, approveDate, pass, approveReason);
        System.out.println("count="+count);

        HttpSession session1=request.getSession();
        ServletContext context1=session1.getServletContext();
        if(context1.getAttribute("applyNum")!=null&&context1.getAttribute("applyNum").toString()!="0"){
            String num=context1.getAttribute("applyNum").toString();
            Integer num0=Integer.parseInt(num)-1;
            context1.setAttribute("applyNum",num0);
        }


        return count+"";
    }
}
