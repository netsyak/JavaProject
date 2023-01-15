package javapro;

import java.awt.Color;
import java.awt.FlowLayout;
//import java.awt.Panel;
//import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.DentalMemberDAO;
import dao.MemberDAO;
import dao.MemberVo;

public class LoginFrame extends WindowAdapter implements ActionListener {
//	private static final Container contentPane = null;
	private JFrame f1, f2, f3, f4, f5, f6, f7, info, update;
	private JTextField tfId, tfPwd, mbId, mbPwd, tfName, tfTel, tfBirth, tfinfo, umbId, umbPwd, utfName, utfTel,
			utfBirth, tfAddr, utfAddr;
	private JTextArea p1;
	private JButton btnLogin, btnSignup, b1, b2, b3, b4, ub4, b5, b6, b7, binfo, binfo1, binfo2, binfo3, binfo4, binfo5,
			binfo6, binfo7, bupdate, ocb, logout;
	private MemberDAO dao;
	private String AllId = "";
	private JLabel la1, la2;

	private JRootPane rootPane; //엔터로 버튼 신행
	
//	private Image background = new ImageIcon(
//			LoginFrame.class.getResource("C:/BackUp/KKY/Javafiles/First_Project/img/dentalimg-001.png")).getImage();// 배경이미지

	LoginFrame() {
		dao = new MemberDAO();

		f1 = new JFrame("로그인");
		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.orange);
		f1.setSize(350, 500);
		f1.setLocationRelativeTo(null);// 프레임 화면 가운데 배치
		f1.addWindowListener(this);
		f1.setResizable(false); // 플레임 크기 고정
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫았을 때 메모리 되돌려받기

		f2 = new JFrame("로그인 성공");
		f2.setLayout(null);
		f2.getContentPane().setBackground(Color.orange);
		f2.setSize(280, 180);
		f2.setLocationRelativeTo(null);
		f2.setResizable(false);
		f2.addWindowListener(this);

		f3 = new JFrame("로그인 실패");
		f3.setLayout(null);
		f3.getContentPane().setBackground(Color.orange);
		f3.setSize(280, 180);
		f3.setLocationRelativeTo(null);
		f3.setResizable(false);
		f3.addWindowListener(this);

		// 회권 가입
		f4 = new JFrame("회원 가입");
		f4.setLayout(null);
		f4.getContentPane().setBackground(Color.orange);
		f4.setSize(350, 500);
		f4.setLocationRelativeTo(null);
		f4.setResizable(false);
		f4.addWindowListener(this);

		f5 = new JFrame("회원 가입 성공");
		f5.setLayout(null);
		f5.getContentPane().setBackground(Color.orange);
		f5.setSize(280, 180);
		f5.setLocationRelativeTo(null);
		f5.setResizable(false);
		f5.addWindowListener(this);

		f6 = new JFrame("재확인 요청");
		f6.setLayout(null);
		f6.getContentPane().setBackground(Color.orange);
		f6.setSize(280, 150);
		f6.setLocationRelativeTo(null);
		f6.setResizable(false);
		f6.addWindowListener(this);

		f7 = new JFrame("재등록 완료");
		f7.setLayout(null);
		f7.getContentPane().setBackground(Color.orange);
		f7.setSize(280, 180);
		f7.setLocationRelativeTo(null);
		f7.addWindowListener(this);

		update = new JFrame("회원 정보 수정");
		update.setLayout(null);
		update.getContentPane().setBackground(Color.orange);
		update.setSize(350, 500);
		update.setLocationRelativeTo(null);
		update.setResizable(false);
		update.addWindowListener(this);

		// 치과 진료 안내 창
		info = new JFrame("치과 진료 안내");
		info.setLayout(null);
		info.setSize(650, 550);
		info.getContentPane().setBackground(Color.orange);
		info.setLocationRelativeTo(null);
		info.addWindowListener(this);
		info.setResizable(false);

		// 치과 진료 안내 칸
		p1 = new JTextArea(40, 40); // info 내용 노출 창
//		JScrollPane scrollPane = new JScrollPane(p1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		ScrollPane sp = new ScrollPane();
//	s
		p1.setLayout(new FlowLayout());
		p1.setBounds(110, 95, 510, 385);
//		p1.add(scrollPane);
		p1.setBackground(Color.yellow);
		p1.setLineWrap(true);
		p1.setEditable(false);
		p1.setText("  \r\n" + "    안녕하세요. 반갑습니다.\r\n" + "\r\n" + "    오늘도 좋은 하루 되세요 !!!");

