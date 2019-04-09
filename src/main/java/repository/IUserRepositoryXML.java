package repository;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserRepositoryXML {
    List<User> getAll();

    User getOne(@Param("id") int id);

    Integer insert(@Param("user") User user);
}
