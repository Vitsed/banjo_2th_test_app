package pages.kinopoisk.pages.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.*;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Поиск фильмов")
public interface AdvancedSearchBlock extends AbstractBlockElement, Input.WithInput,
        DropDown.WithDropDown, Button.WithButton, CheckBox.WithCheckBox,
        Text.WithText {

    @WithName("интервал по")
    @FindBy("//select[@id='to_year']")
    DropDown selectToYear();

    @WithName("+ жанр:")
    @FindBy("//select[@id='m_act[genre]']")
    DropDown selectGenre();

    @WithName("Искать фильм:")
    @FindBy("//*[@id='find_film']")
    Input findFilmInput();

    @WithName("поиск")
    @FindBy("//input[@type='button']")
    Button findButton();

    @WithName("выбран|выбраны жанр|жанры")
    @FindBy("//input[@type='checkbox']")
    CheckBox genreCheckBox();

    @WithName("жанр|жанры")
    @FindBy("//span[@id='genre_selected']")
    Text genreSelectedText();

    interface WithAdvancedSearchBlock extends AbstractBlockElement {

        @FindBy("//form[@id='formSearchMain']")
        AdvancedSearchBlock advancedSearchBlock();
    }
}
