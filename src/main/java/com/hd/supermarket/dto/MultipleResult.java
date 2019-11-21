package com.hd.supermarket.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 多结果集
 * @author 李金荣
 * @date 2018/11/1 11:46
 */
@Getter
@Setter
public class MultipleResult<E> extends BaseResult {

    private long totalCount;

    private List<E> result;

    public static <E> MultipleResult<E> build(List<E> e){
        return build(0, e);
    }

    public static <E> MultipleResult<E> build(int code, List<E> e){
        return build(0, e.size(), e);
    }

    public static <E> MultipleResult<E> build(int code, long totalCount, List<E> e){
        MultipleResult result = new MultipleResult();
        result.code = code;
        result.totalCount = totalCount;
        result.result = e;
        return result;
    }

}
