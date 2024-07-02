package ru.netology.authorizationservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import ru.netology.authorizationservice.controller.UserHandlerMethodArgumentResolver;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcContext extends WebMvcConfigurerAdapter {
    /*
    Зарегистрируем класс UserHandlerMethodArgumentResolver в качестве распознавателя аргументов метода,
    внеся следующие изменения в класс конфигурации,
    который настраивает веб-уровень нашего веб-приложения Spring
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserHandlerMethodArgumentResolver());
    }
}
