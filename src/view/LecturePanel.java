package view;

import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.CLecture;
import global.Constants.ELecturePanel;
import valueObject.VCLecture;
import valueObject.VMLecture;

public class LecturePanel extends JPanel {
	private static final long serialVersionUID = ELecturePanel.serialVersionUID.getInt();
	private LectureList lectureList;
	private CLecture cLecture;
	private Vector<VCLecture> vcLectures;

	public LecturePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.lectureList = new LectureList();
		new Vector<VMLecture>();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(this.lectureList);
		this.add(scrollPane);

	}

	public void refresh(String fileName) throws FileNotFoundException {

		this.cLecture = new CLecture();
		this.vcLectures = cLecture.getData(fileName);

		this.lectureList.addRows(this.vcLectures);
	}

	public void initialize(String id) {
	}

	public Vector<VCLecture> getSelectedLectures() {

		return this.lectureList.getSelectedLectures(this.vcLectures);
	}

	class LectureList extends JTable {

		private static final long serialVersionUID = 1L;
		private DefaultTableModel tableModel;
		private Vector<VCLecture> selectedLectures;

		public LectureList() {
			new Vector<VMLecture>();
			this.selectedLectures = new Vector<VCLecture>();
			Vector<String> header = new Vector<String>();
			for (int i = 1; i < ELecturePanel.values().length; i++)
				header.add(ELecturePanel.values()[i].getString());

			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);

		}

		public void addRows(Vector<VCLecture> vcLectures) {

			this.tableModel.setRowCount(0);
			Vector<String> rowData;
			for (VCLecture vcLecture : vcLectures) {
				rowData = new Vector<String>();
				rowData.add(vcLecture.getId());
				rowData.add(vcLecture.getName());
				rowData.add(vcLecture.getProfessorName());
				rowData.add(vcLecture.getCredit());
				rowData.add(vcLecture.getTime());
				this.tableModel.addRow(rowData);
			}
			this.getSelectionModel().addSelectionInterval(0, 0);
		}

		public Vector<VCLecture> getSelectedLectures(Vector<VCLecture> vcLectures) {

			this.selectedLectures = new Vector<VCLecture>();

			for (int i = 0; i < this.getRowCount(); i++) {
				if (this.isRowSelected(i)) {
					this.selectedLectures.add(vcLectures.elementAt(i));
				}

			}

			return this.selectedLectures;
		}

	}

}
