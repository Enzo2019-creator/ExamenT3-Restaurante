package pe.edu.upn.res.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioDetailsService usuarioDetailsService;
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/index.html").permitAll()
				.antMatchers("/plato/nuevo").hasRole("ADMIN")
				.antMatchers("/plato/edit/**").hasRole("ADMIN")
				.antMatchers("/plato/del/**").hasRole("ADMIN")
				.antMatchers("/tipo").hasRole("ADMIN")
				.antMatchers("/tipo/nuevo").hasRole("ADMIN")
				.antMatchers("/tipo/info/**").hasRole("ADMIN")
				.antMatchers("/tipo/edit/**").hasRole("ADMIN")
				.antMatchers("/tipo/del/**").hasRole("ADMIN")
				.antMatchers("/personal").hasRole("ADMIN")
				.antMatchers("/personal/nuevo").hasRole("ADMIN")
				.antMatchers("/personal/info/**").hasRole("ADMIN")
				.antMatchers("/personal/edit/**").hasRole("ADMIN")
				.antMatchers("/personal/del/**").hasRole("ADMIN")
				.antMatchers("/pedido").authenticated() //.hasRole("ADMIN")
				.antMatchers("/pedido/nuevo").authenticated()
				.antMatchers("/pedido/info/**").hasRole("ADMIN")
				.antMatchers("/pedido/edit/**").authenticated()
				.antMatchers("/pedido/del/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginProcessingUrl("/signin")
				.loginPage("/login").permitAll()
				.usernameParameter("inputUsername")
                .passwordParameter("inputPassword")
			.and()
	        .logout()
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.logoutSuccessUrl("/")
	        .and()
            .rememberMe()
            	.tokenValiditySeconds(2592000)
            	.key("Cl4v3.")
            	.rememberMeParameter("checkRememberMe")
            	.userDetailsService(usuarioDetailsService)
            .and()
                .exceptionHandling()
                    .accessDeniedHandler(accessDeniedHandler);
		
	}
	
	@Bean
	PasswordEncoder passwordEncoder( ) {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.usuarioDetailsService);

        return daoAuthenticationProvider;
    }
	
}
