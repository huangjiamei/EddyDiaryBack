package com.example.demo.controller;

import com.example.demo.entity.Diary;
import com.example.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by damei on 19/2/27.
 */
@Controller //控制层注解
@RequestMapping("/") //配置url映射，作用在类上
public class DiaryController {
    @Autowired
    private DiaryService diaryService;

    @RequestMapping("/diary") //配置url映射，作用在方法上
    @ResponseBody
    public List<Diary> getDiaries() {
        return diaryService.getAllDiaries();
    }

    @RequestMapping("/adddiary")
    @ResponseBody
    public void addDiary(HttpServletRequest request) {
        Diary diary = new Diary();
        diary.setIsprivate(request.getParameter("isPrivate"));
        diary.setDate(request.getParameter("date"));
        diary.setLocation(request.getParameter("location"));
        diary.setMood(request.getParameter("mood"));
        diary.setContent(request.getParameter("content"));
        diary.setTag(request.getParameter("tag"));
        diaryService.addDiary(diary);
        //System.out.println(request.getParameter("date"));

    }
}
