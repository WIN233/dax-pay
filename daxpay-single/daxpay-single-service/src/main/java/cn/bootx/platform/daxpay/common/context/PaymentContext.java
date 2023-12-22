package cn.bootx.platform.daxpay.common.context;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 支付上下文
 * @author xxm
 * @since 2023/12/22
 */
@Getter
@Setter
@Accessors(chain = true)
public class PaymentContext {

    /** 当前支付接口编码 */
    private String apiCode;

    /** 是否开启回调通知 */
    private boolean notice;

    /** 请求参数是否签名 */
    private boolean reqSign;

    /** 响应参数是否签名 */
    private boolean resSign;

    /** 回调信息是否签名 */
    private boolean noticeSign;

    /** 是否记录请求的信息 */
    private boolean record;
}
