package cn.kgc.tangcco.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(filterName="CharactorFilter",urlPatterns="*.action",
initParams= {
		@WebInitParam(name="encoding",value="utf-8")
})
public class CharactorFilter implements Filter {

	@Override
	public void destroy() {
		 encoding=null;

	}
	private  String encoding=null;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 if(encoding!=null){
		        //设置request字符编码
		            request.setCharacterEncoding(encoding);
		         //设置response字符编码
		            response.setContentType("text/html;charset="+encoding);
		        }
		     //传给下一个过滤器
		        chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding=filterConfig.getInitParameter("encoding");

	}

}
