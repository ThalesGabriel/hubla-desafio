package org.thales.hublafullstack.infrastructure.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequestMapping(value = "transactions")
@Tag(name = "Transactions")
public interface TransactionApi {

  @PostMapping(
          consumes = { "multipart/form-data" },
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  @Operation(summary = "Create transactions from file")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Created successfully"),
          @ApiResponse(responseCode = "422", description = "A validation error was thrown"),
          @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
  })
  ResponseEntity<?> create(@RequestParam("file") MultipartFile file) throws Exception;


  @GetMapping
  @Operation(summary = "List all transactions paginated")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Listed successfully"),
          @ApiResponse(responseCode = "422", description = "A invalid parameter was received"),
          @ApiResponse(responseCode = "500", description = "An internal server error was thrown"),
  })
  List<Map> listTransactions(
          @RequestParam(name = "page", required = false, defaultValue = "0") final int page,
          @RequestParam(name = "perPage", required = false, defaultValue = "10") final int perPage
  );


}

