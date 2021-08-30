package steps;


import cucumber.api.java.ru.И;
import pages.html_elements.CheckBox;
import ru.yandex.qatools.matchers.webdriver.EnabledMatcher;

public class CheckBoxSteps extends BaseSteps {

    @И("активировать чекбокс {string}")
    public void selectCheckboxVal(String string) {
        CheckBox checkBox = getElementByName(CheckBox.class, string);
        checkBox.should(EnabledMatcher.enabled());
        checkBox.setChecked(true);
    }

}