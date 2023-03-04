package com.lqw;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lqw.domain.book;
import com.lqw.service.bookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringbootSmmpApplicationTests {

	@Resource
	private bookService ba;
	@Test
	void contextLoads() {
	}

}
