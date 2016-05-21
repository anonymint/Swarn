package com.anonymint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger Config
 *
 * @author <a href="mailto:mint.com@gmail.com">anonymint</a>
 * @since 2016-05-21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket dataApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("data-api")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/api/.*/data/.*"))
                .build();

    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "The swarn API",
                "Swarn API document",
                "Version 2",
                "http://en.wikipedia.org/wiki/Terms_of_service",
                contact(),
                "The MIT License (MIT)",
                "https://opensource.org/licenses/MIT"
        );
        return apiInfo;
    }

    private Contact contact() {
        return new Contact("anonymint", "www.3kalak.com", "mint.com@gmail.com");
    }

}
