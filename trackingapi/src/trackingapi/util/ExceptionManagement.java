//package rama.his.billing.exception;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//
//import rama.his.billing.dao.factory.TransactionLogDAO;
//import rama.his.connection.factory.ConnectionFactory;
//public class ExceptionManagement implements Serializable{
//	public static String businessException="Business";
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 5828282875126180693L;
//	public static List<ExceptionBean> getException(Exception exception) throws Exception{
//		List<ExceptionBean> lExceptionBean=null; ExceptionBean exceptionBean=null;
//		StackTraceElement[] stackTraceElement=null; TransactionLogDAO transactionLogDAO=null; JsonObject jsonObject=null; JsonObject jsonError=null;
//		Connection sqlConn = null; Gson gson=null;
//		try {
//			lExceptionBean=new ArrayList<ExceptionBean>();
//			exceptionBean = new ExceptionBean();
//			stackTraceElement=exception.getStackTrace(); transactionLogDAO=new TransactionLogDAO(); jsonObject = new JsonObject();
//			gson = new GsonBuilder().serializeNulls().create();
//			if(exception.getCause()!=null) {
//				if("Business".equals(exception.getCause().getMessage())) {
//					exceptionBean.setErrorType(1);			
//					exceptionBean.setErrorText(exception.getMessage());
//				}else {
//					exceptionBean.setErrorType(2);		
//					exceptionBean.setErrorText(exception.toString()+" root Cause: "+exception.getCause());
//				}
//			}else {
//				exceptionBean.setErrorType(2);	
//				exceptionBean.setErrorText(exception.toString());
//				sqlConn=ConnectionFactory.getSQLInstance();
//				if(stackTraceElement.length>0) {
//					jsonError = gson.fromJson(gson.toJson(stackTraceElement[0]), JsonObject.class);
//					jsonObject.addProperty("moduleName", jsonError.get("methodName").getAsString());
//					jsonObject.addProperty("exmsg", exception.toString());
//					jsonObject.add("exception", gson.fromJson(gson.toJson(stackTraceElement), JsonArray.class));
//					transactionLogDAO.writeErrorLog(sqlConn, jsonObject);
//				}
//			}			
//			lExceptionBean.add(exceptionBean);
//			return lExceptionBean;
//		}catch(Exception e) {
//			throw e;
//		}finally {
//			lExceptionBean=null; exceptionBean=null; stackTraceElement=null;
//			 transactionLogDAO=null; jsonObject=null; jsonError=null;
//			ConnectionFactory.closeConnection(sqlConn);
//		}
//	}
//}
