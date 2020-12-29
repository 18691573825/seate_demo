package cn.cloud.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 库存服务
 * @author wangzhongxiang
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("cn.cloud.sample.*")
public class StorageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServerApplication.class, args);
	}

}
