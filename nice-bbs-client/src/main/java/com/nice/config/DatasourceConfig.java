//package com.nice.config;
//
//import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
//import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingAlgorithm;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingAlgorithm;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
//import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
//import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class DatasourceConfig {
//
//    @Autowired
//    private MyBatisConfig1 dbConfig1;
//
//    @Autowired
//    private MyBatisConfig2 dbConfig2;
//
//    @Autowired
//    private DatabaseShardingAlgorithm databaseShardingAlgorithm;
//
//    @Autowired
//    private TableShardingAlgorithm tableShardingAlgorithm;
//
//    private DataSource buildDataSource() throws SQLException {
//    //分库设置
//    Map<String, DataSource> dataSourceMap = new HashMap<>(2);
//    //添加两个数据库database0和database1
//    dataSourceMap.put("ds0", dbConfig1.createDataSource());
//    dataSourceMap.put("ds1", dbConfig2.createDataSource());
//    //设置默认数据库
//    DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, "ds0");
//
//    //分表设置，大致思想就是将查询虚拟表Goods根据一定规则映射到真实表中去
//    TableRule orderTableRule = TableRule.builder("bbs_question")
//            .actualTables(Arrays.asList("bbs_question", "bbs_question1"))
//            .dataSourceRule(dataSourceRule)
//            .build();
//
//        //分库分表策略
//        ShardingRule shardingRule = ShardingRule.builder()
//                .dataSourceRule(dataSourceRule)
//                .tableRules(Arrays.asList(orderTableRule))
//                .databaseShardingStrategy(new DatabaseShardingStrategy("bbs_question_id", (SingleKeyDatabaseShardingAlgorithm<?>) databaseShardingAlgorithm))
//                .tableShardingStrategy(new TableShardingStrategy("bbs_question_type", (SingleKeyTableShardingAlgorithm<?>) tableShardingAlgorithm)).build();
//        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
//        return dataSource;
//    }
//
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new DefaultKeyGenerator();
//    }
//
//}
