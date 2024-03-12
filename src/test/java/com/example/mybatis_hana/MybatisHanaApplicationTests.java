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
        SqlSession session = MyBatisUtils.getSession();
        IClassMapper mapper = session.getMapper(IClassMapper.class);
        IClass icalss = mapper.selectClassById(2);
        System.out.println(icalss.toString());
        session.close();
    }
        @Test
        public void updateStudent() {
            SqlSession session = MyBatisUtils.getSession();
            IStudent student = new IStudent();
            student.setId(4);
            student.setName("丁真");
            student.setAge(23);
            IStudentMapper mapper = session.getMapper(IStudentMapper.class);
            int update = mapper.updateStudent(student);
            if (update > 0) {
                System.out.println("修改了" + update + "条数据！");
            } else {
                System.out.println("修改失败！");
            }
            System.out.println(student.toString());
            session.commit();
            session.close();
        }
    }