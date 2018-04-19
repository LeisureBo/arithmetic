package �ַ�����ε��;

public class Main {
	//�ַ�����
	public class HString{
		public char[] str;
		public int length;
	}
	//���ĸ�ֵ
	public void assign(HString s,HString t){
		if(s == null || t == null){
			return ;
		}
		s.length = t.length;
		s.str = new char[s.length];
		//���tΪ�յĻ���SҲΪ��
		if(t.str == null){
			s.str = null;
		//���tΪ�մ��Ļ���SҲΪ�մ�
		}else if(t.str.length == 0){
			s.str = new char[0];
		//�����Ϊ�մ��Ļ�
		}else{
			for(int i = 0;i<t.length;i++){
				s.str[i] = t.str[i];
			}
		}
	}
	//������
	public void concat(HString s,HString t){
		//��t�ַ������ӵ�s�ַ�������
		HString temp = new HString();
		//��s���ַ�������temp��holdס
		assign(temp,s);
		//�ı�s��str����ֵ�Լ�length����
		s.length = s.length+t.length;
		s.str = new char[s.length];
		//��temp�е�ֵ�Լ�t�е�ֵ��copy����
		//�ȸ�temp��ֵ
		for(int i =0;i<temp.length;i++){
			s.str[i] = temp.str[i];
		}
		//�ٸ�t��ֵ
		int index = temp.length;
		for(int i=0;i<t.length;i++){
			s.str[index++] = t.str[i];
		}
	}
	//�Ӵ���λ��ģʽƥ�䣩 
	//�ж�t����s�е��Ǹ�λ�ã�����λ��������������ǵ�ǰ���Ӵ��Ļ��ͷ���0
	public int index(HString s,HString t){
		//��һ���ַ�����ָ��
		int first = 0;
		//�ڶ����ַ�����ָ��
		int second = 0;
		//���в���
		while(first < s.length && second < t.length){
			//�����ָ��++
			if(s.str[first] == t.str[second]){
				first ++ ;
				second ++;
				//����second��0first�����ϴο�ʼ+1λ��
			}else{
				first = first - second + 1;
				second = 0;
			}
		}
		//�ж�����second�Ƿ����t����
		if(second == t.length){
			return first - second;
		}else {
			return 0;
		}
	}
	//KMP
	public int KMP(HString s,HString t){
		//���ǰ׺����
		int[] next = getNext02(t);
		//����S����
		int i = 0;
		//����T����ָ�룬��1��t.length��Ϊ0ʱ������ʾ����λ�ã����Ǳ�ʾΪ��ǰSλ���ַ�����T��λ������������
		//Ҳ���ǵ�ǰ��next[1]��ʱ�����ʱ���Ѿ���ʾ�˵�ǰû����ǰ׺
		int j = 1;
		while(i<s.length && j<=t.length){
			//��ǰ��λ��Ԫ����ȵ�ʱ�����++����,j==0����Ϊ��T������λ���Ҳ������S���鵱ǰiλ�ö�Ӧʱ��Ӧ��
			//i����ָ������++��Ȼ���ڽ��бȽϣ����0�������ʾ
			if(j == 0 || s.str[i] == t.str[j-1]){
				i++;
				j++;
				//������Ƚ��л�����������������Ϊnext�����ֵ
			}else{
				j = next[j];
			}
		}
		if(j>t.length){
			return i-t.length;
		}else{
			return 0;
		}
	}
	//ǰ׺����next
	public int[] getNext(HString t){
		//��������Ϊ�ַ������ȵ�ǰ׺����
		int[] next = new int[t.length+1];
		//�����ָ��
		int i = 1;
		//ǰ׺��������JΪ0��ʱ��û�б�Ҫ�����жϣ�˵����ǰλ�õ�ǰ׺�ͺ�׺��ȵĿ϶�û��
		int j = 0;
		//����Ϊ1λ��Ϊ0������֮���Բ���0�����ж�����Ϊ���ǵ�KMP�㷨�е���Ҫ����һλ�Ƚϵ�����
		next[1] = 0;
		while(i<t.length){
			//���ǰ׺�о����������Ϲ�ϵ�ļ��ϣ���ǰ�¼�������λ�ýڵ���ͬ�Ļ� ++����
			if( j == 0 || t.str[i-1] == t.str[j-1]){
				i++;
				j++;
				next[i] = j;
				//����
			}else{
				j = next[j];
			}
		}
		return next;
	}
	//�Ľ���ǰ׺next����
	//�������������ʱ����иĽ�
	public int[] getNext02(HString t){
		//��������Ϊ�ַ������ȵ�ǰ׺����
		int[] next = new int[t.length+1];
		//�����ָ��
		int i = 1;
		//ǰ׺��������JΪ0��ʱ��û�б�Ҫ�����жϣ�˵����ǰλ�õ�ǰ׺�ͺ�׺��ȵĿ϶�û��
		int j = 0;
		//����Ϊ1λ��Ϊ0������֮���Բ���0�����ж�����Ϊ���ǵ�KMP�㷨�е���Ҫ����һλ�Ƚϵ�����
		next[1] = 0;
		while(i<t.length){
			//���ǰ׺�о����������Ϲ�ϵ�ļ��ϣ���ǰ�¼�������λ�ýڵ���ͬ�Ļ� ++����
			if( j == 0 || t.str[i-1] == t.str[j-1]){
				i++;
				j++;
				if(t.str[i-1]!=t.str[j-1]){
					next[i] = j;
				}else{
					next[i] = next[j];
				}
				
				//����
			}else{
				j = next[j];
			}
		}
		return next;
	}
	public static void main(String[] args){
		Main m = new Main();
		HString t = m.new HString();
		//��Ϊû���ڳ�ʼ���׶θ�ֵ����Ҫ��������
		t.str = new char[]{'1','2','3','4','5'};
		t.length = t.str.length;
		HString s = m.new HString();
		m.assign(s, t);
		System.out.println("��ֵ��");
		System.out.println(s.length);
		for(int i = 0;i<s.length;i++){
			System.out.print(s.str[i]+" ");
		}
		//������
		m.concat(s, t);
		System.out.println();
		System.out.println("���ӣ�");
		System.out.println(s.length);
		for(int i = 0;i<s.length;i++){
			System.out.print(s.str[i]+" ");
		}
		System.out.println();
		HString temp = m.new HString();
		temp.length = 3;
		temp.str = new char[]{'3','4','5'};
		System.out.println(m.index(t, temp));
		System.out.println("KMP");
		HString s1 = m.new HString();
		HString s2 = m.new HString();
		s1.str = new char[]{'a','b','c','a','b','c','a','b','c','d','a','b','c','a','b',};
		s1.length = s1.str.length;
		s2.str = new char[]{'a','b','c','d'};
		s2.length = s2.str.length;
		System.out.println("����1");
		for(int i =0 ;i<s1.str.length;i++){
			System.out.print(s1.str[i]+" ");
		}
		System.out.println();
		System.out.println("����2");
		for(int i=0;i<s2.str.length;i++){
			System.out.print(s2.str[i]+" ");
		}
		System.out.println();
		System.out.println("����λ��"+m.KMP(s1, s2));
	}
}
