package json;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	/**
	 * ��java����ת����json����
	 * @throws JsonProcessingException 
	 */
	public static void test1() throws JsonProcessingException{
		Stock s = new Stock();
		s.setCode("600877");
		s.setName("�й�����");
		s.setPrice(9);
		//ʹ��jackson�ṩ��api��ת��
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(s);
		System.out.println(jsonStr);
		
	}
	/**
	 * ��java������ɵļ���ת����json�ַ���
	 * 
	 */
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks = new ArrayList<Stock>();
		Random r = new Random();
		for(int i=0;i<8;i++){
			Stock s = new Stock();
			s.setCode("60087"+r.nextInt(10));
			s.setName("�й�����"+r.nextInt(10));
			s.setPrice(r.nextInt(10));
			stocks.add(s);
		}
		//ʹ��jackson�ṩ��api��ת��
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(stocks);
		System.out.println(jsonStr);
	}
	public static void main(String[] args) throws JsonProcessingException {
		test1();
		test2();
		System.out.println();
		
		System.out.println('A'+2);
		
		System.out.println(50&7);
	}

}
