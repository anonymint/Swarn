package com.anonymint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Main Spring Boot
 *
 * @author <a href="mailto:mint.com@gmail.com">anonymint</a>
 * @since 2016-05-21
 */

@SpringBootApplication
@Controller
@Api(tags = {"Data API"}, description = "Data API version 2 powered by Swagger 2 and Spring Fox")
public class Application {

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/swagger-ui.html";
    }

    @ApiOperation(value = "getData", nickname = "getData nickname")
    @RequestMapping(value = "/api/v2/data/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Data getData(@PathVariable final long id) {
        return new Data(id, RequestMethod.GET.name());
    }

    @ApiOperation(value = "postData", nickname = "postData nickname")
    @RequestMapping(value = "/api/v2/data/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Data postData(@PathVariable final long id) {
        return new Data(id, RequestMethod.POST.name());
    }

    @ApiOperation(value = "putData", nickname = "putData nickname")
    @RequestMapping(value = "/api/v2/data/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Data putData(@PathVariable final long id) {
        return new Data(id, RequestMethod.PUT.name());
    }

    @Bean
    public EmbeddedServletContainerCustomizer errorHandlerPages() {
        return container -> container.addErrorPages(
                new ErrorPage(HttpStatus.NOT_FOUND, "/"),
                new ErrorPage(HttpStatus.BAD_REQUEST, "/")
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
