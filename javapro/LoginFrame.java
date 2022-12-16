package javapro;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginFrame extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button button1;
	private TextField tfid;
	private TextField tfpwd;
	private TextField asw;
	private MemberDAO dao;

	public LoginFrame() {
		dao = new MemberDAO();

		f = new Frame("Login");
		f.setLayout(new FlowLayout());
		f.setSize(450, 120);
		f.setLocation(500, 200);
		f.addWindowListener(this);

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("PASSWORD : ", Label.RIGHT);

		tfid = new TextField(10);
		tfpwd = new TextField(10);

		button1 = new Button("Login");
		button1.addActionListener(this);
		asw = new TextField(40);
		tfpwd.setEchoChar('*');

		f.add(lid);
		f.add(tfid);
		f.add(lpwd);
		f.add(tfpwd);
		f.add(button1);
		f.add(asw);
		f.setVisible(true);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 150, screenSize.height / 2 - 100);
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Login")) {
			System.out.println("Click");
			ArrayList<MemberVo> list = dao.list(tfid.getText());

			String id = "", password = "";
			for (int i = 0; i < list.size(); i++) {
				MemberVo data = (MemberVo) list.get(i);
				id = data.getId();
				password = data.getPassword();

				System.out.println(id + " : " + password);
			}

			if (tfid.getText().equals(id) && tfpwd.getText().equals(password)) {
				System.out.println("로그인 성공");
				asw.setText("로그인 성공 하셨습니다.");
			} else {
				System.out.println("로그인 실패");
				asw.setText("로그인 실패하셨습니다. 재시도해주세요");

			}
		}
	}

	public static void main(String[] args) {

		new LoginFrame();

	}

}
