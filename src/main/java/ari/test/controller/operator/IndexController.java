/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller.operator;

import ari.test.model.Pasien;
import ari.test.ref.JenisKelamin;
import ari.test.service.DoReadService;
import ari.test.service.DoSaveService;
import ari.test.service.GenerateIdPasienService;
import ari.test.service.PrivilegeService;
import ari.test.util.HibernateUtil;
import ari.test.util.ThymeleafUtil;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
                Pasien saveData = new Pasien();
                Logger.getLogger(IndexController.class.getName())
                        .info("jenis kelamin : " + request.getParameter("jenisKelamin")
                                + "\ntanggal lahir : " + request.getParameter("tglLahir")
                                + "\nkelurahan : " + request.getParameter("kelurahan")
                        );
                saveData.setIdPasien(new GenerateIdPasienService().doGenerate());
                saveData.setNama(request.getParameter("nama"));
                saveData.setJenisKelamin(
                        (request.getParameter("jenisKelamin")).equals("0") ? JenisKelamin.Laki : JenisKelamin.Perempuan);
                saveData.setKelurahan(request.getParameter("kelurahan"));
                saveData.setNoHp(request.getParameter("noHp"));
                saveData.setAlamat(request.getParameter("alamat"));
                saveData.setRt(Integer.valueOf(request.getParameter("rt")));
                saveData.setRw(Integer.valueOf(request.getParameter("rw")));
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateLahir = null;
                try {
                    dateLahir = dateFormat.parse(request.getParameter("tglLahir"));
                    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String d = dateFormat.format(dateLahir);
                    saveData.setTanggalLahir(dateFormat.parse(d));
                } catch (ParseException ex) {
                    Logger.getLogger(IndexController.class.getName()).log(Level.SEVERE, null, ex);
                }
                DoSaveService sav = new DoSaveService();
                sav.doSave(saveData);
            }
        }
        try {
            Pasien data = new Pasien();
            DoReadService read = new DoReadService();
            List<Pasien> dataResult = read.doReadList(data);

            WebContext ctx = new WebContext(request, response, servletContext,
                    request.getLocale());
            ctx.setVariable("data", dataResult);
            ctx.setVariable("dataKelurahan", getKelurahan());
            ThymeleafUtil.getTemplateEngine().process("/operator/index", ctx, response.getWriter());
        } catch (IOException ex) {
            Logger.getLogger(ari.test.controller.admin.IndexController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<String> getKelurahan() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<String> dataList = new ArrayList<String>();
        try {
            transaction = session.beginTransaction();
            String hql = "select k.kelurahan  from Kelurahan k";
            dataList = session.createQuery(hql).list();
            transaction.commit();
        } catch (Exception x) {
            x.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return dataList;
    }
}
