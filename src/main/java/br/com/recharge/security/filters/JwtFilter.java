package br.com.recharge.security.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter implements Filter {

	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_VALUE_PREFIX = "Bearer ";

	private final AuthenticationManager authenticationManager;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String jwt = getBearerToken((HttpServletRequest) request);

//		if () {
//			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//			return;
//		}
		chain.doFilter(request, response);
	}

	private String getBearerToken(HttpServletRequest request) {
		String authHeader = request.getHeader(AUTH_HEADER_KEY);
		if (authHeader != null && authHeader.startsWith(AUTH_HEADER_VALUE_PREFIX)) {
			return authHeader.substring(AUTH_HEADER_VALUE_PREFIX.length());
		}
		return null;
	}

}