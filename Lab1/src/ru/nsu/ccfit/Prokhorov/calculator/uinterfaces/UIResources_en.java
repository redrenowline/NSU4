package ru.nsu.ccfit.Prokhorov.calculator.uinterfaces;

import java.util.ListResourceBundle;

public class UIResources_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{UIResources.HELLO_MESSAGE_ID, "The stack calculator v%s start work!\n"},
			{UIResources.GOODBUY_MESSGE_ID, "The stack calculator stop working! Good day!\n"},
			{UIResources.WRONGCOMMAND_ID, "Sorry, but it seems like calculator don'r know that command! Try again please!\n"},
			{UIResources.WRONGARGUMENT_ID, "Sorry, but it seems like you inoput wrong arguments! Try again or use help coomand\n"},
			{UIResources.FACTORYSYSTEMERROR_ID, "Sorry, but it seems like we got undefined exception, please check that your calculator has got the lastest version.\n"},
			{UIResources.WRONGCOMMNADEXECUTION_ID, "This command doesn't work truly!\n"},
			{UIResources.FILENOTFOUNT_ID, "This file can't be opened, please try again!\n"},
			{UIResources.IOEXCEPTION_ID, "This file cannot be readen!\n"}
		};
	}

}