		// 로그인 화면 창 라벨
//		JLabel txt = new JLabel();
//		txt.setBounds(97, 15, 200, 50);
//		txt.setText("어서오세요. 반갑습니다.");
//		txt.setFont(txt.getFont().deriveFont(13.f));
		JLabel txt = new JLabel();
		txt.setBounds(31, 115, 300, 30);
		txt.setText("치과진료 & 비용 안내\r\n");
		txt.setFont(txt.getFont().deriveFont(29.f));
		txt.setForeground(Color.BLUE);

		JLabel lid = new JLabel("아이디 :", JLabel.RIGHT);
		lid.setBounds(40, 300, 60, 30);
		JLabel lpwd = new JLabel("비밀번호 :", JLabel.RIGHT);
		lpwd.setBounds(40, 335, 60, 20);
		JLabel msg = new JLabel("로그인 성공!!!", JLabel.CENTER);
		msg.setBounds(95, 0, 75, 90);
		JLabel msg1 = new JLabel("로그인 실패!!!", JLabel.CENTER);
		msg1.setBounds(95, 0, 75, 90);
		JLabel msg2 = new JLabel("가입 성공!!!", JLabel.CENTER);
		msg2.setBounds(95, 0, 80, 90);

		// 회원 가입 창 메뉴별 라벨
		JLabel mId = new JLabel("아이디 :", JLabel.RIGHT);
		mId.setBounds(15, 50, 60, 30);
		JLabel mPwd = new JLabel("비밀번호 :", JLabel.RIGHT);
		mPwd.setBounds(15, 90, 60, 30);
		JLabel name = new JLabel("이름 :", JLabel.RIGHT);
		name.setBounds(15, 130, 60, 30);
		JLabel birth = new JLabel("생년월일 :", JLabel.RIGHT);
		birth.setBounds(15, 170, 60, 30);
		JLabel birth1 = new JLabel("예시) 20220102", JLabel.RIGHT);
		birth1.setBounds(70, 190, 100, 30);
		birth1.setForeground(Color.red);
		JLabel tel = new JLabel("전화번호 :", JLabel.RIGHT);
		tel.setBounds(15, 222, 60, 30);
		JLabel tel1 = new JLabel("예시) 01098761234, '-' 없이 작성하세요.", JLabel.RIGHT);
		tel1.setBounds(60, 246, 240, 30);
		tel1.setForeground(Color.red);
		JLabel addr = new JLabel("주소 :", JLabel.RIGHT);
		addr.setBounds(15, 280, 60, 30);
		JLabel addr1 = new JLabel("광역시/도, 구/시, 동/마을 까지 작성하세요.", JLabel.RIGHT);
		addr1.setBounds(70, 300, 240, 30);
		addr1.setForeground(Color.red);

		// 회원 정보 수정 창
		JLabel umId = new JLabel("아이디 :", JLabel.RIGHT);
		umId.setBounds(15, 50, 60, 30);
		JLabel umPwd = new JLabel("비밀번호 :", JLabel.RIGHT);
		umPwd.setBounds(15, 90, 60, 30);
		JLabel uname = new JLabel("이름 :", JLabel.RIGHT);
		uname.setBounds(15, 130, 60, 30);
		JLabel ubirth = new JLabel("생년월일 :", JLabel.RIGHT);
		ubirth.setBounds(15, 170, 60, 30);
		JLabel ubirth1 = new JLabel("예시) 20220102", JLabel.RIGHT);
		ubirth1.setBounds(70, 190, 100, 30);
		ubirth1.setForeground(Color.red);
		JLabel utel = new JLabel("전화번호 :", JLabel.RIGHT);
		utel.setBounds(15, 222, 60, 30);
		JLabel utel1 = new JLabel("예시) 01098761234, '-' 없이 작성하세요.", JLabel.RIGHT);
		utel1.setBounds(60, 246, 240, 30);
		utel1.setForeground(Color.red);
		JLabel uaddr = new JLabel("주소 :", JLabel.RIGHT);
		uaddr.setBounds(15, 280, 60, 30);
		JLabel uaddr1 = new JLabel("광역시/도, 구/시, 동/마을 까지 작성하세요.", JLabel.RIGHT);
		uaddr1.setBounds(70, 300, 240, 30);
		uaddr1.setForeground(Color.red);

