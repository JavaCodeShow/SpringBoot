package com.jf.prometheus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author 江峰
 * @date 2020/6/5 11:23
 * @Email: jiangfeng@jumstc.com
 * @description
 */
@Component
public class RegistrationService {

    private static final String[] NO_SERVICE_TAGS = new String[0];

    @Autowired
    private DiscoveryClient discoveryClient;

    // public Single<ChangeItem<Map<String, String[]>>> getServiceNames(long waitMillis, Long index) {
    //     return returnDeferred(waitMillis, index, () -> {
    //         List<String> services = discoveryClient.getServices();
    //         Set<String> set = new HashSet<String>();
    //         set.addAll(services);
    //
    //         Map<String, String[]> result = new HashMap<String, String[]>();
    //         for (String item : set) {
    //             result.put(item, NO_SERVICE_TAGS);
    //         }
    //         return result;
    //     });
    // }

    public Object getService(String appName) {
        List<ServiceInstance> instances = discoveryClient.getInstances(appName);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        if (instances == null) {
            return Collections.emptyList();
        } else {
            Set<ServiceInstance> instSet = new HashSet<ServiceInstance>(instances);
            for (ServiceInstance instance : instSet) {
                Map<String, Object> ipObj = new HashMap<String, Object>();

                ipObj.put("Address", instance.getHost());
                ipObj.put("Node", instance.getServiceId());
                ipObj.put("ServiceAddress", instance.getHost());
                ipObj.put("ServiceName", instance.getServiceId());
                ipObj.put("ServiceID", instance.getHost() + ":" + instance.getPort());
                ipObj.put("ServicePort", instance.getPort());
                ipObj.put("NodeMeta", Collections.emptyMap());
                Map<String, String> metaJo = new HashMap<String, String>();
                metaJo.put("management.port", "" + instance.getPort());
                ipObj.put("ServiceMeta", metaJo);
                ipObj.put("ServiceTags", Collections.emptyList());

                list.add(ipObj);
            }
            return list;
        }
    }
}