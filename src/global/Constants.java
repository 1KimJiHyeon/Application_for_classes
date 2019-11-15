package global;



public class Constants {
	//enumeration
	public static enum EDataFileName {
		path("data/"),
		root("root"),
		login("login"),
		personalInfo("student"),
		idfind("idfind.txt"),
		pwfind("pwfind.txt"),
		mjicon("top_img.png"),oicon("if_letter_O_blue_1553085.png"),
		xicon("if_letter_X_blue_1553039.png"),
		mjlogo("logo_mju_wide_trans.png"),
		txt(".txt");
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	
	public static enum EMainFrame {
		serialVersionUID("1"),
		title("������û"),
		width("1400"),
		height("600");
		
		private String value;
		private EMainFrame(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELoginDialog {
		serialVersionUID("1"),
		width("300"),
		height("380"),
		nameLabel(" ���̵�   "),
		nameTextSize("15"),
		passwordLabel("��й�ȣ"),
		passwordTextSize("15"),
		okButton("Ȯ��"),
		cancelButton("���"),
		findidpw("���̵�/��й�ȣ ã��"),
		findactioncommand("find"),
		SuppressWarnings("deprecation"),
		login("�α���â");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {
		serialVersionUID("1"),
		width("300"),
		height("380"),
		lbInsaPostfix("�� �ȳ��ϼ���"),
		btnInfo("��������"),
		btnLogout("�α׾ƿ�"),
		blogout("�α׾ƿ� �Ǽ̽��ϴ�."),
		btnInfosetActionCommand("btninfo"),
		btnLogoutsetActionCommand("btnlogout"),
		whitechangesetActionCommand("whitechange"),
		yellowchangesetActionCommand("yellowchange"),
		redchangesetActionCommand("redchange"),
		themechange("        �׸�����:  "),
		strDateFormat("yyyy�� MM�� dd��"),
		SimpleDateFormat("HH:mm:ss"),
		infoLabel("���� ����"),
		infonameLabel("�̸�: "),
		infomajorLabel("�а�: "),
		infostunumLabel("�й�: "),
		infonumLabel("��ȭ��ȣ: "),
		;
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum ELecturePanel{
		serialVersionUID("1"),
		id("���¹�ȣ"),
		name("���¸�"),
		professor("������"),
		credit("����"),
		time("�ð�")	;
		
		private String value; //�ϳ��� �ش��ϴ� Ŭ������ �������ϴµ� ������ �ϳ����ٰ� ��
		
		private ELecturePanel(String value) {
			this.value = value;
			
		}
		
		public String getString() {
			return this.value;
		}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	
	public static enum EErrorDialog {
		serialVersionUID("1"),
		title("����"),
		message("�߸� �Է�����");
		
		private String value;
		private EErrorDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EDirectoryPanel {
		serialVersionUID("1");
		
		private String value;
		private EDirectoryPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EBasketPanelPanel {
		serialVersionUID("1");
		
		private String value;
		private EBasketPanelPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EMovePanel {
		serialVersionUID("1"),
		rightButton(">"),
		rightButtonsetActionCommand("rightButton"),
		leftButton("<"),
		leftButtonsetActionCommand("leftButton");
		
		private String value;
		private EMovePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}public static enum ERegistrationPanel {
		serialVersionUID("1"),
		Basket("Basket"),
		Result("Result");
		
		private String value;
		private ERegistrationPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}public static enum ESelectionPanel {
		serialVersionUID("1");
		
		private String value;
		private ESelectionPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EIdpwfind {
		serialVersionUID("1"),
		width("370"),
		height("380"),
		nameLabel(" �̸�   "),
		nameTextSize("15"),
		numLabel("�й�"),
		numTextSize("15"),
		idcheck("���̵� Ȯ��"),
		VerticalStrut("30"),
		idLabel("���̵�"),
		idTextSize("15"),
		pwcheck("��й�ȣ Ȯ��"),
		pwis("���� ��й�ȣ�� "),
		is("�Դϴ�."),
		idis("���� ���̵�� "),
		caution("�� ��ư�� ������ ������ �߸� �Է� �Ѱ��Դϴ�. ��"), 
		idpwfind("���̵�/��й�ȣ ã��");
		
		private String value;
		private EIdpwfind(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
