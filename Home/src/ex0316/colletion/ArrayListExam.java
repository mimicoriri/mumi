package ex0316.colletion;

import java.util.ArrayList;
import static java.lang.System.out;

class Test{
	int a=10;
	public void aa() {}
	
}

class ArrayListExam extends ArrayList<Object> {

	// ���� Variable
	// Object Ÿ��1��, int Ÿ�� 1��;
	Object obj;
	int i;

	// Constractor
	public ArrayListExam() {
		// �ʱ� �뷮 5�� ����
		super(5);

	}

	// method
	// method�̸� ����Ÿ�� �μ�

	/*
	 * addInt ���� ����(int)1�� �ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.
	 */
	public void addInt(int a) {
		add(new Integer(a));
	}

	/*
	 * addFloat ���� �Ǽ�(float)1�� �ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.
	 */
	public void addFloat(float t) {
		add(new Float(t));
	}

	/*
	 * addString ���� String ���ڿ�1�� �ϴ��� : �μ��� ���� String �� list�� �߰�.
	 */
	public void addString(String s) {
		add(s);
		add(new Test());
	}

	/*
	 * printList ���� ���� ������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� �� �������� ���. List�� ����� �� ��ü��
	 * �ɹ������� �������� ���
	 */
	public void printList() {
		this.i = super.size();
		System.out.println("����� ����: "+i);
		for(int index=0; index<size();index++) {
			obj = super.get(index);
			out.println(obj);
		}
		////////////////////////////////
		out.println("������ for");
		for(Object o:this) {
			out.println(o);
			
		}
		
		//Test�� a������ ȣ��(����)
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
 * ������
 * 
 * list�� ����ִ� ��ü�� �� ������=3 5 5.5 newString
 * 
 * Normal Termination ��� �Ϸ� (0�� ���).
 */