package com.hd.supermarket.dto.options;

/**
 * @author 李金荣
 * @date 2018/11/2 11:54
 */
public class PageableOptions extends BaseOptions {

    private static final Integer DEFAULT_PAGING_SIZE = 10;
    private static final Integer DEFAULT_PAGING_START = 0;

    private Integer start;

    private Integer count;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getValidCount() {
        if (count == null || count < 0) {
            return DEFAULT_PAGING_SIZE;
        }
        return count;
    }

    public Integer getValidStart() {
        if (start == null || start < 0) {
            return DEFAULT_PAGING_START;
        }
        return start;
    }
}
