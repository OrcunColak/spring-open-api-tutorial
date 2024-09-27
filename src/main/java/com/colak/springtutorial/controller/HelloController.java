package com.colak.springtutorial.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "HelloController API's", description = "Examples for operations like create/update/delete")
public class HelloController {

    @Operation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new project",
                    content = {@Content(
                            schema = @Schema(implementation = HelloResponse.class)
                    )}),
            @ApiResponse(responseCode = "400", description = "Issue with Request",
                    content = {@Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(
                            schema = @Schema(implementation = ErrorResponse.class)
                    )})
    })
    @Parameter(name = "no arguments required ", description = "")
    @GetMapping("/sayhello")
    public HelloResponse sayHello() {
        return new HelloResponse("welcome to hello world");
    }
}
