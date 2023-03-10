package com.jf.mps.account.fallback;

/**
 * 调用分布式Id服务，异常熔断处理
 *
 * @author 江峰
 * @date 2020/7/19 15:04
 */
// @Component
// @Slf4j
// public class AccountClientFallbackFactory implements FallbackFactory<AccountApi> {
//
//     @Override
//     public AccountClient create(Throwable throwable) {
//         return new AccountClient() {
//             @Override
//             public CommonResult<AccountInfo> findById(IdRequest request) {
//                 return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
//             }
//
//             @Override
//             public CommonResult<String> createOrUpdate(GenericRequest<AccountCreateOrUpdateParam> request) {
//                 // try {
//                 //     GlobalTransactionContext.reload(RootContext.getXID()).rollback();
//                 // } catch (TransactionException e) {
//                 //     log.error("手动回滚事务失败，XID:{}", RootContext.getXID());
//                 //     e.printStackTrace();
//                 // }
//                 return CommonResult.fail(GlobalErrorCodeEnum.RPC_TIME_OUT.getCode(), GlobalErrorCodeEnum.RPC_TIME_OUT.getMessage());
//             }
//
//         };
//     }
// }