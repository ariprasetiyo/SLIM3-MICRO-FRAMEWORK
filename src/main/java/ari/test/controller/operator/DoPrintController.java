/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.controller.operator;

import ari.test.model.Pasien;
import ari.test.service.DoReadService;
import ari.test.service.PrivilegeService;
import org.hibernate.criterion.Restrictions;
import org.slim3.controller.Navigation;

/**
 *
 * @author ari-prasetiyo
 */
public class DoPrintController extends PrivilegeService {

    @Override
    protected Navigation run() throws Exception {
        PrivilegeServices();
        response.setContentType("text/html");
        String uUid = request.getParameter("id");
        Pasien data = new Pasien();
        DoReadService read = new DoReadService();
        data = (Pasien) read.doReadClass(data, Restrictions.eq("id", uUid));
        response.getWriter().write(printLayout(data));
        return null;
    }

    private String printLayout(Pasien data) {
        return ("<html>"
                + "    <head>"
                + "        <title>Print Kartu Pasien</title>"
                + "        <meta charset='UTF-8'>"
                + "        <meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "    </head>"
                + "    <body>"
                + "        <style>"
                + "            .font_all{"
                + "                font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif;"
                + "                font-size: 13px;"
                + "            }"
                + "            .font_size_header_center{"
                + "                font-size: 18px;"
                + "                text-align:center;   "
                + "            }"
                + "            .font_size_header_enter_12px{"
                + "                font-size: 12px;"
                + "                text-align:center; "
                + "                padding-right: 100px;"
                + "            }"
                + "            .font_size_header_left{"
                + "                font-size: 18px;"
                + "                text-align:left; "
                + "                margin-left: 1px;"
                + "            }"
                + "            .font_size_header_left_12px{"
                + "                font-size: 12px;"
                + "                text-align:left; "
                + "                margin-left: 1px;"
                + "            }"
                + "            .box_bagian_atas {"
                + "                padding-bottom: 1px;"
                + "                margin: 0px 11px 1px;"
                + "            }"
                + "            .box_bagian_body {"
                + "                padding-bottom: 1px;"
                + "                margin: 0px 11px 1px;"
                + "                border-bottom: 1px solid #EEE;"
                + "            }"
                + "            .box_bagian_bawah {"
                + "                padding-bottom: 1px;"
                + "                margin: 0px 11px 1px;"
                + "                border-bottom: 1px solid #EEE;"
                + "            }"
                + "            .box_all{"
                + "                padding-left: 1%;"
                + "                width:100%;"
                + "            }"
                + "            .row {"
                + "                margin-right: 1%;"
                + "                margin-left: 1%;"
                + "            }"
                + "            /* css tabel */"
                + "            td {"
                + "                border: 0px;"
                + "                text-align: left;"
                + "                padding: 0px 0px;"
                + ""
                + "            }"
                + "            .text-center{"
                + "                text-align: center;"
                + "            }"
                + "            .text-left{"
                + "                text-align: left;"
                + "            }"
                + "            table {"
                + "                border-spacing: 0px;"
                + "                border-collapse: collapse;"
                + "                width: 100%;"
                + "                border: 0px;"
                + "            }"
                + "            input[type='checkbox'] {"
                + "                margin: 4px 0px 0px;"
                + "                line-height: normal;"
                + "            }"
                + "            .margin_left{"
                + "                margin-left:  10px;"
                + "            }"
                + "        </style>"
                + "        <div id='printable' class='font_all box_all' >"
                + "            <div class='box_bagian_atas'>"
                + "                <div class='font_size_header_center'  >No Kartu Pasien</div>"
                + "                <div class='font_size_header_center'  >" + data.getIdPasien() + "</div>"
                + "            </div>"
                + "            <table >"
                + "                <tr>"
                + "                    <td style='width: 10px; ' nowrap>Nama</td> "
                + "                    <td style='width: 0px; ' nowrap>:</td>"
                + "                    <td style='width: 30px' nowrap>" + data.getNama() + "</td> "
                + "                </tr>"
                + "            </table>"
                + "        </div>"
                + "    </body>"
                + "</html>"
                + "");
    }

}
