package ex0316.colletion;

import java.util.ArrayList;
import java.util.List;

public class ListExam {

	List<String> list = new ArrayList<String>(5); //10�� ����
	/**
	 * ������ �߰�
	 * */
	public void addList(String [] args) {
		for(String s:args) {
			list.add(s);
		}
	}
	
	/**
	 * ������ ���
	 * */
	public void printList() {
		for(int i=0; i<list.size();i++) {
			String s=list.get(i);
			System.out.println(s);
		}
	}
	
	/**
	 * list���� �޼ҵ� test
	 */
	
	public void listMethod() {
		//1.�������� üũ
		if(list.contains("��ȿ��")) {
			System.out.println("�ִ�");
		}else {
			System.out.println("����");
		}
		//2. ��ȿ���� ������� �ִ��� üũ
		int index = list.indexOf("��ȿ��");
		System.out.println("index: "+ index);
		//3. 3���� �׸� �����ϱ�
		String s= list.remove(3);
		System.out.println("����: "+ s);
		this.printList();

		//4. "��ȿ�� ����"
		list.remove("��ȿ��");
		this.printList();

		//5. 2������ �ִ� ������ "�ȳ�" ��ü�ϱ�
		list.set(2,"�ȳ�");
		//6. 3������ "�̳���" �����ϱ�
		list.add(3,"�̳���");
		this.printList();

		//7. 1~3���� ������ ������ �����ϱ�
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
