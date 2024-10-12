package raisetech.student.management;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生情報を管理するためのSpring Bootアプリケーション。 学生の名前と年齢をHashMapで管理し、GETとPOSTリクエストで情報を取得・更新します。
 */
@SpringBootApplication
@RestController
public class Application {

  //  HashMapを使って、学生の名前と年齢を管理
  private Map<String, String> studentInfoMap = new HashMap<>();

  /**
   * アプリケーションのエントリーポイント。
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /**
   * 学生情報の全てを取得するメソッド。
   *
   * @return 全学生の名前と年齢のマップ
   */
  @GetMapping("/studentInfo")
  public Map<String, String> getStudentInfo() {
    return studentInfoMap;
  }

  /**
   * 学生情報を表示するメソッド（名前と年齢をフォーマットして表示）。
   *
   * @return 学生の名前と年齢の文字列
   */
  @GetMapping("/studentInfo/display")
  public String getStudentInfoDisplay() {
    StringBuilder sb = new StringBuilder();
    studentInfoMap.forEach((key, value) -> sb.append("名前：" + key + " 年齢：" + value + "歳\n"));
    return sb.toString();
  }

  /**
   * 指定した名前の学生が存在するかを確認し、名前のみを返すメソッド。
   *
   * @param name 学生の名前
   * @return 名前が存在すればその名前、なければ「学生が見つかりません」と表示
   */
  @GetMapping("/studentInfo/name/{name}")
  public String getStudentNameOnly(@PathVariable String name) {
    if (studentInfoMap.containsKey(name)) {
      return "名前：" + name;
    } else {
      return "学生が見つかりません。";
    }
  }

  /**
   * 指定した名前の学生の年齢を取得するメソッド。
   *
   * @param name 学生の名前
   * @return 名前が存在すれば年齢、なければ「学生が見つかりません」と表示
   */
  @GetMapping("/studentInfo/age/{name}")
  public String getStudentAge(@PathVariable String name) {
    return studentInfoMap.getOrDefault(name, "学生が見つかりません。");
  }

  /**
   * 新しい学生情報を登録するメソッド。
   *
   * @param name 学生の名前
   * @param age  学生の年齢
   */
  @PostMapping("/studentInfo")
  public void setStudentInfoMap(@RequestParam String name, @RequestParam String age) {
    studentInfoMap.put(name, age);  // nameをキー, ageを値として更新
  }

  /**
   * 学生の名前を更新するメソッド。
   *
   * @param oldName 古い名前
   * @param newName 新しい名前
   */
  @PostMapping("/studentName")
  public void updateStudentName(@RequestParam String oldName, @RequestParam String newName) {
    if (studentInfoMap.containsKey(oldName)) {
      String age = studentInfoMap.remove(oldName);
      studentInfoMap.put(newName, age);
    } else {
      System.out.println("学生情報が、更新されていません。");
    }
  }
}
