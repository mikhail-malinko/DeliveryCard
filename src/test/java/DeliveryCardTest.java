import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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
    @Test
    void EnteringValidValues() {
        Configuration.headless = true;
        //Configuration.holdBrowserOpen = true;

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Уфа");
        String Date = generateDate(3,"dd.MM.yyyy");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        $("[data-test-id=date] input").sendKeys(Date);
        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79998887766");
        $("label[data-test-id=agreement]").click();
        $("button.button").click();
        $(".notification__content")
                .shouldBe(Condition.visible, Duration.ofSeconds(15))
                .shouldHave(Condition.exactText("Встреча успешно забронирована на " + Date));

    }
}


//        import org.junit.jupiter.api.BeforeEach;
//        import org.junit.jupiter.api.DisplayName;
//        import org.junit.jupiter.api.Test;
//
//        import java.text.SimpleDateFormat;
//        import java.util.Calendar;
//        import java.util.Date;
//
//        import static com.codeborne.selenide.Condition.exactText;
//        import static com.codeborne.selenide.Condition.text;
//        import static com.codeborne.selenide.Selenide.$;
//        import static com.codeborne.selenide.Selenide.$$;
//        import static com.codeborne.selenide.Selenide.open;
//
//
//        class AppCardDelivery {
//        String[] monthNames = { "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь" };
//        String date;
//        String month;
//        String day;
//
//        @BeforeEach
//        void setUp() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.DAY_OF_MONTH, 100);
//        date =  new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime());
//        month = monthNames[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR);
//        day = Integer.toString(calendar.get(Calendar.DATE));
//        open("http://localhost:9999");
//        }
//
//        @Test
//        @DisplayName("Должен забронировать встречу при вводе валидных данных")
//        void shouldRegisterCardDelivery() {
//        $("span[data-test-id='city'] input").setValue("Пе");
//        $$("div.popup__content div").find(exactText("Пермь")).click();
//        $("span[data-test-id='date'] button").click();
//
//        while (!$("div.calendar__name").getText().equals(month)) {
//        $$("div.calendar__arrow.calendar__arrow_direction_right").get(1).click();
//        }
//
//        $$("table.calendar__layout td").find(text(day)).click();
//        $("span[data-test-id='name'] input").setValue("Пупкин Василий");
//        $("span[data-test-id='phone'] input").setValue("+79000000000");
//        $("label[data-test-id='agreement']").click();
//        $$("button").find(exactText("Забронировать")).click();
//        $("div.notification__content").waitUntil(text("Встреча успешно забронирована на " + date),
//        15000);
//        }
//
//        }