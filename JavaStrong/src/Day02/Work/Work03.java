package Day02.Work;

public class Work03 {
    public static void main(String[] args) {
        String str = "aa oo pp dd ghj as jjaf adj i";
        //���ַ������Ϊһ���ַ�������
        String[] s = str.split(" ");
        //����һ��StringBuild���������洢ԭ�����ַ�������s,sss[i] = new StringBuilder(s[i]);setCharAt������StringBuild��
        StringBuilder[] sss = new StringBuilder[s.length];
        //����һ��char���͵����������洢��д��ĸ��ӦΪcharAt����ȡ��������char���͵�
        char[] ss = new char[s.length];
        //����һ��StringBuild��������ƴ��StringBuild�����ÿ���ַ�������Ϊһ��String�ַ���
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            // System.out.println(s[i]);
            //��ȡ�ַ��������ÿ��Ԫ�ص�����ĸ�洢��char������
            ss[i] = s[i].charAt(0);
            // System.out.println(ss[i]);
            //��char�����е�СдתΪ��д
            if (ss[i] <= 'z' && ss[i] >= 'a') {
                ss[i] -= 32;
            }
            //System.out.println(ss[i]);
            //��ԭ���ַ�������ת��ΪStringBuild����
            sss[i] = new StringBuilder(s[i]);
            //�� char�����ss[i]�滻StringBuild�����sss[i]�еĵ�i��ֵ
            sss[i].setCharAt(0, ss[i]);
            //ƴ��
            sb.append(sss[i]).append(" ");
        }
        System.out.println(sb);
    }
}
