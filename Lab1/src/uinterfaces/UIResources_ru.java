package uinterfaces;

import java.util.ListResourceBundle;

public class UIResources_ru extends ListResourceBundle {
	
	@Override
	protected Object[][] getContents(){
		return new Object[][] {
			{"HELLO_MESSAGE", "Стековый калькулятор v%s начинает работу!\n"},
			{"GOODBUY_MESSAGE", "Стековый калькулятор прекращает свою работу! Приятного вам дня!\n"}
		};
	}
}
