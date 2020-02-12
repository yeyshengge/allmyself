package Day07.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
1.1． 从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。
如果该年没有举办世界杯，则输出：没有举办世界杯。
//tips:参阅Map接口containsKey(Object key)方法
1.2． 在原有世界杯Map 的基础上，增加如下功能： 读入一支球队的名字，输出该球队夺冠的年份列表。
例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯
			//tips:参阅Map接口containsValue(Object value)方法
示例：
届数	   举办年份	举办地点	冠军
第一届   1930年	乌拉圭	乌拉圭
第二届	1934年	意大利	意大利
第三届	1938年	法国	    意大利
第四届	1950年	巴西	    乌拉圭
第五届	1954年	瑞士	    西德
第六届	1958年	瑞典	    巴西
第七届	1962年	智利	    巴西
第八届	1966年	英格兰	英格兰
第九届	1970年	墨西哥	巴西
第十届	1974年	前西德	西德
第十一届	1978年	阿根廷	阿根廷
第十二届	1982年	西班牙	意大利
第十三届	1986年	墨西哥	阿根廷
第十四届	1990年	意大利	西德
第十五届	1994年	美国	    巴西
第十六届	1998年	法国	    法国
第十七届	2002年	韩日	    巴西
第十八届	2006年	德国	    意大利
第十九届	2010年	南非	    西班牙
第二十届	2014年	巴西	    德国

 */
public class Subject1_1 {
    public static void main(String[] args) {
        ShiJieBei s1 = new ShiJieBei("第一届", "乌拉圭", "乌拉圭");
        ShiJieBei s2 = new ShiJieBei("第二届", "意大利", "意大利");
        ShiJieBei s3 = new ShiJieBei("第三届", "法国", "意大利");
        ShiJieBei s4 = new ShiJieBei("第四届", "巴西", "乌拉圭");
        ShiJieBei s5 = new ShiJieBei("第五届", "瑞士", "西德");
        ShiJieBei s6 = new ShiJieBei("第六届", "瑞典", "巴西");
        ShiJieBei s7 = new ShiJieBei("第七届", "智利", "巴西");
        ShiJieBei s8 = new ShiJieBei("第八届", "英格兰", "英格兰");
        ShiJieBei s9 = new ShiJieBei("第九届", "墨西哥", "巴西");
        ShiJieBei s10 = new ShiJieBei("第十届", "前西德", "西德");
        ShiJieBei s11 = new ShiJieBei("第十一届", "阿根廷", "阿根廷");
        ShiJieBei s12 = new ShiJieBei("第十二届", "西班牙", "意大利");
        ShiJieBei s13 = new ShiJieBei("第十三届", "墨西哥", "阿根廷");
        ShiJieBei s14 = new ShiJieBei("第十四届", "意大利", "西德");
        ShiJieBei s15 = new ShiJieBei("第十五届", "美国", "巴西");
        ShiJieBei s16 = new ShiJieBei("第十六届", "法国", "法国");
        ShiJieBei s17 = new ShiJieBei("第十七届", "韩日", "巴西");
        ShiJieBei s18 = new ShiJieBei("第十八届", "德国", "意大利");
        ShiJieBei s19 = new ShiJieBei("第十九届", "南非", "西班牙");
        ShiJieBei s20 = new ShiJieBei("第二十届", "巴西", "德国");

        HashMap<String, ShiJieBei> map = new HashMap<>();
        map.put("1930年", s1);
        map.put("1934年", s2);
        map.put("1938年", s3);
        map.put("1950年", s4);
        map.put("1954年", s5);
        map.put("1958年", s6);
        map.put("1962年", s7);
        map.put("1966年", s8);
        map.put("1970年", s9);
        map.put("1974年", s10);
        map.put("1978年", s11);
        map.put("1982年", s12);
        map.put("1986年", s13);
        map.put("1990年", s14);
        map.put("1994年", s15);
        map.put("1998年", s16);
        map.put("2002年", s17);
        map.put("2006年", s18);
        map.put("2010年", s19);
        map.put("2014年", s20);

        System.out.println(map);

        //1.1． 从命令行读入一个字符串，表示一个年份，输出该年的世界杯冠军是哪支球队。
        //如果该年没有举办世界杯，则输出：没有举办世界杯。

        Scanner input = new Scanner(System.in);
        /*System.out.println("请输入年份(后面加单位年)：");
        String year = input.nextLine();
        if (map.containsKey(year)) {
            System.out.println("第" + year + "的冠军是" + map.get(year).getChampion());
        } else {
            System.out.println("没有举办世界杯");
        }*/

        //1.2． 在原有世界杯Map 的基础上，增加如下功能： 读入一支球队的名字，输出该球队夺冠的年份列表。
        //例如，读入“巴西”，应当输出 1958 1962 1970 1994 2002 读入“荷兰”，应当输出 没有获得过世界杯
        //			//tips:参阅Map接口containsValue(Object value)方法
        //示例：

        int index =0;
        System.out.println("请输入球队名称");
        String b =input.nextLine();
        Set<Map.Entry<String, ShiJieBei>> en = map.entrySet();
        for(Map.Entry<String, ShiJieBei> s :en){
           // System.out.println(s.getValue().getChampion());
           if( s.getValue().getChampion().equals(b)){
               index++;
               System.out.println(s.getKey());
           }
        }
        if(index==0){
            System.out.println(" 没有获得过世界杯");
        }

    }
}
