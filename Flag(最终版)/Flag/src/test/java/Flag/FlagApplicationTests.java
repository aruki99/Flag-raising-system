package Flag;

import Flag.lesson01.DO.Data;
import Flag.lesson01.DO.Students;
import Flag.lesson01.students;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class  FlagApplicationTests {

    @Autowired
    students students1;

    @Test
    void contextLoads() {
        System.out.println("dsadsa");
    }

    @Test
    void DOTest(){
        int count = students1.getCount();
        System.out.println(count);
    }

    @Autowired
    Data data;

    @Test
    void StudentsTest(){
        Students students = new Students("123","123",123);
        int paiWei = data.getPaiWei(students);
        System.out.println(paiWei);
    }

 //   @Test
//    void paiweitest(){
//        int paiwei = students1.getpaiwei();
//        System.out.println("排位为" + paiwei);
//    }


}
