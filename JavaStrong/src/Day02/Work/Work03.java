package Day02.Work;

public class Work03 {
    public static void main(String[] args) {
        String str = "aa oo pp dd ghj as jjaf adj i";
        //把字符串拆分为一个字符串数组
        String[] s = str.split(" ");
        //定义一个StringBuild数组用来存储原来的字符串数组s,sss[i] = new StringBuilder(s[i]);setCharAt方法在StringBuild中
        StringBuilder[] sss = new StringBuilder[s.length];
        //定义一个char类型的数组用来存储大写字母，应为charAt方法取出来的是char类型的
        char[] ss = new char[s.length];
        //定义一个StringBuild对象，用来拼接StringBuild数组的每个字符串，成为一个String字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            // System.out.println(s[i]);
            //提取字符串数组的每个元素的首字母存储在char数组中
            ss[i] = s[i].charAt(0);
            // System.out.println(ss[i]);
            //把char数组中的小写转为大写
            if (ss[i] <= 'z' && ss[i] >= 'a') {
                ss[i] -= 32;
            }
            //System.out.println(ss[i]);
            //把原来字符串数组转换为StringBuild数组
            sss[i] = new StringBuilder(s[i]);
            //用 char数组的ss[i]替换StringBuild数组的sss[i]中的第i个值
            sss[i].setCharAt(0, ss[i]);
            //拼接
            sb.append(sss[i]).append(" ");
        }
        System.out.println(sb);
    }
}
