package com.example.demo.dao;

import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by damei on 19/3/31.
 */
@Repository //数据访问层注解
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //添加用户
    public void addUser(UserEntity user) {
        String sql = "insert into user(userid, username, userpicture) values(?,?,?)";
        jdbcTemplate.update(sql, user.getUserid(), user.getUsername(), user.getUserpicture());
    }
    //查询所有用户
    public List<UserEntity> getList () {
        String sql = "select * from user";
        return (List<UserEntity>) jdbcTemplate.query(sql, new RowMapper<UserEntity>() {
            @Override
            public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                UserEntity user = new UserEntity();
                user.setUserid(resultSet.getString("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setUserpicture(resultSet.getString("userpicture"));
                return user;
            }
        });
    }
}
