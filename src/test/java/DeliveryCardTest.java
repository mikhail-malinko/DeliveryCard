import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryCardTest {
    private String generateDate(int addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }
//    @BeforeAll
//    public static void setUp() {
//        Configuration.headless = true;
//        Configuration.browser = "chrome";
    }
    @Test
<<<<<<< HEAD
    public void enteringValidValues() {

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Уфа");
        String currentDate = generateDate(3,"dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys(currentDate);
=======
    void enteringValidValues() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Уфа");
        String dateCurrent = generateDate(3,"dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys(dateCurrent);
>>>>>>> second
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79998887766");
        $("label[data-test-id=agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
<<<<<<< HEAD
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + currentDate));
=======
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + dateCurrent));
>>>>>>> second

    }
}43tqwertv z
