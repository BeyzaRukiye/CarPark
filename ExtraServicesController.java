package controller;

import entity.ExtraServices;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class ExtraServicesController implements Serializable {


    private ExtraServices extraServices;

    private List<ExtraServices> testlist;
    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private CarparkController carparkController;

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

    public void updateForm(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public void clearForm() {
        this.extraServices = new ExtraServices();
    }

    public void create() {
        this.getEdao().insert(this.extraServices);
        this.clearForm();
    }

    public void deleteConfirm(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public void delete() {
        this.clearForm();
    }

    public void update() {
        this.clearForm();
    }


    public ExtraServices getExtraServices() {
        if (this.extraServices == null) {
            this.extraServices = new ExtraServices();
        }
        return extraServices;
    }

    public void setExtraServices(ExtraServices extraServices) {
        this.extraServices = extraServices;
    }

    public CarparkController getCarparkController() {
        return carparkController;
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
