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
        //一对多查询出二班所有学生的信息
        //将id=4的学生姓名修改为李雷，年龄修改为21
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