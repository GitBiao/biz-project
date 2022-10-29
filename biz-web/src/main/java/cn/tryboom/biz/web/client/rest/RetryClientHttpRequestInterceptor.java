package cn.tryboom.biz.web.client.rest;

import org.springframework.core.Ordered;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * 重试 {@link ClientHttpRequestInterceptor}
 *
 * @author biao
 */
public class RetryClientHttpRequestInterceptor implements ClientHttpRequestInterceptor, Ordered {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        ClientHttpResponse response = null;
        try {
            response = execution.execute(request, body);
            if (!response.getStatusCode().is2xxSuccessful()) {
                // retry ...
            }
        } catch (IOException e) {
            // retry ...
        }

        return response;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
