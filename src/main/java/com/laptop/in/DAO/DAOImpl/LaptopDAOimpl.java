package com.laptop.in.DAO.DAOImpl;

import com.laptop.in.DAO.LaptopDAO;
import com.laptop.in.Entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;

@Repository
public class LaptopDAOimpl implements LaptopDAO {
    private final EntityManager theManager;

@Autowired
    public LaptopDAOimpl(EntityManager theManager)  {
        this.theManager = theManager;
    }


    @Override
    @Transactional
    public void addlaptop(Laptop theLaptop) {

    theManager.persist(theLaptop);
    }


    //find by id method
    @Override
    public Laptop findById(int theId)
    {
        return theManager.find(Laptop.class,theId);
    }

    @Override
    public Laptop findByIMEI(String imei)
    {
        Query q = theManager.createQuery("SELECT l FROM Laptop l WHERE l.imei = :imei ");
        q.setParameter("imei",imei);
        q.setMaxResults(1);
        return (Laptop) q.getSingleResult();
    }

    @Override
    public List<Laptop> fetchAll() {
        Query q= theManager.createQuery("SELECT l FROM Laptop l");
        return q.getResultList();
    }


    @Transactional
    @Override

    public void update(int theId)
    {
        Scanner sc = new Scanner(System.in);
        Laptop foundLaptop=theManager.find(Laptop.class,theId);

        if(foundLaptop==null)
        {
            System.out.println("No Such Laptop is Available to Update");

        }
        else
        {
            System.out.println("Enter the Laptop Updated RAM:");
            foundLaptop.setRam(sc.next());
        }
    }

    @Transactional
    @Override
    public void remove(int theId)
    {
        Laptop foundLaptop = theManager.find(Laptop.class,theId);
        if(foundLaptop==null)
        {
            System.out.println("No laptop Found for Entered Id");

        }
        else{
            theManager.remove(foundLaptop);
            System.out.println("Laptop Removed SuccessFully..!");
        }
    }


}
