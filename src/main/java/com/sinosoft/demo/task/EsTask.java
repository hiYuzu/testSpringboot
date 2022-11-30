package com.sinosoft.demo.task;

import com.sinosoft.demo.client.ElasticsearchClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/27 14:23
 */
@Slf4j
@Component
public class EsTask {
    @Resource
    private ElasticsearchClient elasticsearchClient;

//    @PostConstruct
    public void testEs() {
        elasticsearchClient.createIndex("zxy_test_20220926");

        String id = "1";
        String name = "ddd";
        String zjhm = "12312312123123123";
        try {
            elasticsearchClient.batchSave(id, name, zjhm);
            Thread.sleep(5000);
            elasticsearchClient.search("ddd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        elasticsearchClient.dropIndex("zxy_test_20220926");
    }
}
