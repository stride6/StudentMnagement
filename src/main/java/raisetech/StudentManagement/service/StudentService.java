package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentCourses;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.repositry.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        return repository.search();


    }

    public StudentDetail searchStudent(String id) {
        Student student = repository.searchStudent(id);
        List<StudentCourses> studentsCourses = repository.searchStudentCourses(student.getId());
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudent(student);
        studentDetail.setStudentCourses(studentsCourses);
        return studentDetail;
    }

    public List<StudentCourses> searchStudentsCourseList() {
        return repository.searchStudentsCourses();
        //ローカル変数　studentCourse を作成
        //String repository = "https://github.com/example/repository";
        //System.out.println(repository);
    }

    @Transactional
    public void registerStudent(StudentDetail studentDetail) {
        repository.registerStudent(studentDetail.getStudent());
        for (StudentCourses studentCourses : studentDetail.getStudentCourses()) {
            studentCourses.setStudentId(studentDetail.getStudent().getId());

            studentCourses.setCourseStartAt(LocalDateTime.now());

            studentCourses.setCourseEndAt(LocalDateTime.now().plusYears(1));
            repository.registerStudentsCourses(studentCourses);
        }
    }

    @Transactional
    public void updateStudent(StudentDetail studentDetail) {
        repository.updateStudent(studentDetail.getStudent());
        for (StudentCourses studentCourses : studentDetail.getStudentCourses()) {
            repository.updateStudentsCourses(studentCourses);
        }

    }
}


