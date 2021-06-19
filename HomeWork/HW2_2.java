import java.util.*;
import java.util.Scanner;

public class HW2_2 {
	public static void main(String[] args) {
		LinkedList<String> stack = new LinkedList<String>(); //String형태로 LinkedList stack 생성
		Scanner key = new Scanner(System.in); //Scanner 객체 생성
		while(true) { //사용자가 원할 때까지 반복하기 위해 while true 사용
			boolean tf = true; //)}]가 먼저 나오는 경우에 correct 방지하기 위해 쓰이는 변수
			System.out.print("Input: ");
			String s = key.next(); //next()로 괄호 입력 받기
			if(s.equals("0")) break; //0 입력했을 경우 while문 나가서 반복 종료
			String[] array = s.split(""); //입력 받은 괄호들을 하나씩 분리해 array에 저장
			for(int i=0; i<array.length; i++) { //array 길이만큼 반복
				if(array[i].equals("(")) //입력 값이 (와 같을 경우 stack에 push
					stack.push(array[i]);
				else if(array[i].equals("{")) //{로 반복
					stack.push(array[i]);
				else if(array[i].equals("[")) //[로 반복
					stack.push(array[i]);
				
				else if(array[i].equals(")")){ //)와 같을 경우는 stack 짝이 맞는지 확인
					if(!stack.isEmpty()) { //stack 비어있을 수 있기 때문에 확인하기
						if(!(stack.pop().equals("("))) {
							System.out.println("Incorrect\n");
							break; //짝이 안맞을 경우 안맞다고 출력하고 for문 나가기
						}
					}
					else { //stack 비어있을 경우 짝 안맞음
						System.out.println("Incorrect\n");
						tf=false; //tf를 false로 바꿔 마지막에 Correct 출력 안되도록 하기
						break;
					}
				}
				else if(array[i].equals("}")){ //}로 반복
					if(!stack.isEmpty()) {
						if(!(stack.pop().equals("{"))) {
							System.out.println("Incorrect\n");
							break;
						}
					}
					else {
						System.out.println("Incorrect\n");
						tf=false;
						break;
					}
				}
				else if(array[i].equals("]")){ //]로 반복
					if(!stack.isEmpty()) {
						if(!(stack.pop().equals("["))) {
							System.out.println("Incorrect\n");
							break;
						}
					}
					else {
						System.out.println("Incorrect\n");
						tf=false;
						break;
					}
				}
				else {
					System.out.println("Wrong Input\n"); //괄호 외의 문자 입력시에 출력
					tf=false;
					break;
				}
			}
			if(stack.isEmpty()&&tf) //짝 맞추기 끝난 후 stack이 비어있고 tf가 true인 경우 correct 출력
				System.out.println("Correct\n");
			else
				stack.clear();//stack 비워져있지 않은 경우 clear하기
		}
		System.out.println("Program finished"); //0입력하여 while문 나왔을 경우 실행 종료
	}
}
