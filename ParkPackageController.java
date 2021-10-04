package controller;

import entity.ParkPackage;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class ParkPackageController implements Serializable {

    private ParkPackage parkPackage;

    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void geri() {
        if (this.page == 1) {
            if (this.getPageCount() != 0) {
                this.page = this.getPageCount();
            }
        } else {
            this.page--;
        }
    }

    public void ileri() {
        if (this.page == this.getPageCount() || this.getPageCount() == 0) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void ilk() {
        this.page = 1;
    }

    public void son() {
        if (this.getPageCount() != 0) {

            this.page = this.getPageCount();
        }
    }

    public void updateForm(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
    }

    public void clearForm() {
        this.parkPackage = new ParkPackage();
    }

    public void create() {
        this.clearForm();
    }

    public void deleteConfirm(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
    }

    public void delete() {
        this.clearForm();
    }

    public void update() {
        this.clearForm();
    }

    public ParkPackage getParkPackage() {
        if (this.parkPackage == null) {
            this.parkPackage = new ParkPackage();
        }
        return parkPackage;
    }

    public void setParkPackage(ParkPackage parkPackage) {
        this.parkPackage = parkPackage;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
