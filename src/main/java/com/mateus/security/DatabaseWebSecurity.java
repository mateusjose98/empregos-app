package com.mateus.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource); //usar as tabelas users e authorities padrão
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, status from Usuario where username=?")
				.authoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up "
						+ "inner join Usuario u on u.id = up.Usuario_id "
						+ "inner join Perfil p on p.id = up.Perfil_id " + "where u.username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// recursos estáticos todos permitidos
				.antMatchers("/bootstrap/**", "/imagens/**", "/tinymce/**", "/logos/**").permitAll()

				// views públicas todas permitidas
				.antMatchers("/", "/usuarios/singup", "/search", "/vagas/view/**").permitAll()

				// atribuir os Perfis do banco ao acesso a URL
				.antMatchers("/vagas/indexPaginate").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
				.antMatchers("/vagas/aplicar").authenticated()
				.antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR", "ADMINISTRADOR")
				.antMatchers("/usuarios/index").hasAnyAuthority("ADMINISTRADOR")
				// as demais precisam de autenticação
				.anyRequest().authenticated()
				// liberando o formulário de login
				.and().formLogin().loginPage("/login").permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}