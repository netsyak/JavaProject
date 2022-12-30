package javapro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//import oracle.net.aso.f;

public class LoginFrame extends WindowAdapter implements ActionListener {
	private JFrame f1, f2, f3, f4, f5;
	private JTextField tfId, tfPwd, mbId, mbPwd, tfName, tfTel, tfAddr, tfBirth;
	private JButton btnLogin, btnSignup, b1, b2, b3, b4;
	private MemberDAO dao;
//	private JCheckBox box1;

	public LoginFrame() {
		dao = new MemberDAO();

		f1 = new JFrame("로그인");
		f1.setLayout(null);
		f1.getContentPane().setBackground(Color.orange);
		f1.setSize(350, 500);
		f1.setLocationRelativeTo(null);// 프레임 화면 가운데 배치
		f1.addWindowListener(this);

		f2 = new JFrame("로그인 성공");
		f2.setLayout(null);
		f2.getContentPane().setBackground(Color.orange);
		f2.setSize(280, 180);
		f2.setLocationRelativeTo(null);
		f2.addWindowListener(this);

		f3 = new JFrame("로그인 실패");
		f3.setLayout(null);
		f3.getContentPane().setBackground(Color.orange);
		f3.setSize(280, 180);
		f3.setLocationRelativeTo(null);
		f3.addWindowListener(this);

		f4 = new JFrame("회원 가입");
		f4.setLayout(null);
//		f4.setLayout(new FlowLayout());
		f4.getContentPane().setBackground(Color.orange);
		f4.setSize(350, 500);
		f4.setLocationRelativeTo(null);
		f4.addWindowListener(this);

		f5 = new JFrame("치과 정보");
		f5.setLayout(null);
		f5.getContentPane().setBackground(Color.orange);
		f5.setSize(600, 500);
		f5.setLocationRelativeTo(null);
		f5.addWindowListener(this);

//		JPanel p = new JPanel();
//		p.setLayout(null);
//		p.add(tfMsg);
//		p.setOpaque(false);
//		p.setBounds(100, 330, 235, 30);

		// 로그인 화면 창
		JLabel txt = new JLabel();
		txt.setBounds(105, 10, 150, 150);
		txt.setText("어서오세요. 반갑습니다.");
		JLabel lid = new JLabel("ID", JLabel.RIGHT);
		lid.setBounds(40, 300, 60, 30);
		JLabel lpwd = new JLabel("Password", JLabel.RIGHT);
		lpwd.setBounds(40, 335, 60, 20);
		JLabel msg = new JLabel("로그인 성공!!!", JLabel.CENTER);
		msg.setBounds(95, 0, 75, 90);
		JLabel msg1 = new JLabel("로그인 실패!!!", JLabel.CENTER);
		msg1.setBounds(95, 0, 75, 90);

		// 회원 가입 창 메뉴별
		JLabel mId = new JLabel("ID", JLabel.RIGHT);
		mId.setBounds(15, 50, 60, 30);
		JLabel mPwd = new JLabel("Password", JLabel.RIGHT);
		mPwd.setBounds(15, 90, 60, 30);
		JLabel name = new JLabel("이름", JLabel.RIGHT);
		name.setBounds(15, 130, 60, 30);
		JLabel gender = new JLabel("성별", JLabel.RIGHT);
		gender.setBounds(15, 170, 60, 30);
		JLabel birth = new JLabel("생년월일", JLabel.RIGHT);
		birth.setBounds(15, 210, 60, 30);
		JLabel tel = new JLabel("전화번호", JLabel.RIGHT);
		tel.setBounds(15, 250, 60, 30);
		JLabel addr = new JLabel("주소", JLabel.RIGHT);
		addr.setBounds(15, 290, 60, 30);

		// 로그인 화면 텍스트 칸
		tfId = new JTextField(10);
		tfId.setBounds(120, 300, 150, 27); // 텍스트 칸
		tfId.setBackground(Color.white);
		tfPwd = new JPasswordField(10);
		tfPwd.setBounds(120, 330, 150, 27);
		tfPwd.setBackground(Color.white);
//		tfMsg = new JTextField(40);
//		tfMsg.setBounds(13, 428, 310, 27);
//		tfMsg.setBackground(Color.white);

		// 회원 정보 창
		mbId = new JTextField(20);
		mbId.setBounds(90, 50, 150, 27);
		mbId.setBackground(Color.white);
		mbPwd = new JTextField(20);
		mbPwd.setBounds(90, 90, 150, 27);
		mbPwd.setBackground(Color.white);
		
		tfName = new JTextField(10);
		tfName.setBounds(90, 130, 150, 27);
		tfName.setBackground(Color.white);
//		tfGender = new JTextField(null);
//		tfGender.setBounds(90, 90, 150, 27);
//		tfGender.setBackground(Color.white);
		ButtonGroup box1;
		JRadioButton rd1 = new JRadioButton("남");
		JRadioButton rd2 = new JRadioButton("여");
		box1 = new ButtonGroup();
		box1.add(rd1);
		box1.add(rd2);
		rd1.setBounds(90, 170, 40, 27);
		rd2.setBounds(150, 170, 40, 27);
		rd1.setBackground(null);
		rd2.setBackground(null);
		tfBirth = new JTextField(10);
		tfBirth.setBounds(90, 210, 150, 27);
		tfBirth.setBackground(Color.white);
		tfTel = new JTextField(12);
		tfTel.setBounds(90, 250, 150, 27);
		tfTel.setBackground(Color.white);
		tfAddr = new JTextField(40);
		tfAddr.setBounds(90, 290, 150, 50);
		tfAddr.setBackground(Color.white);

		// 치과치료 안내창
//		JLabel la1 = new JLabel("치과 비용은... ?", JLabel.RIGHT);
//		la1.setBounds(30, 30, 105, 30);
//		la1.setBackground(Color.white);
//
//		JTextField tf = new JTextField(10);
//		tf.setBounds(60, 60, 170, 30); // 텍스트 칸
//		tf.setBackground(Color.white);
//
//		JButton b1 = new JButton("검색");
//		b1.setBounds(240, 60, 60, 30);
//
//		f5.add(tf);
//		f5.add(la1);
//		f5.add(b1);

		// 버튼이름들
		btnLogin = new JButton("로그인");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(30, 390, 122, 30);
		btnSignup = new JButton("회원 가입");
		btnSignup.addActionListener(this);
		btnSignup.setBounds(182, 390, 122, 30);

		b1 = new JButton("확인");
		b1.addActionListener(this);
		b1.setBounds(100, 80, 70, 40);

		b2 = new JButton("로그인 재시도");
		b2.addActionListener(this);
		b2.setBounds(69, 80, 130, 40);

		b3 = new JButton("저장하기");
		b3.setBounds(30, 390, 122, 30);
		b3.addActionListener(this);
		b4 = new JButton("뒤로가기");
		b4.setBounds(182, 390, 122, 30);
		b4.addActionListener(this);

		f1.add(txt);
		f1.add(lid);
		f1.add(tfId);
		f1.add(lpwd);
		f1.add(tfPwd);
		f1.add(btnLogin);
		f1.add(btnSignup);
//		f1.add(tfMsg);

		f2.add(msg);
		f2.add(b1);
		f3.add(msg1);
		f3.add(b2);
		
		f4.add(b3);
		f4.add(b4);

		f4.add(mId);
		f4.add(mbId);

		f4.add(mPwd);
		f4.add(mbPwd);

		f4.add(name);
		f4.add(tfName);
		f4.add(gender);
		f4.add(rd1);
		f4.add(rd2);
		f4.add(tel);
		f4.add(tfTel);
		f4.add(addr);
		f4.add(tfAddr);
		f4.add(birth);
		f4.add(tfBirth);

		f1.setVisible(true);
//		f2.setVisible(true);   //창 확인 하기
//      f3.setVisible(true); 
//		f4.setVisible(true);
//		f5.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("로그인")) {
			System.out.println("Click!");
			ArrayList<MemberVo> list = dao.list(tfId.getText());

			String id = "", password = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				id = data.getId();
				password = data.getPassword();

				System.out.println(id + " : " + password);
			}

