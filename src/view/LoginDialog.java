package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import control.CLogin;
import global.Constants.EDataFileName;
import global.Constants.EErrorDialog;
import global.Constants.ELoginDialog;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = ELoginDialog.serialVersionUID.getInt();

	private JLabel nameLabel;
	static JTextField nameText;
	private JLabel passwordLabel;
	static JPasswordField passwordText;
	private JButton okButton;
	private JButton cancelButton;
	private CLogin cLogin;

	public LoginDialog(ActionListener actionHandler) {
		this.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setTitle(ELoginDialog.login.getString());
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel totalpanel = new JPanel();
		totalpanel.setLayout(new BoxLayout(totalpanel, BoxLayout.Y_AXIS));

		JPanel mj = new JPanel();
		ImageIcon icon = new ImageIcon(EDataFileName.path.getString() + EDataFileName.mjicon.getString());
		JLabel label = new JLabel(icon);
		mj.add(label);
		totalpanel.add(mj);

		JPanel panel1 = new JPanel();
		nameLabel = new JLabel(ELoginDialog.nameLabel.getString());
		panel1.add(nameLabel);
		LoginDialog.nameText = new JTextField(ELoginDialog.nameTextSize.getInt());
		panel1.add(nameText);
		totalpanel.add(panel1);

		JPanel panel2 = new JPanel();
		passwordLabel = new JLabel(ELoginDialog.passwordLabel.getString());
		panel2.add(passwordLabel);
		LoginDialog.passwordText = new JPasswordField(ELoginDialog.passwordTextSize.getInt());
		panel2.add(passwordText);
		totalpanel.add(panel2);

		ImageIcon saveImage1 = new ImageIcon(EDataFileName.path.getString() + EDataFileName.oicon.getString());
		ImageIcon saveImage2 = new ImageIcon(EDataFileName.path.getString() + EDataFileName.xicon.getString());

		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		okButton = new JButton(ELoginDialog.okButton.getString(), saveImage1);
		okButton.addActionListener(actionHandler);
		okButton.setActionCommand(ELoginDialog.okButton.getString());

		panel3.add(okButton);

		// panel3.add(Box.createHorizontalStrut(30));

		cancelButton = new JButton(ELoginDialog.cancelButton.getString(), saveImage2);
		cancelButton.addActionListener(actionHandler);
		cancelButton.setActionCommand(ELoginDialog.cancelButton.getString());
		panel3.add(cancelButton);
		totalpanel.add(panel3);

		JPanel panel4 = new JPanel();

		JButton find = new JButton(ELoginDialog.findidpw.getString());
		find.addActionListener(actionHandler);
		find.setActionCommand(ELoginDialog.findactioncommand.getString());
		panel4.add(find);
		totalpanel.add(panel4);

		this.add(totalpanel);
		this.setVisible(true);
	}

	public void initialize() {
		// TODO Auto-generated method stub
	}

	public String validateUser() {
		String id = nameText.getText();
		
		@SuppressWarnings("deprecation")
		String password = passwordText.getText();

		this.cLogin = new CLogin();
		boolean result = cLogin.validateUser(id, password);

		if (result) {
			return id;
		} else {
			JOptionPane.showMessageDialog(this, EErrorDialog.message.getString(), EErrorDialog.title.getString(),
					JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}

	public void cancel() {
	}
}
