package com.jf.utils.result;

import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-20 12:37:00
 * @since
 */
@Setter
@ToString
public class PageQueryRequest<T> {

    private static final int DEFAULT_SIZE = 10;

    /**
     * 每页查多少个
     */
    private Integer pageSize;

    /**
     * 当前页码
     */
    private Integer currPage;

    /**
     * 查询条件
     */
    private T data;

    /**
     * 从哪一行开始查询
     */
    private Integer startRow;

    public Integer getPageSize() {
        if (Objects.isNull(this.pageSize)) {
            this.pageSize = DEFAULT_SIZE;
        }
        return this.pageSize >= 1000 ? 1000 : this.pageSize;
    }

    public Integer getCurrPage() {
        return this.currPage;
    }


    public T getData() {
        return this.data;
    }

    public Integer getStartRow() {
        return this.getPageSize() * (this.currPage - 1);
    }


}
