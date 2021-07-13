import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyFrame extends JFrame implements ActionListener{
	JLabel label=new JLabel(" "); //Wrong Input 출력할 Label 생성
	int kor=0, eng=0, math=0; //textfield로 입력받을 성적들 int형으로 생성
	JTextField t1=new JTextField(5); //kor 점수 입력 받을 textfield
	JTextField t2=new JTextField(5); //eng 점수 입력 받을 textfield
	JTextField t3=new JTextField(5); //math 점수 입력 받을 textfield
	class MyPanel extends JPanel{ //그래프 부분 판넬
		public void paint(Graphics g) {
			g.setColor(Color.black); //그래프 기본선 그리기 위해 검정색으로 설정
			g.drawLine(100, 60, 400, 60); //그래프 구성 요소들 그리기 시작
			g.drawLine(100, 80, 400, 80);
			g.drawLine(100, 100, 400, 100);
			g.drawLine(100, 120, 400, 120);
			g.drawLine(100, 140, 400, 140);
			g.drawLine(100, 160, 400, 160);
			g.drawLine(100, 180, 400, 180);
			g.drawLine(100, 200, 400, 200);
			g.drawLine(100, 220, 400, 220);
			g.drawLine(100, 240, 400, 240);
			g.drawLine(100, 260, 400, 260);
			g.drawLine(100, 60, 100, 260);
			g.drawString("100", 75, 65);
			g.drawString("90", 75, 85);
			g.drawString("80", 75, 105);
			g.drawString("70", 75, 125);
			g.drawString("60", 75, 145);
			g.drawString("50", 75, 165);
			g.drawString("40", 75, 185);
			g.drawString("30", 75, 205);
			g.drawString("20", 75, 225);
			g.drawString("10", 75, 245);
			g.drawString("KOR", 170, 275);
			g.drawString("ENG", 240, 275);
			g.drawString("MATH", 310, 275); //그래프 구성 요소 그리기 끝
			
			g.setColor(Color.red); //막대 그리기 위해 빨간색으로 설정
			g.fillRect(170, 260-kor, 8, kor); //적절한 위치에 높이 kor만큼의 사각형 그리기
			g.fillRect(240, 260-eng, 8, eng); //적절한 위치에 높이 eng만큼의 사각형 그리기
			g.fillRect(310, 260-math, 8, math); //적절한 위치에 높이 math만큼의 사각형 그리기 
		}
	}
	public void actionPerformed(ActionEvent e) {//버튼 눌렸을 때 실행
		try { //점수 정확히 기재했는지 error handling 하기 위해 try로 실행
			label.setText(" "); //label 초기화해주기
			kor=Integer.parseInt(t1.getText())*2; //t1에 입력된 값 받아와 int형으로 변경하고 그래프 간격 위해서 곱하기
			eng=Integer.parseInt(t2.getText())*2; //t2로 반복
			math=Integer.parseInt(t3.getText())*2; //t3로 반복
			if((kor<0||kor>200)||(eng<0||eng>200)||(math<0||math>200)) {
				throw new Exception(); //점수들이 범위 외에 있을 경우 예외처리
			}
			repaint(); //새로 바뀐 점수들 이용해서 그래프 다시 그리기
		}
		catch(Exception ex) { //에러 발생했을 경우
			kor=0; //점수들 초기화하기
			eng=0;
			math=0;
			repaint(); //초기화한 점수로 그래프 다시 그리기
			label.setText("Wrong Input"); //label Wrong Input으로 변경하기
		}
	}
	
	public MyFrame() {
		setTitle("Score Graph"); //프레임의 이름 Score Graph로 설정
		setSize(500, 400); //프레임 크기 설정
		JPanel topP = new JPanel(); //wrong input 출력하는 라벨 넣을 panel 생성
		MyPanel centerP = new MyPanel(); //그래프 그리는 panel 생성
		JPanel bottomP = new JPanel(); //점수 입력하고 버튼 누르는 panel 생성
		topP.add(label); //topP panel에 라벨 추가
		JButton b = new JButton("Show Graph"); //그래프 그리는 버튼 생성
		b.addActionListener(this); //버튼에 event handling 추가
		bottomP.add(new JLabel("Kor")); //bottomP panel에 Kor label 추가
		bottomP.add(t1); //bottomP panel에 kor 점수 입력 받는 t1 textfield 추가
		bottomP.add(new JLabel("Eng")); //bottomP panel에 Eng label 추가
		bottomP.add(t2); //bottomP panel에 eng 점수 입력 받는 t2 textfield 추가
		bottomP.add(new JLabel("Math")); //bottomP panel에 math label 추가
		bottomP.add(t3); //bottomP panel에 math 점수 입력 받는 t3 textfield 추가
		bottomP.add(b);	//bottomP에 그래프 다시 그리는 b button 추가
		add(topP, "North"); //프레임의 북쪽에 topP 추가
		add(centerP, "Center"); //프레임의 가운데에 centerP 추가
		add(bottomP, "South"); //프레임의 남쪽에 bottomP 추가
		setResizable(false); //프레임 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x누르면 종료
		setVisible(true); //프레임 가시화
	}
	
}
public class {
	public static void main(String[] args) {
		MyFrame f = new MyFrame(); //MyFrame 객체 생성
	}
}
