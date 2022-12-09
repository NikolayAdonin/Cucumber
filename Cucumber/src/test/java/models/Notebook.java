package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

import java.io.Serializable;

public class Notebook implements Serializable {
    private Ram ram;
    private Company company;

    public Notebook() {
    }

    public Notebook(Ram ram, Company company) {
        this.ram = ram;
        this.company = company;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Ram getRam() {
        return this.ram;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }
}
