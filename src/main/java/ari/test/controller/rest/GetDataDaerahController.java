/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller.rest;

import ari.test.model.Kelurahan;
import ari.test.service.DoReadService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.Restrictions;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 *
 * @author ari-prasetiyo
 */
public class GetDataDaerahController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        if (isPost()) {
            try {
                String id = request.getParameter("id");
                Gson gson = new Gson();
                Kelurahan lurah = new Kelurahan();
                DoReadService read = new DoReadService();
                lurah = (Kelurahan) read.doReadClass(lurah, Restrictions.eq("id", id));

                JsonElement jE = gson.toJsonTree(lurah);
                JsonObject jO = new JsonObject();
                jO.add("dataWilayah", jE);
                response.setContentType("application/json");
                response.getWriter().print(jO);
            } catch (IOException ex) {
                Logger.getLogger(GetDataDaerahController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

}