		// 로그인 화면 텍스트 칸
		tfId = new JTextField(20);
		tfId.setBounds(120, 300, 150, 27); // 텍스트 칸
		tfId.setBackground(Color.white);

		tfPwd = new JPasswordField(20); // " * " 비번 표시 칸
		tfPwd.setBounds(120, 330, 150, 27);
		tfPwd.setBackground(Color.white);
//		tfPwd.setEchoChar('*');// AWT 식 password * 표시 하는 방법

		// 치과 정보 검색창 맨트
		la2 = new JLabel("치과비용은?", JLabel.RIGHT);
		la2.setBounds(15, 41, 70, 30);
		la2.setBackground(Color.white);
//		la2.setFont(la2.getFont().deriveFont(13.f));

		// 회원 정보 창
		mbId = new JTextField(20);
		mbId.setBounds(85, 50, 150, 27);
		mbId.setBackground(Color.white);
		mbId.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 16)
					ke.consume();
			}
		});

		mbPwd = new JPasswordField(20);
		mbPwd.setBounds(85, 90, 150, 27);
		mbPwd.setBackground(Color.white);
		mbPwd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 16)
					ke.consume();
			}
		});
		

		tfName = new JTextField(20);
		tfName.setBounds(85, 130, 150, 27);
		tfName.setBackground(Color.white);
		tfName.addKeyListener(new KeyAdapter() {

	public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 8)
					ke.consume();
			}
		});

		tfBirth = new JTextField(20);
		tfBirth.setBounds(85, 170, 150, 27);
		tfBirth.setBackground(Color.white);
		tfBirth.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 8)
					ke.consume();
			}
		});

		tfTel = new JTextField(20);
		tfTel.setBounds(85, 225, 150, 27);
		tfTel.setBackground(Color.white);
		tfTel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 11)
					ke.consume();
			}
		});

		tfAddr = new JTextField(80);
		tfAddr.setBounds(85, 280, 200, 27);
		tfAddr.setBackground(Color.white);
//		tfAddr.setLineWrap(true); // TextArea 메서드 자동 줄 바꾸기

		// 회원 정보 수정 창의 Field
		umbId = new JTextField(20);
		umbId.setBounds(85, 50, 150, 27);
		umbId.setBackground(Color.lightGray);
		umbId.setEditable(false); // 회원 수정시 아이디 수정 불가능

		umbPwd = new JPasswordField(20);
		umbPwd.setBounds(85, 90, 150, 27);
		umbPwd.setBackground(Color.white);
		umbPwd.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 16)
					ke.consume();
			}
		});

		utfName = new JTextField(20);
		utfName.setBounds(85, 130, 150, 27);
		utfName.setBackground(Color.lightGray);
		utfName.setEditable(false); // 회원 수정시 수정 불가능

		utfBirth = new JTextField(20);
		utfBirth.setBounds(85, 170, 150, 27);
		utfBirth.setBackground(Color.lightGray);
		utfBirth.setEditable(false); // 회원 수정시 수정 불가능
		utfBirth.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 8)
					ke.consume();
			}
		});

		utfTel = new JTextField(20);
		utfTel.setBounds(85, 225, 150, 27);
		utfTel.setBackground(Color.white);
		utfTel.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 11)
					ke.consume();
			}
		});

		utfAddr = new JTextField(80);
		utfAddr.setBounds(85, 280, 200, 27);
		utfAddr.setBackground(Color.white);
//		utfAddr.setLineWrap(true); // 자동 줄 바꾸기

		// 치과치료 안내창의 버튼들
		tfinfo = new JTextField(50);
		tfinfo.setBounds(110, 40, 185, 30); // 텍스트 칸
		tfinfo.setBackground(Color.white);

