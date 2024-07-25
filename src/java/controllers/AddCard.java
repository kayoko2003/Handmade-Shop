/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAL.DAO;
import Model.Account;
import Model.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class AddCard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCard at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        DAO dao = new DAO();
        Account a = (Account) session.getAttribute("acc");
        List<Item> listItem = new ArrayList<>();

        if (a == null) {
            response.sendRedirect("login");
            return;
        } else {
            listItem = dao.listItemCardByUserID(a.getId());
        }

        String pid = request.getParameter("pid");
        String quantity = request.getParameter("quantity");

        Product product = dao.getProductByID(pid);
        int cid = product.getCategory().getcId();

        List<Product> listP = dao.getProductByCID(String.valueOf(cid));
        List<Model.Category> listC = dao.getAllCategory();

        int index = index(pid);
        listP.remove(index);

        boolean exist = false;

        for (Item item : listItem) {
            if (item.getProduct().getId_product() == Integer.parseInt(pid)) {
                int number = Integer.parseInt(quantity) + item.getQuantity();
                dao.updateToCart(a.getId(), pid, number);
                exist = true;
                break;
            }
        }
        if (exist == false) {
            dao.addToCart(a.getId(), pid, quantity);
        }

        request.setAttribute("size", dao.listItemCardByUserID(a.getId()).size());

        request.setAttribute("relate", listP);
        request.setAttribute("listC", listC);
        request.setAttribute("product", product);
        request.getRequestDispatcher("views/shop-detail.jsp").forward(request, response);
    }

    public int index(String pid) {
        int id = Integer.parseInt(pid);
        DAO dao = new DAO();
        Product product = dao.getProductByID(pid);
        int cid = product.getCategory().getcId();
        List<Product> listP = dao.getProductByCID(String.valueOf(cid));

        for (int i = 0; i < 10; i++) {
            if (listP.get(i).getId_product() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
