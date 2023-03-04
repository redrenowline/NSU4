package ru.nsu.ccfit.Prokhorov.calculator.uinterfaces;

import java.util.ListResourceBundle;

public class UIResources_ru extends ListResourceBundle {
	
	@Override
	protected Object[][] getContents(){
		return new Object[][] {
			{UIResources.HELLO_MESSAGE_ID, "Стековый калькулятор v%s начинает работу!\n"},
			{UIResources.GOODBUY_MESSGE_ID, "Стековый калькулятор прекращает свою работу! Приятного вам дня!\n"},
			{UIResources.WRONGCOMMAND_ID, "Стековый калькулятор не знает такой комманды, попробуйте еще раз (ну давайте), либо вызовите комманду help \n"},
			{UIResources.WRONGARGUMENT_ID, "Стековый калькуоятор считает что у вас неправльно поданы аргументы для комманды, попробуйте вызвать команду help \n"},
			{UIResources.FACTORYSYSTEMERROR_ID, "При создании команды произошла неизвестная ошибка, попробуйте обновить версию калькулятора \n"}
		};
	}
}
