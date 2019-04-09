package test;

import entity.User;
import repository.Conn;
import repository.IUserRepository;
import repository.IUserRepositoryXML;
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

    @Test
    public void xmlGetAll() throws IOException {
        Conn conn = new Conn();
        List<User> list = new ArrayList<>();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        try {
            IUserRepositoryXML userRepository = sqlSession.getMapper(IUserRepositoryXML.class);
            list = userRepository.getAll();
        } finally {
            //关闭session
            conn.closeSqlSession(sqlSession);
        }

        System.out.println(list);
    }

    @Test
    public void xmlInsert() throws IOException {
        Conn conn = new Conn();
        List<User> list = new ArrayList<>();
        //获取session
        SqlSession sqlSession = conn.getSqlSession();

        User user = new User("benen", "123456", "11111111111", "asda", 1);
        IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);
        int i = userRepositoryXML.insert(user);

        //手动提交事务
        sqlSession.commit();
        sqlSession.close();

        System.out.println(i);
    }
}