package com.swedbank.balticcore.controller;

import com.swedbank.balticcore.dto.AddAccountRequestDTO;
import com.swedbank.balticcore.dto.GetAccountRequestDTO;
import com.swedbank.balticcore.dto.AccountResponseDTO;
import com.swedbank.balticcore.service.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class AccountController {

  private final AccountService accountService;


  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @Tag(name= "getAccount", description="Get account details")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Successful retrieval of account details"),
      @ApiResponse(responseCode = "400", description = "Something bad happened")
  })
  @GetMapping("/{id}")
  public AccountResponseDTO getAccount(@Parameter(description = "Account id", required = true, name = "id")
                                       @PathVariable("id") String id,
                                       @Parameter(description = "Language", required = true, name = "language")
                                       @RequestParam("language") String language,
                                       @Parameter(description = "format", required = true, name = "format")
                                       @RequestParam("format") String format,
                                       @Parameter(description = "openedBefore", name = "openedBefore")
                                       @RequestParam("openedBefore") LocalDate openedBefore
  ) {

    return accountService.getAccount(new GetAccountRequestDTO(id, language, format, openedBefore));
  }

  @Tag(name= "getAllAcounts", description="Get list of all acounts")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Successful retrieval of accounts list"),
      @ApiResponse(responseCode = "400", description = "Something bad happened")
  })
  @GetMapping
  public List<AccountResponseDTO> getAccounts(@RequestParam("format") String format) {

    return accountService.getAccounts(format);
  }

  @Tag(name= "addAccount", description="Add new account")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Account was added"),
      @ApiResponse(responseCode = "400", description = "Something bad happened")
  })
  @PostMapping
  public int addAccount(@Parameter(description = "Customer id", required = true, name = "customerId")
                                       @RequestParam("customerId") String customerId) {

    return accountService.addAcoount(new AddAccountRequestDTO(customerId));
  }

}

