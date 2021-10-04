package controller;

import entity.Carpark;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CarparkController implements Serializable {

    private Carpark carpark;

    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private CountryController countryController;
    @Inject
    private CityController cityController;
    @Inject
    private ExtraServicesController extraServicesController;

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

    public void updateForm(Carpark carpark) {
        this.carpark = carpark;
    }

    public void clearForm() {
        this.carpark = new Carpark();
    }

    public void create() {

        this.clearForm();
    }

    public void deleteConfirm(Carpark carpark) {
        this.carpark = carpark;
    }

    public void delete() {
        this.clearForm();
    }

    public void update() {
        this.clearForm();
    }

 

    public Carpark getCarpark() {
        if (this.carpark == null) {
            this.carpark = new Carpark();
        }
        return carpark;
    }

    public void setCarpark(Carpark carpark) {
        this.carpark = carpark;
    }

    public CountryController getCountryController() {
        return countryController;
    }

    public CityController getCityController() {
        return cityController;
    }

    public ExtraServicesController getExtraServicesController() {
        return extraServicesController;
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
