package controller;

import entity.City;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class CityController implements Serializable {

    private City city;
    /**
     * bul değişkeni search için diğerleri pagination için oluşturuldu.
     */
    private String bul = "";
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private CountryController countryController;

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

    public void updateForm(City city) {
        this.city = city;
    }

    public void clearForm() {
        this.city = new City();
    }

    public void create() {
        this.clearForm();
    }

    public void deleteConfirm(City city) {
        this.city = city;
    }

    public void delete() {
        this.clearForm();
    }

    public void update() {
        this.clearForm();
    }

  
    public City getCity() {
        if (this.city == null) {
            this.city = new City();
        }
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CountryController getCountryController() {
        return countryController;
    }

    public void setCountryController(CountryController countryController) {
        this.countryController = countryController;
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
