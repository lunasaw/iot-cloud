package io.github.lunasaw.iot.common.enums.iot;

/**
 * 0：设备。设备不能挂载子设备。可以直连物联网平台，也可以作为网关的子设备连接物联网平台。作为网关子设备时，必须同时传入 ProtocolType。
 * 1：网关。网关可以挂载子设备，具有子设备管理模块，维持子设备的拓扑关系，和将拓扑关系同步到物联网平台。
 *
 * @author luna
 */
public enum NodeTypeEnums {
    /**
     * 默认策略全局限流
     */
    DEVICE(0, "device"),

    /**
     * 根据请求者IP进行限流
     */
    GATEWAY(1, "gateway");

    NodeTypeEnums(int i, String device) {

    }
}
