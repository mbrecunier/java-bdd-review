import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

  }

  public static String vowelReplacer(String originalString) {
    String puzzleString = "";
    String[] vowels = "aeiou".split("");

    for (String vowel : vowels) {
      if (originalString.contains(vowel)) {
        puzzleString = originalString.replaceAll(vowel, "-");
      }
    }
    //for each character in vowel array
      //check if original string contains
      //replace vowel with dash and store in puzzleString
    return puzzleString;
  }
}
