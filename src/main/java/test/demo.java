package test;

import Entity.User;
import Repository.Conn;
import Repository.IUserRepository;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class demo {

    //获取session
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

    public demo() throws IOException {
    }

    public List<User> getAll() throws IOException {
        List<User> list;
        list = userRepository.selectAll();
        //关闭session
        sqlSession.close();
        System.out.println(list);
        return list;
    }

    public User getOne(int id){
        User user = new User();
        user = userRepository.selectById(id);
        sqlSession.close();

        return user;
    }
}
