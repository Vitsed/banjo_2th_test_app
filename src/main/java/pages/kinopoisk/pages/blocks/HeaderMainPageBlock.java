package pages.kinopoisk.pages.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Input;
import pages.html_elements.Link;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title("Заголовок главной страницы")
public interface HeaderMainPageBlock extends AbstractBlockElement, Input.WithInput, Link.WithLink {


    @WithName("Расширенный поиск")
    @FindBy("//a[@href='/s/']")
    Link advancedSearchLink();

    interface WithHeaderMainPageBlock extends AbstractBlockElement {

        @FindBy("//header")
        HeaderMainPageBlock headerBlock();
    }
}
