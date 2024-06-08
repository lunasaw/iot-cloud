package io.github.lunasaw.iot.intergration.aliyun.api.product;

import org.apache.commons.collections4.CollectionUtils;
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

    @SneakyThrows
    public CreateProductTagsResponse createProductTagsWithOptions(CreateProductTagsRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getProductTag()), "productTag is null");
        return getClient().createProductTagsWithOptions(request, runtime);
    }

    @SneakyThrows
    public UpdateProductTagsResponse createProductTagsWithOptions(UpdateProductTagsRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getProductTag()), "productTag is null");
        return getClient().updateProductTagsWithOptions(request, runtime);
    }

    @SneakyThrows
    public DeleteProductTagsResponse createProductTagsWithOptions(DeleteProductTagsRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getProductTagKey()), "productTag is null");
        return getClient().deleteProductTagsWithOptions(request, runtime);
    }

    /**
     * 查询所有标签
     */
    @SneakyThrows
    public ListProductTagsResponse queryProductTagsWithOptions(ListProductTagsRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().listProductTagsWithOptions(request, runtime);
    }


    /**
     * 支持按照TagKey和TagValue组合，或只按照TagKey来搜索。
     * 传入多个ProductTag是或的关系
     * ListProductByTags
     */
    @SneakyThrows
    public ListProductByTagsResponse listProductByTagsWithOptions(ListProductByTagsRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getProductTag()), "productTag is null");
        return getClient().listProductByTagsWithOptions(request, runtime);
    }

    /**
     * ReleaseProduct
     */
    @SneakyThrows
    public ReleaseProductResponse releaseProductWithOptions(ReleaseProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().releaseProductWithOptions(request, runtime);
    }

    /**
     * CancelReleaseProduct
     */
    @SneakyThrows
    public CancelReleaseProductResponse cancelReleaseProductWithOptions(CancelReleaseProductRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().cancelReleaseProductWithOptions(request, runtime);
    }

    /**
     * QueryProductCertInfo
     */
    @SneakyThrows
    public QueryProductCertInfoResponse queryProductCertInfoWithOptions(QueryProductCertInfoRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().queryProductCertInfoWithOptions(request, runtime);
    }

    /**
     * SetProductCertInfo
     * 1：由物联网平台颁发 X.509 证书。
     * 3：由第三方平台颁发 X.509 证书。
     */
    @SneakyThrows
    public SetProductCertInfoResponse setProductCertInfoWithOptions(SetProductCertInfoRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.notNull(request.getIssueModel(), "issueModel is null");
        return getClient().setProductCertInfoWithOptions(request, runtime);
    }

    /**
     * UpdateProductFilterConfig
     */
    @SneakyThrows
    public UpdateProductFilterConfigResponse updateProductFilterConfigWithOptions(UpdateProductFilterConfigRequest request, RuntimeOptions runtime) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        // true：对设备上报的时间戳相同的属性消息进行去重。
        // false：不根据时间戳进行消息去重。
        Assert.notNull(request.getPropertyTimestampFilter(), "propertyTimestampFilter is null");
        // true：对设备上报相同属性值的消息进行去重。
        // false：不根据属性值进行消息去重。
        Assert.notNull(request.getPropertyValueFilter(), "propertyValueFilter is null");
        return getClient().updateProductFilterConfigWithOptions(request, runtime);
    }
}
