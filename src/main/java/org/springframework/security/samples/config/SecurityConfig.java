package org.springframework.security.samples.config;

//import com.developers.demo_stock.service.UserService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    
   /* @Autowired
    private UserService userDetailsService;*/
    
    @Autowired
    private BCryptPasswordEncoder bcrypt;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "country/country").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login-error");

        http
                .authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");

        /*auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username as nombre, password,active as enabled FROM users  WHERE username=? ")
                .authoritiesByUsernameQuery("select u.username as nombre, r.code as authority from users u join membership m on m.user_id = u.id join positions p on m.position_id = p.id " +
                                            "join position_roles pr on pr.position_id = p.id join roles r on r.id = pr.role_id where u.username = ? ");*/
        
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
