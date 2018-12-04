package com.agri.service;

import com.agri.request.FormerRequest;
import com.agri.response.FormerResponse;

import java.util.List;
import java.util.Map;

public interface FormerService {

    FormerResponse addFormer(final FormerRequest request);

    FormerResponse updateFormer(final FormerRequest request);

    List<FormerResponse> searchFormer(final Map<String, String> searchParams);
}