//		la1 = new JLabel("치과 비용은... ?", JLabel.RIGHT);
//		la1.setBounds(45, 10, 150, 30);
//		la1.setBackground(Color.white);
		la1 = new JLabel();
		la1.setBounds(135, 10, 150, 30);
		la1.setBackground(Color.white);

		binfo = new JButton("검색");
		binfo.setBounds(300, 40, 60, 30);
		rootPane = info.getRootPane();
		rootPane.setDefaultButton(binfo);

		binfo1 = new JButton("예방치료");
		binfo1.setBackground(Color.CYAN);
		binfo1.setBounds(12, 100, 85, 30);
		binfo1.addActionListener(this);

		binfo2 = new JButton("보존치료");
		binfo2.setBackground(Color.CYAN);
		binfo2.setBounds(12, 140, 85, 30);
		binfo2.addActionListener(this);

		binfo3 = new JButton("보철치료");
		binfo3.setBackground(Color.CYAN);
		binfo3.setBounds(12, 180, 85, 30);
		binfo3.addActionListener(this);

		binfo4 = new JButton("교정치료");
		binfo4.setBackground(Color.CYAN);
		binfo4.setBounds(12, 220, 85, 30);
		binfo4.addActionListener(this);

		binfo5 = new JButton("심미치료");
		binfo5.setBackground(Color.CYAN);
		binfo5.setBounds(12, 260, 85, 30);
		binfo5.addActionListener(this);

		binfo6 = new JButton("신경치료");
		binfo6.setBackground(Color.CYAN);
		binfo6.setBounds(12, 300, 85, 30);
		binfo6.addActionListener(this);

		binfo7 = new JButton("정보수정");
		binfo7.setBackground(Color.green);
		binfo7.setBounds(440, 40, 85, 30);
		binfo7.addActionListener(this);

		logout = new JButton("로그아웃");
		logout.setBackground(Color.pink);
		logout.setBounds(530, 40, 85, 30);
		logout.addActionListener(this);

		info.add(tfinfo);
		info.add(la1);
		info.add(la2);
		info.add(binfo);// 버튼
		info.add(p1);// 판넬
		info.add(binfo1);
		info.add(binfo2);
		info.add(binfo3);
		info.add(binfo4);
		info.add(binfo5);
		info.add(binfo6);
		info.add(binfo7);
		info.add(logout);

		// 버튼 이름들
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(30, 390, 122, 30);
		rootPane = f1.getRootPane();
		rootPane.setDefaultButton(btnLogin);
		
		btnSignup = new JButton("회원 가입");
		btnSignup.addActionListener(this);
		btnSignup.setBounds(182, 390, 122, 30);
		

		ocb = new JButton("중복확인");
		ocb.addActionListener(this);

		b1 = new JButton("확인");
		b1.setBounds(100, 80, 70, 40);
		b1.addActionListener(this);
		rootPane = f2.getRootPane();
		rootPane.setDefaultButton(b1);
		
		b2 = new JButton("로그인 재시도");
		b2.setBounds(69, 80, 130, 40);
		b2.addActionListener(this);
		rootPane = f3.getRootPane();
		rootPane.setDefaultButton(b2);

		b3 = new JButton("저장하기");
		b3.setBounds(30, 390, 122, 30);
		b3.addActionListener(this);

		b4 = new JButton("뒤로가기");
		b4.setBounds(182, 390, 122, 30);
		b4.addActionListener(this);

		ub4 = new JButton("뒤로가기");
		ub4.setBounds(182, 390, 122, 30);
		ub4.addActionListener(this);

		b5 = new JButton("성공");
		b5.setBounds(100, 80, 70, 40);
		b5.addActionListener(this);

		b6 = new JButton("재확인");
		b6.setBounds(85, 40, 100, 40);
		b6.addActionListener(this);

		b7 = new JButton("등록확인");
		b7.setBounds(85, 80, 100, 40);
		b7.addActionListener(this);

		bupdate = new JButton("수정저장");
		bupdate.setBounds(30, 390, 122, 30);
		bupdate.addActionListener(this);

		f1.add(txt);
//		f1.add(txt1);
		f1.add(lid);
		f1.add(tfId);
		f1.add(lpwd);
		f1.add(tfPwd);
		f1.add(btnLogin);
		f1.add(btnSignup);

		f2.add(msg);
		f2.add(b1);

		f3.add(msg1);
		f3.add(b2);

		// 회원 가입 정보
		f4.add(b3);
		f4.add(b4);
		f4.add(ocb);
		f4.add(mId);
		f4.add(mbId);
		f4.add(mPwd);
		f4.add(mbPwd);
		f4.add(name);
		f4.add(tfName);
		f4.add(tel);
		f4.add(tel1);
		f4.add(tfTel);
		f4.add(addr);
		f4.add(addr1);
		f4.add(tfAddr);
		f4.add(birth);
		f4.add(birth1);
		f4.add(tfBirth);

		// 회원 정보 수정의 자료내용
		update.add(bupdate);
		update.add(ub4);
		update.add(umId);
