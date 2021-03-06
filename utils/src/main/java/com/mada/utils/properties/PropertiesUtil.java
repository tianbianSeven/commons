package com.mada.utils.properties;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther: madali
 * @Date: 2018/8/28 20:25
 */
@Log4j2
public class PropertiesUtil {

    /**
     * 路径说明：
     * path不以’/'开头时，默认是从此类所在的包下取资源；
     * path  以’/'开头时，则是从ClassPath根下获取；
     * <p>
     * 具体文件和代码的位置是，代码在src/main/java目录下，资源文件在src/main/resources/目录下。
     * 会从当前类的目录下去找，这个文件如果不和该类在一个目录下，就找不到。
     * 会从编译后的整个classes目录下去找，maven也会把资源文件打包进classes文件夹，所以可以找到。
     * ClassLoader就是从整个classes文件夹找的，所以前面无需再加/。
     */
    private static final String CONFIG_PATH = "zk.properties";
    private static final String CONFIG_PATH2 = "/zk/zk.properties";

    private static Properties properties = new Properties();
    private static Properties properties2 = new Properties();

    static {
        try {
            // 读取resources路径下的文件
            InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(CONFIG_PATH);
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("加载:{}配置文件失败", CONFIG_PATH, e);
        }

        try {
            // 读取resources/zk路径下的文件
            InputStream inputStream2 = PropertiesUtil.class.getResourceAsStream(CONFIG_PATH2);
            properties2.load(inputStream2);
        } catch (IOException e) {
            log.error("加载:{}配置文件失败", CONFIG_PATH2, e);
        }
    }

    public static String getValue(String propertiesKey) {
        return properties.getProperty(propertiesKey);
    }

}
