package ex0316.colletion;

import java.util.ArrayList;
import static java.lang.System.out;

class Test{
	int a=10;
	public void aa() {}
	
}

class ArrayListExam extends ArrayList<Object> {

	// 전역 Variable
	// Object 타입1개, int 타입 1개;
	Object obj;
	int i;

	// Constractor
	public ArrayListExam() {
		// 초기 용량 5개 생성
		super(5);

	}

	// method
	// method이름 리턴타입 인수

	/*
	 * addInt 없음 정수(int)1개 하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.
	 */
	public void addInt(int a) {
		add(new Integer(a));
	}

	/*
	 * addFloat 없음 실수(float)1개 하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.
	 */
	public void addFloat(float t) {
		add(new Float(t));
	}

	/*
	 * addString 없음 String 문자열1개 하는일 : 인수로 받은 String 을 list에 추가.
	 */
	public void addString(String s) {
		add(s);
		add(new Test());
	}

	/*
	 * printList 없음 없음 정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력. List에 저장된 각 객체를
	 * 맴버변수에 저장한후 출력
	 */
	public void printList() {
		this.i = super.size();
		System.out.println("저장된 개수: "+i);
		for(int index=0; index<size();index++) {
			obj = super.get(index);
			out.println(obj);
		}
		////////////////////////////////
		out.println("개선된 for");
		for(Object o:this) {
			out.println(o);
			
		}
		
		//Test의 a변수를 호출(접근)
		if(obj instanceof Test) {
			Test tt = (Test)obj;
			tt.aa();
			out.println(tt.a);
		}
	}

	public static void main(String args[]) {
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");
		list.addInt(5);
		list.addFloat(5.5f);
		list.addString(s);
		list.printList();
	}
}

/*
 * 실행결과
 * 
 * list에 들어있는 객체의 총 개수는=3 5 5.5 newString
 * 
 * Normal Termination 출력 완료 (0초 경과).
 */