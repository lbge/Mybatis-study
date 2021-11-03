package com.linge.mapper;

import com.linge.pojo.User;
import com.linge.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    SqlSession session = MybatisUtil.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);

    @Test
    public void selectAll() {
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
        session.close();
    }

    @Test
    public void selectById() {
        User user = mapper.selectById(1);
        System.out.println(user.toString());
        session.close();
    }

    @Test
    public void selectByNameAndPwd() {
        Map<String,Object> map = new HashMap<>();
        map.put("name","狂神");
        map.put("pwd","123456");
        User user = mapper.selectByNameAndPwd(map);
        System.out.println(user.toString());
    }

    @Test
    public void insert() {
        mapper.insert(new User(4, "赵四", "666"));
        session.commit();
        session.close();
    }

    @Test
    public void modify(){
        User user = mapper.selectById(1);
        user.setName("王大");
        mapper.modify(user);
        session.commit();
        session.close();
    }

    @Test
    public void delete(){
        mapper.delete(4);
        session.commit();
        session.close();
    }
}
