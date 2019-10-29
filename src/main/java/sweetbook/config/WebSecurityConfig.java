package sweetbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsService;


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .anyRequest().permitAll();


    /*.antMatchers(
            "/recipe/pagecount",
            "recipe/page/*",
            "/user/test/*",
            "/login"
        ).permitAll()
*/

      //  .permitAll()
      //  .and()
      //  .logout()
      //  .permitAll()
      //  .and()
      //  .csrf()
      //  .disable();
;
  }


 @Autowired
  public void configure (AuthenticationManagerBuilder builder) throws Exception {
    builder
        .authenticationProvider(authenticationProvider())
        .userDetailsService(userDetailsService)
        .passwordEncoder(NoOpPasswordEncoder.getInstance());
  }

@Bean
  public DaoAuthenticationProvider authenticationProvider() {
    final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    return authProvider;
  }





}