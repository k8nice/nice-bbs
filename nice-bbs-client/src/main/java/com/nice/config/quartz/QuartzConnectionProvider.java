package com.nice.config.quartz;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.quartz.SchedulerException;
import org.quartz.utils.ConnectionProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.SQLException;

public class QuartzConnectionProvider implements ConnectionProvider {


    public static final String QUARTZ_DATASOURCE_PREFIX = "spring.quartz.properties.org.quartz.dataSource.quartzDS.";

    //JDBC驱动
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"driver}")
    public String driver;

    //JDBC连接串
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"URL}")
    public String URL;

    //数据库用户名
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"user}")
    public String user;

    //数据库用户密码
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"password}")
    public String password;

    //数据库最大连接数
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"maxConnection}")
    public int maxConnection;


    //数据库SQL查询每次连接返回执行到连接池，以确保它仍然是有效的。
    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"validationQuery}")
    public String validationQuery;

    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"validateOnCheckout}")
    private boolean validateOnCheckout;

    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"idleConnectionValidationSeconds}")
    private int idleConnectionValidationSeconds;

    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"maxCachedStatementsPerConnection}")
    public String maxCachedStatementsPerConnection;

    @Value("${"+QUARTZ_DATASOURCE_PREFIX+"discardIdleConnectionsSeconds}")
    private String discardIdleConnectionsSeconds;

    public String getMaxCachedStatementsPerConnection() {
        return maxCachedStatementsPerConnection;
    }

    public void setMaxCachedStatementsPerConnection(String maxCachedStatementsPerConnection) {
        this.maxCachedStatementsPerConnection = maxCachedStatementsPerConnection;
    }

    public String getDiscardIdleConnectionsSeconds() {
        return discardIdleConnectionsSeconds;
    }

    public void setDiscardIdleConnectionsSeconds(String discardIdleConnectionsSeconds) {
        this.discardIdleConnectionsSeconds = discardIdleConnectionsSeconds;
    }

    public static final int DEFAULT_DB_MAX_CONNECTIONS = 10;

    public static final int DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION = 120;




    //Druid连接池
    private HikariDataSource dataSource;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxConnection() {
        return maxConnection;
    }

    public void setMaxConnection(int maxConnection) {
        this.maxConnection = maxConnection;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public boolean isValidateOnCheckout() {
        return validateOnCheckout;
    }

    public void setValidateOnCheckout(boolean validateOnCheckout) {
        this.validateOnCheckout = validateOnCheckout;
    }

    public int getIdleConnectionValidationSeconds() {
        return idleConnectionValidationSeconds;
    }

    public void setIdleConnectionValidationSeconds(int idleConnectionValidationSeconds) {
        this.idleConnectionValidationSeconds = idleConnectionValidationSeconds;
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("quartzDS") HikariDataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        try {
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate primarySqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

//    @Bean(name = "dataSource")
//    @QuartzDataSource
//    public void setHikariDataSource(HikariDataSource dataSource) {
//        this.dataSource = dataSource;
////        return datasource;
//    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void shutdown() throws SQLException {
        dataSource.close();
    }
    public void initialize() throws SQLException{
        if (this.URL == null) {
            throw new SQLException("DBPool could not be created: DB URL cannot be null");
        }

        if (this.driver == null) {
            throw new SQLException("DBPool driver could not be created: DB driver class name cannot be null!");
        }

        if (this.maxConnection < 0) {
            throw new SQLException("DBPool maxConnectins could not be created: Max connections must be greater than zero!");
        }

        dataSource = new HikariDataSource();
        try{
            dataSource.setDriverClassName(this.driver);
        } catch (Exception e) {
            try {
                throw new SchedulerException("Problem setting driver class name on dataS" +
                        "ource: " + e.getMessage(), e);
            } catch (SchedulerException e1) {
            }
        }




        dataSource.setJdbcUrl(this.URL);
        dataSource.setUsername(this.user);
        dataSource.setPassword(this.password);
        dataSource.setMaximumPoolSize(this.maxConnection);
        dataSource.setMinimumIdle(1);
        dataSource.setMaxLifetime(0);
//        datasource.set(this.DEFAULT_DB_MAX_CACHED_STATEMENTS_PER_CONNECTION);

        if (this.validationQuery != null) {
            dataSource.setConnectionTestQuery(this.validationQuery);
            if(!this.validateOnCheckout)
                dataSource.setJdbc4ConnectionTest(true);
            else
                dataSource.setJdbc4ConnectionTest(false);
            dataSource.setIdleTimeout(this.idleConnectionValidationSeconds);
        }
    }

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * 提供get set方法
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */





}
