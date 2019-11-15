package control;

import model.MLogin;

public class CLogin {
	private MLogin mLogin;

	public boolean validateUser(String id, String password) {
		this.mLogin = new MLogin();

		return this.mLogin.validateUser(id, password);
	}
}
