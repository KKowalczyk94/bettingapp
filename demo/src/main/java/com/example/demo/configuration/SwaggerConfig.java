//package com.example.demo.configuration;//package com.example.demo.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public  Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//}
//
////    @Bean
////    public OpenAPI customOpenAPI() {
////        return new OpenAPI()
////                .info(new Info()
////                        .title("Demo API")
////                        .version("1.0")
////                        .description("API documentation for the Demo application"));
////    }
////
////    @Bean
////    public GroupedOpenApi publicApi() {
////        return GroupedOpenApi.builder()
////                .group("public")
////                .pathsToMatch("/**")
////                .build();
////    }
//
