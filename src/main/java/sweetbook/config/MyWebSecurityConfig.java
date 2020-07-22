package sweetbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import sweetbook.security.MyAuthEntryPoint;
import sweetbook.security.MyAuthSuccessHandler;
import sweetbook.security.MyCorsFilter;
import sweetbook.security.MyLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;

  @Bean
  MyAuthEntryPoint myAuthEntryPoint() {
    return new MyAuthEntryPoint();
  }

  @Bean
  MyAuthSuccessHandler myAuthSuccessHandler() {
    return new MyAuthSuccessHandler();
  }

  @Bean
  MyLogoutSuccessHandler myLogoutSuccessHandler() {
    return new MyLogoutSuccessHandler();
  }

  @Bean
  SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler() {
    return new SimpleUrlAuthenticationFailureHandler();
  }


  @Bean
  MyCorsFilter myCorsFilter() {
    return new MyCorsFilter();
  }


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http

        .csrf().disable()

        .addFilterBefore(myCorsFilter(), ChannelProcessingFilter.class)

        .httpBasic()

        .and()
        .exceptionHandling().authenticationEntryPoint(myAuthEntryPoint())

        .and()
        .formLogin()
        .successHandler(myAuthSuccessHandler())
        .failureHandler(simpleUrlAuthenticationFailureHandler())

        .and()
        .logout()
        .logoutSuccessHandler(myLogoutSuccessHandler())

        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/*/**").permitAll()

        .antMatchers(HttpMethod.GET, "/recipe/**" ).permitAll()
        .antMatchers("/recipe/like/**" ).authenticated()

        .antMatchers("/user/register/**").permitAll()
        .antMatchers("/user/**" ).authenticated()

        .antMatchers("/login").permitAll()
        .antMatchers("/logout").authenticated()

        .anyRequest().authenticated();
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .authenticationProvider(authenticationProvider())
        .userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder);
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder);
    return authProvider;
  }

  final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

}