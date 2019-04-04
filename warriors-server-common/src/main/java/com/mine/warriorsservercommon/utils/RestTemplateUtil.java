package com.mine.warriorsservercommon.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;
import java.util.Map;

@Slf4j
@Component
public class RestTemplateUtil {

    /**
     * @param url          接口地址
     * @param httpMethod   请求方式   GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE
     * @param param        参数
     * @param responseType 返回类型   Object.class
     * @param <T>
     * @param <K>
     * @return
     */
    public <T, K> ResponseEntity<K> exchange(String url, HttpMethod httpMethod, T param, Class<K> responseType) {
        RestTemplate restTemplate = HttpsClient.getRestTemplate();
        ResponseEntity<K> resp = null;
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        httpHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<T> httpEntity = new HttpEntity<>(param, httpHeaders);
        try {
            for (int i = 1; i <= 3; i++) {
                log.info("第" + i + "次请求" + url);
                try {
                    resp = restTemplate.exchange(url, httpMethod, httpEntity, responseType);
                    if (resp.getStatusCodeValue() == 200) {
                        log.info("接口返回" + JSON.toJSONString(resp.getBody()));
                        break;
                    }
                } catch (Exception e) {
                    log.info("接口调用报错：");
                    log.info(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}

class HttpsClient {

    public static RestTemplate restTemplate = null;

    public static RestTemplate getRestTemplate() {
        return restTemplate;
    }

    static {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext;
        try {
            sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
            HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
            requestFactory.setHttpClient(httpClient);
            restTemplate = new RestTemplate(requestFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

