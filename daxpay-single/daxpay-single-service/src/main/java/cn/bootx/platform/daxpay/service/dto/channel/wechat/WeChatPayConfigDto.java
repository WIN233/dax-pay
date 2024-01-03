package cn.bootx.platform.daxpay.service.dto.channel.wechat;

import cn.bootx.platform.common.core.rest.dto.BaseDto;
import cn.bootx.platform.starter.data.perm.sensitive.SensitiveInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author xxm
 * @since 2021/3/19
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Schema(title = "微信支付配置")
public class WeChatPayConfigDto extends BaseDto implements Serializable {

    @Schema(description = "微信商户号")
    @SensitiveInfo
    private String wxMchId;

    @Schema(description = "微信应用appId")
    @SensitiveInfo
    private String wxAppId;

    @Schema(description = "商户平台「API安全」中的 APIv2 密钥")
    @SensitiveInfo
    private String apiKeyV2;

    @Schema(description = "商户平台「API安全」中的 APIv3 密钥")
    @SensitiveInfo
    private String apiKeyV3;

    @Schema(description = "APPID对应的接口密码，用于获取接口调用凭证access_token时使用")
    @SensitiveInfo
    private String appSecret;

    @Schema(description = "API 证书中的 p12 文件id")
    @SensitiveInfo
    private String p12;

    @Schema(description = "服务器异步通知页面路径 通知url必须为直接可访问的url，不能携带参数。公网域名必须为https ")
    private String notifyUrl;

    @Schema(description = "是否沙箱环境")
    private boolean sandbox;

    @Schema(description = "可用支付方式")
    private List<String> payWays;

    @Schema(description = "是否启用")
    private Boolean activity;

    @Schema(description = "状态")
    private String state;

    @Schema(description = "备注")
    private String remark;

}
