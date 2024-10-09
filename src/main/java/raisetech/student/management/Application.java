package raisetech.student.management;

import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

/* localhost:8080/helloを入力すると「Hello World!!!」が表示されます。
*
*
*/
  @GetMapping("/hello")
  public String test(){
    
    return "Hello World!!!";
  }
}
