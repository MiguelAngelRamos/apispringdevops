package cl.kibernumacademy.apirest.controllers;

import cl.kibernumacademy.apirest.models.entity.Student;
import cl.kibernumacademy.apirest.models.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost", "http://192.168.49.2:30100"})
@RestController
@RequestMapping("/api")
public class StudentRestController {
  @Autowired
  private IStudentService studentService;

  @GetMapping("/students")
  public List<Student> getAllStudents() {
    return studentService.findAll();
  }

  @GetMapping("/student/{id}")
  public Optional<Student> getStudentById(@PathVariable Long id) {
    Optional<Student> optionalStudent = studentService.findById(id);

    if(!optionalStudent.isPresent()) throw new StudentNotFoundException("Student not found for: " +  id);

    return optionalStudent;
  }

  //localhost:8080/api/clientes
  @PostMapping("/student")
  @ResponseStatus(HttpStatus.CREATED)
  public Student create(@RequestBody Student cliente) {
    return studentService.save(cliente);
  }

  // Actualizar un recurso

  @PutMapping("/student/{id}")
  public Optional<Student> update(@RequestBody Student student, @PathVariable Long id) {

    // Encontrar dentro de la base de datos el estudiante el estudiante que deseamos actualizar
    Optional<Student> studentActual = studentService.findById(id);

    if(!studentActual.isPresent()) throw new StudentNotFoundException("No existe un cliente con ese id: " +  id);

    // al cliente actual necesitamos actualizar sus datos
    studentActual.get().setName(student.getName());
    studentActual.get().setLastname(student.getLastname());
    studentActual.get().setEmail(student.getEmail());

    // ahora llamamos al servicio para guardar los datos actualizados del cliente
    studentService.save(studentActual.get());

    return studentActual;
  }

  @DeleteMapping("/student/{id}")
  public void delete(@PathVariable Long id) {
    studentService.delete(id);
  }


}

class StudentNotFoundException extends RuntimeException {

  public StudentNotFoundException(String message) {
    super(message);
  }
}
