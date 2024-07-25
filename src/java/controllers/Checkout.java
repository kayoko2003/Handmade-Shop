/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAL.DAO;
import Model.Account;
import Model.Cart;
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
public class Checkout extends HttpServlet {

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
            out.println("<title>Servlet Checkout</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Checkout at " + request.getContextPath() + "</h1>");
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
        int number = 0;
        Account a = (Account) session.getAttribute("acc");

        List<Item> list = dao.listItemCardByUserID(a.getId());
        
        if(list.isEmpty()){
            request.setAttribute("cardempty", "Your cart is empty");
            request.getRequestDispatcher("views/cart.jsp").forward(request, response);
            return;
        }
        
        for (Item item : list) {
            if (item.getQuantity() > dao.getProductByID(String.valueOf(item.getProduct().getId_product())).getQuantity()) {
                if (dao.getProductByID(String.valueOf(item.getProduct().getId_product())).getQuantity() == 0) {
                    dao.removeItemFromCart(String.valueOf(item.getProduct().getId_product()), a.getId());
                } else {
                    dao.updateToCart(a.getId(),
                            String.valueOf(item.getProduct().getId_product()),
                            dao.getProductByID(String.valueOf(item.getProduct().getId_product())).getQuantity());
                }
                number++;
            }
        }
        if (number > 0) {
            request.setAttribute("mess", "Some product are sold out or not enough quantity");
            request.setAttribute("totalmoney", dao.getCartByUserId(a.getId()).getTotalMoney());
            request.setAttribute("size", dao.listItemCardByUserID(a.getId()).size());
            request.setAttribute("listItem", dao.listItemCardByUserID(a.getId()));
            request.getRequestDispatcher("views/cart.jsp").forward(request, response);
        } else {
            dao.addOrder(a, dao.getCartByUserId(a.getId()).getTotalMoney());
            for (Item item : list) {
                dao.addOrderDetail(item, dao.getLastOrder());
                dao.UpdateAfterOrder(item);
                dao.removeItemFromCart(String.valueOf(item.getProduct().getId_product()), a.getId());
            }
            response.sendRedirect("home");
        }
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
