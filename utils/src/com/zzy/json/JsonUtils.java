package com.zzy.json;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.zzy.model.Person;
import com.zzy.model.Phone;

/**
 * JsonUtil.java 说明：json工具类
 * 
 * @author zhengzy
 * @date 2015年9月25日
 */
public class JsonUtils {

	public static <T> T fromJson(String strJson, Class<T> className) {
		try {
			return new ObjectMapper().readValue(strJson, className);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toJson(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		/**
		 * model需要空的构造函数
		 */
		Person person = new Person(1, "xiaoming", new Phone("0594", "1234567890"));
		System.out.println(JsonUtils.toJson(person));
		Person person2 = JsonUtils.fromJson(JsonUtils.toJson(person), Person.class);
		System.out.println(person2.toString());
	}
}
