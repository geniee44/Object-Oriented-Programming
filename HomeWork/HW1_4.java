import java.util.Scanner;
class StudentInformation{
	private String id; //학생 id 저장할 변수
	private String name; //학생 이름 저장할 변수
	public void setID(String id) {
		this.id=id;
	}//id의 setter 메소드
	public void setName(String name) {
		this.name=name;
	}//name의 setter 메소드
	public String getID() {
		return id;
	}//id의 getter 메소드
	public String getName() {
		return name;
	}//name의 getter 메소드
	public void display() {
		System.out.printf("%n%-15s%-10s", name, id);
	}//이름과 id를 출력하는 메소드
}
class StudentScore extends StudentInformation{ //StudentInformation 클래스를 상속
	private int korean; //국어점수 저장할 변수
	private int math; //수학 점수 저장할 변수
	private int english; //영어 점수 저장할 변수
	public int sum=0; //평균 점수 저장할 변수 0으로 초기화
	public double avg; //평균 점수 저장할 변수
	public void setKorean(int korean) {
		this.korean=korean;
	}//korean의 setter 메소드
	public void setMath(int math) {
		this.math=math;
	}//math의 setter 메소드
	public void setEnglish(int english) {
		this.english=english;
	}//english의 setter 메소드
	public int getKorean() {
		return korean;
	}//korean의 getter 메소드
	public int getMath() {
		return math;
	}//math의 getter 메소드
	public int getEnglish() {
		return english;
	}//english의 getter 메소드
	public void display() { //조상 클래스의 diplay 메소드 오버라이딩
		super.display(); //super로 조상 클래스 메소드 부르기
		System.out.printf("%-10d%-10d%-10d", korean, math, english); //국어, 수학, 영어 점수 출력
	}
}
public class HW1_4 {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in); //Scanner 객체 생성
		System.out.println("How many students are there?");
		int len=key.nextInt(); //nextInt로 학생 수 입력받기
		StudentScore[] s = new StudentScore[len]; //학생 수 만큼 인스턴스 배열 생성
		System.out.println("Input the informaiton.");
		double k=0, m=0, e=0; //국어, 수학, 영어 점수 평균 낼 변수 선언
		
		for(int i=0; i<len; i++) { //학생 수만큼 for문으로 반복해서 학생 정보 입력 받기
			key.nextLine();
			s[i]=new StudentScore(); //객체 생성
			System.out.print("\nID: ");
			s[i].setID(key.nextLine()); //nextLine으로 ID 입력 받기
			System.out.print("Name: ");
			s[i].setName(key.nextLine()); //반복
			System.out.print("Korean: ");
			s[i].setKorean(key.nextInt()); //nextInt로 국어 점수 입력 받기
			System.out.print("Math: ");
			s[i].setMath(key.nextInt()); //반복
			System.out.print("English: ");
			s[i].setEnglish(key.nextInt()); //반복
			k+=s[i].getKorean(); //k에 국어 점수 더해서 총점 내기
			m+=s[i].getMath(); //반복
			e+=s[i].getEnglish(); //반복
			s[i].sum=s[i].getKorean()+s[i].getMath()+s[i].getEnglish(); //학생 총점 저장하는 변수 sum에 모든 점수 더하기
			s[i].avg=(double)(s[i].sum)/3; //총점 3으로 나눠서 평균값 내기
		}
		k/=len; //총합 구한 국어 점수 학생 수 만큼 나눠서 평균 내기
		m/=len; //반복
		e/=len; //반복
		System.out.printf("%n%-15s%-10s%-10s%-10s%-10s%-10s%-10s", "NAME", "ID", "KOREAN", "MATH", "ENGLISH", "SUM", "AVG");
		for(int i=0; i<len; i++) { //for문으로 학생 수만큼 반복
			s[i].display(); //display 메소드로 학생 정보, 점수 출력
			System.out.printf("%-10d%-8.2f", s[i].sum, s[i].avg); //학생의 총점과 평균 출력
		}
		System.out.printf("%n%-25s%-10.2f%-10.2f%-10.2f", "Subject Avg", k, m, e); //국어, 수학, 영어 각각 평균 점수 출력
		
		System.out.println("\n\n<Students over the average>");
		System.out.println("\nKorean:");
		for(int i=0; i<len; i++) { //for문으로 학생 수만큼 반복
			if(s[i].getKorean()>=k) //학생의 국어 점수가 평균보다 넘을 경우에 학생 이름 출력
				System.out.print(s[i].getName()+"\t");
		}
		System.out.println("\nMath:"); //국어 점수로 반복
		for(int i=0; i<len; i++) {
			if(s[i].getMath()>=m)
				System.out.print(s[i].getName()+"\t");
		}
		System.out.println("\nEnglish:"); //영어 점수로 반복
		for(int i=0; i<len; i++) {
			if(s[i].getEnglish()>=e)
				System.out.print(s[i].getName()+"\t");
		}
	}
}
