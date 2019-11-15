package view;

import java.io.IOException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import control.CLecture;
import global.Constants.EBasketPanelPanel;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;

public class BasketPanel extends JPanel {
	private static final long serialVersionUID = EBasketPanelPanel.serialVersionUID.getInt();

	private Vector<VCLecture> vCLectures;
	private BasketList basketList;
	private CLecture cLecture;
	private Vector<VCLecture> VCLectures2;

	public BasketPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.vCLectures = new Vector<VCLecture>();

		this.basketList = new BasketList();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.basketList);
		this.add(scrollPane);
	}

	public void initialize(String id) {

	}

	public void finish(String fileName) throws IOException {

		this.cLecture = new CLecture();
		this.VCLectures2 = new Vector<VCLecture>();
		this.cLecture.setData(fileName, this.VCLectures2);

	}

	public void addRows(Vector<VCLecture> vCRemovedLectures) {
		this.basketList.addRows(vCRemovedLectures);
	}

	public void removeSelectedLectures() {
		this.basketList.removeSelectedLectures();
	}

	public Vector<VCLecture> getSelectedLectures() {
		return this.basketList.getSelectedLectures();

	}

	private class BasketList extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;

		public BasketList() {
			Vector<String> header = new Vector<String>();
			header.addElement(ELecturePanel.name.getString());
			header.addElement(ELecturePanel.professor.getString());

			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);

		}

		public void addRows(Vector<VCLecture> vCRemovedLectures) {
			Vector<String> rowData;
			for (VCLecture vCLecture : vCRemovedLectures) {
				rowData = new Vector<String>();

				rowData.addElement(vCLecture.getName());
				rowData.addElement(vCLecture.getProfessorName());
				this.tableModel.addRow(rowData);
				vCLectures.add(vCLecture);

			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

		public void removeSelectedLectures() {

			for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {// 0에서부터 시작
				if (this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCLectures.remove(i);
				}
				this.getSelectionModel().addSelectionInterval(0, 0);
			}
		}

		public Vector<VCLecture> getSelectedLectures() {
			Vector<VCLecture> vCRemovedLectures = new Vector<VCLecture>();
			for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {// 0에서부터 시작
				if (this.isRowSelected(i)) {
					this.tableModel.removeRow(i);
					vCRemovedLectures.add(vCLectures.get(i));
					vCLectures.remove(i);
				}
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
			return vCRemovedLectures;
		}
	}

}
