package PracticeRealTime.TestNG;
import org.testng.annotations.Test;

public class SimpleAssignmentOnWednsday {
	public static void transfer() {
		System.out.println("we can send money");
	}
	public void history() {
		System.out.println("we can see history");
	}
	@Test
	public void reacharge() {
		System.out.println("we can reacharge also");
	}
	public static void main(String[] args) {
		SimpleAssignmentOnWednsday a=new SimpleAssignmentOnWednsday();
		a.transfer();
		a.history();
		a.reacharge();
	}
}

