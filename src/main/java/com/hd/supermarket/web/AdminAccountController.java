package com.hd.supermarket.web;

import com.hd.supermarket.dto.MultipleResult;
import com.hd.supermarket.dto.options.AdminAccountOptions;
import com.hd.supermarket.dto.options.PageableOptions;
import com.hd.supermarket.model.AdminAccount;
import com.hd.supermarket.service.AdminAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李金荣
 * @date 2018/11/1 14:03
 */
@RequestMapping("/admin-account")
@RestController
public class AdminAccountController extends BaseController<AdminAccount, AdminAccountService> {

    @GetMapping("/search")
    public MultipleResult<AdminAccount> search(AdminAccountOptions options) {
        return service.search(options);
    }

}
