package tui;

public class TuiMainMenu {
	public static void main(String[] args) {
		startUp();
		endApplication();
	}

	private static void endApplication() {
		System.out.println("Exiting");
	}

	private static void startUp() {
		System.out.println("Sales manegent system version 0.1");

		boolean goOn = true;
		while (goOn) {
			String res = promptUser().toLowerCase();

			switch (res) {
			case "make order":
				System.out.println();
				OrderMenu om = new OrderMenu();
				break;
			case "exit":
				TextInput ti = new TextInput();
				goOn = !ti.promptBoolean("Are you sure you want to exit?");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + res);
			}
		}

	}

	private static String promptUser() {
		StringRenderer sr = new StringRenderer();
		TextChoice<String> tc = new TextChoice("Main menu", sr);
		String[] prompts = promptOptions();

		tc.addOptions(prompts);

		String res = tc.prompt("Choose option", false);
		return res;

	}

	private static String[] promptOptions() {
		String[] res = { "Make order", "Exit" };
		return res;
	}

}
