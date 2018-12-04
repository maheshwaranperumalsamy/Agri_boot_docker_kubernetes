package com.agri.controller;

import com.agri.request.FormerRequest;
import com.agri.response.FormerResponse;
import com.agri.service.FormerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/former/")
public class FormerController {

    private final FormerService service;

    @Autowired
    public FormerController(final FormerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public FormerResponse addFormer(@RequestBody final FormerRequest request) {
        return service.addFormer(request);
    }

    @PostMapping(value = "{formerId}")
    @ResponseStatus(HttpStatus.OK)
    FormerResponse updateFormer(final FormerRequest request) {
        return service.updateFormer(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<FormerResponse> searchFormer(final Map<String, String> searchParams) {
        return service.searchFormer(searchParams);
    }
}
