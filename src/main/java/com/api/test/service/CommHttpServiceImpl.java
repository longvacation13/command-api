package com.api.test.service;

import com.comm.code.CommCodeEnum;
import com.comm.dto.CommResDto;
import com.config.exception.CustomException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CommHttpServiceImpl implements CommHttpService {


    /**
     * http 2.0 test (blocking)
     * @return
     */
    @Override
    public CommResDto httpRequest() {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://httpbin.org/get"))
                .build();
        try{

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new CommResDto.Builder<String>()
                                .resultCode(response.statusCode()+"")
                                .resultData(response.body()).build();

        } catch (Exception e) {
            throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
    }
}
