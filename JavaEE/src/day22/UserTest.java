package day22;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class UserTest {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setGender("男");


        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);//把数据转换成json数据的字符串类型
        // System.out.println(s);
        mapper.writeValue(new File("D:\\ideaspacework\\JavaEE\\src\\day22\\a.txt"), user);

    }
}
