/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DAL.DAO;
import Model.Account;
import Model.Cart;
import Model.Category;
import Model.Item;
import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class Shop extends HttpServlet {

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
            out.println("<title>Servlet Shop</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Shop at " + request.getContextPath() + "</h1>");
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

        List<Product> list1 = dao.getAllProductExceptSoldOut();
        List<Category> listC = dao.getAllCategory();
        List<Product> topLatest = dao.getTop6Latest();

        List<Item> listItem = new ArrayList<>();

        if (a != null) {
            listItem = dao.listItemCardByUserID(a.getId());
        }

        int size = list1.size();
        int page, numperpage = 9;
        int num = (size % numperpage == 0 ? (size / numperpage) : (size / numperpage) + 1);
        String xpage = request.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start, end;
        start = (page - 1) * numperpage;
        end = Math.min(page * numperpage, size);

        String pid = request.getParameter("pid");

        Product product = dao.getProductByID(pid);
        int numProduct = 0;
        if (a != null && pid != null) {
            Cart cart = dao.getCartByUserId(a.getId());
            Item item = cart.getItemById(Integer.parseInt(pid));
            if (item != null) {
                numProduct = item.getQuantity();
            }
        }

        if (pid != null && a == null) {
            response.sendRedirect("login");
            return;
        } else if (a != null && pid != null && numProduct < product.getQuantity()) {

            boolean exist = false;

            for (Item item : listItem) {
                if (item.getProduct().getId_product() == Integer.parseInt(pid)) {
                    int number = 1 + item.getQuantity();
                    dao.updateToCart(a.getId(), pid, number);
                    exist = true;
                    break;
                }
            }
            if (exist == false) {
                dao.addToCart(a.getId(), pid, "1");
            }
        } else if (a != null && pid != null) {
            session.setAttribute("messshop", product.getName_product() + " not enough quantity, sorry about that!!!");
        }

        List<Product> list = dao.getListByPage(list1, start, end);
        if (a != null && pid != null) {
            listItem = dao.listItemCardByUserID(a.getId());
        }

        request.setAttribute("size", listItem.size());
        request.setAttribute("page", page);
        request.setAttribute("num", num);
        request.setAttribute("listP", list);
        request.setAttribute("listC", listC);
        request.setAttribute("latest", topLatest);
        request.getRequestDispatcher("views/shop.jsp").forward(request, response);
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
