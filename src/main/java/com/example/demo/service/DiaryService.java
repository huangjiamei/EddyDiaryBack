package com.example.demo.service;


import com.example.demo.dao.DiaryDao;
import com.example.demo.entity.DiaryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by damei on 19/2/28.
 */
@Service //业务层注解
public class DiaryService {
    @Autowired
    private DiaryDao diaryDao;
    public List<DiaryEntity>  getAllDiaries() {

        return diaryDao.getList();
    }
    public void addDiary(DiaryEntity diary) {
        diaryDao.addDiary(diary);
    }
    public void deleteDiaryByiId(String id) {
        diaryDao.deleteDiaryById(id);
    }
}
