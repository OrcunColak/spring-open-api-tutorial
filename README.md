# Read me

Example that shows how to use Swagger

Also see  
https://snowcloudbyte.medium.com/spring-boot-3-swagger-for-api-documentation-f2021dbc5b69

# Swagger

http://localhost:8080/swagger-ui/index.html
or
http://localhost:8080/swagger-ui/swagger-ui/index.html

# API Docs

http://localhost:8080/swagger-doc/v3/api-docs

# Annotating the REST controller
## Class-Level Annotations
 @Tag
 Describes the controller’s purpose and groups related endpoints.
 ```java
@RestController
@RequestMapping("/api/articles")
@Tag(name = "Article Management", 
  description = "CRUD operations for managing articles metadata")
public class ArticleController {
    // CRUD methods here
}
```

## Method-Level Annotations
@Operation: Describes the purpose of the endpoint with a summary and description.  
@ApiResponse: Describes the HTTP status codes returned by the endpoint and any associated information.  
@Parameter: Adds details about individual parameters passed to the endpoint, such as path variables or request bodies.

Example for Get
```java
@Operation(summary = "Get article by ID", description = "Fetches an article by its ID")
@ApiResponse(responseCode = "200", description = "Successfully found the article")
@ApiResponse(responseCode = "404", description = "Article not found")
@Parameter(name = "id", description = "ID of the article to retrieve", required = true)
@GetMapping("/{id}")
public Article getArticleById(@PathVariable Long id) {
    return articles.stream()
            .filter(article -> article.getId().equals(id))
            .findFirst()
            .orElse(null);
}
```

Example for Post
```java
@Operation(summary = "Create a new article", description = "Adds a new article to the list")
@ApiResponse(responseCode = "201", description = "Article created successfully")
@io.swagger.v3.oas.annotations.parameters.RequestBody(
    description = "Article object containing details of the new article",
    required = true
)
@PostMapping
public Article createArticle(@RequestBody Article article) {
    article.setId((long) (articles.size() + 1));
    articles.add(article);
    return article;
}
```

Example for Delete
```java
@Operation(summary = "Delete an article", description = "Deletes an article by its ID")
@ApiResponse(responseCode = "200", description = "Article deleted successfully")
@ApiResponse(responseCode = "404", description = "Article not found")
@DeleteMapping("/{id}")
public String deleteArticle(@PathVariable Long id) {
    articles.removeIf(article -> article.getId().equals(id));
    return "Article with ID " + id + " deleted successfully";
}
```

## Default parameters for request body objects
Use the @Schema annotation from Swagger/OpenAPI to define default values that will appear directly in Swagger UI. 
```java
import io.swagger.v3.oas.annotations.media.Schema;

public class Article {

    private Long id;

    @Schema(description = "Title of the article", example = "Sample Title")
    private String title;

    @Schema(description = "Author of the article", example = "Unknown Author")
    private String author;

    @Schema(description = "Content of the article", example = "Sample Content")
    private String content;

    // Constructors, getters, and setters
}
```

## Defining the Security Schema
With the @SecurityScheme and @SecurityRequirement annotations, you can seamlessly integrate JWT-based authentication or any other authentication with OpenAPI Swagger.  
```java
@SecurityScheme(
        name = "bearerAuth",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        description = "JWT Bearer token authentication"
)
public class OpenAPIConfig {
}
...
@RestController
@RequestMapping("/api/articles")
@Tag(name = "Article Management", description = "CRUD operations for managing articles metadata")
@SecurityRequirement(name = "bearerAuth")
public class ArticleController {
   //Code goes here
}
```

