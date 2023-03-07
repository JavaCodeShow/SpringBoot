package com.jf.mps.account.api;

import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.account.info.AccountInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author 江峰
 * @since 2020/2/17
 */
public interface AccountApi {

    @PostMapping(value = "/endpoint/v1/account/find_by_id", consumes = APPLICATION_JSON_VALUE)
    CommonResult<AccountInfo> findById(@RequestBody IdRequest request);

    @PostMapping(value = "/endpoint/v1/account/find_by_id", consumes = APPLICATION_JSON_VALUE)
    CommonResult<AccountInfo> createOrUpdate(@RequestBody IdRequest request);
}
