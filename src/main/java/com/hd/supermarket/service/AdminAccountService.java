package com.hd.supermarket.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hd.supermarket.dto.MultipleResult;
import com.hd.supermarket.dto.options.AdminAccountOptions;
import com.hd.supermarket.mapper.AdminAccountMapper;
import com.hd.supermarket.model.AdminAccount;
import com.hd.supermarket.service.impl.BaseServerImpl;
import com.hd.supermarket.util.Utils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author 李金荣
 * @date 2018/11/1 11:04
 */
@Service
public class AdminAccountService extends BaseServerImpl<AdminAccount, AdminAccountMapper> implements BaseService<AdminAccount> {

    public MultipleResult<AdminAccount> search(AdminAccountOptions options) {
        PageHelper.offsetPage(options.getValidStart(), options.getValidCount());
        Example example = Example.builder(AdminAccount.class).build();
        if (Utils.isNotEmpty(options.getAdminName())) {
            example.and().andLike("adminName", String.format("%%%s%%", options.getAdminName()));
        }
        PageInfo<AdminAccount> pageInfo = new PageInfo<>(mapper.selectByExample(example));
        // or code
        // int totalCount = mapper.selectCountByExample(example);
        return MultipleResult.build(0, pageInfo.getTotal(), pageInfo.getList());
    }
}
