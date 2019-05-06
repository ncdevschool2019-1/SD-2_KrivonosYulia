package com.netcracker.projectmanager.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RestCustomPage<T> extends PageImpl<T> {

    private static final long serialVersionUID = 3248189030448292002L;


    public RestCustomPage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public RestCustomPage(List<T> content) {
        super(content);
    }

    public  RestCustomPage(){
        super(new ArrayList<T>());
    }



    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RestCustomPage(@JsonProperty("content") List<T> content,
                        @JsonProperty("number") int number,
                        @JsonProperty("size") int size,
                        @JsonProperty("totalElements") Long totalElements,
                        @JsonProperty("pageable") JsonNode pageable,
                        @JsonProperty("last") boolean last,
                        @JsonProperty("totalPages") int totalPages,
                        @JsonProperty("sort") JsonNode sort,
                        @JsonProperty("first") boolean first,
                        @JsonProperty("numberOfElements") int numberOfElements) {

        super(content, PageRequest.of(number, size), totalElements);
    }
}
