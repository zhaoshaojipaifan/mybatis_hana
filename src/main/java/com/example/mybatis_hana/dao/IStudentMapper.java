package com.example.mybatis_hana.dao;

import com.example.mybatis_hana.pojo.IStudent ;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import java.util.List;
public interface IStudentMapper {
    @Select("select * from s_student where id = #{id}")
    IStudent selectStudent(int id);
    @Select("select * from s_student where cid=#{id} ")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "classname",property = "classname")
    })
    List<IStudent> selectStudentByCid(int cid);
}

