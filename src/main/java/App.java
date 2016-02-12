import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

  }

  public static String vowelReplacer(String originalString) {
    String[] vowels = "aeiou".split("");
    String puzzleString = originalString;

    for (String vowel : vowels) {
      if (puzzleString.contains(vowel)) {
        puzzleString = puzzleString.replaceAll(vowel, "-");
      }
    }

    return puzzleString;
  }
}
