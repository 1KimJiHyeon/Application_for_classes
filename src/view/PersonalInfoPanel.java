package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.Timer;

import control.CPersonalInfo;
import global.Constants.EDataFileName;

import global.Constants.EPersonalInfoPanel;

import valueObject.VCPersonalInfo;

public final class PersonalInfoPanel extends JPanel {
	private static final long serialVersionUID = EPersonalInfoPanel.serialVersionUID.getInt();
	static JPanel total;
	private JLabel lbInsa;
	private JLabel lbInsaPostfix;
	private JButton btnInfo;
	private JButton btnLogout;
	PersonalInfoPanel PersonalInfoPanel;

	private JButton whitechange;

	private JButton redchange;
	private JButton yellowchange;

	@SuppressWarnings("static-access")
	public PersonalInfoPanel() {

		this.setBackground(Color.gray);
		this.setLayout(new FlowLayout());
		ActionHandler actionHandler = new ActionHandler();

		PersonalInfoPanel.total = new JPanel();
		total.setBackground(Color.gray);
		ImageIcon icon = new ImageIcon(EDataFileName.path.getString() + EDataFileName.mjlogo.getString());
		JLabel label = new JLabel(icon);
		total.add(label);

		this.lbInsa = new JLabel();
		total.add(this.lbInsa);

		this.lbInsaPostfix = new JLabel(EPersonalInfoPanel.lbInsaPostfix.getString());
		total.add(this.lbInsaPostfix);

		this.btnInfo = new JButton(EPersonalInfoPanel.btnInfo.getString());
		this.btnInfo.setActionCommand(EPersonalInfoPanel.btnInfosetActionCommand.getString());
		this.btnInfo.addActionListener(actionHandler);
		total.add(this.btnInfo);

		this.btnLogout = new JButton(EPersonalInfoPanel.btnLogout.getString());
		this.btnLogout.setActionCommand(EPersonalInfoPanel.btnLogoutsetActionCommand.getString());
		this.btnLogout.addActionListener(actionHandler);
		total.add(this.btnLogout);

		this.whitechange = new JButton();
		whitechange.setBackground(Color.white);
		this.whitechange.setActionCommand(EPersonalInfoPanel.whitechangesetActionCommand.getString());
		this.whitechange.addActionListener(actionHandler);

		this.yellowchange = new JButton();
		yellowchange.setBackground(Color.yellow);
		this.yellowchange.setActionCommand(EPersonalInfoPanel.yellowchangesetActionCommand.getString());
		this.yellowchange.addActionListener(actionHandler);

		this.redchange = new JButton();
		redchange.setBackground(Color.red);
		this.redchange.setActionCommand(EPersonalInfoPanel.redchangesetActionCommand.getString());
		this.redchange.addActionListener(actionHandler);

		this.add(total);
		date();
		clock();
		JLabel theme = new JLabel(EPersonalInfoPanel.themechange.getString());
		this.add(theme);
		this.add(this.whitechange);
		this.add(this.yellowchange);
		this.add(this.redchange);
	}

	public void date() {

		Date objDate = new Date();
		String strDateFormat = EPersonalInfoPanel.strDateFormat.getString();
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		JLabel timeLabel = new JLabel(objSDF.format(objDate));
		total.add(timeLabel);
	}

	public void whitechange() {
		// PersonalInfoPanel
		this.setBackground(Color.white);
		total.setBackground(Color.white);

	}

	public void yellowchange() {
		// PersonalInfoPanel
		this.setBackground(Color.yellow);
		total.setBackground(Color.yellow);
	}

	public void redchange() {
		// PersonalInfoPanel
		this.setBackground(Color.red);
		total.setBackground(Color.red);
	}

