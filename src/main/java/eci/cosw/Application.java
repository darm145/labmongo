package eci.cosw;

import eci.cosw.data.Configuration.AppConfiguration;
import eci.cosw.data.Persistence.CustomerRepository;
import eci.cosw.data.Persistence.TodoRepository;
import eci.cosw.data.Persistence.UserRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;


@SpringBootApplication

public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
    MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
        customerRepository.deleteAll();
        todoRepository.deleteAll();
        userRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
        System.out.println("==================prueba findbyResponsible====================");
        System.out.println();
        System.out.println();
        
        userRepository.save(new User("david","david@hotmail.com"));
        userRepository.save(new User("daniel","daniel@hotmail.com"));
        todoRepository.save(new Todo("dormir",10,new Date(),"david@hotmail.com","in progress"));
        todoRepository.save(new Todo("comer",10,new Date(),"david@hotmail.com","done"));
        todoRepository.save(new Todo("comer",10,new Date(),"daniel@hotmail.com","in progress"));
        System.out.println("TODOS DAVID");
        for(Todo t: todoRepository.findByResponsible("david@hotmail.com")){
            System.out.println(t.toString());
        }
        System.out.println("TODOS DANIEL");
        for(Todo t: todoRepository.findByResponsible("daniel@hotmail.com")){
            System.out.println(t.toString());
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==================prueba findbyResponsible====================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=============================queries==========================");
        
        


    }

}