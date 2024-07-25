/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ngoc
 */
public class Category {
    private int cId;
    private String cName;
    private String image;

    public Category() {
    }

    public Category(int cId, String cName, String image) {
        this.cId = cId;
        this.cName = cName;
        this.image = image;
    }



    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Category{" + "cId=" + cId + ", cName=" + cName + ", image=" + image + '}';
    }

}
