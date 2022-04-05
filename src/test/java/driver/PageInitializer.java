package driver;

import pages.*;

public class PageInitializer extends Driver {

	public static commonPage comm;
	public static womenPage women;
	public static cartPage cart;
	public static dressesPage dresses;
	public static signinPage signin;
	public static CreateAccountPage create;

	public static void initialize() {
		comm = new commonPage();
		women = new womenPage();
		cart = new cartPage();
		dresses = new dressesPage();
		signin = new signinPage();
		create = new CreateAccountPage();
	}
}
