package cl.kibernumacademy.apirest.models.services;

import cl.kibernumacademy.apirest.models.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

  public List<Student> findAll();
  public Optional<Student> findById(Long id);
  public Student save(Student student);
  public void delete(Long id);
}
