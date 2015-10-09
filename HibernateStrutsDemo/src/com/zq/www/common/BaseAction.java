package com.zq.www.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


//提取的公共Action
public class BaseAction extends ActionSupport{
	
	
	// 取得Request/Response/Session的简化函数 //
		
		/**
		 * 取得HttpRequest的简化方法.
		 */
		public static HttpServletRequest getRequest() {
			return ServletActionContext.getRequest();
		}

		/**
		 * 取得HttpResponse的简化方法.
		 */
		public static HttpServletResponse getResponse() {
			return ServletActionContext.getResponse();
		}
		
		
		//得到session
		
		

}
