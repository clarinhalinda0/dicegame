package com.lunaltas.dicegame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(authorize -> authorize
				// recursos estáticos - Spring Boot serve arquivos de /static/ diretamente na raiz
				// então /static/rolling-dice.gif é acessado como /rolling-dice.gif
				.requestMatchers("/css/**", "/js/**", "/image/**", "/webjars/**", "/*.gif", "/*.png", "/*.jpg", "/*.jpeg", "/*.ico", "/*.svg", "/*.gif").permitAll()
				// páginas de autenticação
				.requestMatchers("/login").permitAll()
				// páginas públicas
				.requestMatchers("/").permitAll()
				// todas as outras requisições precisam de autenticação
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/bets/index", true)
				.failureUrl("/login?error=true")
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
			);
		
		return http.build();
	}
}
