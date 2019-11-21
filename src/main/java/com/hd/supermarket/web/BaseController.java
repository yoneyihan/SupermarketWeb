package com.hd.supermarket.web;

import com.hd.supermarket.dto.SingleResult;
import com.hd.supermarket.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 李金荣
 * @date 2018/11/1 11:13
 */
public class BaseController<MODEL, SERVICE extends BaseService<MODEL>> {

    @Autowired
    protected SERVICE service;

    @GetMapping("/{modelId}")
    public SingleResult<MODEL> get(@PathVariable("modelId") Integer modelId) {
        return service.get(modelId);
    }

    @PostMapping
    public SingleResult<MODEL> create(@RequestBody  MODEL model) {
        return service.create(model);
    }

    @PutMapping()
    public SingleResult<MODEL> update(@RequestBody MODEL model){
        return service.update(model);
    }

}
