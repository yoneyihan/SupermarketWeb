package com.hd.supermarket;

import com.hd.supermarket.dto.SingleResult;
import com.hd.supermarket.model.AdminAccount;
import com.hd.supermarket.service.AdminAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	AdminAccountService adminAccountService;

	@Test
	public void contextLoads() {
		getById();
	}

	public void create() {
		AdminAccount adminAccount = new AdminAccount();
		adminAccount.setAdminName("Dream rain");
		adminAccount.setUserName("Her");
		adminAccount.setPassword("123456");
		adminAccount.setIsDefault(1);
		adminAccount.setIsDeleted(0);
		SingleResult<AdminAccount> i = adminAccountService.create(adminAccount);

		System.out.println(String.format("exec: %d", i.getCode()));
	}

	public void getById() {
		SingleResult<AdminAccount> result = adminAccountService.get(8);
		AdminAccount adminAccount = result.getResult();
		System.out.println(adminAccount);
	}



}