			if (tfId.getText().equals(id) && tfPwd.getText().equals(password)) {
				System.out.println("로그인 성공");
//				tfMsg.setText("로그인 성공!!! 어서오세요!!!");
				f1.setVisible(false);
				f2.setVisible(true);
			} else {
				System.out.println("로그인 실패");
//				tfMsg.setText("로그인 실패!!! 재시도 해주세요!!!");
				f1.setVisible(false);
				f3.setVisible(true);
			}

		}
		if (e.getActionCommand().equals("회원 가입")) { //
			System.out.println("Click!");
			f4.setVisible(true);
		}
		if (e.getActionCommand().equals("확인")) {
			System.out.println("Click!");
			f2.setVisible(false);
			f5.setVisible(true);
		}
		if (e.getActionCommand().equals("로그인 재시도")) {
			System.out.println("Click!");
			f3.setVisible(false);
			f1.setVisible(true);
		}
		if (e.getActionCommand().equals("저장하기")) {
			System.out.println("Click!");
			f4.setVisible(false);
			f1.setVisible(true);
		}
		if (e.getActionCommand().equals("뒤로가기")) {
			System.out.println("Click!");
			f4.setVisible(false);
			f1.setVisible(true);
		}

	}

	public static void main(String[] args) {
		new LoginFrame();

	}
}