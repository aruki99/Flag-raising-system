package Flag.lesson01.DO;

import Flag.lesson01.students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //创建一个类，存你自己封装的函数，要加上@Service注解
public class Data {

    //引入数据库接口
    @Autowired
    students students1;


    public int getPaiWei(Students students) {

        String yiban_id = students.getYiban_id();
        students1.deleteStudent(yiban_id);
        students1.addStudents(students);
        return students1.getpaiwei(yiban_id);

    }
}
