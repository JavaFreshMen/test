package com.njusoft.its.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 *
 * @author 作者 E-mail:857332533@qq.com
 * @date 创建时间：2017年10月19日 下午12:50:51
 * @version 1.0
 * @since JDK 1.7
 */
public class CrossOriginControl implements Filter {
	private Logger logger = Logger.getLogger(CrossOriginControl.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// 检测跨域访问问题
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
//		logger.info("request orign； "+httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		httpServletResponse.setHeader("Access-Control-Max-Age", "1800");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"Origin, No-Cache,x-auth-token,withCredentials, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
		httpServletResponse.setHeader("XDomainRequestAllowed", "1");

		logger.info("拦截请求: " + httpServletRequest.getServletPath() + " session id: "
				+ httpServletRequest.getSession().getId());

		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
