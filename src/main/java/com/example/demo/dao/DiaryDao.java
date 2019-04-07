package com.example.demo.dao;

import com.example.demo.entity.DiaryEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
    //private NamedParameterJdbcTemplate jdbcTemplate;


    //登录，获取用户信息并存储到数据库


    //查询全部日记
    public List<DiaryEntity> getList() {
        String sql = "select * from diary";
        return (List<DiaryEntity>) jdbcTemplate.query(sql, new RowMapper<DiaryEntity>() {
            @Override
            public DiaryEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                DiaryEntity diary = new DiaryEntity();
                diary.setDiaryid(resultSet.getInt("diaryid"));
                diary.setTag(resultSet.getString("tag"));
                diary.setDdate(resultSet.getString("ddate"));
                diary.setWeek(resultSet.getString("week"));
                diary.setDtime(resultSet.getString("dtime"));
                diary.setLocation(resultSet.getString("location"));
                diary.setMood(resultSet.getString("mood"));
                diary.setContent(resultSet.getString("content"));
                diary.setIsprivate(resultSet.getString("isprivate"));
                diary.setDiarypicture(resultSet.getString("diarypicture"));
                /*
                UserEntity userEntity = new UserEntity();
                userEntity.setUserid(resultSet.getString("diaryid"));
                diary.setUserByUserid(userEntity);
                */
                return diary;
            }
        });
    }

    //添加日记
    public void addDiary(DiaryEntity diary){
        String sql = "insert into diary(isprivate, ddate, week, dtime, location, mood, content, tag, diarypicture, userid) values(?,?,?,?,?,?,?,?,?,?)";
        System.out.println(diary.getUserByUserid().getUserid());
        int result = jdbcTemplate.update(sql, diary.getIsprivate(), diary.getDdate(), diary.getWeek(), diary.getDtime(), diary.getLocation(), diary.getMood(), diary.getContent(), diary.getTag(),diary.getDiarypicture(), diary.getUserByUserid().getUserid());
        if(result>0)
            System.out.println("Add diary success!");
        else
            System.out.println("Add diary fail!");
    }

    //根据日记Id删除日记
    public void deleteDiaryById(String id) {
        String sql = "delete from diary where diaryid = ?";
        Object args[] = new Object[]{id};
        int result = jdbcTemplate.update(sql,args);
        if(result>0)
            System.out.println("Delete diary success!");
        else
            System.out.println("Delete diary fail");
    }
}
