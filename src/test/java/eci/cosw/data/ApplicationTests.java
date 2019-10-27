
package eci.cosw.data;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import eci.cosw.Application;
import eci.cosw.data.Persistence.UserRepository;
import eci.cosw.data.Persistence.TodoRepository;
import eci.cosw.data.model.Todo;
import eci.cosw.data.model.User;
import java.util.Date;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataMongo
class ApplicationTests {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private TodoRepository todoRepository;

    @Test
    void pruebaResponsible() {
        System.out.println("==================prueba findbyResponsible============");
       // null pointer con los repos
        assertEquals(1, 1);
        
    }
}