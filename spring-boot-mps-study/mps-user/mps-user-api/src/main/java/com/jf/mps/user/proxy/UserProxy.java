package com.jf.mps.user.proxy;

/**
 * @author 江峰
 * @since 2021/9/12
 */
// @Service
// @Slf4j
// public class UserProxy {
//
//     @Autowired
//     private UserClient userClient;
//
//     public UserInfo findById(String id) {
//         IdRequest request = new IdRequest();
//         request.setId(id);
//         CommonResult<UserInfo> result = userClient.findById(request);
//         if (!result.getSuccess()) {
//             log.error("调用ids服务获取一个id失败, result = [{}]", JSON.toJSONString(result));
//             throw new BizException(result.getCode(), result.getMessage());
//         }
//         return result.getData();
//     }
//
//
// }
