import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter a word or sentence");
    submit(".btn-success");
    assertThat(pageSource()).contains("Can you guess this puzzle?");
  }

  @Test
  public void vowelReplacer_returnsString_string() {
    App testApp = new App();
    String puzzleString = testApp.vowelReplacer("hello");
    assertEquals(true, puzzleString instanceof String);
  }

  @Test
  public void vowelReplacer_turnsEIntoDash_changedString() {
    App testApp = new App();
    assertEquals("h-y", testApp.vowelReplacer("hey"));
  }

  @Test
  public void vowelReplacer_replacesMultipleVowels_changedString() {
    App testApp = new App();
    assertEquals("p-nn-", testApp.vowelReplacer("penne"));
  }

  @Test
  public void vowelReplacer_replacesAllVowels_changedString() {
    App testApp = new App();
    assertEquals("-v-ry c-t -s -nd-rgr--nd", testApp.vowelReplacer("every cat is underground"));
  }

  @Test
  public void vowelReplacer_isCaseInsensitive_changedString() {
    App testApp = new App();
    assertEquals("w--H--h-h", testApp.vowelReplacer("wOaHoAhOh"));
  }

  @Test
  public void vowelReplace_doesNotInterfereWithPunctuation_changedString() {
    App testApp = new App();
    assertEquals("Y--'r- (m-yb-) - * st-d3nt", testApp.vowelReplacer("You're (maybe) a * stud3nt"));
  }
}
