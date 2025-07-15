package com.example.demo.service;

import com.example.demo.Tools;
import com.example.demo.entity.Approvetable;
import com.example.demo.mapper.ApprovetableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class ApproveEntryService {
    @Autowired
    ApprovetableMapper approvetableMapper;
    public int entry(Integer id, String approveNum, String approveDate, String pass, String approveReason){
        Approvetable approvetable = new Approvetable();
        approvetable.setId(id);
        approvetable.setApproveNum(approveNum);
        approvetable.setApproveDate(Tools.dateTrans(approveDate));
        approvetable.setPass(pass);
        approvetable.setApproveReason(approveReason);
        return approvetableMapper.insert(approvetable);
    }
}
