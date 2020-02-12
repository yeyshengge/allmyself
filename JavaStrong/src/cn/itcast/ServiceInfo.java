package cn.itcast;

/**
 * 请补充完整实体类ServiceInfo，用来封装文件中每一行数据
 */
public class ServiceInfo {
    private String name;
    private String ip;
    private String port;
    private String appname;

    public ServiceInfo() {
    }

    public ServiceInfo(String name, String ip, String port, String appname) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.appname = appname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", appname='" + appname + '\'' +
                '}';
    }
}
