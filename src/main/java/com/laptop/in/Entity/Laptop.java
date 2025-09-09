package com.laptop.in.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="lap_table")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="Name")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="RAM")
    private String ram;

    @Column(name="ROM")
    private String rom;

    @Column(name="IMEI")
    private String imei;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Laptop(String name, String brand, String ram, String rom, String imei) {
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.rom = rom;
        this.imei = imei;
    }

    public Laptop() {
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
