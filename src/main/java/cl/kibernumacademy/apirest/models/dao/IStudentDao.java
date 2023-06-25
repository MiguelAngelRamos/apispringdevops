package cl.kibernumacademy.apirest.models.dao;

import cl.kibernumacademy.apirest.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentDao extends CrudRepository<Student, Long> {
}
