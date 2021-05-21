package de.noventi.cm.example.config;

/**@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


  @Autowired
  private JwtAuthenticationEntryPoint entryPoint;

  @Bean
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    log.info("Configure " + JwtAuthenticationFilter.class);
    return new JwtAuthenticationFilter();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .cors()
        .and()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .exceptionHandling().authenticationEntryPoint(entryPoint)
        .and()
        .authorizeRequests()
        .anyRequest().authenticated();

    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    http.headers().frameOptions().disable();

  }

}**/
