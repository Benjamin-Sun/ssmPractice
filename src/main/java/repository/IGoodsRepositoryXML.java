package repository;

import entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsRepositoryXML {

    List<Goods> getAll();

    Goods getByNameOrDesc(@Param("gname") String gname, @Param("gdesc") String gdesc);
}
