package ru.soapbear.weathertalks.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Pavel.Krizskiy on 8/21/2017.
 *
 * This class contains main configuration of app.
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import({DatabaseConf.class, TemplateConf.class})
@ComponentScan("ru.soapbear.weathertalks")
public class AppConf extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
