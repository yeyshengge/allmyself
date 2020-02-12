package com.zps;

public class StringTest {
    public static void main(String[] args) {
        /*
        电影名***2019年动画喜剧《愤怒的小鸟2》BD国英双语双字
日期***  日期：2019-10-29 22:31:11 点击：0
我是电影名---愤怒的小鸟2 1080p BD国英双语双字 2019年动画喜剧
我是佚名---译　　名　愤怒的小鸟2/愤怒的小鸟大电影2/愤怒鸟大电影2(港)/愤怒鸟玩电影2(台)
我是片名---片　　名　The Angry Birds Movie 2/Angry Birds 2
我是年代---年　　代　2019
我是产地---产　　地　芬兰/美国
我是类别---类　　别　喜剧/动画/冒险
我是语言---语　　言　英语
我是字幕---字　　幕　中英双字幕
我是上映时间---上映日期　2019-08-14(美国)/2019-08-16(中国)
我是豆瓣评分---豆瓣评分　7.2/10 from 14926 users
我是片长---片　　长　96分钟
我是导演---导　　演　图鲁普·范·奥尔曼 Thurop Van Orman
我是主演---主　　演　杰森·苏戴奇斯 Jason Sudeikis
         */
        String str = "  日期：2019-10-29 22:31:11 点击：0";
        System.out.println(str.substring(5,24));
    }
}
