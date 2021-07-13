import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class NameFrame extends JFrame implements ActionListener{//프레임 클래스
	JTextField t1= new JTextField(5); //kim 입력 받을 textfield
	JTextField t2= new JTextField(5); //lee 입력 받을 textfield
	JTextField t3= new JTextField(5); //park 입력 받을 textfield
	JTextField t4= new JTextField(5); //etc 입력 받을 textfield
	String s=" "; //예외처리에서 쓰일 문자열 생성, 프레임 처음 생성 시 옆에 글자 안나오도록 " "으로 초기화
	int kim=0, lee=0, park=0, etc=0; //textfield로 입력 받은 숫자 계산해 각도 저장할 변수들
	
	class GraphPanel extends JPanel{ //그래프 부분 panel class
		public void paint(Graphics g) {
			if(s.equals("")) { //에러 핸들링 위해서 s 비어있을 때만 실행
				g.setColor(Color.yellow); //색상 노란색으로 설정하고 옆에 설명 쓰기
				g.drawString("YELLOW: KIMs", 350, 120);
				g.fillArc(120, 80, 170, 170, 0, kim); //내각 kim만큼의 호 그리기
				g.setColor(Color.red); //빨간색, lee으로 반복
				g.drawString("RED: LEES", 350, 140);
				g.fillArc(120, 80, 170, 170, kim, lee);
				g.setColor(Color.blue); //파란색, park로 반복
				g.drawString("BLUE: PARKs", 350, 160);
				g.fillArc(120, 80, 170, 170, lee+kim, park);
				g.setColor(Color.green); //초록색, etc로 반복
				g.drawString("GREEN: Etc", 350, 180);
				g.fillArc(120, 80, 170, 170, park+lee+kim, etc);
			}
			else { //s가 비어있지 않을 경우 실행
				g.setColor(Color.black); //검은색으로 변경하고 s 나타내기
				g.drawString(s, 150, 280);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {//버튼 눌렸을 때 실행
		try {//에러 핸들링 위해서 try로 실행
			s=""; //s 초기화
			kim=Integer.parseInt(t1.getText()); //t1에 입력 받은 string형 int형으로 변환, kim에 저장
			lee=Integer.parseInt(t2.getText()); //t2, lee로 반복
			park=Integer.parseInt(t3.getText()); //t3, park로 반복
			etc=Integer.parseInt(t4.getText()); //t4, etc로 반복
			int total=kim+lee+park+etc; //int형 total에 모든 수 더한 값 저장
			if(kim<0||lee<0||park<0||etc<0) //변수 중 하나라도 음수일 경우 exception 처리
				throw new NumberFormatException();
			if(total>100) //합이 100이 넘을 경우 exception 처리하여 문구 넘기기
				throw new Exception("Number of students is 100");
			kim=((kim*360)/total); //각도로 바꾸기 위해서 360 곱하고 total로 나누기
			lee=((lee*360)/total); //lee로 반복
			park=((park*360)/total); //park로 반복
			etc=((etc*360)/total); //etc로 반복
		}
		
		catch(NumberFormatException ex) {//string int로 변환시 문제 생기거나 변수 중 음수 있을 경우
			s="Input numbers of student names"; //s에 문장 저장
		}
		catch(Exception ex) { //합이 100 넘을 경우
			s=ex.getMessage(); //넘겨 받은 문구 s에 저장
		}
		finally { //모든 경우에 repaint 실행
			repaint();
		}
	}
	public NameFrame() {
		setTitle("Pie Char of Student names - 안혜진"); //이름 설정
		setSize(500, 400); //크기 설정
		GraphPanel p1 = new GraphPanel(); //그래프 부분 panel 생성
		JPanel p2 = new JPanel(); //button과 textfield 놓을 panel 생성
		JButton b = new JButton("Graph"); //그래프 만드는 버튼 생성
		b.addActionListener(this); //버튼에 event handling 처리
		
		p2.add(new JLabel("Kim")); //p2에 Kim label과 t1 textfield 추가
		p2.add(t1);
		p2.add(new JLabel("Lee")); //반복
		p2.add(t2);
		p2.add(new JLabel("Park")); //반복
		p2.add(t3);
		p2.add(new JLabel("Etc")); //반복
		p2.add(t4);
		p2.add(b); //p2에 버튼 추가
		
		add(p1, "Center"); //p1을 프레임의 center 자리에 추가
		add(p2, "South"); //p2를 프레임의 남쪽에 추가
		setDefaultCloseOperation(EXIT_ON_CLOSE); //x 누르면 실행 종료
		Toolkit tk = getToolkit();
		Dimension d = tk.getScreenSize(); //모니터 크기 구하기
		int screenHeight=d.height; //모니터 높이 구하기
		int screenWidth=d.width; //모니터 폭 구하기
		setLocation(screenWidth/2-this.getWidth()/2, screenHeight/2-this.getHeight()/2);
		//모니터, 프레임 크기 계산해서 모니터 가운데에 프레임 위치하게 조정
		setVisible(true);//프레임 가시화
	}
}
public class {
	public static void main(String[] args) {
		NameFrame f = new NameFrame(); //NameFrame 객체 생성
	}
}
