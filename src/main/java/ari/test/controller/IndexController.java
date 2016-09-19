/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller;

import ari.test.util.ThymeleafUtil;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 *
 * @author ari-prasetiyo
 */
public class IndexController extends Controller {

    protected Navigation run() {
        System.out.println("dicoba");
        new ThymeleafUtil(request, response, servletContext);
        return null;
    }
}
