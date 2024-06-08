package io.github.lunasaw.app.produect;

import com.alibaba.fastjson2.JSON;
import com.aliyun.iot20180120.models.CreateProductRequest;
import com.aliyun.iot20180120.models.CreateProductResponse;
import com.aliyun.iot20180120.models.QueryProductListResponse;
import io.github.lunasaw.app.ApiTest;
import io.github.lunasaw.iot.intergration.aliyun.domain.AliyunIotConfig;
import io.github.lunasaw.iot.intergration.aliyun.api.product.ProductApi;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author luna
 * @date 2024/6/7
 */
public class ProductApiTest extends ApiTest {

    @Autowired
    private ProductApi productApi;

    @Autowired
    private AliyunIotConfig aliyunIotConfig;

    @Test
    public void atest() throws Exception {
        CreateProductRequest request = new CreateProductRequest();
        request.setProductName("测试");
        request.setNodeType(0);
        request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();

        CreateProductResponse product = productApi.createProduct(request, runtime);
        System.out.println(JSON.toJSONString(product));
    }

    @Test
    public void btest() {

        com.aliyun.iot20180120.models.QueryProductListRequest queryProductListRequest = new com.aliyun.iot20180120.models.QueryProductListRequest();
        queryProductListRequest.setPageSize(10);
        queryProductListRequest.setCurrentPage(1);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();

        QueryProductListResponse queryProductListResponse = productApi.queryProductListWithOptions(queryProductListRequest, runtime);
        System.out.println(JSON.toJSONString(queryProductListResponse));

    }

}
