package com.laptop.in;

import com.laptop.in.DAO.LaptopDAO;
import com.laptop.in.Entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner(LaptopDAO theLaptop)
    {
        return runner->
        {


            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Your Option !  ");

            System.out.println("1.Add Laptop");
            System.out.println("2. Fetch Laptop By Id");
            System.out.println("3. Fetch By IMEI ");
            System.out.println("4. Fetch All Laptop Details ");
            System.out.println("5. Update Ram");
            System.out.println("6. Remove Laptop");
            int ch=sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.println("Enter Laptop Name");
                    String name=sc.next();

                    System.out.println("Enter Laptop Brand");
                    String brand=sc.next();

                    System.out.println("Enter Laptop ram");
                    String ram=sc.next();

                    System.out.println("Enter Laptop rom");
                    String rom=sc.next();

                    System.out.println("Enter Laptop imei");
                    String imei=sc.next();

                    theLaptop.addlaptop(new Laptop(name,brand,ram,rom,imei));
                    System.out.println("Laptop Added SuccessFully..!");

                    break;

                case 2:
                    System.out.println("Enter the Id To fetch");


                    Laptop foundLaptop = theLaptop.findById(sc.nextInt());
                    if(foundLaptop!=null)
                    {
                      System.out.println(foundLaptop);
                    }
                    else{
                        System.out.println("No laptop found");
                    }
                    break;

                case 3:
                    System.out.println("Enter IMEI TO FETCH");
                    Laptop p = theLaptop.findByIMEI(sc.next());
                    if(p!=null)
                    {
                        System.out.println(p);
                    }
                    else{
                        System.out.println("No laptop found");
                    }
                    break;

                case 4:
                    System.out.println("All Laptops");
                    List<Laptop> lap=theLaptop.fetchAll();
                    for (Laptop l:lap){
                        System.out.println(l);
                    }
                    break;

                case 5:
                    System.out.println("Enter Laptop id to update ram: ");
                    theLaptop.update(sc.nextInt());

                    break;
                case 6:
                    System.out.println("Enter Laptop Id to Remove Laptop Details");
                    theLaptop.remove(sc.nextInt());
                    break;






                default:
                    System.out.println("Functionalities Under Development");












            }

        };
    }

	public static void main(String[] args) {
		SpringApplication.run(LaptopApplication.class, args);
	}

}
