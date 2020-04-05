package trackingapi.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import trackingapi.model.ExceptionBean;

public class ExceptionManagement implements Serializable{
	public static String businessException="Business";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5828282875126180693L;
	public static List<ExceptionBean> getException(Exception exception) throws Exception{
		List<ExceptionBean> lExceptionBean=null; ExceptionBean exceptionBean=null; Gson gson=null;
		try {
			lExceptionBean=new ArrayList<ExceptionBean>();
			exceptionBean = new ExceptionBean();
			gson = new GsonBuilder().serializeNulls().create();
			if(exception.getCause()!=null) {
				if("Business".equals(exception.getCause().getMessage())) {
					exceptionBean.setErrorType(1);			
					exceptionBean.setErrorText(exception.getMessage());
				}else {
					exceptionBean.setErrorType(2);		
					exceptionBean.setErrorText(exception.toString()+" root Cause: "+exception.getCause());
				}
			}else {
				exceptionBean.setErrorType(2);	
				exceptionBean.setErrorText(exception.toString());
			}			
			lExceptionBean.add(exceptionBean);
			return lExceptionBean;
		}catch(Exception e) {
			throw e;
		}finally {
			lExceptionBean=null; exceptionBean=null;
		}
	}
}
