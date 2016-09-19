/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import ari.test.service.DoSaveService;
import ari.test.util.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import org.junit.Ignore;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;


@Ignore("untuk test data sysuser dan sysgroups")
public class SysUserTest {

    private static SysUserGroups admin, operator;
    private static SysUser ari;
    private static Logger log = Logger.getLogger(SysUserTest.class);

    //@Ignore("data sample sudah ready")
    @Test
    public void createGroupsSample() {
        DoSaveService sav = new DoSaveService();
        admin = new SysUserGroups();
        admin.setGroupsName("admin");
        sav.doSave(admin);
        operator = new SysUserGroups();
        operator.setGroupsName("operator");
        sav.doSave(operator);

        ari = new SysUser();
        ari.setName("ari");
        ari.setSysUserGroups(admin);
        sav.doSave(ari);

        ari = new SysUser();
        ari.setName("ari prasetiyo");
        ari.setSysUserGroups(admin);
        sav.doSave(ari);

        ari = new SysUser();
        ari.setName("prasetiyo");
        ari.setSysUserGroups(operator);
        sav.doSave(ari);
    }

    @Test
    public void checkJumlahDataGroups() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            String hql = "from SysUserGroups";
            List<SysUserGroups> groups = session.createQuery(hql).list();

            Map map = new HashMap();
            map.put("admin", 1);
            map.put("operator", 1);

            for (SysUserGroups group : groups) {
                if (map.get(group.groupsName) == null) {
                    log.debug("ada data yang gak bener");
                    assertTrue(false);
                }
            }

            String hqlUser = "select count(1) from SysUser";
            int resultCountUser = Integer.valueOf(session.createQuery(hqlUser).uniqueResult().toString());

            assertTrue(resultCountUser >= 3);

            transaction.commit();
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

}
