package com.spring.swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SwaggerController {

  @ApiOperation(value="API Title", notes="API Description")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "apiParameter", dataType = "string", paramType = "query", example = "Swagger"),
      @ApiImplicitParam(name = "swaggerYn", dataType = "string", paramType = "query", example = "Y", allowEmptyValue = true, allowableValues = "Y, N")
  })
  @GetMapping(value = "/Swagger")
  public ResponseEntity getSwagger(@RequestParam String apiParameter, @RequestParam(required = true) String swaggerYn){
    String str = "Hello! ";
    str += apiParameter;
    str += "\n SwaggerYn is ";
    str += swaggerYn;
    return ResponseEntity.ok(str);
  }

  @ApiOperation(value = "This method is used to get the current date.", hidden = false)
  @GetMapping("/getDate")
  public LocalDate getDate() {
    return LocalDate.now();
  }

  @ApiOperation(value = "PostMapping", hidden = false)
  @PostMapping("/post")
  public ResponseEntity postData() {
    /* Business Logic */
    return ResponseEntity.ok("Y");
  }

  @ApiOperation(value = "PutMapping", hidden = false)
  @PutMapping("/put")
  public ResponseEntity putData() {
    /* Business Logic */
    return ResponseEntity.ok("Y");
  }

  @ApiOperation(value = "DeleteMapping", hidden = false)
  @DeleteMapping("/post")
  public ResponseEntity deleteData() {
    /* Business Logic */
    return ResponseEntity.ok("Y");
  }
}
