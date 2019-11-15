package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import global.Constants.ERegistrationPanel;
import valueObject.VCLecture;

public class RegistrationPanel extends JPanel {
	private static final long serialVersionUID = ERegistrationPanel.serialVersionUID.getInt();
	private ActionListener actionHandler;

	private SelectionPanel selectionPanel;
	private MovePanel movePanel1;
	private BasketPanel basketPanel;
	private MovePanel movePanel2;
	private BasketPanel resultPanel;

	public RegistrationPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.actionHandler = new ActionHandler();

		this.selectionPanel = new SelectionPanel();
		this.add(this.selectionPanel);

		this.movePanel1 = new MovePanel(this.actionHandler);
		this.add(this.movePanel1);

		this.basketPanel = new BasketPanel();
		this.add(this.basketPanel);

		this.movePanel2 = new MovePanel(this.actionHandler);
		this.add(this.movePanel2);

		this.resultPanel = new BasketPanel();
		this.add(this.resultPanel);
	}

	public void initialize(String id) {
		this.selectionPanel.initialize(id);
		this.basketPanel.initialize(id);
		this.resultPanel.initialize(id);
	}

	public void finish(String id) throws IOException {
		this.selectionPanel.finish(id);
		this.basketPanel.finish(id + ERegistrationPanel.Basket.getString());
		this.resultPanel.finish(id + ERegistrationPanel.Result.getString());

	}

	private void moveLecturesToBasket() {
		Vector<VCLecture> selectedLectures = this.selectionPanel.getSelectedLectures();// °á°ú¸¦
		this.basketPanel.addRows(selectedLectures);// basket¿¡ ÁÜ
	}

	private void removeSelectedLectures() {
		this.basketPanel.removeSelectedLectures();
	}

	private void moveResultToBasket() {
		Vector<VCLecture> selectedLectures = this.resultPanel.getSelectedLectures();
		this.basketPanel.addRows(selectedLectures);
	}

	private void moveBasketToResult() {
		Vector<VCLecture> selectedLectures = this.basketPanel.getSelectedLectures();
		this.resultPanel.addRows(selectedLectures);
	}

	private class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource().equals(movePanel1.getLeftButton())) {
				removeSelectedLectures();
			}

			else if (event.getSource().equals(movePanel1.getRightButton())) {
				moveLecturesToBasket();
			} else if (event.getSource().equals(movePanel2.getLeftButton())) {
				moveResultToBasket();
			} else if (event.getSource().equals(movePanel2.getRightButton())) {
				moveBasketToResult();
			}

		}
	}

}
