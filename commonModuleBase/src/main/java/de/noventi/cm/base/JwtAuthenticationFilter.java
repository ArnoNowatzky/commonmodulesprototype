package de.noventi.cm.base;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    /**TODO
    log.debug("doFilterInternal called");
    try {
      String jwt = getJwtFromRequest(request);

      DecodedJWT decodedJWT = JWT.decode(jwt);
      if (decodedJWT.getType() == null || ! decodedJWT.getType().equalsIgnoreCase("JWT"))
        throw new IllegalStateException("No valid JWT token found (" + decodedJWT.getType() + ")");

      if (decodedJWT.getAlgorithm() == null || !decodedJWT.getAlgorithm().equalsIgnoreCase("HS512"))
        throw new IllegalStateException("No valid JWT algorithm found (" + decodedJWT.getType() + ")");



      String mandant = decodedJWT.getClaim("mandant").asString();
      String username = decodedJWT.getClaim("username").asString();
      String role = decodedJWT.getClaim("role").asString();

      if (log.isDebugEnabled()) {
        log.debug("Header     : " + decodedJWT.getHeader());
        log.debug("Signature  : " + decodedJWT.getSignature());
        log.debug("Payload    : " + decodedJWT.getPayload());
        log.debug("Type       : " + decodedJWT.getType());
        log.debug("Expiration : " + decodedJWT.getExpiresAt());
        log.debug("Algorithm  : " + decodedJWT.getAlgorithm());
        for (String next : decodedJWT.getClaims().keySet()) {
          log.debug("Claim      : " + next);
          Claim claim = decodedJWT.getClaim(next);
          log.debug("Value       : " + claim.asString());
        }

        log.debug("Mandant  : " + mandant);
        log.debug("Username : " + username);
        log.debug("Role     : " + role);
      }


      Algorithm algorithm = Algorithm.HMAC512(mandant);
      algorithm.verify(decodedJWT);



      UsernamePasswordAuthenticationToken authenticationToken =
          new UsernamePasswordAuthenticationToken(
              username,
              null, Arrays.asList(new Role(role))
          );
      authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }catch (Exception e) {
      logger.error("Could not authenticate in SecurityContext: " + e.getLocalizedMessage(), e);
    }**/

    //filterChain.doFilter(request, response);
  }

  private String getJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");

    if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7, bearerToken.length());
    }
    else
      log.error("BearerToken does not start with Bearer: " + bearerToken);

    return null;
  }
}