	public void clock() {
		JLabel timeLabel = new JLabel();
		total.add(timeLabel);

		final DateFormat timeFormat = new SimpleDateFormat(EPersonalInfoPanel.SimpleDateFormat.getString());
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String time = timeFormat.format(date);
				timeLabel.setText(time);
			}
		};
		Timer timer = new Timer(1000, timerListener);

		timer.setInitialDelay(0);
		timer.start();
	}

	public void initialize(String id) {
		this.showPersonalInfo(id);
	}

	private void showPersonalInfo(String id) {
		CPersonalInfo cPersonalInfo = new CPersonalInfo();
		VCPersonalInfo vCPersonalInfo = cPersonalInfo.getPersonalInfo(id);
		this.lbInsa.setText(vCPersonalInfo.getName());
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals(EPersonalInfoPanel.btnInfosetActionCommand.getString())) { // 걍 내역 없애면 되니까
																										// 나중에

				info();
			} else if (e.getActionCommand().equals(EPersonalInfoPanel.btnLogoutsetActionCommand.getString())) {
				logout();
			} else if (e.getActionCommand().equals(EPersonalInfoPanel.whitechangesetActionCommand.getString())) {
				whitechange();
			} else if (e.getActionCommand().equals(EPersonalInfoPanel.yellowchangesetActionCommand.getString())) {
				yellowchange();
			} else if (e.getActionCommand().equals(EPersonalInfoPanel.redchangesetActionCommand.getString())) {
				redchange();
			}
		}

		private void logout() {
			JDialog logout = new JDialog();
			JOptionPane.showMessageDialog(logout, EPersonalInfoPanel.blogout.getString());
			System.exit(0);

		}

		void info() {
			JFrame info = new JFrame(EPersonalInfoPanel.btnInfo.getString());
			info.setSize(EPersonalInfoPanel.width.getInt(), EPersonalInfoPanel.height.getInt());
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			info.setLocation(dim.width / 2 - info.getSize().width / 2, dim.height / 2 - info.getSize().height / 2);
			info.setLayout(new FlowLayout());
			info.setUndecorated(true);
			info.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
			
			JPanel infopanel = new JPanel();
			
			ImageIcon icon = new ImageIcon(EDataFileName.path.getString() + EDataFileName.mjlogo.getString());
			JLabel label = new JLabel(icon);
			infopanel.add(label);
			infopanel.setLayout(new BoxLayout(infopanel, BoxLayout.Y_AXIS));
			String id = LoginDialog.nameText.getText();
			@SuppressWarnings("deprecation")
			String pw = LoginDialog.passwordText.getText();

			File loginfile = new File(EDataFileName.path.getString() + EDataFileName.login.getString());
			File studentfile = new File(EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
			Scanner scanner;
			Scanner scanner2;

			try {
				scanner = new Scanner(loginfile);
				scanner2 = new Scanner(studentfile);

				while (scanner.hasNext()) {

					String sID = scanner.next();
					String sPassword = scanner.next();

					if (id.equals(sID) && pw.equals(sPassword)) {
						while (scanner2.hasNext()) {
							String cID = scanner2.next();
							if (sID.equals(cID)) {
								File studentinfofile = new File(
										EDataFileName.path.getString() + cID + EDataFileName.txt.getString());
								@SuppressWarnings("resource")
								Scanner scanner3 = new Scanner(studentinfofile);

								while (scanner3.hasNext()) {
									String Name = scanner3.next();
									String major = scanner3.next();
									String snumber = scanner3.next();
									String pnumber = scanner3.next();

									infopanel.add(new JLabel(EPersonalInfoPanel.infonameLabel.getString() + Name));
									infopanel.add(new JLabel(EPersonalInfoPanel.infomajorLabel.getString() + major));
									infopanel.add(new JLabel(EPersonalInfoPanel.infostunumLabel.getString() + snumber));
									infopanel.add(new JLabel(EPersonalInfoPanel.infonumLabel.getString() + pnumber));
								}

							}
						}

					}
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			info.add(infopanel);
			info.setVisible(true);
		}
	}

	public void info() {
		// TODO Auto-generated method stub

	}

}