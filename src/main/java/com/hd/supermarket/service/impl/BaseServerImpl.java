package com.hd.supermarket.service.impl;

import com.github.pagehelper.PageHelper;
import com.hd.supermarket.dto.MultipleResult;
import com.hd.supermarket.dto.SingleResult;
import com.hd.supermarket.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * Base server impl
 * @author 李金荣
 * @date 2018/11/1 10:53
 */
public class BaseServerImpl<MODEL, MAPPER extends Mapper<MODEL>> implements BaseService<MODEL> {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected MAPPER mapper;

    @Override
    public SingleResult<MODEL> create(MODEL model) {
        mapper.insert(model);
        return SingleResult.build(model);
    }

    @Override
    public SingleResult<MODEL> createBySelective(MODEL model) {
        mapper.insertSelective(model);
        return SingleResult.build(model);
    }

    @Override
    public SingleResult<MODEL> update(MODEL model) {
        mapper.updateByPrimaryKey(model);
        return SingleResult.build(model);
    }

    @Override
    public SingleResult<MODEL> updateBySelective(MODEL model) {
        mapper.updateByPrimaryKeySelective(model);
        return SingleResult.build(model);
    }

    @Override
    public SingleResult<MODEL> get(Integer id) {
        return SingleResult.build(mapper.selectByPrimaryKey(id));
    }

    @Override
    public MultipleResult<MODEL> getByEntity(MODEL model) {
        return MultipleResult.build(mapper.select(model));
    }

    @Override
    public MultipleResult<MODEL> getByExample(Example example) {
        return MultipleResult.build(mapper.selectByExample(example));
    }
}
