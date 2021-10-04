package controller;

import entity.Document;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author Alperen
 */
@Named
@SessionScoped
public class DocumentController implements Serializable {

    private Document document;
    private String bul = "";

    private Part doc;  //dosyamızı xhtml tarafına direk yollayamadığımız için part türünde bir referans ürettik
    private final String uploadTo = "D:\\CarparkFiles\\";

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    @Inject
    private UserController userController;
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

    public void upload() {

        try {
            InputStream input = doc.getInputStream();
            File f = new File(this.getUploadTo() + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());
            /*
            Veritabanına kayıt işlemi
             */

            document = this.getDocoument();
            document.setFile_name(f.getName());
            document.setFile_path(f.getParent());
            document.setFile_type(doc.getContentType());
            
        } catch (Exception e) {
            System.out.println("DocumentController HATA(UPLOAD):" + e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public Document getDocoument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public UserController getUserController() {
        return userController;
    }

    public CarparkController getCarparkController() {
        return carparkController;
    }
}
