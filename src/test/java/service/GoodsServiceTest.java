package service;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import repository.Conn;
import repository.IGoodsRepositoryXML;

import java.io.IOException;

import static org.junit.Assert.*;

public class GoodsServiceTest {

    @Test
    public void getByNameOrDesc() throws IOException {
        Conn conn = new Conn();
        SqlSession session = conn.getSqlSession();

        IGoodsRepositoryXML goodsRepositoryXML = session.getMapper(IGoodsRepositoryXML.class);
        System.out.println(goodsRepositoryXML.getByNameOrDesc(null, null));
    }
}