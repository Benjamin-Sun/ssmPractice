package repository;

import entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsRepositoryXML {

    List<Goods> getAll();

    List<Goods> getByNameOrDesc(@Param("gname") String gname, @Param("gdesc") String gdesc);

    List<Goods> getByNameOrDescT(@Param("gname") String gname, @Param("gdesc") String gdesc);

}
