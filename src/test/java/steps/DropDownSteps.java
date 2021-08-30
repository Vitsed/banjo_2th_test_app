package steps;


import cucumber.api.java.ru.И;
import pages.html_elements.DropDown;
import ru.yandex.qatools.matchers.webdriver.DisplayedMatcher;

public class DropDownSteps extends BaseSteps {

    @И("в выпадающем списке {string} выбрать значение {string}")
    public void selectValueInDropDown(String ddName, String value) {
        DropDown dropDown = getElementByName(DropDown.class, ddName);
        dropDown.should(DisplayedMatcher.displayed());
        dropDown.selectByValue(value);
    }

}