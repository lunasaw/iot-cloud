package io.github.lunasaw.iot.intergration.aliyun.api.product;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aliyun.iot20180120.models.*;
import com.aliyun.teautil.models.RuntimeOptions;
import com.luna.common.check.Assert;

import io.github.lunasaw.iot.intergration.aliyun.api.AbstractAliyunApi;
import io.github.lunasaw.iot.intergration.aliyun.domain.AliyunIotConfig;
import lombok.SneakyThrows;

/**
 * @author luna
 * @date 2024/6/7
 */
@Component
public class ProductApi extends AbstractAliyunApi {

    @Autowired
    private AliyunIotConfig aliyunIotConfig;

    @SneakyThrows
    public CreateProductResponse createProduct(CreateProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        return getClient().createProductWithOptions(request, runtime);
    }

    @SneakyThrows
    public QueryProductResponse queryProductWithOptions(QueryProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().queryProductWithOptions(request, runtime);
    }

    @SneakyThrows
    public QueryProductListResponse queryProductListWithOptions(QueryProductListRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        return getClient().queryProductListWithOptions(request, runtime);
    }

    @SneakyThrows
    public UpdateProductResponse updateProductWithOptions(UpdateProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.notNull(request.getProductName(), "productName is null");
        return getClient().updateProductWithOptions(request, runtime);
    }

    @SneakyThrows
    public DeleteProductResponse updateProductWithOptions(DeleteProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().deleteProductWithOptions(request, runtime);
    }
}
