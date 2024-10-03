package com.colak.springtutorial.controller.get.quote;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller that returns Java type
@RestController
public class QuoteController {

    @Operation(summary = "Get quote")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Quote sent successfully.", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "403", description = "Quote not sent successfully.", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping(value = "/quote")
    public String quote() {
        return "quote";
    }

}
