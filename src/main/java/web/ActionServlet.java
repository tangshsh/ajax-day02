package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import json.Stock;


public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void service(
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		response.setContentType("text/html;charset=UTF-8");
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		System.out.println("action:"+action);
		PrintWriter out = response.getWriter();
		if("/quoto".equals(action)){
			//模拟生成股票信息
			List<Stock> stocks = new ArrayList<Stock>();
			Random r = new Random();
			for(int i=0;i<8;i++){
				Stock s = new Stock();
				s.setCode("60087"+r.nextInt(10));
				s.setName("中国嘉陵"+r.nextInt(10));
				s.setPrice(r.nextInt(10));
				stocks.add(s);
			}
			//使用jackson提供的api来转换
			ObjectMapper om = new ObjectMapper();
			String jsonStr = om.writeValueAsString(stocks);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if("/demo".equals(action)){
			Random r = new Random();
			int str = r.nextInt(100);
			ObjectMapper om = new ObjectMapper();
			
			String jsonStr = om.writeValueAsString(str);
			System.out.println(jsonStr);
			out.println(jsonStr);
		}else if("/check".equals(action)){
			String uname = request.getParameter("uname");
			ObjectMapper om = new ObjectMapper();
			System.out.println(uname);
			if(uname==""){
				String jsonStr = om.writeValueAsString("请输入用户名");
				out.println(jsonStr);
				return;
			}
			if("Sally".equals(uname)){
				String jsonStr = om.writeValueAsString("用户已被使用");
				out.println(jsonStr);
			}else{
				String jsonStr = om.writeValueAsString("可以使用");
				out.println(jsonStr);
			}
			
		}
		
				
	
	}

}
