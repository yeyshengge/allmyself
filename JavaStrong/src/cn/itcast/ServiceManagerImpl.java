package cn.itcast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ServiceManagerImpl implements ServiceManager {
    @Override
    public ServiceInfo getServiceInfo(String port) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\ideaspacework\\JavaStrong\\src\\service.txt"));
        ArrayList<ServiceInfo> list = new ArrayList<>();
        String len;
        while ((len = br.readLine()) != null) {
            if (len.startsWith("#") || len.equals("")) {
                continue;
            }
            list.add(new ServiceInfo(len.split(" ")[0], len.split(" ")[1], len.split(" ")[2], len.split(" ")[3]));
        }

        for (ServiceInfo serviceInfo : list) {
            if (serviceInfo.getPort().equals(port)) {
                return serviceInfo;
            }
        }
        return null;
    }
}
