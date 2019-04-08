package Repository;

import Entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserRepository {
    @Select("SELECT * FROM t_user")
    public List<User> selectAll();

    @Select("SELECT * FROM t_user WHERE uid = #{id}")
    public User selectById(int id);
}
