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
		title("수강신청"),
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
		nameLabel(" 아이디   "),
		nameTextSize("15"),
		passwordLabel("비밀번호"),
		passwordTextSize("15"),
		okButton("확인"),
		cancelButton("취소"),
		findidpw("아이디/비밀번호 찾기"),
		findactioncommand("find"),
		SuppressWarnings("deprecation"),
		login("로그인창");
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel {
		serialVersionUID("1"),
		width("300"),
		height("380"),
		lbInsaPostfix("님 안녕하세요"),
		btnInfo("개인정보"),
		btnLogout("로그아웃"),
		blogout("로그아웃 되셨습니다."),
		btnInfosetActionCommand("btninfo"),
		btnLogoutsetActionCommand("btnlogout"),
		whitechangesetActionCommand("whitechange"),
		yellowchangesetActionCommand("yellowchange"),
		redchangesetActionCommand("redchange"),
		themechange("        테마변경:  "),
		strDateFormat("yyyy년 MM월 dd일"),
		SimpleDateFormat("HH:mm:ss"),
		infoLabel("개인 정보"),
		infonameLabel("이름: "),
		infomajorLabel("학과: "),
		infostunumLabel("학번: "),
		infonumLabel("전화번호: "),
		;
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum ELecturePanel{
		serialVersionUID("1"),
		id("강좌번호"),
		name("강좌명"),
		professor("교수명"),
		credit("학점"),
		time("시간")	;
		
		private String value; //하나에 해당하는 클래스를 만들어야하는데 지금은 하나에다가 씀
		
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
		title("오류"),
		message("잘못 입력했음");
		
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
		nameLabel(" 이름   "),
		nameTextSize("15"),
		numLabel("학번"),
		numTextSize("15"),
		idcheck("아이디 확인"),
		VerticalStrut("30"),
		idLabel("아이디"),
		idTextSize("15"),
		pwcheck("비밀번호 확인"),
		pwis("님의 비밀번호는 "),
		is("입니다."),
		idis("님의 아이디는 "),
		caution("※ 버튼의 반응이 없으면 잘못 입력 한것입니다. ※"), 
		idpwfind("아이디/비밀번호 찾기");
		
		private String value;
		private EIdpwfind(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}
