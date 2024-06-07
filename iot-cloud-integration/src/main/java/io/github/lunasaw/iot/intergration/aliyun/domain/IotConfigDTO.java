package io.github.lunasaw.iot.intergration.aliyun.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author luna
 * @date 2024/6/7
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "iot")
public class IotConfigDTO {

    @Value("${iot.accessKeyId}")
    private String accessKeyId;

    @Value("${iot.accessKeySecret}")
    private String accessKeySecret;

    /**
     *  Endpoint 请参考 <a href="https://api.aliyun.com/product/Iot">...</a>
     */
    @Value(("${iot.endpoint}"))
    private String endpoint;
}
