package com.MusicCamp.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info);
    }

    Info info = new Info().title("MusicCamp API입니다").version("0.0.1").description(
            "<h3>백엔드 API 명세서</h3>" +
                    "<br>" + "MusicCamp-SERVER API 작성자<br>" +
                    "이승주: dltmdwn0111@gmail.com" );
}