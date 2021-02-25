package Flag.lesson01;

import Flag.lesson01.DO.Students;
import org.apache.ibatis.annotations.*;

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
    public Integer getpaiwei(String yiban_id);

    @Insert("INSERT INTO students(yiban_id,name) VALUES(#{yiban_id},#{name})")
    public void addStudents(Students students);

    @Update("update students set paiWei=#{paiWei} where yiban_id=#{yiban_id}" )
    public void updatePaiWei(int paiWei, String yiban_id);

    @Delete("delete from students where yiban_id=#{yiban_id}")
    public void deleteStudent(String yiban_id);
}
