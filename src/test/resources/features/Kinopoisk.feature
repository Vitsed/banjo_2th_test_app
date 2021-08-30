# language: ru
# образец

@Kinopoisk @softAssert
Функция: Kinopoisk

  Сценарий: Поиск фильма на портале яндекса "кинопоиск"
	Если перейти по адресу "https://www.kinopoisk.ru/"
	Тогда открыта страница "КиноПоиск. Все фильмы планеты."
	И нажать на ссылку "Расширенный поиск"
	Тогда открыта страница "Расширенный поиск"
	И на текущей странице перейти к блоку "Поиск фильмов"
	И в поле ввода "Искать фильм:" ввести "Назад в будущее"
#	Тогда проверить, что в поле значение = "Назад в будущее"
	И нажать на выпадающий список "интервал по"
	И в выпадающем списке  выбрать значение "1985"
	И в выпадающем списке "+ жанр:" выбрать значение "фантастика"
#	Тогда элемент "текст с параметром: выбран жанр" отображен
	И проверить, что в "тексте с параметром: жанр" значение = "фантастика"
	Затем нажать на чекбокс "выбран жанр"
	И проверить, что чекбокс активирован
	И нажать на кнопку "поиск"
    Тогда открыта страница "Результаты поиска (37)"

	