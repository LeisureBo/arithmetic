package ջ��ʵ��.˳��;

import java.util.Stack;

public class Main {
	public static final int MAXSIZE = 100;

	public SeqStack s;// ȫ�ֱ�����ǰ������ջ

	// ��ǰջ�࣬���������ǰջ�Ĵ洢���飬�Լ���ǰջ��ָ��һֱָ��ǰ���һ��Ԫ��
	public class SeqStack {
		// ָ��
		public int[] data = new int[MAXSIZE];
		public int top;
	}

	// ջ�ĳ�ʼ��
	public SeqStack seqStackinit() {
		// ��ʼ��һ����ջ
		s = new SeqStack();
		s.top = -1;// ��ʼ�����ջ��ָ��ָ��-1��ʾ��ǰ����û���κ�Ԫ��
		return s;
	}

	// �ж�ջ��
	public boolean SeqStackEmpty() {
		if (s == null || s.top == -1) {
			return true;
		} else {
			return false;
		}
	}

	// ��ջ
	public void SeqStackPush(int number) {
		if (s == null) {
			System.out.println("ջδ��ʼ��!");
		} else {
			if (s.top == MAXSIZE - 1) {
				System.out.println("ջ��");
				return;
			} else {
				// ��ջ
				s.top++;
				s.data[s.top] = number;
			}
		}
	}

	// ��ջ
	public int SeqStackPop() {
		if (s == null) {
			System.out.println("ջδ��ʼ��!");
			return -1; // ��ǰջδ��ʼ���Ĵ����־
		} else {
			if (s.top == -1) {
				System.out.println("ջ��");
				return -2; // ��ǰջ�յĴ����־
			} else {
				int index = s.top;
				s.top--;
				return s.data[index];
			}
		}
	}

	// ȡջ��Ԫ��
	public int SeqStackGetTop() {
		if (s == null) {
			System.out.println("ջδ��ʼ��!");
			return -1;// ��ǰջδ��ʼ���Ĵ����־
		} else {
			if (s.top != -1) {
				return s.data[s.top];
			} else {
				return -2;// ��ǰջ�յĴ����־
			}
		}
	}

	// ���ջ����
	public void SeqStackClean() {
		if (s == null) {
			return;
		} else {
			s.top = -1;// �õ�ǰָ��ָ��-1λ��
		}
	}

	// ��ǰջ����
	public int SeqStackSize() {
		if (s == null) {
			System.out.println("ջδ��ʼ��!");
			return -1;
		} else {
			return s.top + 1;
		}
	}

	// ����ת�� �˴�Ϊʮ����ת��Ϊ8���ƣ���������ת��˼·��ͬ
	public void convert(int number) {
		seqStackinit();// ��ʼ��һ��ջ
		// ���Ͻ���ת��֮��ѹջ
		while (number != 0) {
			SeqStackPush(number % 8);
			number /= 8;
		}
		// ջ��Ϊ��ʱ��ջ
		while (!SeqStackEmpty()) {
			System.out.print(SeqStackPop() + " ");
		}
	}

	// �ж��������ʽ�����Ƿ�ƥ��
	public void Match(String ex) {
		if (ex == null || ex.length() == 0) {
			return;
		} else {
			seqStackinit();// ��ʼ��һ��ջ
			for (int i = 0; i < ex.length(); i++) {
				char temp = ex.charAt(i);
				switch (temp) {
				case '{':
					SeqStackPush(temp);
					break;
				case '}':
					if (SeqStackGetTop() != '{') {
						System.out.println("���ʽ��ƥ��");
						return;
					} else {
						SeqStackPop();
						break;
					}
				case '[':
					SeqStackPush(temp);
					break;
				case ']':
					if (SeqStackGetTop() != '[') {
						System.out.println("���ʽ��ƥ��");
						return;
					} else {
						SeqStackPop();
						break;
					}
				case '(':
					SeqStackPush(temp);
					break;
				case ')':
					if (SeqStackGetTop() != '(') {
						System.out.println("���ʽ��ƥ��");
						return;
					} else {
						SeqStackPop();
						break;
					}
				}
			}
			System.out.println("��ǰ���ʽ��ȷ");
		}
	}

	// ���ʽ��ֵ
	public int CalculExp(String ex) {
		if (ex == null || ex.length() == 0) {
			return -10000000;// ��ǰ�������ı�־
		} else {
			Stack<Integer> number = new Stack<Integer>();
			Stack<Character> operator = new Stack<Character>();
			for (int i = 0; i < ex.length(); i++) {
				if (ex.charAt(i) >= '0' && ex.charAt(i) <= '9') {
					number.push(Integer.parseInt(String.valueOf(ex.charAt(i))));
				} else if (ex.charAt(i) == '(') {
					operator.push(ex.charAt(i));
				} else if (ex.charAt(i) == ')') {
					while (operator.peek() != '(') {
						char temp = operator.pop();
						int number1 = number.pop();
						int number2 = number.pop();
						if (temp == '+') {
							number.push(number1 + number2);
						} else if (temp == '-') {
							number.push(number1 - number2);
						} else if (temp == '*') {
							number.push(number1 * number2);
						} else {
							number.push(number1 / number2);
						}
					}
					operator.pop();// �����һ�����ų�ջ
				} else if (ex.charAt(i) == '+' || ex.charAt(i) == '-') {
					if (operator.size() == 0) {
						operator.push(ex.charAt(i));
					} else {
						if (operator.peek() == '*' || operator.peek() == '/') {
							int number1 = number.pop();
							int number2 = number.pop();
							if (operator.peek() == '*') {
								number.push(number1 * number2);
							} else {
								number.push(number1 / number2);
							}
							operator.pop();
						}
						operator.push(ex.charAt(i));
					}
				} else {
					operator.push(ex.charAt(i));
				}
			}
			while (operator.size() != 0) {
				int number1 = number.pop();
				int number2 = number.pop();
				if (operator.peek() == '+') {
					number.push(number1 + number2);
					operator.pop();
				} else if (operator.peek() == '-') {
					number.push(number2 - number1);
					operator.pop();
				} else if (operator.peek() == '*') {
					number.push(number1 * number2);
					operator.pop();
				} else {
					number.push(number2 / number1);
					operator.pop();
				}
			}
			return number.pop();
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.seqStackinit();// ��ʼ��
		System.out.println(m.SeqStackEmpty());// �ж�ջ�Ƿ�Ϊ��
		m.SeqStackPush(10);// ��ջ
		m.SeqStackPush(20);
		System.out.println(m.SeqStackPop());// ��ջ
		System.out.println(m.SeqStackSize());// ��ǰջ����
		System.out.println(m.SeqStackGetTop());// ȡջ��Ԫ��
		m.SeqStackClean();// ��յ�ǰջ
		System.out.println(m.SeqStackSize());
		m.convert(1600);
		m.Match("((a+b+[[c+d]]))");
		System.out.println(m.CalculExp("1+(3+5*8)-8*2"));
	}
}
