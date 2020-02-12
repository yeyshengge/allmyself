import com.zps.domain.Province;
import com.zps.service.SericeInter;
import com.zps.service.serviceImpl.ServinceImpl;

import java.util.List;

public class myTest {
    public static void main(String[] args) {
        SericeInter s = new ServinceImpl();
        List<Province> all = s.findAll();
        for (Province province : all) {
            System.out.println(province.getName() + ":" + province.getId());
        }

    }
}
