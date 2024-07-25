/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import Model.Cart;
import Model.Category;
import Model.Item;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ngoc
 */
public class DAO extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product c "
                + "inner join category ca on c.cid = ca.cid";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> getAllProductExceptSoldOut() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product c\n"
                + "inner join category ca on c.cid = ca.cid\n"
                + "where c.quantity <> 0 and c.isShow = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Account> getAllAccountExceptLeader() {
        List<Account> list = new ArrayList<>();
        String query = "select * from users\n"
                + "where id <> 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product p\n"
                + "inner join category c on p.cid = c.cid\n"
                + "where c.cid = ? and p.quantity <> 0 and p.isShow = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, cid);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product p\n"
                + "inner join category c on p.cid = c.cid\n"
                + "where p.product_name like ? and p.quantity <> 0 and p.isShow = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            list.add(new Product(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDate(7),
                    rs.getInt(8),
                    rs.getInt(9),
                    rs.getBoolean(10),
                    new Category(rs.getInt(11),
                            rs.getString(12),
                            rs.getString(13)
                    )));
        } catch (Exception e) {

        }
        return list;
    }

    public List<Product> searchByPrice(String min, String max) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product p\n"
                + "inner join category c on p.cid = c.cid\n"
                + "where product_price >= ? and product_price <= ? and p.quantity <> 0 and p.isShow = 1";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, min);
            ps.setString(2, max);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "select * from product p\n"
                + "inner join category c on p.cid = c.cid\n"
                + "where p.product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        ));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Account getUserByID(String id) {
        String query = "select * from users p\n"
                + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Product> getTop6Latest() {
        List<Product> list = new ArrayList<>();
        String query = "select top 6 * from product c\n"
                + "inner join category ca on c.cid = ca.cid\n"
                + "where c.quantity <> 0 and c.isShow = 1"
                + "order by c.import_date desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductSortByPurchase() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product c\n"
                + "inner join category ca on c.cid = ca.cid\n"
                + "where c.quantity <> 0 and c.isShow = 1"
                + "order by c.num_purchases desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getBoolean(10),
                        new Category(rs.getInt(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "select * from users\n"
                + "where nickname = ?\n"
                + "and password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from users\n"
                + "where nickname = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getBoolean(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void signUp(String nickname, String pass, String mail, String fullname, String address, String numberPhone) {
        String query = "insert into users\n"
                + "values(?,?,?,?,?,?,0)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nickname);
            ps.setString(2, pass);
            ps.setString(3, mail);
            ps.setString(4, fullname);
            ps.setString(5, address);
            ps.setString(6, numberPhone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insert(String name, String price, String describe, String image, String cid, String quantity) {
        String query = "insert into product\n"
                + "values(?,?,?,?,?,?,0,?,1)";
        Date currentDate = new Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = date.format(currentDate);
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, describe);
            ps.setString(4, image);
            ps.setString(5, cid);
            ps.setString(6, dateString);
            ps.setString(7, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(String name, String price, String describe, String image, String cid, String pid, String quantity) {
        String query = "update product\n"
                + "set product_name = ?,\n"
                + "product_price = ?,\n"
                + "product_describe = ?,\n"
                + "image = ?,\n"
                + "quantity = ?,\n"
                + "cid = ?\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, describe);
            ps.setString(4, image);
            ps.setString(5, quantity);
            ps.setString(6, cid);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void EditUser(String id, String nickname, String pass, String email, String fullname, String address, String phone, String isAdmin) {
        String query = "update users\n"
                + "set nickname = ?,\n"
                + "password = ?,\n"
                + "email = ?,\n"
                + "fullname = ?,\n"
                + "address = ?,\n"
                + "phonenumber = ?,\n"
                + "isAdmin = ?\n"
                + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nickname);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, isAdmin);
            ps.setString(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void statusProduct(String pid, String isShow) {
        String query = "update product\n"
                + "set isShow = ?\n"
                + "where product_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, isShow);
            ps.setString(2, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(String aid) {
        String query = "delete from users\n"
                + "where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, aid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(String fullname, String email, String address, String numberPhone, int id) {
        String query = "update users\n"
                + "set fullname = ?,\n"
                + "email = ?,\n"
                + "address = ?,\n"
                + "phonenumber = ?\n"
                + "where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, numberPhone);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void changePass(String pass, int id) {
        String query = "update users\n"
                + "set password = ?\n"
                + "where id =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pass);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addOrder(Account a, int totalmoney) {
        LocalDate currenDate = java.time.LocalDate.now();
        String date = currenDate.toString();
        try {
            String sql = "insert into bill values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setInt(2, totalmoney);
            ps.setString(3, date);
            ps.setString(4, "1");
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public String getLastOrder() {
        try {
            String sql1 = "select top 1 bill_id from bill\n"
                    + "order by bill_id desc";
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                String last = rs.getString(1);
                return last;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addOrderDetail(Item i, String id) {
        try {
            String lastIdOrder = getLastOrder();
            String sql2 = "insert into [billDetail] values (?,?,?,?)";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, id);
            ps2.setInt(2, i.getProduct().getId_product());
            ps2.setInt(3, i.getQuantity());
            ps2.setInt(4, i.getPrice());
            ps2.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void UpdateAfterOrder(Item i) {
        try {
            //cap nhat lai so luong mua
            String sql3 = "update product\n"
                    + "set quantity = quantity - ?\n"
                    + "where product_id = ?";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setInt(1, i.getQuantity());
            ps3.setInt(2, i.getProduct().getId_product());
            ps3.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List<Order> getOrderByUserId(int id) {
        List<Order> list = new ArrayList<>();
        String query = "select * from bill b\n"
                + "inner join statusOrder s on b.idStatus = s.id\n"
                + "where user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String query = "select * from bill b\n"
                + "inner join statusOrder s on b.idStatus = s.id";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Order getOrderByOrderID(int oid) {
        String query = "select * from bill b\n"
                + "inner join statusOrder s on b.idStatus = s.id\n"
                + "where bill_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, oid);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<OrderDetail> getAllOrderDetailById(String id) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select * from billDetail\n"
                + "where bill_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void deleteOrderByID(String id) {
        String query = "delete from bill\n"
                + "where bill_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrderDetailByID(String id) {
        String query = "delete from billDetail\n"
                + "where bill_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getListByPage(List<Product> list, int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Item> listItemCardByUserID(int id) {
        String sql = "select * from [card] c\n"
                + "inner join product p on p.product_id = c.pid\n"
                + "where c.userid = ?";
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Item(getProductByID(rs.getString(1)),
                        rs.getInt(3),
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Cart getCartByUserId(int id) {
        Cart cart = new Cart(listItemCardByUserID(id));
        return cart;
    }

    public void addToCart(int userid, String pid, String quantity) {
        try {
            String sql = "insert into [card] values (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setInt(2, userid);
            ps.setString(3, quantity);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateToCart(int userid, String pid, int quantity) {
        try {
            String sql = "update [card] \n"
                    + "set quantity =  ?\n"
                    + "where userid = ? and pid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, userid);
            ps.setString(3, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void removeItemFromCart(String pid, int userid) {
        String query = "delete from card\n"
                + "where pid = ? and userid = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pid);
            ps.setInt(2, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int index(String pid) {
        int id = Integer.parseInt(pid);
        DAO dao = new DAO();
        Product product = dao.getProductByID(pid);
        int cid = product.getCategory().getcId();
        List<Product> listP = dao.getProductByCID(String.valueOf(cid));

        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getId_product() == id) {
                return i;
            }
        }
        return -1;
    }

    public List<String> status() {
        String sql = "select* from statusOrder";
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void changeStatusByIdOrder(int status, int id) {
        try {
            String sql = "update bill \n"
                    + "set idStatus =  ?\n"
                    + "where bill_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void setQuantityProductCancel(int quantity, int pid) {
        try {
            //cập nhật lại số lượng hàng nếu người mua hủy đơn
            String sql3 = "update product\n"
                    + "set quantity = quantity + ?\n"
                    + "where product_id = ?";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setInt(1, quantity);
            ps3.setInt(2, pid);
            ps3.executeUpdate();

        } catch (Exception e) {

        }
    }

    public void setNumPerchases(int quantity, int pid) {
        try {
            //cập nhật lại số lượng hàng nếu người mua hủy đơn
            String sql3 = "update product\n"
                    + "set num_purchases = num_purchases + ?\n"
                    + "where product_id = ?";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setInt(1, quantity);
            ps3.setInt(2, pid);
            ps3.executeUpdate();

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        System.out.println(dao.getOrderByOrderID(33).getStatus());

    }
}
