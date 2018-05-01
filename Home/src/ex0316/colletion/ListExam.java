package ex0316.colletion;

import java.util.ArrayList;
import java.util.List;

public class ListExam {

	List<String> list = new ArrayList<String>(5); //10개 공간
	/**
	 * 데이터 추가
	 * */
	public void addList(String [] args) {
		for(String s:args) {
			list.add(s);
		}
	}
	
	/**
	 * 데이터 출력
	 * */
	public void printList() {
		for(int i=0; i<list.size();i++) {
			String s=list.get(i);
			System.out.println(s);
		}
	}
	
	/**
	 * list관련 메소드 test
	 */
	
	public void listMethod() {
		//1.존재유무 체크
		if(list.contains("이효리")) {
			System.out.println("있다");
		}else {
			System.out.println("없다");
		}
		//2. 이효리가 몇번지에 있는지 체크
		int index = list.indexOf("이효리");
		System.out.println("index: "+ index);
		//3. 3번지 항목 제거하기
		String s= list.remove(3);
		System.out.println("삭제: "+ s);
		this.printList();

		//4. "이효리 제거"
		list.remove("이효리");
		this.printList();

		//5. 2번지에 있는 데이터 "안녕" 교체하기
		list.set(2,"안녕");
		//6. 3번지에 "이나영" 삽입하기
		list.add(3,"이나영");
		this.printList();

		//7. 1~3번지 사이의 데이터 추출하기
		List<String> subList=list.subList(0, 3);
		System.out.print(subList);
		
	}
	
	public static void main(String[] args) {
		ListExam le = new ListExam();
		le.addList(args);
		le.printList();
		le.listMethod();
	}

}
