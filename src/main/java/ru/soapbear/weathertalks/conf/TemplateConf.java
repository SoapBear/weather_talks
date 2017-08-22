package ru.soapbear.weathertalks.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

/**
 * Created by Pavel.Krizskiy on 8/22/2017.
 *
 * This class contains configuration for template.
 */
@Configuration
@PropertySource({
        "classpath:template.properties"})
public class TemplateConf {

    @Value("${prefix}")
    private String prefix;

    @Value("${suffix}")
    private String suffix;

    @Value("${templateMode}")
    private String templateMode;

    @Autowired
    ServletContext context;

    @Bean
    public AbstractConfigurableTemplateResolver templateResolver() {

        AbstractConfigurableTemplateResolver templateResolver = new ServletContextTemplateResolver(context);

        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setTemplateMode(templateMode);

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();

        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);

        String[] viewNames = new String[2];
        viewNames[0] = "*.html";
        viewNames[1] = "*.xhtml";

        viewResolver.setViewNames(viewNames);

        return viewResolver;
    }
}
