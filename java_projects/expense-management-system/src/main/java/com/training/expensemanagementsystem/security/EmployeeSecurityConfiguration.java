package com.training.expensemanagementsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration {

	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests
		(requests -> requests
                .requestMatchers("/").permitAll()
                .requestMatchers("/expense").permitAll()
                .requestMatchers("/expense/*").permitAll()
                .requestMatchers(HttpMethod.POST, "/expense", "/expense/*").permitAll()
                .requestMatchers(HttpMethod.PUT, "/expense").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/expense/*").permitAll()
                .requestMatchers("/index").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/viewAllProducts").hasAnyRole("USER", "ADMIN","CR")
				.requestMatchers("/addProduct").hasAnyRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/login").permitAll())
				//.logout(logout -> logout.permitAll())
              //  .logout(logout -> logout.permitAll())
                .logout(logout -> logout.permitAll()
                        .logoutUrl("/logout").permitAll()
                        .logoutSuccessUrl("/login").permitAll()
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"))
                        .exceptionHandling(ex -> ex
                        .accessDeniedPage("/access-denied")
                );

		http.csrf().disable();
		return http.build();
	}

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")  // embedded LDAP users
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=example,dc=com")
                .and()
                .passwordCompare()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .passwordAttribute("userPassword");
    }


//    @Autowired
//    DataSource dataSource;
//
//    //Enable jdbc authentication
//    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource);
//    }


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//        authenticationMgr.inMemoryAuthentication()
//                .withUser("neha").password("tech").authorities("ROLE_USER")
//                .and()
//                .withUser("tufail").password("ahmed").authorities("ROLE_USER", "ROLE_ADMIN")
//                .and()
//                .withUser("admin").password("admin").authorities("ROLE_ADMIN")
//                .and()
//                .withUser("aryan").password("secret").authorities("ROLE_CR");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}