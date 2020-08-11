package com.dy.authorization.filter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dy.authorization.properties.SecurityConstants;
import com.dy.authorization.rsa.RSAUtil;

/**
 * @Title RequestWrapper
 * @Description  自定义HttpServletRequestWrapper
 * @author dy
 * @date 2019年12月13日
 */
public class RequestWrapper extends HttpServletRequestWrapper {

	private Logger logger = LoggerFactory.getLogger(Object.class);
	
	private Map<String, String[]> paramsMap = new HashMap<String, String[]>();//将request对象中的参数修改后，放在这个集合里，随后项目取的所有Parameter都是从这个集合中取数
	
	/**
	 * 定义构造函数
	 * @param request
	 */
    public RequestWrapper(HttpServletRequest request) {
        super(request);
        Map<String, String[]> params = (Map<String,String[]>)request.getParameterMap();
        for (Map.Entry<String, String[]> entry: params.entrySet()) {
        	String key = entry.getKey();
        	String[] values = entry.getValue();
        	for (int i = 0; i < SecurityConstants.NEED_DECRYPT_PARAMS.length; i++) {     	
            	if(key.equals(SecurityConstants.NEED_DECRYPT_PARAMS[i])) {
            		if(StringUtils.isNotBlank(values[0])) {
            			if(values[0].contains(" "))//使用postman可能会把+转为空格
            				values[0] = values[0].replace(" ", "+");
            			logger.info("解密前："+values[0]);
    	        		values[0] = RSAUtil.decrypt(values[0], SecurityConstants.PRIVATE_KEY);
    	        		logger.info("解密后："+values[0]);    	            	            	
            		}
            		break;
                }
    		}
        	paramsMap.put(key, values);	
		}     
    }

    @Override
    public String getParameter(String name) {
         String[]values = paramsMap.get(name);
         if(values == null || values.length == 0) {
             return null;
         }
         return values[0];
    }
    
    @Override
    public Enumeration<String> getParameterNames() {
        Vector<String> v = new Vector<String>();
        for (String key : paramsMap.keySet()) {
            v.add(key);
        }
        return v.elements();
    }
    
    @Override
    public String[] getParameterValues(String name) {
        return paramsMap.get(name);
    }
}
