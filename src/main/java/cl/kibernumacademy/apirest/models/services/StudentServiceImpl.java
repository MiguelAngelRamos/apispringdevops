package cl.kibernumacademy.apirest.models.services;

import cl.kibernumacademy.apirest.models.dao.IStudentDao;
import cl.kibernumacademy.apirest.models.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService{

  @Autowired
  private IStudentDao studentDao;
  @Override
  public List<Student> findAll() {
    return (List<Student>)studentDao.findAll();
  }

  @Override
  public Optional<Student> findById(Long id) {
    return studentDao.findById(id);
  }

  @Override
  public Student save(Student student) {
    return studentDao.save(student);
  }

  @Override
  public void delete(Long id) {
    studentDao.deleteById(id);
  }
}
