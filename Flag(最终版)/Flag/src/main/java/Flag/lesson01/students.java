package Flag.lesson01;

import Flag.lesson01.DO.Students;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface students {
    @Select("SELECT count(*) from students")
    public  int getCount();

    @Select("SELECT * from students")
    public ArrayList<Students>getAll();

    @Select("SELECT paiWei FROM `students`WHERE yiban_id = #{yiban_id};")
    public int getpaiwei(String id);

    @Insert("INSERT INTO students(yiban_id,name,paiWei) VALUES(#{yiban_id},#{name},#{paiWei})")
    public void addStudents(Students students);
}
