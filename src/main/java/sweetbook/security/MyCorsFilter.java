package sweetbook.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyCorsFilter implements Filter {

  private final List<String> allowedOrigins = Arrays.asList("http://localhost:8080");

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

    if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
      HttpServletRequest request = (HttpServletRequest) req;
      HttpServletResponse response = (HttpServletResponse) res;

      String origin = request.getHeader("Origin");
      response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
      response.setHeader("Vary", "Origin");

      response.setHeader("Access-Control-Max-Age", "3600");

      response.setHeader("Access-Control-Allow-Credentials", "true");

      response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

      response.setHeader("Access-Control-Allow-Headers",
          "Origin, X-Requested-With, Content-Type, Accept, Authorization");

    }

    chain.doFilter(req, res);
  }

  @Override
  public void init(FilterConfig filterConfig) {
  }
}
