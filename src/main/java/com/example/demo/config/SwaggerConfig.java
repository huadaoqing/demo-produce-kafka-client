package com.example.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
       // ParameterBuilder tokenPar = new ParameterBuilder();
        //用来统一一些公用参数，这里设置前端和后台登录的输入参数
/*        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("sessionId")
                .description("登录令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")  //参数类型为header中的参数
                .required(false)
                .build();
        ParameterBuilder tokenPar1 = new ParameterBuilder();
        tokenPar1.name("backSessionId")
                .description("后台登录令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        pars.add(tokenPar1.build());*/
        return new Docket(DocumentationType.SWAGGER_2)
     //           .globalOperationParameters(pars)//定义全局的请求参数
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build().directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
    	        .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class).apiInfo(apiInfo());
    }
	  
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("kafka生产者相关API")
                .description("kafka生产者相关API接口")
               // .termsOfServiceUrl("http://localhost:12011")
                .contact("Hua")
                .version("1.0")
                .build();
    }
    

}
