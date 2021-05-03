package com.digitalSignage.oauth;


import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
   JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity.cors();
        httpSecurity.headers().addHeaderWriter(new StaticHeadersWriter("Access-Control-Allow-Origin","http://192.168.1.8:3000"));
        httpSecurity.csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers("/authenticate").permitAll()
                .antMatchers("/css/*").permitAll()
                .antMatchers("/libs/*").permitAll()
                .antMatchers("/login.js").permitAll()
                .antMatchers("/style.css").permitAll()
                .antMatchers("/bootstrap.min.css").permitAll()
                .antMatchers("/libs/*/*/*").permitAll()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/index.js").permitAll()
                .antMatchers("/user.html").permitAll()
                .antMatchers("/sign.html").permitAll()
                .antMatchers("/sign.js").permitAll()
                .antMatchers("/favicon.ico").permitAll()
                .antMatchers("/vendor/*/*/*").permitAll()
                .antMatchers("/vendor/*").permitAll()
                .antMatchers("/vendor/*/*").permitAll()
                .antMatchers("/images/*").permitAll()
                .antMatchers("/main.js").permitAll()
                .antMatchers("/updateLicence.html").permitAll()
                .antMatchers("/updateLicence.js").permitAll()
                .antMatchers("/deleteLicence.html").permitAll()
                .antMatchers("/deleteLicence.js").permitAll()
                .antMatchers("/user.js").permitAll()
                .antMatchers("/userList.html").permitAll()
                .antMatchers("/userList.js").permitAll()
                .antMatchers("/http://192.168.1.8:3000").permitAll()
                .antMatchers("/insertLogin").permitAll()
                .antMatchers("/getLogin").permitAll()


                // all other requests need to be authenticated
                .anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
   /* public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*");
    }*/


    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("/insertLogin").allowedOrigins("*");
    }
}
