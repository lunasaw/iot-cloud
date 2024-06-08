package io.github.lunasaw.iot.intergration.aliyun.api.device;

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
 * @date 2024/6/8
 */
@Component
public class DeviceApi extends AbstractAliyunApi {

    @Autowired
    private AliyunIotConfig aliyunIotConfig;

    /**
     * RegisterDevice
     */
    @SneakyThrows
    public RegisterDeviceResponse registerDeviceWithOptions(RegisterDeviceRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().registerDeviceWithOptions(request, runtimeOptions);
    }

    /**
     * QueryDeviceInfo
     */
    @SneakyThrows
    public QueryDeviceInfoResponse queryDeviceInfoWithOptions(QueryDeviceInfoRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        return getClient().queryDeviceInfoWithOptions(request, runtimeOptions);
    }

    /**
     * QueryDeviceDetail
     * 调用该接口查询指定设备的详细信息
     */
    @SneakyThrows
    public QueryDeviceDetailResponse queryDeviceDetailWithOptions(QueryDeviceDetailRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        return getClient().queryDeviceDetailWithOptions(request, runtimeOptions);
    }

    /**
     * BatchQueryDeviceDetail
     * 查询指定产品下多个设备的详细信息
     */
    @SneakyThrows
    public BatchQueryDeviceDetailResponse batchQueryDeviceDetailWithOptions(BatchQueryDeviceDetailRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        // 要查询的设备名称列表。最多可包含 100 个设备名称。
        // 说明 查询的设备必须在同一产品下
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getDeviceName()), "deviceName is null");
        return getClient().batchQueryDeviceDetailWithOptions(request, runtimeOptions);
    }

    /**
     * QueryDevice 分页
     * 调用该接口查询指定产品下的所有设备列表
     */
    @SneakyThrows
    public QueryDeviceResponse queryDeviceWithOptions(QueryDeviceRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.notNull(request.getPageSize(), "pageSize is null");
        Assert.notNull(request.getCurrentPage(), "currentPage is null");
        return getClient().queryDeviceWithOptions(request, runtimeOptions);
    }

    /**
     * DeleteDevice
     */
    @SneakyThrows
    public DeleteDeviceResponse deleteDeviceWithOptions(DeleteDeviceRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(request.getIotId() != null
            || (StringUtils.isNoneBlank(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().deleteDeviceWithOptions(request, runtimeOptions);
    }

    /**
     * GetDeviceStatus
     * 调用该接口查看指定设备的运行状态
     */
    @SneakyThrows
    public GetDeviceStatusResponse getDeviceStatusWithOptions(GetDeviceStatusRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(request.getIotId() != null
            || (StringUtils.isNoneBlank(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().getDeviceStatusWithOptions(request, runtimeOptions);
    }

    /**
     * BatchGetDeviceState
     * 调用该接口批量查看同一产品下指定设备的运行状态
     */
    @SneakyThrows
    public BatchGetDeviceStateResponse batchGetDeviceStateWithOptions(BatchGetDeviceStateRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(
            CollectionUtils.isNotEmpty(request.getIotId())
                || (CollectionUtils.isNotEmpty(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().batchGetDeviceStateWithOptions(request, runtimeOptions);
    }

    /**
     * DisableThing
     * 调用该接口禁用指定设备
     */
    @SneakyThrows
    public DisableThingResponse disableThingWithOptions(DisableThingRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(request.getIotId() != null
            || (StringUtils.isNoneBlank(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().disableThingWithOptions(request, runtimeOptions);
    }

    /**
     * EnableThing
     * 调用该接口解除指定设备的禁用状态，即启用被禁用的设备
     */
    @SneakyThrows
    public EnableThingResponse enableThingWithOptions(EnableThingRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(request.getIotId() != null || (StringUtils.isNoneBlank(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().enableThingWithOptions(request, runtimeOptions);
    }

    /**
     * ResetThing
     * 重置指定设备，重置直连设备一型一密状态，同时删除当前设备的拓扑关系
     */
    @SneakyThrows
    public ResetThingResponse resetThingWithOptions(ResetThingRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.isTrue(request.getIotId() != null || (StringUtils.isNoneBlank(request.getDeviceName()) && request.getProductKey() != null),
            "iotId or (productKey and deviceName) must not be null");
        return getClient().resetThingWithOptions(request, runtimeOptions);
    }

    // 设备注册 一型一密预注册

    /**
     * BatchRegisterDevice
     * 指定产品下批量注册多个设备（随机生成设备名）
     * 批量注册设备有两种方式：
     * 由系统随机生成设备名称：调用本接口。 建议按照以下流程注册设备和查看结果。
     * 调用本接口批量注册设备。返回成功结果，表示批量注册的申请已经提交成功。实际的注册是异步执行，会有一个过程。
     * 调用QueryBatchRegisterDeviceStatus查看设备注册结果。
     * 调用QueryPageByApplyId查看批量注册的设备信息（DeviceName、DeviceSecret、IotId）。
     * 自定义设备名称：请参见BatchRegisterDeviceWithApplyId。
     */
    @SneakyThrows
    public BatchRegisterDeviceResponse batchRegisterDeviceWithOptions(BatchRegisterDeviceRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.notNull(request.getCount(), "count is null");
        return getClient().batchRegisterDeviceWithOptions(request, runtimeOptions);
    }

    /**
     * BatchCheckDeviceNames
     * 调用该接口在指定产品下批量自定义设备名称。物联网平台将检查名称的合法性
     */
    @SneakyThrows
    public BatchCheckDeviceNamesResponse batchCheckDeviceNamesWithOptions(BatchCheckDeviceNamesRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getProductKey(), "productKey is null");
        Assert.isTrue(CollectionUtils.isNotEmpty(request.getDeviceNameList()) || request.getDeviceName() != null, "deviceNameList is null");
        return getClient().batchCheckDeviceNamesWithOptions(request, runtimeOptions);
    }

    /**
     * BatchRegisterDeviceWithApplyId
     * 根据申请批次ID（ApplyId）批量注册设备
     * 由系统随机生成设备名称：请调用BatchRegisterDevice接口。
     * 自定义设备名称：需本接口与BatchCheckDeviceNames等接口结合实现。请按以下流程操作：
     * 调用BatchCheckDeviceNames接口，传入要批量注册的设备的名称。物联网平台检查您提交的设备名称符合要求后，返回申请批次ID（ApplyId）。ApplyId将用于设备名称校验结果查询、批量设备注册和设备信息查询。
     * 调用QueryBatchRegisterDeviceStatus接口，根据申请批次ID，查看名称校验结果。请确保自定义设备名称全部校验通过，再执行后续操作完成设备注册。
     * 说明
     * 如果有校验失败的设备名称，请根据错误信息提示进行修正，然后重新调用BatchCheckDeviceNames接口获取新的申请批次ID（ApplyId）后，再次调用QueryBatchRegisterDeviceStatus接口确认全部设备名称校验通过。
     * 调用本接口批量注册设备。本接口调用返回的成功结果，仅表示批量注册的申请已经提交成功。实际的注册会有一个过程。
     * （可选）调用QueryBatchRegisterDeviceStatus查看设备注册结果。
     * 调用QueryPageByApplyId查看批量注册的设备信息。
     */
    @SneakyThrows
    public BatchRegisterDeviceWithApplyIdResponse batchRegisterDeviceWithApplyIdWithOptions(BatchRegisterDeviceWithApplyIdRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getApplyId(), "applyId is null");
        Assert.notNull(request.getProductKey(), "productKey is null");
        return getClient().batchRegisterDeviceWithApplyIdWithOptions(request, runtimeOptions);
    }

    // 一型一密免注册 ------------------------------

    /**
     * QueryClientIds
     * 一型一密免注册场景下，调用该接口查看单个设备的标识列表
     */
    @SneakyThrows
    public QueryClientIdsResponse queryClientIdsWithOptions(QueryClientIdsRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getIotId(), "iotId is null");
        return getClient().queryClientIdsWithOptions(request, runtimeOptions);
    }

    /**
     * TransformClientId
     * 一型一密免注册场景下，若设备包含多个设备标识，需调用该接口指定一个正确的设备标识，以防止非法的设备登录
     */
    @SneakyThrows
    public TransformClientIdResponse queryClientIdsWithOptions(TransformClientIdRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        // 设备ID
        Assert.notNull(request.getIotId(), "iotId is null");
        // 设备标识ID
        Assert.notNull(request.getClientId(), "clientId is null");
        return getClient().transformClientIdWithOptions(request, runtimeOptions);
    }

    /**
     * DeleteClientIds
     * 一型一密免注册场景下，若单个设备的标识个数超出限制（5个），可调用该接口删除设备下的所有标识
     */
    @SneakyThrows
    public DeleteClientIdsResponse queryClientIdsWithOptions(DeleteClientIdsRequest request, RuntimeOptions runtimeOptions) {
        if (StringUtils.isBlank(request.getIotInstanceId())) {
            request.setIotInstanceId(aliyunIotConfig.getIotInstanceId());
        }
        Assert.notNull(request.getIotId(), "iotId is null");
        return getClient().deleteClientIdsWithOptions(request, runtimeOptions);
    }

}
