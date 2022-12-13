package tui;


import java.util.LinkedList;
import java.util.List;

public class TextChoice<T> {
	private String title,
					numberComplaint,
					cancelText;
	List<T> options;
	ListRenderer<T> r;
	
	public TextChoice(String title, ListRenderer<T> r) {
		this.title = title;
		options = new LinkedList<>();
		this.r = r;
		numberComplaint = "0";
	}
	
	public T prompt(String prompt, boolean cancellable) {
		System.out.println(title);
		
		if(cancellable) {
			printOption(0, "cancel");
		}
		
		for(int i = 0; i < options.size(); i++) {
			printOption(i+1, r.display(options.get(i)));
		}
		
		TextInput ti = new TextInput();
		
		int choosenOption = ti.promptInt(prompt, null);
		while((cancellable && choosenOption <= 0 && choosenOption > options.size())
				|| (!cancellable && choosenOption < 1 || choosenOption > options.size())) {
			System.out.println("Choose viable number");
			int complaints = 0;
			complaints++;
			choosenOption = ti.promptInt(prompt,"" + (complaints));
			
			int tempComplaint = Integer.parseInt(numberComplaint) + complaints;
			numberComplaint = Integer.toString(tempComplaint);
			
			System.out.println(numberComplaint);
		}
		
		T res;
		if(cancellable && choosenOption <= 0) {
			res = null;
		}
		else {
			 res = options.get(choosenOption-1);
		}
	
		return res;
		
	}
	
	private void printOption(int i, String text) {
		System.out.println(i + ": \t" + text);
	}
	
	public void setCancelText(String cancel) {
		this.cancelText = cancel;
	}
	
	public void setNumberComplaints(String complain) {
		numberComplaint = complain;
	}
	
	public void addOption(T t) {
		options.add(t);
		
	}
	
	public void addOptions(T[] t) {
		for(int i = 0; i < t.length; i++) {
			addOption(t[i]);
		}
	}

	public void clearOptions() {
		options = new LinkedList<>();
		
	}
}
