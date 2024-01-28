package com.api.test.service;

import com.comm.dto.CommResDto;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface CommHttpService {

    CommResDto httpRequest();

}
