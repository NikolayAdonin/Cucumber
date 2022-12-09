package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

public class NotebookBuilder {
    private Ram ram;
    private Company company;
    public NotebookBuilder(Ram ram, Company company){
        this.ram = ram;
        this.company = company;
    }
    public Notebook build(){
        Notebook notebook = new Notebook();
        notebook.setRam(this.ram);
        notebook.setCompany(this.company);
        return notebook;
    }
}
