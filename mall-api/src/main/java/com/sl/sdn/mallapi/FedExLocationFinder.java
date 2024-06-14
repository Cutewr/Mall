package com.sl.sdn.mallapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FedExLocationFinder {

    private static final String API_URL = "https://apis-sandbox.fedex.com/location/v1/locations";
    private static final String CONTENT_TYPE = "application/json";
    private static final String AUTHORIZATION = "Bearer 02820acd08544e16945cb07492b7f4f8l7063bef08439d4bb8b5a4971b8e74c7cc"; // 替换为您的访问令牌

    public static void main(String[] args) {
        try {
            findFedExLocations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void findFedExLocations() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(API_URL);

        // 设置头部信息
        httpPost.setHeader("content-type", CONTENT_TYPE);
        httpPost.setHeader("authorization", AUTHORIZATION);

        // 准备JSON请求体
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> locationsSummaryRequestControlParameters = new HashMap<>();
        Map<String, Object> constraints = new HashMap<>();
        Map<String, Object> location = new HashMap<>();
        Map<String, String> address = new HashMap<>();

        address.put("postalCode", "10001");
        address.put("countryCode", "US");

        location.put("address", address);

        constraints.put("locationSearchCriterion", "ADDRESS");
        constraints.put("location", location);
        constraints.put("multipleMatchesAction", "RETURN_ALL");
        constraints.put("sameState", true);
        constraints.put("sameCountry", true);
        constraints.put("redirectToHoldType", "FEDEX_EXPRESS");

        constraints.put("dropoffTime", "16:00:00");
        constraints.put("dropOffServiceType", "FedEx Ground");
        constraints.put("getCall", true);

        constraints.put("locationAttrTypes", new String[]{
                "ACCEPTS_CASH",
                "FEDEX_RETURNS_TECHNOLOGY",
                "COPY_AND_PRINT_SERVICES"
        });

        constraints.put("locationTypes", new String[]{
                "FEDEX_AUTHORIZED_SHIP_CENTER",
                "FEDEX_OFFICE"
        });

        constraints.put("carrierCodes", new String[]{
                "FDXE",
                "FDXG"
        });

        locationsSummaryRequestControlParameters.put("constraints", constraints);
        requestBody.put("locationsSummaryRequestControlParameters", locationsSummaryRequestControlParameters);

        // 将请求体转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequestBody = objectMapper.writeValueAsString(requestBody);

        // 设置JSON请求体
        StringEntity requestEntity = new StringEntity(jsonRequestBody);
        httpPost.setEntity(requestEntity);

        // 执行请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        System.out.println(response);

        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // 打印响应
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
        } finally {
            response.close();
        }
    }
}
