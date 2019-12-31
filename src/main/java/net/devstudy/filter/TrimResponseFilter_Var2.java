package net.devstudy.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

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
/*@WebFilter({"/trim", "/trim-params.html"})*/
public class TrimResponseFilter_Var2 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse originalResponse = (HttpServletResponse) resp;
		TrimWriter trimWriter = new TrimWriter();
		TrimResponse response = new TrimResponse(originalResponse, trimWriter);
		chain.doFilter(req, response);
		PrintWriter pw = originalResponse.getWriter();
		pw.write(trimWriter.getContent());
		originalResponse.setContentLength(trimWriter.getLength());
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
		private TrimWriter trimWriter;

		private TrimResponse(HttpServletResponse response, TrimWriter trimWriter) {
			super(response);
			this.trimWriter = trimWriter;
		}

		@Override
		public PrintWriter getWriter() throws IOException {
			return new PrintWriter(trimWriter);
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
					trimWriter.write(b);
				}
			};
		}
	}
	
	/**
	 * 
	 * @author devstudy
	 * @see http://devstudy.net
	 */
	private static class TrimWriter extends Writer {
		private final StringBuilder buf = new StringBuilder();
		@Override
		public void write(int c) throws IOException {
			processChar((char)c);
		}
		@Override
		public void write(char[] cbuf, int off, int len) throws IOException {
			for (int i = off; i < len; i++) {
				processChar(cbuf[i]);
			}
		}
		@Override
		public void write(String str, int off, int len) throws IOException {
			for (int i = off; i < len; i++) {
				processChar(str.charAt(i));
			}
		}
		private void processChar(char ch) throws IOException {
			if (ch != '\t' && ch != '\r' && ch != '\n') {
				buf.append(ch);
			}
		}
		@Override
		public void flush() throws IOException {
		}
		@Override
		public void close() throws IOException {
		}
		private String getContent(){
			return buf.toString();
		}
		private int getLength(){
			return buf.length();
		}
	}
}
