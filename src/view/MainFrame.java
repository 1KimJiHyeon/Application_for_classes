package view;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import control.CLecture;
import global.Constants.EMainFrame;
import valueObject.VCLecture;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = EMainFrame.serialVersionUID.getInt();

	private PersonalInfoPanel personalInfo;
	private RegistrationPanel registration;
	private String id;

	private CLecture cLecture;

	private Vector<VCLecture> VCLectures2;

	public MainFrame() {

		this.setTitle(EMainFrame.title.getString());
		this.setSize(EMainFrame.width.getInt(), EMainFrame.height.getInt());
		this.setUndecorated( true );
		this.getRootPane().setWindowDecorationStyle( JRootPane. INFORMATION_DIALOG);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		WindowListener windowListener = new WindowHandler();
		this.addWindowListener(windowListener);
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		this.personalInfo = new PersonalInfoPanel();
		this.add(this.personalInfo, BorderLayout.NORTH);

		this.registration = new RegistrationPanel();
		this.add(this.registration, BorderLayout.CENTER);

		this.setVisible(true);
	}

	public void initialize(String id) {
		this.id = id;
		this.personalInfo.initialize(id);
		this.registration.initialize(id);

	}

	public void finish(String fileName) throws IOException {
		this.cLecture = new CLecture();
		this.VCLectures2 = new Vector<VCLecture>();
		this.cLecture.setData(fileName, this.VCLectures2);
	}

	private class WindowHandler implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			
			try {
				finish(id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
