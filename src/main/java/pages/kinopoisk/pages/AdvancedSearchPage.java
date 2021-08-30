package pages.kinopoisk.pages;

import pages.kinopoisk.pages.blocks.AdvancedSearchBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title("Расширенный поиск")
public interface AdvancedSearchPage extends AbstractPage, AdvancedSearchBlock,
        AdvancedSearchBlock.WithAdvancedSearchBlock {

    @Override
    default boolean isOpen() {
        return  findFilmInput().isDisplayed() && findButton().isDisplayed()
                && this.getWrappedDriver().getTitle().equals("Расширенный поиск");
    }
}
