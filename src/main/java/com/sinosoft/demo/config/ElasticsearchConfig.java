package com.sinosoft.demo.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Elasticsearch 配置
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/19 9:30
 */
@Configuration
public class ElasticsearchConfig {
    @Value("${sinosoft.elasticsearch.client.ips}")
    private String clientIps;

    @Value("${sinosoft.elasticsearch.client.ports}")
    private String clientPorts;

    @Value("${sinosoft.elasticsearch.client.username}")
    private String clientUserName;

    @Value("${sinosoft.elasticsearch.client.password}")
    private String clientPassword;

    @Value("${sinosoft.elasticsearch.client.scheme}")
    private String clientScheme;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        //集群节点构造
        String[] hosts = clientIps.split(",");
        HttpHost[] httpHosts = new HttpHost[hosts.length];
        for(int i=0;i<hosts.length;i++) {
            httpHosts[i] = new HttpHost(hosts[i], Integer.parseInt(clientPorts.split(",")[i]), clientScheme);
        }
        //带用户名密码
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(clientUserName, clientPassword));
        RestClientBuilder builder = RestClient.builder(httpHosts).setRequestConfigCallback(requestConfigBuilder -> {
            requestConfigBuilder.setConnectTimeout(-1);
            requestConfigBuilder.setSocketTimeout(-1);
            requestConfigBuilder.setConnectionRequestTimeout(-1);
            return requestConfigBuilder;
        }).setHttpClientConfigCallback(httpClientBuilder -> {
            httpClientBuilder.disableAuthCaching();
            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
        });

        return new RestHighLevelClient(builder);
    }
}
