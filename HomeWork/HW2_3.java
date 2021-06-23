import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CalFrame extends JFrame implements ActionListener{
	JTextField field = new JTextField(); //계산 결과 보여줄 textfield 생성
	String result=""; //사용자가 입력한 값 저장할 result 생성
	public CalFrame() {
		setTitle("Calculator"); //제목 설정
		setSize(300, 200); //크기 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //container x 누르면 실행 중단
		setLayout(new BorderLayout()); //borderlayout으로 component 위치, 크기 조정
		
		JPanel panel = new JPanel(); //계산기의 버튼들 저장할 패널 생성
		panel.setLayout(new GridLayout(0, 4, 1, 0)); //패널을 gridlayout으로 조정하기

		makeButton("7", panel); //makeButton 메소드로 panel에 버튼 생성
		makeButton("8", panel);
		makeButton("9", panel);
		makeButton("/", panel);
		makeButton("4", panel);
		makeButton("5", panel);
		makeButton("6", panel);
		makeButton("*", panel);
		makeButton("1", panel);
		makeButton("2", panel);
		makeButton("3", panel);
		makeButton("-", panel);
		makeButton("New", panel);
		makeButton("0", panel);
		makeButton("=", panel);
		makeButton("+", panel); //여기까지 반복
			
		field.setHorizontalAlignment(JTextField.RIGHT); //오른쪽부터 써지게 바꾸기
		
		add(field, BorderLayout.NORTH); //위에서 생성한 필드 north 위치에 넣기
		add(panel, BorderLayout.CENTER); //버튼들 추가한 panel을 center 위치에 넣기
		pack(); //frame 최소화
		setVisible(true); //만든 frame 가시화
	}
	void makeButton(String text, JPanel panel) { //패널에 버튼 생성해주는 메소드
		JButton b = new JButton(); //button 하나 생성
		b.setText(text); //인자로 받은 문자열 버튼에 넣기
		b.addActionListener(this); //버튼에 이벤트 핸들링 추가
		panel.add(b); //버튼을 인자로 받은 패널에 추가
	}
	public void actionPerformed(ActionEvent e) { //버튼 눌렸을 경우 실행
		String str = e.getActionCommand(); //어떤 버튼 눌렸는지 str에 저장
		if(str.equals("New")) { //str이 New와 같을 경우
			result=""; //result 초기화
			field.setText(result); //초기화된 result로 field 다시 설정
		}
		else if(str.equals("=")){ //str이 =과 같을 경우
			String[] array=result.split(""); //result에 저장된 문자들 array 배열에 분리해서 저장
			int a = Integer.parseInt(array[0]); //첫번째로 입력된 문자 int형으로 변환해서 a에 저장
			int b = Integer.parseInt(array[2]); //세번째로 입력된 문자 int형으로 변환해서 b에 저장
			int answer=0; //결과 출력할 answer변수 0으로 초기화
			if(array[1].equals("/")) { //계산이 /일 경우
				double c=(double)a/b; //double형으로 a/b 계산한 값 저장
				field.setText(Double.toString(c)); //계산한 값 string으로 변환해 field에 재설정
			}
			else if(array[1].equals("*")) //계산이 *일 경우
				field.setText(Integer.toString(a*b)); //계산한 값 string으로 변환해 field에 재설정		
			else if(array[1].equals("-")) //-로 반복
				field.setText(Integer.toString(a-b));
			else if(array[1].equals("+")) //+로 반복
				field.setText(Integer.toString(a+b));
		}
		else {//그 외의 경우는 field에 보여주기만 하기
			result=result+str; //result에 새로운 str 추가
			field.setText(result); //추가된 result field에 재설정
		}
	}
}

public class HW2_3 {
	public static void main(String[] args) {
		CalFrame f = new CalFrame(); //CalFrame 객체 생성
	}
}
