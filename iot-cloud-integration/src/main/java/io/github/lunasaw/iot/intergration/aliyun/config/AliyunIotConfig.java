package io.github.lunasaw.iot.intergration.aliyun.config;

import com.aliyun.iot20180120.Client;
import io.github.lunasaw.iot.intergration.aliyun.domain.IotConfigDTO;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luna
 * @date 2024/6/7
 */
@Component
@Data
public class AliyunIotConfig implements InitializingBean {

    @Autowired
    private IotConfigDTO iotConfigDTO;

    private static Client client;

    public  Client createClient() throws Exception {
        // 工程代码泄露可能会导致 AccessKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考。
        // 建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html。
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(iotConfigDTO.getAccessKeyId())
                .setAccessKeySecret(iotConfigDTO.getAccessKeySecret())
                .setEndpoint(iotConfigDTO.getEndpoint());
        return new Client(config);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        client = createClient();
    }
}
