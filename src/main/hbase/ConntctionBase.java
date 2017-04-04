package main.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * Created by Administrator on 2017/4/3 0003.
 */
public class ConntctionBase {

    private HBaseAdmin admin = null;
    // 定义配置对象HBaseConfiguration
    private HBaseConfiguration cfg = null;

    public ConntctionBase() throws Exception {
        Configuration HBASE_CONFIG = new Configuration();

        HBASE_CONFIG.set("hbase.zookeeper.quorum", "192.168.40.131");

        HBASE_CONFIG.set("hbase.zookeeper.property.clientPort", "2181");

        cfg = new HBaseConfiguration(HBASE_CONFIG);

        admin = new HBaseAdmin(cfg);
    }


}
