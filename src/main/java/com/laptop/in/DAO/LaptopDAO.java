package com.laptop.in.DAO;

import com.laptop.in.Entity.Laptop;
import jakarta.transaction.Transactional;

import java.util.List;

public interface LaptopDAO {

    public void addlaptop(Laptop theLaptop);

    public Laptop  findById(int theId);

    public Laptop findByIMEI(String imei);

    public List<Laptop> fetchAll();

    public void update(int theId);

    @Transactional
    public void remove(int theId);


}
