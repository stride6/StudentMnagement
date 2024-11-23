package raisetech.StudentManagement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentService;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
//import raisetech.StudentManagement.domain.StudentDetail;


import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
private StudentService service;

@Autowired
public  StudentController(StudentService service) {
this.service = service;
}

@GetMapping("/studentList")
public List<StudentDetail> getStudentList() {
    service.searchStudentList();
    service.searchStudentsCourseList();

    List<StudentDetail> studentDetails = new ArrayList<>()
    for(Student student :Students){
    StudentDetail studentDetail = new StudentDetail();
    StudentDetail.setStudent(student);

    List<StudentsCourses> convertStudentCourses = new ArrayList<>();
    for(StudentCourses studentCourses : studentsCourses){
        if(student.getId().equals(studentCourses.getStudentId())){
            convertStudentCourses.add(studentCourse);
        }
studentDetail.setStudentCourses(convertStudentCourses);
studentDetails.add(studentDetail);

    }
    }


    return studentDetails;
}
@GetMapping("/studentsCourseList")
public List<StudentCourses> getStudentsCourseList(){
    return service.searchStudentsCourseList();
}
}
