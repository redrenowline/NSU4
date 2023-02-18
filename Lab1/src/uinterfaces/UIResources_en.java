package uinterfaces;

import java.util.ListResourceBundle;

public class UIResources_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {
			{"HELLO_MESSAGE", "The stack calculator v%d start work!\n"},
			{"GOODBUY_MESSAGE", "The stack calculator stop working! Good day!\n"}
		};
	}

}
