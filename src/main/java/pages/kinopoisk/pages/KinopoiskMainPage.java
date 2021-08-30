package pages.kinopoisk.pages;

import pages.kinopoisk.pages.blocks.HeaderMainPageBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title("КиноПоиск. Все фильмы планеты.")
public interface KinopoiskMainPage extends AbstractPage, HeaderMainPageBlock {

    @Override
    default boolean isOpen() {
        return  advancedSearchLink().isDisplayed()
                && this.getWrappedDriver().getTitle().equals("КиноПоиск. Все фильмы планеты.");
    }
}
