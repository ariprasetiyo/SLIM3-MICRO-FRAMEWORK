/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller.webcam;

import ari.test.util.ThymeleafUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author ari-prasetiyo
 */
public class IndexController extends Controller {

    protected Navigation run() {
        System.out.println("test");
        try {
            WebContext ctx = new WebContext(request, response, servletContext,
                    request.getLocale());
            ThymeleafUtil.getTemplateEngine().process("/webcam/index", ctx, response.getWriter());

        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
