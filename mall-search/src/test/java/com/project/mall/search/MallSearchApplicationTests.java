package com.project.mall.search;

import com.alibaba.fastjson.JSON;
import com.project.mall.search.config.MallElasticSearchConfig;
import com.project.mall.search.entity.Source;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class MallSearchApplicationTests {
    @Autowired
    private RestHighLevelClient client;

    @Test
    void contextLoads() {
        System.out.println(client);
    }

    @Data
    class User{
        private String name;
        private String gender;
        private Integer age;
    }

    /*
    * 测试存储数据到es
    * 更新也可以
    * */
    @Test
    void indexData() throws IOException {
        IndexRequest indexRequest=new IndexRequest("users");
        indexRequest.id("1");    //数据的id
        //indexRequest.source("username","zhangsan","age",18,"gender","男");   //以key-value对形式存储数据

        //将对象转成json数据
        User user = new User();
        user.setAge(18);
        user.setName("zhangsan");
        user.setGender("男");
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);    //要保存的内容
        //使用客户端执行es操作
        IndexResponse response = client.index(indexRequest, MallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(response);
    }

    /*
    * 复杂数据搜索
    * */
    @Test
    void searchData() throws IOException{
        //1、创建搜索请求
        SearchRequest searchRequest = new SearchRequest();
        //指定索引
        searchRequest.indices("bank");
        //指定检索条件
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();

        //1.1 构造检索条件
        sourceBuilder.query(QueryBuilders.matchQuery("address","mill"));
        //1.2 构造聚合条件
        //1.2.1 按照年龄分布进行聚合
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        //AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        //TermsAggregationBuilder ageAggBalanceAvg = ageAgg.subAggregation(balanceAvg);
        //1.2.2 求出年龄平均值
        //AvgAggregationBuilder ageAvg = AggregationBuilders.avg("ageAvg").field("age");
        sourceBuilder.size(0);
        sourceBuilder.aggregation(ageAgg);
        //打印检索条件
        System.out.println(sourceBuilder.toString());

        searchRequest.source(sourceBuilder);

        //2、执行搜索
        SearchResponse searchResponse = client.search(searchRequest, MallElasticSearchConfig.COMMON_OPTIONS);

        //
        System.out.println(searchResponse.toString());
    }

    // 按照年龄聚合，并且求这些年龄段人的平均薪资
    @Test
    void multiAggData() throws IOException{
        //1、构造检索条件
        SearchSourceBuilder sourceBuilder=new SearchSourceBuilder();
        // 检索所有数据
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        //构造聚合条件
        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(100);
        TermsAggregationBuilder ageAggBalanceAvg = ageAgg.subAggregation(balanceAvg);

        //sourceBuilder
        sourceBuilder.aggregation(ageAggBalanceAvg);

        //2、创建检索请求
        SearchRequest searchRequest=new SearchRequest();
        searchRequest.indices("bank");
        searchRequest.source(sourceBuilder);

        //3、发送检索请求
        SearchResponse searchResponse = client.search(searchRequest,MallElasticSearchConfig.COMMON_OPTIONS);

        //4、解析检索响应
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hits1 = hits.getHits();
        for (SearchHit hit : hits1) {
        /*
          "_index" : "bank",
          "_type" : "account",
          "_id" : "1",
          "_score" : 1.0,
          "_source" :*/
            String sourceAsString = hit.getSourceAsString();
            Source source = JSON.parseObject(sourceAsString, Source.class);
            System.out.println("source:"+source);
        }
       // System.out.println(searchResponse.toString());

    }

}
