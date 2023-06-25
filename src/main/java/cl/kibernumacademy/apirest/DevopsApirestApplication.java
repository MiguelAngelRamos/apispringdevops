package cl.kibernumacademy.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cl.kibernumacademy.apirest.models.dao.IStudentDao;
import cl.kibernumacademy.apirest.models.entity.Student;

@SpringBootApplication
public class DevopsApirestApplication implements CommandLineRunner{

  private final IStudentDao repository;
  @Autowired
  public DevopsApirestApplication(IStudentDao repository) {
    this.repository = repository;
  }
  public static void main(String[] args) {
    SpringApplication.run(DevopsApirestApplication.class, args);
  }

@Override
 public void run(String... args) throws Exception {
  Student student1 = new Student("Miguel", "Ramos", "mramoscli@correo.com");
  Student student2 = new Student("Camila", "Marquez", "cmarquez@correo.com");
   repository.save(student1);
   repository.save(student2);

 }

}
