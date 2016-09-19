/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller;

import ari.test.model.SysUser;
import ari.test.service.DoReadService;
import java.util.logging.Logger;
import org.hibernate.criterion.Restrictions;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 *
 * @author ari-prasetiyo
 */
public class DoLoginController extends Controller {

    protected Navigation run() {
        String username = request.getParameter("username");

        SysUser users = new SysUser();
        DoReadService read = new DoReadService();
        SysUser data = (SysUser) read.doReadClass(users, Restrictions.eq("name", username));
        if (data != null) {
            String groupsName = data.getSysUserGroups().getGroupsName();
            request.getSession().setAttribute("userLevel", groupsName);
            Logger.getLogger(DoLoginController.class + "").info("berhasil login" + groupsName);
            return redirect("/" + groupsName + "/");
        }
        return redirect("");
    }
}
