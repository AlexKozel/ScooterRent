package com.example.controllersTests;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 3/31/17.
 */
@Component
public class TestHelper {


    /**
     *  доделать в свободное время, гет работет
     *
     * @return
     */
    public HttpEntity getRequestHeaders() {
        List<MediaType> acceptTypes = new ArrayList<MediaType>();
        acceptTypes.add(MediaType.APPLICATION_JSON_UTF8);

        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        reqHeaders.setAccept(acceptTypes);
        reqHeaders.add("Authorization", "Basic YWJjOmFkbWlu");

        return new HttpEntity<String>("parameters", reqHeaders);
    }

}