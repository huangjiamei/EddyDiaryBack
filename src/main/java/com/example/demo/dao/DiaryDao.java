package com.example.demo.dao;

import com.example.demo.entity.Diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by damei on 19/2/28.
 */
@Repository //数据访问层注解
public class DiaryDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //查询全部日记
    public List<Diary> getList() {
        String sql = "select * from diary";
        return (List<Diary>) jdbcTemplate.query(sql, new RowMapper<Diary>() {
            @Override
            public Diary mapRow(ResultSet resultSet, int i) throws SQLException {
                Diary diary = new Diary();
                diary.setDiaryid(resultSet.getInt("diaryid"));
                diary.setTag(resultSet.getString("tag"));
                diary.setDate(resultSet.getString("date"));
                diary.setLocation(resultSet.getString("location"));
                diary.setMood(resultSet.getString("mood"));
                diary.setContent(resultSet.getString("content"));
                diary.setIsprivate(resultSet.getString("isprivate"));
                return diary;
            }
        });
    }

    //添加日记
    public void addDiary(Diary diary){
        String sql = "insert into diary(isprivate, date, location, mood, content, tag) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, diary.getIsprivate(), diary.getDate(), diary.getLocation(), diary.getMood(), diary.getContent(), diary.getTag());
        return ;

    }
}
