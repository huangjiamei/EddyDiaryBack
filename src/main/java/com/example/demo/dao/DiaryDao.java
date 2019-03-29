package com.example.demo.dao;

import com.example.demo.entity.DiaryEntity;
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
    public List<DiaryEntity> getList() {
        String sql = "select * from diary";
        return (List<DiaryEntity>) jdbcTemplate.query(sql, new RowMapper<DiaryEntity>() {
            @Override
            public DiaryEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                DiaryEntity diary = new DiaryEntity();
                diary.setDiaryid(resultSet.getInt("diaryid"));
                diary.setTag(resultSet.getString("tag"));
                diary.setDate(resultSet.getString("date"));
                diary.setWeek(resultSet.getString("week"));
                diary.setTime(resultSet.getString("time"));
                diary.setLocation(resultSet.getString("location"));
                diary.setMood(resultSet.getString("mood"));
                diary.setContent(resultSet.getString("content"));
                diary.setIsprivate(resultSet.getString("isprivate"));
                diary.setDiarypicture(resultSet.getString("diarypicture"));
                return diary;
            }
        });
    }

    //添加日记
    public void addDiary(DiaryEntity diary){
        String sql = "insert into diary(isprivate, date, week, time, location, mood, content, tag, diarypicture) values(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, diary.getIsprivate(), diary.getDate(), diary.getWeek(), diary.getTime(), diary.getLocation(), diary.getMood(), diary.getContent(), diary.getTag(),diary.getDiarypicture());

    }

    //根据日记Id删除日记
    public void deleteDiaryById(String id) {
        String sql = "delete from diary where diaryid = " + id;
        jdbcTemplate.execute(sql);
    }
}
