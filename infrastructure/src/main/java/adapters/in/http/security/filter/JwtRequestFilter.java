package adapters.in.http.security.filter;

import adapters.in.http.security.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
public class JwtRequestFilter extends BasicAuthenticationFilter {
  private final UserDetailsService userDetailsService;
  private final JwtTokenUtil jwtTokenUtil;

  public JwtRequestFilter(
      AuthenticationManager authenticationManager,
      UserDetailsService userDetailsService,
      JwtTokenUtil jwtTokenUtil) {
    super(authenticationManager);
    this.userDetailsService = userDetailsService;
    this.jwtTokenUtil = jwtTokenUtil;
  }

  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {

    final HttpServletRequestWrapper wrapped =
        new HttpServletRequestWrapper(request) {
          @Override
          public StringBuffer getRequestURL() {
            final StringBuffer originalUrl = request.getRequestURL();
            final String updatedUrl = originalUrl.toString().replace("http://", "https://");
            return new StringBuffer(updatedUrl);
          }
        };

    String jwtToken = extractJwtToken(wrapped);
    String username = getUsernameFromToken(jwtToken);
    if (username != null) {
      UserDetails userDetails = loadUserDetails(username);
      if (validateToken(jwtToken, userDetails)) {
        setAuthentication(wrapped, userDetails);
      }
    }
    chain.doFilter(wrapped, response);
  }

  private String extractJwtToken(HttpServletRequest request) {
    String requestTokenHeader = request.getHeader("Authorization");
    if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
      return requestTokenHeader.substring(7);
    }

    logger.warn("JWT Token does not begin with Bearer String");
    return null;
  }

  private String getUsernameFromToken(String jwtToken) {
    try {
      return jwtTokenUtil.getUsernameFromToken(jwtToken);
    } catch (IllegalArgumentException | ExpiredJwtException e) {
      System.out.println("Unable to get JWT Token");
      return null;
    }
  }

  private UserDetails loadUserDetails(String username) {
    return userDetailsService.loadUserByUsername(username);
  }

  private boolean validateToken(String jwtToken, UserDetails userDetails) {
    return jwtTokenUtil.validateToken(jwtToken, userDetails);
  }

  private void setAuthentication(HttpServletRequest request, UserDetails userDetails) {
    UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authentication);
  }
}
