package com.usa.ciclo4.com.usa.ciclo4;

import com.usa.ciclo4.com.usa.ciclo4.crud.GadgetCrudRepository;
import com.usa.ciclo4.com.usa.ciclo4.crud.OrderCrudRepository;
import com.usa.ciclo4.com.usa.ciclo4.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private GadgetCrudRepository gadgetrepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
   
        gadgetrepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll();
    }

}
