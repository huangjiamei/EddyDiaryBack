package com.example.demo.controller;

import com.example.demo.entity.DiaryEntity;
import com.example.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
/*
    static public class DiaryFront {
        String date;
        String week;
        String time;
        String mood;
        String content;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getMood() {
            return mood;
        }

        public void setMood(String mood) {
            this.mood = mood;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        String tag;

    }
*/
    @RequestMapping("/diary") //配置url映射，作用在方法上
    @ResponseBody
    public List<DiaryEntity> getDiaries() {
        /*
        ArrayList<DiaryFront> diaryFrontList = new ArrayList<DiaryFront>();
        List<Diary> diaryList = diaryService.getAllDiaries();
        for (Diary diary : diaryList) {
            DiaryFront diaryFront = new DiaryFront();
            diaryFront.setDate(String.valueOf(diary.getDatetime().getDate()));
            String week = null;
            switch(diary.getDatetime().getDay()) {
                case 0 : week = "周日"; break;
                case 1 : week = "周一"; break;
                case 2 : week = "周二"; break;
                case 3 : week = "周三"; break;
                case 4 : week = "周四"; break;
                case 5 : week = "周五"; break;
                case 6 : week = "周六"; break;
            }
            diaryFront.setWeek(week);
            String hour = String.valueOf(diary.getDatetime().getHours());
            String minute = String.valueOf(diary.getDatetime().getMinutes());
            diaryFront.setTime(hour + ":" + minute);
            diaryFront.setTag(diary.getTag());
            diaryFront.setMood(diary.getMood());
            diaryFront.setContent(diary.getContent());
            diaryFrontList.add(diaryFront);
        }
        return diaryFrontList;
        */
        return diaryService.getAllDiaries();
    }



    @RequestMapping("/adddiary")
    @ResponseBody
    public void addDiary(HttpServletRequest request) {
        DiaryEntity diary = new DiaryEntity();
        diary.setIsprivate(request.getParameter("isPrivate"));
        diary.setDate(request.getParameter("date"));
        diary.setTime(request.getParameter("time"));
        diary.setWeek(request.getParameter("week"));
        diary.setLocation(request.getParameter("location"));
        diary.setMood(request.getParameter("mood"));
        diary.setContent(request.getParameter("content"));
        diary.setTag(request.getParameter("tag"));
        diary.setDiarypicture(request.getParameter("diarypicture"));
        diaryService.addDiary(diary);
        //System.out.println(request.getParameter("date"));

    }

    @RequestMapping("/deletediary")
    @ResponseBody
    public void deleteDiaryById (HttpServletRequest request) {
        diaryService.deleteDiaryByiId(request.getParameter("formData"));
    }
}
