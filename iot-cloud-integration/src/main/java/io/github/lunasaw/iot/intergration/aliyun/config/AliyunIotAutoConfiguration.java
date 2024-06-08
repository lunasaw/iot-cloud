package io.github.lunasaw.iot.intergration.aliyun.config;

import com.luna.common.check.Assert;
import io.github.lunasaw.iot.common.constant.iot.IotConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.aliyun.iot20180120.Client;

import io.github.lunasaw.iot.intergration.aliyun.domain.AliyunIotConfig;
import lombok.Data;

import java.util.Optional;

/**
 * @author luna
 * @date 2024/6/7
 */
@Component
@Data
@Configuration
@EnableConfigurationProperties(AliyunIotConfig.class)
public class AliyunIotAutoConfiguration {

    @Autowired
    private AliyunIotConfig aliyunIotConfig;

    public AliyunIotAutoConfiguration(AliyunIotConfig aliyunIotConfig) {
        this.aliyunIotConfig = aliyunIotConfig;
    }

    @Bean("client")
    public Client client() {
        return createClient();
    }

    private Client createClient() {
        String accessKeyId = Optional.ofNullable(aliyunIotConfig.getAccessKeyId()).filter(StringUtils::isNotBlank)
                .orElse(System.getenv(IotConstant.Client.ACCESS_KEY_ID));
        Assert.isTrue(StringUtils.isNotBlank(accessKeyId), "accessKeyId is null");
        String accessKeySecret = Optional.ofNullable(aliyunIotConfig.getAccessKeySecret()).filter(StringUtils::isNotBlank)
                .orElse(System.getenv(IotConstant.Client.ACCESS_KEY_SECRET));
        Assert.isTrue(StringUtils.isNotBlank(accessKeySecret), "accessKeySecret is null");
        String endpoint = Optional.ofNullable(aliyunIotConfig.getEndpoint()).filter(StringUtils::isNotBlank)
                .orElse(IotConstant.ENDPOINT);
        Assert.isTrue(StringUtils.isNotBlank(endpoint), "endpoint is null");

        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
            .setAccessKeyId(accessKeyId)
            .setAccessKeySecret(accessKeySecret)
            .setEndpoint(endpoint);
        try {
            return new Client(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
