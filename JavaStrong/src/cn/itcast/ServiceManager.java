package cn.itcast;

import java.io.IOException;

/**
 * 服务管理类
 */
public interface ServiceManager {
    /**
     * 根据端口号，查询该端口号对应的应用程序相关信息
     * @param port 参数，端口号
     * @return 返回该端口号对应的ServiceInfo对象
     */
    public abstract ServiceInfo getServiceInfo(String port) throws IOException;
}
