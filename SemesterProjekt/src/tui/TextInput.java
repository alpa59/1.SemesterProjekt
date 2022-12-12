package tui;


import java.util.Scanner;

public class TextInput {
	private Scanner scanner;
	
	public TextInput() {
		scanner = new Scanner(System.in);
	}
	public String promptString(String prompt) {
		System.out.print(prompt + ": ");
		String res = scanner.nextLine();
		return res;
	}
	
	public int promptInt(String prompt, String complaint) {
		while(true) {
			String input = promptString(prompt);
			try {
				int res = Integer.parseInt(input);
				return res;
			}catch(NumberFormatException nfe) {
				System.out.println(input + " is not an integer. " + complaint);
			}
		}
	}
	
	public boolean promptBoolean(String prompt) {
		boolean done = false;
		boolean res = false;
		while(!done) {
			String input = promptString(prompt);
			input = input.toLowerCase();
			switch(input) {
				case "y":
				case "yes":
				case "ja":
				case "j:":
					res = true;
					done = true;
					break;
				case "n":
				case "no":
				case "nej":
					res = false;
					done = true;
					break;
				default:
					System.out.println("You must either answer \"yes\" or \"no\"");
			}
		}
		return res;
	}
}
