package com.learn.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping(path = "/static-filtering")
    public SomeBean staticFiltering() {
        return new SomeBean("value1", "value2", "value3", "value4", "value5");
    }

    @GetMapping(path = "/static-filtering-list")
    public List<SomeBean> staticFilteringList() {
        return List.of(new SomeBean("value1", "value2", "value3", "value4", "value5"));
    }

    @GetMapping(path = "/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3", "value4", "value5");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    @GetMapping(path = "/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList() {
        List<SomeBean> list = List.of(new SomeBean("value1", "value2", "value3", "value4", "value5"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field5");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
}
