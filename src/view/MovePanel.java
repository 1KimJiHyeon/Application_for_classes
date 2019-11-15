package view;

import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import global.Constants.EMovePanel;

public class MovePanel extends JPanel {
	private static final long serialVersionUID = EMovePanel.serialVersionUID.getInt();
	private JButton leftButton;
	private JButton rightButton;

	public JButton getLeftButton() {
		return leftButton;
	}

	public void setLeftButton(JButton leftButton) {
		this.leftButton = leftButton;
	}

	public JButton getRightButton() {
		return rightButton;
	}

	public void setRightButton(JButton rightButton) {
		this.rightButton = rightButton;
	}

	public MovePanel(ActionListener actionHandler) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.rightButton = new JButton(EMovePanel.rightButton.getString());
		this.rightButton.setActionCommand(EMovePanel.rightButtonsetActionCommand.getString());
		this.rightButton.addActionListener(actionHandler);
		this.add(this.rightButton);

		this.add(Box.createVerticalStrut(30));

		this.leftButton = new JButton(EMovePanel.leftButton.getString());
		this.leftButton.setActionCommand(EMovePanel.leftButtonsetActionCommand.getString());
		this.leftButton.addActionListener(actionHandler);
		this.add(this.leftButton);

	}

	public void initialize() {

	}

}
