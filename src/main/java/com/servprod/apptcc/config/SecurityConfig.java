package com.servprod.apptcc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.servprod.apptcc.security.JWTAuthenticationFilter;
import com.servprod.apptcc.security.JWTAuthorizationFilter;
import com.servprod.apptcc.security.JWTUtil;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private JWTUtil jwtUtil;

	private static final String[] PUBLIC_MATCHERS = {
	        //"/api/usuariocomum/**",
	        //"/api/servprod/**",
	        //"api/prestador/**",
	        //"/api/pessoajuridica/**",
	        //"/api/pessoafisica/**",
	        //"/api/endereco/**",
	        //"/api/categoriasp/**",
	        //"/api/avaliacaoSP/**",
	        //"/login/**",
	        //"/auth/forgot/**"
	};
	
    private static final String[] PUBLIC_MATCHERS_POST = {
	        //"/api/usuariocomum/**",
	        //"/api/servprod/**",
	        //"api/prestador/**",
	        //"/api/pessoajuridica/**",
	        //"/api/pessoafisica/**",
	        //"/api/endereco/**",
	        ///"/api/categoriasp/**",
	        //"/api/avaliacaoSP/**",
	        //"/login/**",
                "/auth/forgot/**"
    };
    
    /**private static final String[] PUBLIC_MATCHERS_PUT = {
	        "/api/usuariocomum/**",
	        "/api/servprod/**",
	        "api/prestador/**",
	        "/api/pessoajuridica/**",
	        "/api/pessoafisica/**",
	        "/api/endereco/**",
	        "/api/categoriasp/**",
	        "/api/avaliacaoSP/**",
	        "/login",
                "/auth/forgot/**"
    };*/
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
        	//.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_PUT).permitAll()
                .antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
	
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
