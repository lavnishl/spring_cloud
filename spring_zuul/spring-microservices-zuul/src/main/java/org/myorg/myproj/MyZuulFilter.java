/**
 * 
 */
package org.myorg.myproj;

import java.util.Date;

import com.netflix.zuul.ZuulFilter;

/**
 * @author Lavnish
 *
 */
public class MyZuulFilter extends ZuulFilter {

	/* 
	 * Actual Filter Logic
	 */
	@Override
	public Object run() {
		Date d = new Date();
		System.out.println("This request passed through MyZuulFilter @ "+d.toString());
		return null;
	}

	/* 
	 * Should this filter run or not ?
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* 
	 * What order this filter is in within the given filters of the application
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* 
	 * Standard types in Zuul are "pre" for pre-routing filtering, "route" for routing to an origin, "post" for post-routing filters, "error" for error handling
	 * May want to add header to response or modify data post response
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
