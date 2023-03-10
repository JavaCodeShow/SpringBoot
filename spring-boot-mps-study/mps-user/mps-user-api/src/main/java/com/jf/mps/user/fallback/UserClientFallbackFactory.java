package com.jf.mps.user.fallback;

/**
 * 调用分布式Id服务，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
// @Component
// @Slf4j
// public class UserClientFallbackFactory implements FallbackFactory<UserApi> {
//
//     @Override
//     public UserClient create(Throwable throwable) {
//         return new UserClient() {
//             @Override
//             public CommonResult<UserInfo> findById(IdRequest request) {
//                 return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
//             }
//
//             @Override
//             public CommonResult<Boolean> updateNameById(GenericRequest<UpdateNameParam> request) {
//                 return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
//
//             }
//         };
//     }
// }