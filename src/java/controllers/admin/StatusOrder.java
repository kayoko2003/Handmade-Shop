/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.admin;

import DAL.DAO;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class StatusOrder extends HttpServlet {

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
            out.println("<title>Servlet StatusOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StatusOrder at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        List<Order> order = dao.getAllOrder();

        int i = 0;
        for (Order order1 : order) {
            String text = "status" + order1.getOrderId();
            String status = request.getParameter("status" + order1.getOrderId());
            switch (status) {
                case "ordered" ->
                    i = 1;
                case "processing" ->
                    i = 2;
                case "delivering" ->
                    i = 3;
                case "complete" ->
                    i = 4;
                case "cancel" ->
                    i = 5;
            }

            if (!status.equals(order1.getStatus())) {
                dao.changeStatusByIdOrder(i, order1.getOrderId());
                List<OrderDetail> orderDetail = dao.getAllOrderDetailById(String.valueOf(order1.getOrderId()));
                if (dao.getOrderByOrderID(order1.getOrderId()).getStatus().equals("cancel")) {
                    for (OrderDetail orderDetail1 : orderDetail) {
                        Product product = dao.getProductByID(String.valueOf(orderDetail1.getPid()));
                        dao.setQuantityProductCancel(orderDetail1.getQuantity(), product.getId_product());
                    }
                } else if (dao.getOrderByOrderID(order1.getOrderId()).getStatus().equals("complete")) {
                    for (OrderDetail orderDetail1 : orderDetail) {
                        Product product = dao.getProductByID(String.valueOf(orderDetail1.getPid()));
                        dao.setNumPerchases(orderDetail1.getQuantity(), product.getId_product());
                    }
                }
            }
        }

        response.sendRedirect("manager");
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
