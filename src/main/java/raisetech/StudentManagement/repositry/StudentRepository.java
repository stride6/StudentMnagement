package raisetech.StudentManagement.repositry;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.studentManagement.data.StudentCourses;



@Mapper
public interface StudentRepository {



//    @Select("SELECT * FROM student WHERE name = #{name}")
//    Student searchByName(String name);

//    @Insert("INSERT student values(#｛name｝, #｛age｝)")
//    void registerStudent(String name, int age);

//    @Update("UPDATE student SET age = #{age} WHERE name = #{name}")
//    void updateStudent(String name, int age);

//    @Delete("DELETE FROM student WHERE name =#{name} ")
//    void deleteStudent(String name);
    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentsCourses();
    @Select("students")
    List<Student> search();
}
