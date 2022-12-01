package org.thales.hublafullstack.infrastructure.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.thales.hublafullstack.infrastructure.api.TransactionApi;
import org.thales.hublafullstack.infrastructure.api.pagination.SearchQuery;
import org.thales.hublafullstack.infrastructure.api.service.TransactionService;
import org.thales.hublafullstack.infrastructure.gateway.TransactionJpaEntity;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
public class TransactionController implements TransactionApi {

  @Autowired
  private TransactionService service;

//  @Override
  public ResponseEntity<?> create(MultipartFile file) throws Exception {
    String content = new String(file.getBytes(), StandardCharsets.UTF_8).trim();
    String[] rows = content.split("\n");

    service.create(rows);

//    if (response.notificationErrors() != null)
//      return ResponseEntity.unprocessableEntity().body(response);

    return ResponseEntity.created(URI.create("")).body("");
  }



//  @Override
  public Map<Object, Map<Object, Map<Object, List<TransactionJpaEntity>>>> listTransactions(int page, int perPage) {
    return service.listTransactions(new SearchQuery(page, perPage));
  }

}
