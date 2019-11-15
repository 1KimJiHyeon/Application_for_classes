package valueObject;

import java.util.Scanner;

public class VMPersonalInfo {
	private String Name;
	private String ID;
	
	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void readFromFile(Scanner scanner) {
		this.ID = scanner.next();
		this.Name = scanner.next();
	}
}