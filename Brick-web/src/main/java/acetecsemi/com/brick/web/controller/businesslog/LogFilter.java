package acetecsemi.com.brick.web.controller.businesslog;

import java.io.IOException;

import org.openkoala.businesslog.utils.BusinessLogServletFilter;
import org.openkoala.security.shiro.CurrentUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

/**
 * User: zjzhai Date: 11/27/13 Time: 11:01 AM
 */
public class LogFilter extends BusinessLogServletFilter {

	// 不过滤的uri
	public static String[] NOT_FILTER = new String[] { "login.koala",
			"index.koala", "/auth/", "/log/", "/employee/", "/job/",
			"/organization/", "/post/" };

	/**
	 * 将需要用到的信息放入日志上下文
	 *
	 * @param req
	 * @param resp
	 * @param chain
	 */
	@Override
	public void beforeFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) {
		// 请求的uri
/*		HttpServletRequest request = (HttpServletRequest) req;

		// 取的url相对地址，例如：/PrxWebCache/index.jsp
		String uri = request.getRequestURI();
		if (uri.indexOf(".koala") != -1 && this.checkNotFilter(uri)) {
			request.setAttribute("lastModifyEmployNo",
					CurrentUser.getUserAccount());
		}*/
		addIpContext(getIp(req));
		// TODO 需要自己实现获取用户名
		addUserContext(req.getParameter("user"));
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// To change body of implemented methods use File | Settings | File
		// Templates.
	}

	public void destroy() {
		// To change body of implemented methods use File | Settings | File
		// Templates.
	}

	private boolean checkNotFilter(String uri) {
		for (String s : NOT_FILTER) {
			if (uri.indexOf(s) != -1 && uri.length() > 1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				return false;
			}
		}
		return true;
	}
}
