package com.galaxyt.capricorn.zuul.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import com.galaxyt.capricorn.common.enums.GlobalExceptionCode;
import com.galaxyt.capricorn.common.model.dto.ReturnValueLoader;
import com.galaxyt.capricorn.common.util.json.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理
 * 在网络震荡，请求超时等情况会使用到该配置
 * @author zhouqi
 * @date 2019-06-06 15:31
 * @version v1.0.0
 * @Description
 *
 * Modification History:
 * Date                 Author          Version          Description
---------------------------------------------------------------------------------*
 * 2019-06-06 15:31     zhouqi          v1.0.0           Created
 *
 */
@Component
public class ConsumerFallbackProvider implements FallbackProvider {

    private Logger LOGGER = LoggerFactory.getLogger(ConsumerFallbackProvider.class);


    @Override
    public String getRoute() {
        return "*"; //拦截所有的服务，若要单独指定可使用服务名
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() {

                if (cause != null) {
                    LOGGER.error("", cause.getCause());
                }

                ReturnValueLoader rvl = new ReturnValueLoader(GlobalExceptionCode.FALLBACK_EXCEPTION_CODE.getCode(), route + "服务降级");

                return new ByteArrayInputStream(GsonUtil.getJson(rvl).getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
