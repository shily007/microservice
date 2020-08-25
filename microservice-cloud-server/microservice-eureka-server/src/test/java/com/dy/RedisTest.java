package com.dy;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dy.redis.RedisLock;
import com.dy.utils.jasypt.JasyptConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application_Eureka_Server.class)
public class RedisTest {
	
	static{
		System.setProperty("jasypt.encryptor.password", JasyptConstants.JASYPT_ENCRYPTOR_PASSWORD);
	}

	@Autowired
	private RedisLock redisLock;

	private void testLock(String batch) throws Exception {
		String key = "eureka";
		String value = UUID.randomUUID().toString();
		try {
			if (redisLock.tryLock(key, value)) {
				log.info("方法[ {} ]加锁成功", batch);
				Thread.sleep(15000L);
			} else {
				log.info("方法[ {} ]加锁失败", batch);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			redisLock.release(key, value);
			log.info("方法[ {} ]释放锁", batch);
		}
	}

	@Test
	public void testLock1() throws Exception {
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {				
				@Override
				public void run() {
					try {
						testLock(Thread.currentThread().getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		Thread.sleep(60*1000L);
	}

	@Test
	public void testLock2() throws Exception {
		testLock("2");
	}

}
