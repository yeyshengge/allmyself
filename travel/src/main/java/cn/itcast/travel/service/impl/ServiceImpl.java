package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDaoInter;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.ServiceInter;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class ServiceImpl implements ServiceInter {
    private UserDaoInter u = new UserDaoImpl();

    /**
     * 将注册信息保存在数据库
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User user1 = u.findByUsername(user.getUsername());
        if (user1 == null) {
            //给status code 赋值
            user.setStatus("Y");
            user.setCode(UuidUtil.getUuid());
            u.save(user);
            //邮件内容
            String content = "<a href='http://60.205.184.10:8080/travel/user/active?code=" + user.getCode() + "'>欢迎注册，点我激活</a>";
            //发送邮件
            MailUtils.sendMail(user.getEmail(), content, "激活旅游网");
            return true;
        }
        return false;
    }

    @Override
    public boolean active(String code) {
        User user = u.findByCode(code);
        if (user != null) {
            //说明存在
            u.updataStatus(user);
            return true;
        } else {
            //不存在
            return false;
        }
    }

    @Override
    public User login(User user) {
        User user1 = u.checkUsernameAndPassword(user);
        return user1;
    }
}
