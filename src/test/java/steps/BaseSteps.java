package steps;


import assertion.AssertsManager;
import assertion.ExtendedAssert;
import io.qameta.atlas.webdriver.extension.Name;
import ru.lanit.at.exceptions.FrameworkRuntimeException;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.block.AbstractBlockElement;
import ru.lanit.at.pages.element.UIElement;
import ru.lanit.at.steps.AbstractFrameworkSteps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BaseSteps extends AbstractFrameworkSteps {
    protected ExtendedAssert softAssert() {
        return AssertsManager.getAssertsManager().softAssert();
    }

    protected ExtendedAssert criticalAssert() {
        return AssertsManager.getAssertsManager().criticalAssert();
    }

    protected <T extends UIElement> T getElementByName(Class<T> elementClass, String... params) {
        Class currentClass;
        Optional<Method> elementMethod;
        Object obj = getSearchContext();
        if (obj == null) {
            throw new FrameworkRuntimeException("Установите контекст поиска элемента на страницу/блок");
        }
        if (!AbstractPage.class.isAssignableFrom(obj.getClass())) {
            currentClass = ((AbstractBlockElement) obj).getClass();
        } else {
            currentClass = ((AbstractPage) obj).getClass();
        }
        Method[] methods = currentClass.getInterfaces()[0].getMethods();
        List<Method> blocks = Stream.of(methods).filter(method ->
                elementClass.isAssignableFrom(method.getReturnType())
                        && method.isAnnotationPresent(Name.class)).collect(Collectors.toList());
        if (!blocks.isEmpty() && (params.length == 1)) {
            elementMethod = blocks.stream().filter(method -> method.getDeclaredAnnotation(Name.class).value().equalsIgnoreCase(params[0]))
                    .findFirst();
            if (elementMethod.isPresent()) {
                try {
                    return (T) elementMethod.get().invoke(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }
        return getUIElement(elementClass, params);
    }
}
