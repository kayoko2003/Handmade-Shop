/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.admin;

import DAL.DAO;
import Model.Order;
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
public class DeleteUser extends HttpServlet {

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
            out.println("<title>Servlet DeleteUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteUser at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String id = request.getParameter("aid");
        DAO dao = new DAO();
        List<Order> order = dao.getOrderByUserId(Integer.parseInt(id));

        if (order.isEmpty()) {
            dao.deleteUser(id);
            response.sendRedirect("manager");
        } else {
            for (Order order1 : order) {
                if (!dao.getOrderByOrderID(order1.getOrderId()).getStatus().equals("complete")
                        || !dao.getOrderByOrderID(order1.getOrderId()).getStatus().equals("cancel")) {
                    session.setAttribute("message", "The user cannot be deleted because they have an order in process");
                    response.sendRedirect("manager");
                    return;
                } else {
                    dao.deleteOrderDetailByID(String.valueOf(order1.getOrderId()));
                    dao.deleteOrderByID(String.valueOf(order1.getOrderId()));
                }
            }
            dao.deleteUser(id);
            response.sendRedirect("manager");
        }

// if (dao.getOrderByUserId(Integer.parseInt(id)).equals("complete")
//                || dao.getOrderByUserId(Integer.parseInt(id)).equals("cancel")) {
//            for (Order order1 : order) {
//                dao.deleteOrderDetailByID(String.valueOf(order1.getOrderId()));
//                dao.deleteOrderByID(String.valueOf(order1.getOrderId()));
//            }
//            dao.deleteUser(id);
//            response.sendRedirect("manager");
//        } else {
//            session.setAttribute("message", "The user cannot be deleted because they have an order in process");
//            response.sendRedirect("manager");
//        }
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
