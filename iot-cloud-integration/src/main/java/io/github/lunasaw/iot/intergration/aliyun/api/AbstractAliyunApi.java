package io.github.lunasaw.iot.intergration.aliyun.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.iot20180120.Client;

/**
 * @author luna
 * @date 2024/6/8
 */
@Data
@Component
public abstract class AbstractAliyunApi implements AliyunApi {

    @Autowired
    private Client client;

}
