package com.developers.demo_stock;

import com.developers.demo_stock.entity.Users;
import com.developers.demo_stock.repository.UsersRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoStockApplicationTests {

	@Test
	void contextLoads() {
	}
    
   /* @Autowired
    private UsersRepository userRepo;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Test
    public void crearUsuarioTest(){
        Users user = new Users();
        user.setId(3);
        user.setUsername("prueba");
        user.setPassword(encoder.encode("prueba123"));
        Users validador = userRepo.save(user);
        
        assertTrue(validador.getPassword().equalsIgnoreCase(user.getPassword()));
        
        
    }*/

}
