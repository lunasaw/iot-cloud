package io.github.lunasaw.iot.intergration.aliyun.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author luna
 * @date 2024/6/7
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "iot")
public class AliyunIotConfig {

    @Value("${iot.accessKeyId}")
    private String accessKeyId;

    @Value("${iot.accessKeySecret}")
    private String accessKeySecret;

    /**
     *  Endpoint 请参考 <a href="https://api.aliyun.com/product/Iot">...</a>
     */
    @Value(("${iot.endpoint}"))
    private String endpoint;

    /**
     * 实例 ID。您可在物联网平台控制台的实例概览页面，查看当前实例的 ID。
     */
    @Value(("${iot.iotInstanceId}"))
    private String iotInstanceId;
}
