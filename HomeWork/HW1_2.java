import java.util.Scanner;
class DiceGame{
	private int diceFace; //랜덤수 저장할 변수
	private int userGuess; //사용자의 예측수 저장할 변수
	Scanner key = new Scanner(System.in);
	DiceGame(){} //디폴트 생성자
	private int rollDice() { //주사위 랜덤수 반환할 메소드
		System.out.println("Dice is rolled!");
		return (int)(Math.random()*6)+1; //Math.random으로 1~6까지 중에 랜덤으로 숫자 
	}
	private int getUserInput() { //사용자가 예측하는 숫자 입력 받는 메소드
		int num; //사용자가 예측한 수 저장할 변수
		System.out.println("Guess the number! What do you think?");
		num=key.nextInt(); //nextInt로 num 저장
		while(!((1<=num)&&(num<=6))) { //사용자가 1~6 외의 숫자 입력할 경우 다시 입력하라고 반복하기
			System.out.println("Input number between 1~6.");
			num=key.nextInt(); //nextInt로 다시 입력 받기
		}
		key.nextLine(); //nextLine하기 전에 엔터 한 번 제거하기
		return num; //사용자가 예측한 숫자 반환
	}
	private void checkUserGuess(int num) { //사용자가 예측한 수와 랜덤수가 같은지 비교하는 메소드
		if(diceFace==num) //예측수와 랜덤수가 같으면 Bingo! 출력
			System.out.println("Bingo!");
		else {
			System.out.println("Wrong!"); //다를 경우에는 Wrong! 출력
			System.out.println("The face was "+diceFace); //랜덤수가 뭐였는지 출력
		}
	}
	public void startPlaying() {
		System.out.println("<< GAME START >>");
		diceFace=this.rollDice(); //rollDice 메소드로 랜덤수 받아서 diceFace 저장
		this.checkUserGuess(this.getUserInput()); //checkUserGuess에 getUserInput으로 넣어 맞혔는지 출력
	}
}
public class HW1_2 {
	public static void main(String[] args) {
		DiceGame d= new DiceGame(); //DiceGame 객체 생성
		Scanner key = new Scanner(System.in); //Scanner 객체 생성
		String y_n="Y"; //사용자가 원하는만큼 반복하기 위한 y_n 변수 'Y'로 초기화
		while(y_n.equalsIgnoreCase("Y")){ //y_n가 'Y'와 다를 때까지 반복
			d.startPlaying(); //startPlaying 실행해서 게임 시작
			System.out.println("Try again?");
			y_n=key.nextLine(); //nextLine으로 y_n 입력 받기
		}
		System.out.println("Game finished.");
	}

}
