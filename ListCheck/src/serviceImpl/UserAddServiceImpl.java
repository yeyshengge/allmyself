package serviceImpl;

import dao.UserAddDaoInter;
import daoImpl.UserAddDaoImpl;
import entity.User;
import service.UserAddService;

public class UserAddServiceImpl implements UserAddService {
    @Override
    public void add(User user) {
        UserAddDaoInter u = new UserAddDaoImpl();
        u.add(user);
    }
}
