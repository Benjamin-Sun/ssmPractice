package test;

import Entity.User;
import Repository.Conn;
import Repository.IUserRepository;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class demoTest {
    @Test
    public void getAll() throws IOException {
        Conn conn = new Conn();
        List<User> list = new ArrayList<>();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        try {
            IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);
            list = userRepository.selectAll();
        } finally {
            //关闭session
            conn.closeSqlSession(sqlSession);
        }

        System.out.println(list);
    }
}