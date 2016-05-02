package com.liberation.filter;

import java.io.File;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ImageFilter
 */
@WebFilter(urlPatterns = { "*.png", "*.jpg", "*.gif" }, initParams = {
		@WebInitParam(name = "notFoundImage", value = "/img/img-not-found.png") })
public class ImageFilter implements Filter {
	private String notFoundImage;

	/**
	 * Default constructor.
	 */
	public ImageFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;

		// ==> /images/path/my-image.png
		// ==> /path1/path2/image.pngs
		String servletPath = req.getServletPath();

		// Đường dẫn thực sự trên Server đến thư mục gốc (WebContent).
		String realRootPath = request.getServletContext().getRealPath("");

		// Đường dẫn thực tới file ảnh.
		String imageRealPath = realRootPath + servletPath;

		System.out.println("imageRealPath = " + imageRealPath);

		File file = new File(imageRealPath);

		// Kiểm tra xem ảnh có tồn tại không
		if (file.exists()) {

			// Cho phép request được đi tiếp. (Vượt qua Filter này).
			// (Để đi tiếp tới file ảnh yêu cầu).
			chain.doFilter(request, response);

		} else if (!servletPath.equals(this.notFoundImage)) {

			// Chuyển hướng tới 'image not found' image.
			HttpServletResponse resp = (HttpServletResponse) response;

			// ==> /ServletFilterTutorial + /images/image-not-found.png
			resp.sendRedirect(req.getContextPath() + this.notFoundImage);

		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// ==> /images/image-not-found.png
		notFoundImage = fConfig.getInitParameter("notFoundImage");
	}

}
