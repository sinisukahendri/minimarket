/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop.minimarket.ui.servlet;

/**
 *
 * @author Jaka
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import workshop.minimarket.entity.Barang;
import workshop.minimarket.service.MinimarketService;

@SuppressWarnings("serial")
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
//
//        MinimarketService service =
//                (MinimarketService) ctx.getBean("minimarketService");
//
//        List<Barang> semuaBarang = service.cariSemuaBarang();

        resp.setContentType("text/html");

        String output = "<html>";
        output += "<head>";
        output += "<title>Admin Barang</title>";
        output += "</head>";
        output += "<body>";
        output += "HELLO";
//        output += "<table>";
//
//        for (Barang b : semuaBarang) {
//            output += "<tr>";
//            output += "<td>" + b.getNama_barang() + "</td>";
//            output += "<td>" + b.getKodeBarang() + "</td>";
//            output += "<td><a href='edit?id=" + b.getKodeBarang() + "'>edit</a>";
//            output += " | <a href='delete?id=" + b.getKodeBarang() + "'>delete</a></td>";
//            output += "</tr>";
//        }
//
//        output += "</table>";

        output += "</body>";
        output += "</html>";

        resp.getWriter().print(output);
        resp.getWriter().close();


    }
}