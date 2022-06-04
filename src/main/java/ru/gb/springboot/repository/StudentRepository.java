package ru.gb.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.springboot.model.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s")
    List<Student> findAll();

    Optional<Student> findByName(String Name);

    @Modifying
    @Query("update Student s set s.age = :age, s.name = :name where s.id = :id")
    void saveOrUpdate(@Param("age") Integer age,
                         @Param("name") String name, @Param("id") Long id);

}
