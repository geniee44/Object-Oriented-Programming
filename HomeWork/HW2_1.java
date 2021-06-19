import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;


public class HW2_1 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in); //스캐너 객체 생성
		Scanner inputStream = null; //파일 읽어올 inputStream 만들기
		PrintWriter outputStream=null; //파일 새로 쓸 outputStream 만들기
		System.out.println("Input the filename to read.");
		String oriFile = key.next(); //next()로 읽을 파일 이름 입력 받기
		System.out.println("Input the filename to write");
		String newFile = key.next(); //next()로 새로 생성할 파일 이름 입력 받기
		try {
			inputStream = new Scanner(new File(oriFile)); //inputStream으로 파일 열기
		}
		catch(FileNotFoundException e) { //파일 오픈에 에러 생겼을 경우 핸들링
			System.out.println(e.getMessage());
			System.exit(1); //에러 생겼을 경우 실행 종료
		}
		try {
			outputStream = new PrintWriter(newFile); //outPutStream으로 파일 생성
		}
		catch(IOException e) { //파일 생성에 에러 생겼을 경우 핸들링
			System.out.println("File output Exception");
			System.exit(1); //강제 종료
		}
		while(inputStream.hasNextLine()) { //기존 파일의 내용 끝날 때까지 반복
			String line = inputStream.nextLine(); //line에 파일의 한 줄 전체 저장
			StringTokenizer st = new StringTokenizer(line, " ,\n");
			//StringTokenizer로 space comma \n 분리자로 하여 st에 저장
			while(st.hasMoreTokens()) { //st에 token 있을 동안 반복
				outputStream.println(st.nextToken()); //다음 token을 outputStream으로 새 파일에 출력
			}
		}
		System.out.println(newFile+" is generated."); //파일 생성, 입력 모두 완료됐다고 프린트
		inputStream.close(); //두 스트림 모두 close
		outputStream.close();
	}
}
