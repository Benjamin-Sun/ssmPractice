package repository;

import entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserRepository {
    @Select("SELECT * FROM t_user")
    List<User> selectAll();

    @Select("SELECT * FROM t_user WHERE uid = #{id}")
    User selectById(@Param("id") int id);

    @Insert("INSERT INTO t_user(uname, upwd, telephone, address, ulevel) " +
            "VALUES(#{user.uname}, #{user.upwd}, #{user.telephone}, #{user.address}, #{user.ulevel})")
    Integer insert(@Param("user") User user);

    @Update("UPDATE t_user SET uname = #{user.uname}, upwd = #{user.upwd}, telephone = #{user.telephone}, address = #{user.address}, ulevel = #{user.ulevel} " +
            "WHERE uid = #{id}")
    Integer updateById(@Param("user") User user, @Param("id") int id);

    @Delete("DELETE FROM t_user WHERE uid = #{id}")
    Integer deleteById(int id);
}
