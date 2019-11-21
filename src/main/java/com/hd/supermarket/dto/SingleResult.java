package com.hd.supermarket.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 单结果集
 * @author 李金荣
 * @date 2018/11/1 11:44
 */
@Getter
@Setter
public class SingleResult<E> extends BaseResult {

    private E result;

    public static <E> SingleResult<E> build(E e) {
        return build(0, e);
    }

    public static <E> SingleResult<E> build(int code, E e) {
        SingleResult result = new SingleResult();
        result.code = code;
        result.result = e;
        return result;
    }
}
