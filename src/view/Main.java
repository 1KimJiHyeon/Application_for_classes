package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import global.Constants.ELoginDialog;

public class Main {
	private LoginDialog loginDialog;
	private MainFrame mainFrame;
	Idpwfind find;

	public Main() {
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler);

	}

	public void initialize() {
		this.loginDialog.initialize();
	}

	private void loginOk() {
		String id = loginDialog.validateUser();
		if (id != null) {
			loginDialog.dispose();
			this.mainFrame = new MainFrame();
			this.mainFrame.initialize(id);
		}
	}

	private void loginCancel() {
		loginDialog.cancel();
		loginDialog.dispose();
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(ELoginDialog.okButton.getString())) {
				loginOk();

			} else if (actionEvent.getActionCommand().equals(ELoginDialog.cancelButton.getString())) {
				loginCancel();
			} else if (actionEvent.getActionCommand().equals(ELoginDialog.findactioncommand.getString())) {
				Idpwfind Idpwfind = new Idpwfind();
			}
		}
	}

	public static void main(String[] args) {
		Main main;
		main = new Main();
		main.initialize();
	}

	public void logout() {
		ActionHandler actionHandler = new ActionHandler();
		this.loginDialog = new LoginDialog(actionHandler);

	}
}
