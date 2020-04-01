package webfilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Filters
 */
@WebFilter("/*")
public class Filters implements Filter {

    /**
     * Default constructor. 
     */
    public Filters() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;
    private static final String[] loginRequiredURLs = {
    		"/home","/sum","/print"
    };
 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;
 
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
//        if (path.startsWith("/admin/")) {
//            chain.doFilter(httpRequest, httpResponse);
//            return;
//        }
        
        System.out.println(path);
 
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("userName") != null);
 
        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login.jsp");

//        String password=httpRequest.getParameter("password");  
//        if(password!=null) {
//            if(password.equals("admin")){  
//            	chain.doFilter(request, response);//sends request to next resource  
//            }  	
//        }
    	if(isLoggedIn)
    		System.out.println(session.getAttribute("userName"));
        if (isLoggedIn && (isLoginRequest || isLoginPage)) {
            // the user is already logged in and he's trying to login again
            // then forward to the homepage
            httpRequest.getRequestDispatcher("/").forward(httpRequest, httpResponse);
        } else if (!isLoggedIn && isLoginRequired()) {
            // the user is not logged in, and the requested page requires
            // authentication, then forward to the login page
            String loginPage = "/login.jsp";
            RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(httpRequest, httpResponse);
        } else {
            // for other requested pages that do not require authentication
            // or the user is already logged in, continue to the destination    
            chain.doFilter(httpRequest, httpResponse);
        }
    }
 
 
    private boolean isLoginRequired() {
        String requestURL = httpRequest.getRequestURL().toString();
        System.out.println(requestURL);
        for (String loginRequiredURL : loginRequiredURLs) {
            if (requestURL.contains(loginRequiredURL)) {
                return true;
            }
        }
 
        return false;
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

}
