package com.linge.mapper;

import com.linge.pojo.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectAll();

    User selectById(int id);

    User selectByNameAndPwd(Map<String,Object> map);

    void insert(User user);

    void modify(User user);

    void delete(int id);
}
