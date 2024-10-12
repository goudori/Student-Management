package raisetech.student.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  private String name = "Robolink Drone";

  private String age = "40";

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /* localhost:8080/nameを入力すると「nameの値」が表示されます。
   *
   *
   */


  //  GETを使う
  @GetMapping("/studentInfo")
  public String getName() {

    return name + "　" + age + "歳";
  }

  //  POSTを使う
  @PostMapping("/studentInfo")
  public void setStudentInfo(String name, String age) {
    this.name = name;
    this.age = age;
  }

  @PostMapping("studentName")
  public void updateStudentName(String name) {
    this.name = name;
  }

}
