package ru.gb.springboot.service;

import org.springframework.stereotype.Service;
import ru.gb.springboot.model.Student;
import ru.gb.springboot.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> findByName(String name) {return studentRepository.findByName(name);}

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void saveOrUpdate(Student student){studentRepository.saveOrUpdate(student.getAge(), student.getName(), student.getId());}
}
