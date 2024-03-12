package com.example.mybatis_hana;

import com.example.mybatis_hana.dao.IStudentMapper ;
import com.example.mybatis_hana.pojo.IStudent ;
import com.example.mybatis_hana.utils.MyBatisUtils ;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisHanaApplicationTests {
    @Test
    public void findIStudentByIdTest() {
        // 1.通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        IStudentMapper mapper = session.getMapper(IStudentMapper.class);
        // 2.使用IStudentMapper对象查询id为1的学生的信息
        IStudent student = mapper.selectStudent(2);
        System.out.println(student.toString());
        // 3.关闭SqlSession
        session.close();
    }

}

