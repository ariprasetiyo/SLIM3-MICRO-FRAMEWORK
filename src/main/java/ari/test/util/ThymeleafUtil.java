/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 *
 * @author ari-prasetiyo
 */
public class ThymeleafUtil {

    public ThymeleafUtil(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        try {
            ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
            // XHTML is the default mode, but we will set it anyway for better understanding of code
            templateResolver.setTemplateMode("XHTML");
            templateResolver.setPrefix("/pages/");
            templateResolver.setSuffix(".html");
            templateResolver.setCacheTTLMs(3600000L);
            TemplateEngine templateEngine = new TemplateEngine();
            templateEngine.setTemplateResolver(templateResolver);
            //getServletConfig().getServletContext()

            WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
            // This will be prefixed with /WEB-INF/ and suffixed with .html
            templateEngine.process("/template/thymeleafLayout", ctx, response.getWriter());
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 1000);

        } catch (IOException ex) {
            Logger.getLogger(ThymeleafUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static TemplateEngine templateEngine;

    static {
        ServletContextTemplateResolver templateResolver
                = new ServletContextTemplateResolver();
        templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/pages/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    public static TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

}
