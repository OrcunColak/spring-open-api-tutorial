package com.colak.springtutorial.controller.get.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Controller that returns custom type
@RestController
@Tag(name = "HelloController API's", description = "Examples for operations like create/update/delete")
public class HelloController {

    @Operation(summary = "Say Hello API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create a new project",
                    content = {@Content(schema = @Schema(implementation = HelloResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Issue with Request",
                    content = {@Content(schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
    })
    @Parameter(name = "no arguments required ", description = "")
    @GetMapping("/sayhello")
    public HelloResponse sayHello() {
        return new HelloResponse("welcome to hello world");
    }

    @Operation(
            summary = "Retrieve all accounts",
            description = "Fetches a list of all HelloResponses",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HelloResponses returned",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = HelloResponse.class))
                            )
                    )
            }
    )
    @GetMapping("/sayHelloList")
    public List<HelloResponse> sayHelloList() {
        return List.of(new HelloResponse("welcome to hello world"));
    }
}
