package com.jf.mps.user.api;

import com.jf.model.request.IdRequest;
import com.jf.model.response.CommonResult;
import com.jf.mps.user.info.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author 江峰
 * @since 2020/2/17
 */
public interface UserApi {

    @PostMapping(value = "/endpoint/v1/user/find_by_id", consumes = APPLICATION_JSON_VALUE)
    CommonResult<UserInfo> findById(@RequestBody IdRequest request);

}
