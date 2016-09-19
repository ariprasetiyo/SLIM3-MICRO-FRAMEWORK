/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller.admin;

import ari.test.model.Kelurahan;
import ari.test.service.DoEditService;
import ari.test.service.DoReadService;
import ari.test.service.DoSaveService;
import ari.test.service.PrivilegeService;
import ari.test.util.ThymeleafUtil;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slim3.controller.Navigation;
import org.thymeleaf.context.WebContext;

/**
 *
 * @author ari-prasetiyo
 */
public class IndexController extends PrivilegeService {

    protected Navigation run() {
        PrivilegeServices();
        if (isPost()) {
            if (request.getParameter("save").equalsIgnoreCase("save")) {
                Kelurahan saveData = new Kelurahan();
                saveData.setKelurahan(request.getParameter("kelurahan"));
                saveData.setKecamatan(request.getParameter("kecamatan"));
                saveData.setKota(request.getParameter("kota"));
                DoSaveService sav = new DoSaveService();
                sav.doSave(saveData);
            } else if (request.getParameter("save").equalsIgnoreCase("edit")) {

                Kelurahan editData = new Kelurahan();
                DoEditService edit = new DoEditService();
                editData.setId(request.getParameter("UUID"));
                editData.setKelurahan(request.getParameter("kelurahan"));
                editData.setKecamatan(request.getParameter("kecamatan"));
                editData.setKota(request.getParameter("kota"));
                Kelurahan edsitData = editData;
                edit.doEdit(edsitData, request.getParameter("UUID"));
            }
        }
        try {
            Kelurahan data = new Kelurahan();
            DoReadService read = new DoReadService();
            List<Kelurahan> dataResult = read.doReadList(data);
            System.out.println(dataResult.size() + "----------------");
            for (Kelurahan sd : dataResult) {
                System.out.println(sd.getId());
            }
            WebContext ctx = new WebContext(request, response, servletContext,
                    request.getLocale());
            ctx.setVariable("data", dataResult);
            ThymeleafUtil.getTemplateEngine().process("/admin/index", ctx, response.getWriter());
        } catch (IOException ex) {
            Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
