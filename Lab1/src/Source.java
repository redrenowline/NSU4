
import ru.nsu.ccfit.Prokhorov.calculator.uinterfaces.TextUI;

public class Source {

	public static void main(String[] args) {
		TextUI ui;
		if(args.length == 0) {
			ui = new TextUI(System.out, System.in);
		}else {
			ui = new TextUI(System.out, args);
		}
		ui.start();
	}

}
