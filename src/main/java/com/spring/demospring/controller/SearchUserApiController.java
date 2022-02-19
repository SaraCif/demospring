package com.spring.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.NativeWebRequest;

import com.spring.demospring.api.SearchUserApi;

import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-19T18:02:28.634+01:00[Europe/Berlin]")
@Controller
@RequestMapping("${openapi.swaggerDemoSpring.base-path:}")
public class SearchUserApiController implements SearchUserApi {

    private final NativeWebRequest request;

    @Autowired
    public SearchUserApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
