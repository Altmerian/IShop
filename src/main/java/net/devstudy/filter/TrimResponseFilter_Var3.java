package net.devstudy.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 
 * @author devstudy
 * @see http://devstudy.net
 */
//@WebFilter({"/trim", "/trim-params.html"})
public class TrimResponseFilter_Var3 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse originalResponse = (HttpServletResponse) resp;
		TrimResponse response = new TrimResponse(originalResponse);
		chain.doFilter(req, response);
		PrintWriter pw = originalResponse.getWriter();
		String content = response.getTrimContent();
		pw.write(content);
		originalResponse.setContentLength(content.length());
		pw.flush();
		pw.close();
	}

	@Override
	public void destroy() {
	}

	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static class TrimResponse extends HttpServletResponseWrapper {
		private StringWriter sw = new StringWriter();

		private TrimResponse(HttpServletResponse response) {
			super(response);
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(sw);
		}
		
		@Override
		public ServletOutputStream getOutputStream() throws IOException {
			return new ServletOutputStream(){
				@Override
				public boolean isReady() {
					return false;
				}
				@Override
				public void setWriteListener(WriteListener writeListener) {
					
				}
				@Override
				public void write(int b) throws IOException {
					sw.write(b);
				}
			};
		}

		private String getTrimContent() {
			return trim(sw.toString());
		}
	}

	private static String trim(String text) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (ch != '\t' && ch != '\r' && ch != '\n') {
				res.append(ch);
			}
		}
		return res.toString();
	}
}
