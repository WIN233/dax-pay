package cn.daxpay.single.service.core.order.pay.entity;

import cn.bootx.platform.common.core.function.EntityBaseFunction;
import cn.bootx.platform.common.mybatisplus.base.MpBaseEntity;
import cn.daxpay.single.code.PayMethodEnum;
import cn.daxpay.single.code.PayOrderAllocStatusEnum;
import cn.daxpay.single.code.PayChannelEnum;
import cn.daxpay.single.code.PayOrderRefundStatusEnum;
import cn.daxpay.single.code.PayStatusEnum;
import cn.daxpay.single.param.channel.AliPayParam;
import cn.daxpay.single.param.channel.WalletPayParam;
import cn.daxpay.single.param.channel.WeChatPayParam;
import cn.daxpay.single.service.core.order.pay.convert.PayOrderConvert;
import cn.daxpay.single.service.dto.order.pay.PayOrderDto;
import cn.bootx.table.modify.annotation.DbColumn;
import cn.bootx.table.modify.annotation.DbTable;
import cn.bootx.table.modify.mysql.annotation.DbMySqlIndex;
import cn.bootx.table.modify.mysql.constants.MySqlIndexType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 支付订单
 * @author xxm
 * @since 2023/12/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@DbTable(comment = "支付订单")
@Accessors(chain = true)
@TableName(value = "pay_order",autoResultMap = true)
public class PayOrder extends MpBaseEntity implements EntityBaseFunction<PayOrderDto> {

    /** 商户订单号 */
    @DbMySqlIndex(comment = "商户订单号索引",type = MySqlIndexType.UNIQUE)
    @DbColumn(comment = "商户订单号")
    private String bizOrderNo;

    @DbColumn(comment = "支付订单号")
    private String orderNo;

    /**
     *  通道系统交易号
     */
    @DbColumn(comment = "通道支付订单号")
    private String outOrderNo;

    /** 标题 */
    @DbColumn(comment = "标题")
    private String title;

    /** 描述 */
    @DbColumn(comment = "描述")
    private String description;

    /** 是否支持分账 */
    @DbColumn(comment = "是否需要分账")
    private Boolean allocation;

    @DbColumn(comment = "自动分账")
    private Boolean autoAllocation;

    /**
     * 支付通道
     * @see PayChannelEnum
     */
    @DbColumn(comment = "异步支付通道")
    private String channel;

    /**
     * 支付方式
     * @see PayMethodEnum
     */
    @DbColumn(comment = "支付方式")
    private String method;

    /** 金额 */
    @DbColumn(comment = "金额")
    private Integer amount;

    /** 可退款余额 */
    @DbColumn(comment = "可退款余额")
    private Integer refundableBalance;

    /**
     * 支付状态
     * @see PayStatusEnum
     */
    @DbColumn(comment = "支付状态")
    private String status;

    /**
     * 退款状态
     * @see PayOrderRefundStatusEnum
     */
    @DbColumn(comment = "退款状态")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String refundStatus;

    /**
     * 分账状态
     * @see PayOrderAllocStatusEnum
     */
    @DbColumn(comment = "分账状态")
    private String allocStatus;

    /** 支付时间 */
    @DbColumn(comment = "支付时间")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private LocalDateTime payTime;

    /** 关闭时间 */
    @DbColumn(comment = "关闭时间")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private LocalDateTime closeTime;

    /** 过期时间 */
    @DbColumn(comment = "过期时间")
    private LocalDateTime expiredTime;

    /** 错误码 */
    @DbColumn(comment = "错误码")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String errorCode;

    /** 错误信息 */
    @DbColumn(comment = "错误信息")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String errorMsg;

    /** 同步跳转地址, 以最后一次为准 */
    @DbColumn(comment = "同步跳转地址")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String returnUrl;

    /** 异步通知地址,以最后一次为准 */
    @DbColumn(comment = "异步通知地址")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String notifyUrl;

    /**
     * 附加参数 以最后一次为准
     * @see AliPayParam
     * @see WeChatPayParam
     * @see WalletPayParam
     */
    @DbColumn(comment = "附加参数")
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private String extraParam;

    /** 商户扩展参数,回调时会原样返回, 以最后一次为准 */
    @DbColumn(comment = "商户扩展参数")
    private String attach;

    /** 请求时间，时间戳转时间, 以最后一次为准 */
    @DbColumn(comment = "请求时间，传输时间戳，以最后一次为准")
    private LocalDateTime reqTime;

    /** 支付终端ip 以最后一次为准 */
    @DbColumn(comment = "支付终端ip")
    private String clientIp;

    /**
     * 如果
     */
    public Boolean getAllocation() {
        return Objects.equals(this.allocation, true);
    }

    /**
     * 转换
     */
    @Override
    public PayOrderDto toDto() {
        return PayOrderConvert.CONVERT.convert(this);
    }
}
