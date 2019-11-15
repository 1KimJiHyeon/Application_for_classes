package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import global.Constants.EDataFileName;
import global.Constants.EIdpwfind;
import global.Constants.ELoginDialog;

public class Idpwfind extends JFrame {

	private static final long serialVersionUID = EIdpwfind.serialVersionUID.getInt();

	private JTextField idnameText;
	private JTextField idnumText;
	private JTextField pwnameText;
	private JTextField pwnumText;
	private JTextField pwidText;

	Idpwfind() {
		this.setTitle(EIdpwfind.idpwfind.getString());
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);

		ActionHandler actionHandler = new ActionHandler();

		this.setSize(EIdpwfind.width.getInt(), EIdpwfind.height.getInt());
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

		JPanel totalpanel = new JPanel();
		totalpanel.setLayout(new BoxLayout(totalpanel, BoxLayout.Y_AXIS));

		JLabel caution = new JLabel(EIdpwfind.caution.getString());

		totalpanel.add(caution);
		JPanel idfindpanel = new JPanel();
		idfindpanel.setLayout(new BoxLayout(idfindpanel, BoxLayout.Y_AXIS));

		JPanel idinputpanel = new JPanel();
		idinputpanel.setLayout(new FlowLayout());

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout());

		JLabel idnameLabel = new JLabel(EIdpwfind.nameLabel.getString());

		this.idnameText = new JTextField(EIdpwfind.nameTextSize.getInt());

		panel1.add(idnameLabel);
		panel1.add(this.idnameText);

		idinputpanel.add(panel1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		JLabel idnumLabel = new JLabel(EIdpwfind.numLabel.getString());

		this.idnumText = new JTextField(EIdpwfind.numTextSize.getInt());

		panel2.add(idnumLabel);
		panel2.add(this.idnumText);

		idinputpanel.add(panel2);

		JButton idcorrect = new JButton(EIdpwfind.idcheck.getString());
		idcorrect.addActionListener(actionHandler);
		idcorrect.setActionCommand(EIdpwfind.idcheck.getString());

		idfindpanel.add(idinputpanel);
		idfindpanel.add(idcorrect);

		totalpanel.add(idfindpanel);
		totalpanel.add(Box.createVerticalStrut(EIdpwfind.VerticalStrut.getInt()));
		// pw

		JPanel pwfindpanel = new JPanel();
		pwfindpanel.setLayout(new BoxLayout(pwfindpanel, BoxLayout.Y_AXIS));

		JPanel pwinputpanel = new JPanel();
		pwinputpanel.setLayout(new FlowLayout());

		JPanel pwpanel1 = new JPanel();
		pwpanel1.setLayout(new FlowLayout());

		JLabel pwnameLabel = new JLabel(EIdpwfind.nameLabel.getString());

		this.pwnameText = new JTextField(EIdpwfind.nameTextSize.getInt());

		pwpanel1.add(pwnameLabel);
		pwpanel1.add(this.pwnameText);

		pwinputpanel.add(pwpanel1);

		JPanel pwpanel2 = new JPanel();
		pwpanel2.setLayout(new FlowLayout());

		JLabel pwnumLabel = new JLabel(EIdpwfind.numLabel.getString());

		this.pwnumText = new JTextField(EIdpwfind.numTextSize.getInt());

		JLabel pwidLabel = new JLabel(EIdpwfind.idLabel.getString());

		this.pwidText = new JTextField(EIdpwfind.idTextSize.getInt());

		pwpanel2.add(pwnumLabel);
		pwpanel2.add(this.pwnumText);

		JPanel pwpanel3 = new JPanel();
		pwpanel3.setLayout(new FlowLayout());
		pwpanel3.add(pwidLabel);
		pwpanel3.add(this.pwidText);

		pwinputpanel.add(pwpanel2);
		pwinputpanel.add(pwpanel3);

		JButton pwcorrect = new JButton(EIdpwfind.pwcheck.getString());
		pwcorrect.addActionListener(actionHandler);
		pwcorrect.setActionCommand(EIdpwfind.pwcheck.getString());

		pwfindpanel.add(pwinputpanel);
		pwfindpanel.add(pwcorrect);

		totalpanel.add(pwfindpanel);

		this.add(totalpanel);
		this.setVisible(true);

	}

	class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getActionCommand().equals(EIdpwfind.idcheck.getString())) {

				findid();
			} else if (actionEvent.getActionCommand().equals(EIdpwfind.pwcheck.getString())) {
				findpw();
			}
		}

		@SuppressWarnings("resource")
		private void findpw() {
			String spname = pwnameText.getText();
			String spnumber = pwnumText.getText();
			String spid = pwidText.getText();

			File studentfile = new File(EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
			Scanner scanner3;
			try {
				scanner3 = new Scanner(studentfile);
				while (scanner3.hasNext()) {
					String Name = scanner3.next();
					if (spname.equals(Name)) {

						File studentfile1 = new File(
								EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
						Scanner scanner31;
						scanner31 = new Scanner(studentfile1);
						while (scanner31.hasNext()) {

							String num = scanner31.next();
							if (spnumber.equals(num)) {

								File idfind = new File(
										EDataFileName.path.getString() + EDataFileName.idfind.getString());
								Scanner idscanner;
								idscanner = new Scanner(idfind);

								while (idscanner.hasNext()) {
									String findnum = idscanner.next();

									if (num.equals(findnum)) {
										String findid = idscanner.next();// 아이디 찾음
										if (spid.equals(findid)) {

											File pwfind = new File(
													EDataFileName.path.getString() + EDataFileName.pwfind.getString());
											Scanner pwscanner;
											pwscanner = new Scanner(pwfind);
											while (pwscanner.hasNext()) {
												String idfindinpw = pwscanner.next();

												if (findid.equals(idfindinpw)) {
													String findinpw = pwscanner.next();
													JFrame pwframe = new JFrame();
													pwframe.add(new JLabel(spname + EIdpwfind.pwis.getString()
															+ findinpw + EIdpwfind.is.getString()));
													pwframe.setSize(ELoginDialog.width.getInt(),
															ELoginDialog.height.getInt());
													Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
													pwframe.setLocation(dim.width / 2 - pwframe.getSize().width / 2,
															dim.height / 2 - pwframe.getSize().height / 2);
													pwframe.setUndecorated(true);
													pwframe.getRootPane()
															.setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
													pwframe.setVisible(true);

												}

											}

										}
									}

								}
							}

						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@SuppressWarnings("resource")
		private void findid() {

			String siname = idnameText.getText();
			String sinumber = idnumText.getText();

			File studentfile = new File(EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
			Scanner scanner3;
			try {
				scanner3 = new Scanner(studentfile);
				while (scanner3.hasNext()) {
					String Name = scanner3.next();
					if (siname.equals(Name)) {

						File studentfile1 = new File(
								EDataFileName.path.getString() + EDataFileName.personalInfo.getString());
						Scanner scanner31;
						scanner31 = new Scanner(studentfile1);
						while (scanner31.hasNext()) {
							String num = scanner31.next();
							if (sinumber.equals(num)) {

								File idfind = new File(
										EDataFileName.path.getString() + EDataFileName.idfind.getString());
								Scanner idscanner;
								idscanner = new Scanner(idfind);

								while (idscanner.hasNext()) {
									String findnum = idscanner.next();

									if (num.equals(findnum)) {
										String findid = idscanner.next();
										JFrame idframe = new JFrame();
										idframe.add(new JLabel(siname + EIdpwfind.idis.getString() + findid
												+ EIdpwfind.is.getString()));
										idframe.setSize(ELoginDialog.width.getInt(), ELoginDialog.height.getInt());
										Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
										idframe.setLocation(dim.width / 2 - idframe.getSize().width / 2,
												dim.height / 2 - idframe.getSize().height / 2);
										idframe.setUndecorated(true);
										idframe.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
										idframe.setVisible(true);
									}

								}
							}
						}
					}
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
