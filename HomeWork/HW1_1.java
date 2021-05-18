import java.util.Scanner;
class Time{
	private int hour; //시 저장할 변수
	private int minute; //분 저장할 변수
	private boolean isValid(int hour, int minute) {
		if(((0<=hour)&&(hour<=23))&&((0<=minute)&&(minute<=59))) //시와 분 모두 범위 안에 있다면 true 리턴
			return true;
		else //범위 밖에 있을 경우에는 false 리턴
			return false;
	}
	public void setTime(int hour, int minute) { //hour와 minute의 setter 메소드
		if(this.isValid(hour, minute)) { //isValid 메소드 이용해서 리턴 값이 true일 경우에 변수 저장
			this.hour=hour;
			this.minute=minute;
		}
		else //리턴 값 false일 경우에 잘못된 입력이라고 출력
			System.out.println("Wrong Input");
	}
	public int getTime(char ch) { //어떤 char 입력 받는지에 따라 시나 분 리턴하는 메소드
		int result=0; //리턴할 때 쓰일 변수 선언
		if((ch=='H')||(ch=='h')) //char이 h일 때 result에 hour 저장
			result=this.hour;
		if((ch=='M')||(ch=='m')) //char이 m일 때 result에 minute 저장
			result=this.minute;
		return result; //저장한 값 리턴
	}
}

public class HW1_1 {
	public static void main(String[] args) {
		System.out.println("==========\n전공: 사이버보안\n학번: 1971077\n성명: 안혜진\n==========");
		int hour, minute; //사용자한테 입력받을 시간 변수 선언
		Scanner key=new Scanner(System.in); //Scanner 객체 생성
		Time t = new Time(); //Time 객체 생성
		System.out.println("Hour:");
		hour=key.nextInt(); //nextInt로 hour 입력 받기
		System.out.println("Minute:");
		minute=key.nextInt(); //nextInt로 minute 입력 받기
		t.setTime(hour, minute); //setTime 메소드로 시간 넣기
		System.out.println(t.getTime('H')+":"+t.getTime('M')); //getTime 메소드로 시간 출력
	}

}
