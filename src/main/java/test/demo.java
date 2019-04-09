package test;

import Entity.User;
import Repository.Conn;
import Repository.IUserRepository;
import Repository.IUserRepositoryXML;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class demo {

    //获取session
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IUserRepository userRepository = sqlSession.getMapper(IUserRepository.class);

    public static void main(String[] args) throws IOException {
        System.out.println(new demo().xmlGetAll());
//        System.out.println(new demo().getAll());
    }

    public demo() throws IOException {
    }

    public List<User> getAll(){
        List<User> list = userRepository.selectAll();
        //关闭session
        sqlSession.close();
        System.out.println(list);
        return list;
    }

    public User getOne(int id){
        User user = userRepository.selectById(id);
        sqlSession.close();

        return user;
    }

    public List<User> xmlGetAll(){
        //生成接口对象
        IUserRepositoryXML userRepositoryXML = sqlSession.getMapper(IUserRepositoryXML.class);
        List<User> list = userRepositoryXML.getAll();
        System.out.println(list);

        sqlSession.close();

        return list;
    }
}
