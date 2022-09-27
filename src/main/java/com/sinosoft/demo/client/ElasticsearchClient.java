package com.sinosoft.demo.client;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/19 9:38
 */
@Slf4j
@Service("elasticsearchClient")
public class ElasticsearchClient {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    public void createIndex(String indexName) {
        String shell = "curl -XPUT elastic:Esadm8@188.2.44.107:9200/" + indexName + " -d '{\"settings\":{\"number_of_shards\":3,\"number_of_replicas\":2}}' -H 'Content-Type:application/json'";
        executeShell(shell);
    }

    public void dropIndex(String indexName) {
        String shell = "curl -XDELETE elastic:Esadm8@188.2.44.107:9200/" + indexName;
        executeShell(shell);
    }

    private void executeShell(String shell) {
        String[] cmd = new String[]{"/bin/sh", "-c", shell};
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        try {
            p = rt.exec(cmd);
            p.waitFor();
        } catch (Exception e) {
            log.error("执行错误:" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (p != null) {
                p.destroy();
            }
        }
    }

    public void search(String name) throws IOException {
        SearchRequest request = Requests.searchRequest("zxy_test*");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery("name", name));

        builder.query(boolQueryBuilder);
        request.source(builder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();

        for (SearchHit hit : hits) {
            log.info(JSONUtil.toJsonPrettyStr(hit.getSourceAsMap()));
        }
    }

    public void batchSave(String id, String name, String zjhm) throws IOException {
        ZxyTest data = new ZxyTest(id, name, zjhm, "20220926");
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("zxy_test_20220926").id(data.getId()).source(new ObjectMapper().writeValueAsString(data), XContentType.JSON));
        restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    @Data
    private static class ZxyTest {
        private String id;
        private String name;
        private String zjhm;

        private String date;

        public ZxyTest(String id, String name, String zjhm, String date) {
            this.id = id;
            this.name = name;
            this.zjhm = zjhm;
            this.date = date;
        }
    }
}