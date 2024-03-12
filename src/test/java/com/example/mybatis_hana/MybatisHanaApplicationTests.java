package com.example.mybatis_hana;

import com.example.mybatis_hana.dao.IClassMapper;
import com.example.mybatis_hana.dao.IStudentMapper ;
import com.example.mybatis_hana.pojo.IClass;
import com.example.mybatis_hana.pojo.IStudent ;
import com.example.mybatis_hana.utils.MyBatisUtils ;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MybatisHanaApplicationTests {
    @Test
    public void findIStudentByIdTest() {
        SqlSession session = MyBatisUtils.getSession();
        IStudentMapper mapper = session.getMapper(IStudentMapper.class);
        IStudent student = mapper.selectStudent(2);
        System.out.println(student.toString());
        session.close();
    }

    @Test
    public void selectClassByIdTest() {
        // 1.通过工具类生成SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        IClassMapper mapper = session.getMapper(IClassMapper.class);
        // 2.查询id为2的班级中学生的信息
        IClass icalss = mapper.selectClassById(2);
        System.out.println(icalss.toString());
        session.close();
    }
}