//		update.add(la2);
		update.add(umbId);
		update.add(umPwd);
		update.add(umbPwd);
		update.add(uname);
		update.add(utfName);
		update.add(utel);
		update.add(utel1);
		update.add(utfTel);
		update.add(ubirth);
		update.add(ubirth1);
		update.add(utfBirth);
		update.add(uaddr);
		update.add(uaddr1);
		update.add(utfAddr);

		f5.add(b5);
		f5.add(msg2);

		f6.add(b6);

		f7.add(b7);

		f1.setVisible(true);
//		f2.setVisible(true); // 창 확인 하기
//		f3.setVisible(true);
//		f4.setVisible(true);
//		info.setVisible(true);
	}


	public void windowClosed(WindowEvent e) {
		System.exit(0);

	}

//	public void paint(Graphics g) {
//		g.drawImage(background,0,0,null);
//	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("로그인")) {
			System.out.println("Click! 로그인 진행");

			if (tfId.getText().equals("") || tfPwd.getText().equals("")) { // 로그인 또는 비번 칸에 필히 작성 요청 메시지
				System.out.println("올바른 Id또는 Password를 입력해주세요.");

				f3.setVisible(true);
				return;
			}
			ArrayList<MemberVo> list = dao.list(tfId.getText());

			String id = "", PWD = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				id = data.getId();
				PWD = data.getPwd();

				System.out.println(id + " : " + PWD);
			}

			if (tfId.getText().equals(id) && tfPwd.getText().equals(PWD)) {
				System.out.println("로그인 성공");
				AllId = tfId.getText();
				System.out.println("AllId=" + AllId);
				f1.setVisible(true);
				f2.setVisible(true);
			} else {
				System.out.println("로그인 실패");
				f1.setVisible(true);
				f3.setVisible(true);
			}

		}
		if (e.getActionCommand().equals("회원 가입")) {
			System.out.println("Click! 회원 가입");
			mbId.setText("");
			mbPwd.setText("");
			tfName.setText("");
			tfBirth.setText("");
			tfTel.setText("");
			tfAddr.setText("");
			tfId.requestFocus();
			f4.setVisible(true);
		}
		if (e.getActionCommand().equals("재확인")) {
			System.out.println("Click! 재확인");
			f6.setVisible(false);
			f4.setVisible(true);

		}
		if (e.getActionCommand().equals("확인")) {
			System.out.println("Click! 확인");
			f1.setVisible(false);
			f2.setVisible(false);
			info.setVisible(true);
			la1.setText(AllId + "님 어서오세요");// 회원 성함 노출

		}
		if (e.getActionCommand().equals("로그아웃")) {
			System.out.println("Click! 로그아웃");
			info.setVisible(false);
			f1.setVisible(true);
			tfId.setText("");
			tfPwd.setText("");
			tfId.requestFocus();

		}
		if (e.getActionCommand().equals("로그인 재시도")) {
			System.out.println("Click! 로그인 재시도");
			f3.setVisible(false);
			f1.setVisible(true);

		}
		if (e.getActionCommand().equals("뒤로가기")) {
			System.out.println("Click! 뒤로가기");
			f4.setVisible(false);
			info.setVisible(false);
			update.setVisible(false);
			f1.setVisible(true);
			tfId.setText("");
			tfPwd.setText("");
			umbId.setText("");
			umbPwd.setText("");
		}
		
		if (e.getActionCommand().equals("등록확인")) {
			System.out.println("Click! 등록확인");
			update.setVisible(false);
			f7.setVisible(false);
			info.setVisible(true);

		}
		// 회원정보 저장하기
		if (e.getActionCommand().equals("저장하기")) {
			System.out.println("Click! 저장하기");

			DentalMemberDAO dao = new DentalMemberDAO();
			System.out.println("mbId.getText()=" + mbId.getText());
			System.out.println("AllId=" + AllId);
//			System.out.println("AllId != ''=" + AllId != "");

			// f5 - 가입성공 플레임, f6 - 재확인 플레임
			if (!AllId.equals("")) {
				dao.memUpdate(umbPwd.getText(), utfName.getText(), utfBirth.getText(), utfTel.getText(),
						utfAddr.getText());
				f5.setVisible(true);
				System.out.println("확인 요청");
//			}else {
//				dao.memInsert(umbId.getText(), umbPwd.getText(), utfName.getText(), utfBirth.getText(),
//						utfTel.getText(), utfAddr.getText());
//				f5.setVisible(true);
//				System.out.println("수정 성공");
			}
			if (AllId.equals("")) { // 최초 회원 가입 진행 시 작동
				dao.memInsert(mbId.getText(), mbPwd.getText(), tfName.getText(), tfBirth.getText(), tfTel.getText(),
						tfAddr.getText());
				f5.setVisible(true);
//				System.out.println("가입 성공");
//			} else if (!AllId.equals("")) {
//				dao.memUpdate(umbPwd.getText(), utfName.getText(), utfBirth.getText(),
//						utfTel.getText(), utfAddr.getText());
//				f6.setVisible(true);
//				System.out.println("재확인 요청");
			}
//			if (tfId.getText().equals("") || tfPwd.getText().equals("")) { // 로그인 또는 비번 칸에 필히 작성 요청 메시지
//				System.out.println("회원가입 내용을 입력해 주세요.");
//				f6.setVisible(true);
//				return;
//			}

		}
		if (e.getActionCommand().equals("성공")) {
			System.out.println("Click! 성공");

			f4.setVisible(false);
			f5.setVisible(false);
			f1.setVisible(true);
		}
		// 치과진료 정보 안내 내용
		if (e.getActionCommand().equals("예방치료")) {
			System.out.println("Click! 예방치료");
			p1.setText(" \r\n" + " ■ 예방치료\r\n" + " - 불소도포 올바른 잇솔질, 구강검진, 실란트 등을 통해 \r\n"
					+ " 잇몸질환이나 충치가 생기는 것을 예방해주는 치료를 말합니다.\r\n" + " 치아 관리를 소홀히 하게 되면 세균이 생기기 쉽고 충치가 잘 발생합니다.\r\n"
					+ " \r\n" + " - 충치를 예방하는 방법\r\n" + " 불소도포, 올바른 잇솔질, 치아홈 메우기(실란트 - Sealant), 구강검진, 스케일링 등이 있습니다.\r\n"
					+ "\r\n" + " - 진료 비용(원)\r\n" + "진료 부분        	최소비용	최대비용	평균비용\r\n"
					+ "실란트(만 8세 미만)	₩4,500	₩60,000	₩31,400\r\n" + "실란트(만 8세 이상)	₩4,500	₩60,000	₩27,250\r\n"
					+ "\r\n" + " * 구강검진 비용 : 국민건강보험 가입자는 무료 검진 됩니다.\r\n" + "\r\n"
					+ " * 기간별 정기검진 – 3개월, 6개월, 1년 단위로 정기검진");
		}
		if (e.getActionCommand().equals("보존치료")) {
			System.out.println("Click! 보존치료");
			p1.setText(" \r\n" + " ■ 보존치료\r\n"
					+ " - 충치나 사고 등으로 손상된 치아를 발치하지 않고 살려서 쓰기 위한 근관치료, 치아 손상과 민감증 치료, 충치 치료 후 관리, 변색된 치아의 미백등에 대해 진료합니다.\r\n"
					+ "\r\n" + " 1) 아말감 치료 \r\n" + " - 수은을 이용한 합금의 일종. 충치치료에 가장 오래 쓰인 재료입니다.\r\n"
					+ " 치료 비용이 매우 저렴지만, 자체색상으로 심미성이 떨어지고, 치아와 접착력이 약합니다\r\n" + "\r\n" + " 2) 레진 치료\r\n"
					+ " - 전치(앞니)나 소구치(작은어금니)에 눈에 띄는 곳의 치아우식증 치료에 많이 쓰입니다. \r\n"
					+ " 색상이 치아와 매우 유사하여 높은 심미성으로 사용범위가 넓고, 치아와 잘 접착합니다.  \r\n" + "\r\n" + " 3) 인레이 치료\r\n"
					+ " - 치아우식증(충치)의 범위가 광범위하거나 옆 치아와 충치부위가 맞닿는 경우에는  \r\n"
					+ " 아말감이나 레진으로 치료에 무리가 있을 경우 하게 되는 치료 방법입니다.\r\n"
					+ " 치아우식증의 부분을 제거하고 본을 떠서 제작한 수복물을 접착하는 방법을 사용합니다.\r\n" + "\r\n"
					+ "진료 부분		최소비용	최대비용	평균비용\r\n" + "아말감(국가보험)	₩2,000	₩70,000	₩17,3633\r\n"
					+ "레진(비보험)		₩200,000	₩250,000	₩225,000\r\n"
					+ "인레이 - 골드		₩250,000	₩360,000	₩305,000\r\n"
					+ "인레이 - 레진 		₩150,000	₩350,000	₩257,000\r\n" + "(부위에 따라 다름)");
		}
		if (e.getActionCommand().equals("보철치료")) {
			System.out.println("Click! 보철치료");
			p1.setText(" \r\n" + " ■ 보철치료\r\n" + " - 치아가 상실되거나 발치했을 경우, 또는 부분 손실 일 때 치아를 인공적으로 만들어주는 시술\r\n"
					+ "사랑니로 상실, 잇몸질환으로 상실, 사고로 상실, 충치로 손실 등 원인은 다양\r\n" + "\r\n" + " 1) 크라운 치료\r\n"
					+ " - 충치나 외상이 심해 치아가 대부분 손실 되었을 때에는 치아 자체에 씹는 힘을 감당 못하게 되기에 \r\n"
					+ "  전체적으로 치아를 튼튼하게 씌워주는 '크라운' 치료가 필요합니다.\r\n"
					+ " - 종류 : 골드(GOLD)크라운, PFM(Porcelain Fused Metal)크라운, 지르코니아(Zirconia) 크라운\r\n" + "\r\n"
					+ " 2) 브릿지 \r\n" + " -치아가 사고, 노화로 빠졌거나 충치로 인해 뽑아야 할 때 이용합니다.\r\n"
					+ " 양쪽 치아에 보철물을 끼워 중간의 비어있는 부분에 치아가 있는 것처럼 보이게 하는 치료입니다. \r\n"
					+ " 임플란트에 비해 비용이 저렴하지만 양쪽의 건강한 치아ㅍ삭제가 필요합니다. \r\n" + " 7~10년마다 교체가 필요하다는 단점도 있습니다. \r\n" + "\r\n"
					+ " 3)임플란트\r\n" + " 상실된 잇몸뼈를 대체하여 인공치근과 자연치근을 식립하는 치료입니다. \r\n"
					+ " 치료기간은 2개월~1년으로 치아의 상태에 따라 다양합니다. \r\n" + " <치과 임플란트 & 틀니 보험> \r\n"
					+ " 대상자 : 만 65세 이상 건강보험가입자 또는 피부양자 \r\n" + " 적용범위 : 임플란트 (2개 까지) & 틀니 (부분/전체)\r\n"
					+ " 본인부담금 : 건강보험 50% 적용");

		}
		if (e.getActionCommand().equals("교정치료")) {
			System.out.println("Click! 교정치료");
			p1.setText(" \r\n" + " ■ 교정 치료\r\n" + " 1. 교정의 목적\r\n"
					+ " - 부정교합의 원인을 찾아내고, 얼굴모습과 조화를 고려한 적절할 치료계획이 요구됩니다.\r\n"
					+ " 얼굴의 형태에 따라 치아의 배열을 맞추어 위아랫니가 잘 맞물리게 하게 도와줍니다.\r\n"
					+ " 입의 모양을 바로 잡아주고 음식물을 잘 씹을 수 있게 해주는 것이 목적입니다.\r\n" + " 1) 양치질이 쉬워져 구강조직의 건강을 얻을 수 있습니다.\r\n"
					+ " 2) 씹는 기능이 좋아지며 발음이 또렷해집니다.\r\n" + " 3) 가지러한 치아와 조화로운 얼굴모습을 되찾아드립니다.\r\n" + "\r\n"
					+ " 2. 교정치료의 시기\r\n" + " - 치아교정의 연령에 상관없이 가능합니다.\r\n"
					+ " 성인이 되어서 한다면 치료 속도가 느린 경우에 따라 공간부족으로 발치를 하기도 합니다.\r\n" + "\r\n" + " 3. 교정치료 대상\r\n"
					+ " 1) 치아가 울퉁불퉁한 경우\r\n" + " 2) 치아 사이가 벌어진 경우\r\n" + " 3) 치아가 앞으로 돌출된 경우\r\n"
					+ " 4) 앞니가 안 물리는 경우\r\n" + " 5)깊게 물리는 경우\r\n" + " 6)뒤로 물리는 경우");

		}
		if (e.getActionCommand().equals("심미치료")) {
			System.out.println("Click! 심미치료");
			p1.setText(" \r\n" + " ■ 심미치료\r\n" + " 1. 치아 미백\r\n"
					+ " 변색된 치아를 삭제하거나 손상시키지 않고 치아의 색을 희고 밝게 만드는 치과 치료 시술입니다. \r\n"
					+ " 변색 부위에 안전성이 입증된 치아 미백제를 적용하여 착색 성분의 구조만 변화시켜 치아의 색을 원래의 색으로 회복시키거나 더 밝게 하는 방법입니다.\r\n" + " \r\n"
					+ " 2. 치료 대상\r\n" + " - 치아위치 이상, 벌어진 치아, 치아파절, 검게 변환 잇몸, 누런 치아, 독특한 모양의 앞니 \r\n" + "\r\n"
					+ " 3. 치료 방법  \r\n" + " 1) 라미네이트\r\n" + " 2) 올 세라믹\r\n" + " 3) 치아 미백");
		}
		if (e.getActionCommand().equals("신경치료")) {
			System.out.println("Click! 신경치료");
			p1.setText(" \r\n" + " ■ 신경치료\r\n" + "-보존치료 중에 하나의 치료 방법이 되겠습니다.\r\n" + "\r\n"
					+ "충치가 심하여 치수(신경)까지 침범한 경우에는 \r\n" + "신경치료와 보철치료가 실시되기도 합니다.\r\n" + "\r\n"
					+ " - 심한 충치로 치수까지 감염이 되거나 파절 등 외상으로 치수가 노출되어 \r\n" + "세균에 감염되고 염증의 문제를 해결하기 윈한 치료 입니다. \r\n"
					+ "치아 내부에 신경과 혈관이 들어 있는 치수조직을 제거한 후 그 공간에 재료를 밀봉하여 치아의 기능을 유지하는 치료입니다.\r\n" + "\r\n"
					+ " - 1회 시술로는 끝나지 않고, 보통 3~4회 또는 상태에 따라 그 이상 까지도 시술을 받게 됩니다.");

		} // 회원정보 수정하여 저장하기
		if (e.getActionCommand().equals("정보수정")) {
			System.out.println("Click! 정보수정");
			info.setVisible(true);
			update.setVisible(true);

			ArrayList<MemberVo> list = dao.list(AllId); // DB 자료 갖고 오기

			String Id = "", Pwd = "", Name = "", Birth = "", Tel = "", Address = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				Id = data.getId();
				Pwd = data.getPwd();
				Name = data.getName();
				Birth = data.getBirth();
				Tel = data.getTel();
				Address = data.getAddress();

				umbId.setText(Id);
//				la2.setText(Id);
				umbPwd.setText(Pwd);
				utfName.setText(Name);
				utfBirth.setText(Birth);
				utfTel.setText(Tel);
				utfAddr.setText(Address);

				System.out.println(Id + " : " + Pwd);
			}
		}
		if (e.getActionCommand().equals("수정저장")) {
			System.out.println("Click! 수정저장");

			DentalMemberDAO dao = new DentalMemberDAO();

			// f5 - 가입성공 플레임, f6 - 재확인 플레임
			if (!AllId.equals("")) {
				dao.memUpdate(umbPwd.getText(), utfName.getText(), utfBirth.getText(), utfTel.getText(),
						utfAddr.getText());
				f7.setVisible(true);
				System.out.println("확인 요청");
//				}else {
//					dao.memInsert(umbId.getText(), umbPwd.getText(), utfName.getText(), utfBirth.getText(),
//							utfTel.getText(), utfAddr.getText());
//					f5.setVisible(true);
//					System.out.println("수정 성공");
			}
			if (AllId.equals("")) { // 최초 회원 가입 진행 시 작동
				dao.memInsert(mbId.getText(), mbPwd.getText(), tfName.getText(), tfBirth.getText(), tfTel.getText(),
						tfAddr.getText());
				f5.setVisible(true);
			}

		}
	}

	public static void main(String[] args) {
		new LoginFrame();

	}
}
