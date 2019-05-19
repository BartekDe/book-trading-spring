package pl.bartekde.booktradingspring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.bartekde.booktradingspring.service.UserService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private UserService userService;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() // turn on the restricted access
				.antMatchers("/").permitAll() // everyone can access main page
				.antMatchers("/books/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("/panel/**").hasRole("ADMIN")
                .and()
				.formLogin() // turn on auth based on normal html form
				.loginPage("/loginPage") // specify login page location
				.loginProcessingUrl("/userAuthentication") // specify page that should process login/password (form action), no need to create this page
				.permitAll() // grant access to this page (login page) for all users
                .and()
				.logout()
				.logoutSuccessUrl("/") // after logout redirect to main page
				.permitAll()
                .and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

}
