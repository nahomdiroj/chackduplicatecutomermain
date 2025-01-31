package com.nahom.chackduplicatecutomermain.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.nahom.chackduplicatecutomermain.user.Permission;



@Configuration
@EnableWebSecurity
public class SecurityFilter {



    
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {

        http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
               .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( authConfig -> {
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/signin").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
          
                    authConfig.requestMatchers("/error").permitAll();

                    authConfig.requestMatchers(HttpMethod.GET, "/customer/sms1Telephone/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/customer/shortName/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/customer/motherName/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/customer/mnemonic/*").hasAuthority(Permission.SEND_ALL_DATA.name());


                    
                    authConfig.requestMatchers(HttpMethod.GET, "/ncsregistration/fullname/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/ncsregistration/tin/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/ncsregistration/phone/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                  
                    authConfig.requestMatchers(HttpMethod.GET, "/sanction/fullname/*").hasAuthority(Permission.SEND_ALL_DATA.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/sanction/phone/*").hasAuthority(Permission.SEND_ALL_DATA.name());


                    authConfig.anyRequest().denyAll();


                });

        return http.build();

    }


}
