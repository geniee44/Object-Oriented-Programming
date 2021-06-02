import java.util.Scanner;
public class HW1_3 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in); //Scanner 객체 생성
		String y_n="Y"; //이용자 원하는 만큼 반복하기 위해 사용할 변수
		while(y_n.equalsIgnoreCase("Y")) { //y_n 변수가 'Y'와 다를 때까지 반복
			System.out.println("Input a word");
			String str=key.next(); //next로 단어 입력 받기
			int num=str.length(); //단어 길이 변수 num에 저장
			char a[] = new char[num]; //단어 길이만큼 배열 생성
			a=str.toCharArray(); //문자열 배열로 바꿔서 저장
			if(check(a)) //check 메소드 사용
				System.out.println("Symmetry"); //check true면 symmetry 출력
			else
				System.out.println("Asymmetry"); //check false면 asymmetry 출력
			System.out.println("\nTry again?(y/n)");
			y_n=key.next(); //next로 y_n 입력 받기
		}
	}
	public static boolean check(char[] a) { //대칭인지 확인해서 true/false 반환하는 메소드
		int num = (int)(a.length/2); //배열 길이 2로 나눠서 변수 num에 저장
		boolean tf=true; //반환할 tf 변수 true로 초기화
		for(int i=0; i<=num; i++) { //num만큼 for문으로 반복하기
			if(a[i]!=a[a.length-(i+1)]) //대칭되는 배열 원소가 같지 않을 경우에 tf false로 바꾸기
				tf=false;
		}
		return tf; //tf 반환
	}
}
