package com.xuecheng.test.freemarker;

import com.xuecheng.test.freemarker.model.Student;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by zps on 2019/12/30 11:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FreeMakerTest {

    /**
     * 根据模板跟数据生成html模板
     */
    @Test
    public void test01() throws IOException, TemplateException {
        //定义模板配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //获取模版所在路径
        String path = this.getClass().getResource("/").getPath();
        //设置文件所在目录
        configuration.setDirectoryForTemplateLoading(new File(path + "/templates"));
        //获取模板文件
        Template template = configuration.getTemplate("test1.ftl");
        //获取数据
        Map map = getMap();
        //通过FreeMarkerUtils结合模板与数据
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //InputStream inputStream = IOUtils.toInputStream(html);
        FileOutputStream fos = new FileOutputStream(new File("D:/test1.html"));
        //往文件中写数剧
        IOUtils.write(html, fos);

        fos.flush();
        fos.close();
    }

    /**
     * 根据模板内容生成html
     */
    @Test
    public void test02() throws IOException, TemplateException {
        //设置配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        //定义模板内容
        String content = "<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "名称：${name}\n" +
                "</body>\n" +
                "</html>";
        //定义模板加载器
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        //将模板添加到加载器
        stringTemplateLoader.putTemplate("test1", content);
        //给模板类设置模板
        configuration.setTemplateLoader(stringTemplateLoader);
        //加载数据
        Map map = getMap();
        //拿取模板
        Template template = configuration.getTemplate("test1", "utf-8");

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);

        //获得输入流
        InputStream inputStream = IOUtils.toInputStream(html);

        FileOutputStream fos = new FileOutputStream("D:/test1.html");
        //输入流转输出流
        IOUtils.copy(inputStream, fos);
        //关闭流
        fos.close();
        inputStream.close();


    }

    /**
     * 设置数据
     * @return
     */
    public Map getMap() {
        Map map = new HashMap();
        //往模型数据中存储一个name
        map.put("name", "黑马程序员");
        map.put("point", 123456789);
        //向数据模型放数据
        map.put("name", "黑马程序员");
        Student stu1 = new Student();
        stu1.setName("小明");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());

        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);
        stu2.setBirthday(new Date());

        List<Student> friends = new ArrayList<>();
        friends.add(stu1);
        stu2.setFriends(friends);
        stu2.setBestFriend(stu1);

        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);
        //向数据模型放数据
        map.put("stus", stus);
        //准备map数据
        HashMap<String, Student> stuMap = new HashMap<>();
        stuMap.put("stu1", stu1);
        stuMap.put("stu2", stu2);
        //向数据模型放数据
        map.put("stu1", stu1);
        //向数据模型放数据
        map.put("stuMap", stuMap);

        return map;
    }
}
