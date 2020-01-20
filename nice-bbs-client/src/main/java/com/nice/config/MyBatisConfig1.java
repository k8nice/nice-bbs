//package com.nice.config;
//
//import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//
//import javax.sql.DataSource;
//
////import org.omg.CORBA.PUBLIC_MEMBER;
//
///**
// * @author ningh
// */
//@Configuration
//@MapperScan(basePackages = "com.nice.config",sqlSessionTemplateRef = "sqlSessionTemplate")
//public class MyBatisConfig1 implements EnvironmentAware {
//
//    private Environment environment;
//
//    @Autowired
//    private DBConfig1 dbConfig1;
//
//    @Autowired
//    private DBConfig2 dbConfig2;
//
//    @Primary
//    @Bean(name = "dataSource")
//    public DataSource dataSource(DBConfig1 dbConfig1){
//        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
//        mysqlXADataSource.setURL(dbConfig1.getJdbcUrl());
//        mysqlXADataSource.setUser(dbConfig1.getUsername());
//        mysqlXADataSource.setPassword(dbConfig1.getPassword());
//        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
//        dataSourceBean.setXaDataSource(mysqlXADataSource);
//        return dataSourceBean;
//    }
//
//
//
//
//    @Primary
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        return bean.getObject();
//    }
//
//    @Primary
//    @Bean(name = "sqlSessionTemplate")
//    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }
//
//
//    public DataSource createDataSource() {
//        MysqlXADataSource dataSource = new MysqlXADataSource();
//        dataSource.setUser("root");
//        dataSource.setURL("jdbc:mysql://39.97.179.164:3306/nice_bbs?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
////        dataSource.set("com.mysql.jdbc.Driver");
//        dataSource.setPassword("nice");
//        return dataSource;
//    }
//
//
////    private DataSource buildDataSource() throws SQLException {
////        //分库设置
////        Map<String, DataSource> dataSourceMap = new HashMap<>(2);
////        //添加两个数据库database0和database1
////        dataSourceMap.put(dbConfig1.getDatabaseName(), dbConfig1.createDataSource());
////        dataSourceMap.put(dbConfig2.getDatabaseName(), dbConfig2.createDataSource());
////        //设置默认数据库
////        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap, dbConfig1.getDatabaseName());
////
////        //分表设置，大致思想就是将查询虚拟表Goods根据一定规则映射到真实表中去
////        TableRule orderTableRule = TableRule.builder("bbs_question")
////                .actualTables(Arrays.asList("bbs_question", "bbs_question1"))
////                .dataSourceRule(dataSourceRule)
////                .build();
////
////        //分库分表策略
////        ShardingRule shardingRule = ShardingRule.builder()
////                .dataSourceRule(dataSourceRule)
////                .tableRules(Arrays.asList(orderTableRule))
////                .databaseShardingStrategy(new DatabaseShardingStrategy("bbs_question_id", databaseShardingAlgorithm))
////                .tableShardingStrategy(new TableShardingStrategy("bbs_question_type", tableShardingAlgorithm)).build();
////        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
////        return dataSource;
////    }
////
////
////    @Bean
////    public KeyGenerator keyGenerator() {
////        return new DefaultKeyGenerator();
////    }
//
//}
