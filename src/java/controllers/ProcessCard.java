/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAL.DAO;
import Model.Account;
import Model.Item;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class ProcessCard extends HttpServlet {

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
            out.println("<title>Servlet ProcessCard</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessCard at " + request.getContextPath() + "</h1>");
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
        String delete = request.getParameter("delete");
        String update = request.getParameter("update");
        List<Model.Category> listC = dao.getAllCategory();

        if (delete != null) {
            String pid = request.getParameter("pid");
            dao.removeItemFromCart(pid, a.getId());
        }

        List<Item> items = dao.listItemCardByUserID(a.getId());

        if (update != null) {
            for (Item item : items) {
                String quantity = request.getParameter("pid" + item.getProduct().getId_product());
                dao.updateToCart(a.getId(), String.valueOf(item.getProduct().getId_product()), Integer.parseInt(quantity));
            }
        }

        for (Item item : dao.listItemCardByUserID(a.getId())) {
            if (item.getQuantity() == 0) {
                dao.removeItemFromCart(String.valueOf(item.getProduct().getId_product()), a.getId());
            }
        }

        
        
        request.setAttribute("totalmoney", dao.getCartByUserId(a.getId()).getTotalMoney());
        request.setAttribute("size", dao.listItemCardByUserID(a.getId()).size());
        request.setAttribute("listItem", dao.listItemCardByUserID(a.getId()));
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("views/cart.jsp").forward(request, response);
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
