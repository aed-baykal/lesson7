package ru.gb.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.springboot.converter.StudentMapper;
import ru.gb.springboot.dto.StudentDto;
import ru.gb.springboot.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public AdminController(StudentService studentService,
                           StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        List<StudentDto> studentDtos =  studentService.getAll().stream()
                .map(studentMapper::studentToStudentDto).collect(Collectors.toList());
        model.addAttribute("students", studentDtos);
        return "index";
    }

    @GetMapping("/add")
    public String getStudentAddForm(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        return "add_student_form";
    }

    @PostMapping("/add")
    @Transactional
    public String saveProduct(@Valid StudentDto studentDto,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "add_student_form";
        }
        try {
            studentService.save(studentMapper.studentDtoToStudent(studentDto));
        } catch (RuntimeException ex) {
            model.addAttribute("notFound", ex);
            return "add_student_form";
        }
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    @Transactional
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String getStudentUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("studentDto", studentMapper.studentToStudentDto(studentService.findById(id).orElse(null)));
        return "update_student_form";
    }

    @PostMapping("/update")
    @Transactional
    public String updateStudent(@Valid StudentDto studentDto,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "update_student_form";
        }
        try {
            studentService.saveOrUpdate(studentMapper.studentDtoToStudent(studentDto));

        } catch (RuntimeException ex) {
            model.addAttribute("notFound", ex);
            return "update_student_form";
        }
        return "redirect:/";
    }

}
