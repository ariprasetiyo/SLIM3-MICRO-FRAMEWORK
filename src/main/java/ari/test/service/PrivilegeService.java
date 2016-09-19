/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slim3.controller.Controller;

public abstract  class PrivilegeService extends Controller {

    public void PrivilegeServices() {
        System.out.println("test -------------"+request.getSession().getAttribute("userLevel"));
        String userLevel = (String) request.getSession().getAttribute("userLevel");
        String uri = request.getRequestURI();
        String[] privilegeAdmin = {"admin", "operator"};
        String[] privilegeOperator = {"operator", "doPrint"};
        if (userLevel != null) {
            if (userLevel.equals("admin")) {
                boolean accessRight = false;
                for (String data : privilegeAdmin) {
                    if (uri.contains(data)) {
                        accessRight = true;
                    }
                }
                if (!accessRight) {
                    try {
                        response.sendRedirect("../");
                    } catch (IOException ex) {
                        Logger.getLogger(PrivilegeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (userLevel.equals("operator")) {
                boolean accessRight = false;
                for (String data : privilegeOperator) {
                    if (uri.contains(data)) {
                        accessRight = true;
                    }
                }
                if (!accessRight) {
                    try {
                        response.sendRedirect("../");
                    } catch (IOException ex) {
                        Logger.getLogger(PrivilegeService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            try {
                response.sendRedirect("../");
            } catch (IOException ex) {
                Logger.getLogger(PrivilegeService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
