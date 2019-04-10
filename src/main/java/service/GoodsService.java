package service;

import entity.Goods;
import org.apache.ibatis.session.SqlSession;
import repository.Conn;
import repository.IGoodsRepositoryXML;

import java.io.IOException;
import java.util.List;

public class GoodsService {
    private SqlSession sqlSession = new Conn().getSqlSession();
    private IGoodsRepositoryXML goodsRepositoryXML = sqlSession.getMapper(IGoodsRepositoryXML.class);

    public GoodsService() throws IOException {
    }

    public List<Goods> getByNameOrDesc(String gname, String gdesc){
        List<Goods> goods = goodsRepositoryXML.getByNameOrDesc(gname, gdesc);

        sqlSession.close();
        return goods;
    }
}
