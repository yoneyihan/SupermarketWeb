package com.hd.supermarket.service;

import com.hd.supermarket.dto.MultipleResult;
import com.hd.supermarket.dto.SingleResult;
import tk.mybatis.mapper.entity.Example;

/**
 * Base server
 * @author 李金荣
 * @date 2018/11/1 10:41
 */
public interface BaseService<MODEL> {

    SingleResult<MODEL> create(MODEL model);

    SingleResult<MODEL> createBySelective(MODEL model);

    SingleResult<MODEL> update(MODEL model);

    SingleResult<MODEL> updateBySelective(MODEL model);

    SingleResult<MODEL> get(Integer id);

    MultipleResult<MODEL> getByEntity(MODEL model);

    MultipleResult<MODEL> getByExample(Example example);

}
