package ru.gb.springboot.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentDto {
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Integer age;

}
