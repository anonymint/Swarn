package com.anonymint;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description of this class
 *
 * @author <a href="mailto:mint.com@gmail.com">anonymint</a>
 * @since 2016-05-21
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {

    private SpringSwaggerConfig swaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig swaggerConfig) {
        this.swaggerConfig = swaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin swaggerSpringMvcPlugin() {
        return new SwaggerSpringMvcPlugin(swaggerConfig)
                .swaggerGroup("business-api")
                .includePatterns("/data.*")
                .apiInfo(apiInfo())
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "The swarn api version 1",
                "Swarn API document version 1",
                "http://en.wikipedia.org/wiki/Terms_of_service",
                "mint.com@gmail.com",
                "The MIT License (MIT)",
                "https://opensource.org/licenses/MIT"
        );
        return apiInfo;
    }

}
