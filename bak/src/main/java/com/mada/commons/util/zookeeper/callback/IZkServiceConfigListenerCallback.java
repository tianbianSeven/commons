package com.mada.commons.util.zookeeper.callback;

import com.mada.commons.enumeration.ServiceEnum;
import com.mada.commons.util.zookeeper.entity.ZkConfigurationNodeEntity;

/**
 * Created by madali on 2017/4/27.
 */
public interface IZkServiceConfigListenerCallback {

    void onAdd(ServiceEnum serviceEnum, ZkConfigurationNodeEntity configurationNodeEntity);

    void onUpdate(ServiceEnum serviceEnum, ZkConfigurationNodeEntity configurationNodeEntity);

    void onRemove(ServiceEnum serviceEnum, ZkConfigurationNodeEntity configurationNodeEntity);
}
