package io.github.lunasaw.iot.intergration.aliyun.api.product;

import com.aliyun.iot20180120.models.CreateProductRequest;
import com.aliyun.iot20180120.models.CreateProductResponse;
import com.aliyun.iot20180120.models.QueryProductRequest;
import com.aliyun.iot20180120.models.QueryProductResponse;
import com.aliyun.teautil.models.RuntimeOptions;

import io.github.lunasaw.iot.intergration.aliyun.api.AbstractAliyunApi;
import org.springframework.stereotype.Component;

/**
 * @author luna
 * @date 2024/6/7
 */
@Component
public class ProductApi extends AbstractAliyunApi {

    public CreateProductResponse createProduct(CreateProductRequest request, RuntimeOptions runtime) throws Exception {
        return getClient().createProductWithOptions(request, runtime);
    }

    public QueryProductResponse queryProductWithOptions(QueryProductRequest request, RuntimeOptions runtime) throws Exception {
        return getClient().queryProductWithOptions(request, runtime);
    }
}
