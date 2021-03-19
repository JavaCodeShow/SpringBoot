package com.jf.utils.result;

import com.jf.common.meta.ResultCodeEnum;
import lombok.Data;

/**
 * @author 江峰
 * @email feng.jiang@marketin.cn
 * @create 2021-03-19 23:47:38
 * @since
 */
@Data
public class PageQueryResult<T> extends BaseResult<T> {

    //总记录数
    private Integer total;

    //每页记录数
    private Integer pageSize;

    //总页数
    private Integer totalPages;

    //当前页码
    private Integer currPage;

    public PageQueryResult() {

    }


    public static <T> PageQueryResult<T> success(T data, Integer total) {
        PageQueryResult<T> result = new PageQueryResult<>();
        result.setData(data);
        result.setTotal(total);
        result.setResultCode(ResultCodeEnum.SUCCESS);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    public static <T> PageQueryResult<T> failure() {
        PageQueryResult<T> result = new PageQueryResult<>();
        result.setResultCode(ResultCodeEnum.ERROR);
        result.setSuccess(Boolean.FALSE);
        return result;
    }

}
