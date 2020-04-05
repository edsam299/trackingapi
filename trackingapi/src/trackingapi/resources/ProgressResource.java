package trackingapi.resources;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import trackingapi.config.MySQLFactory;
import trackingapi.dao.ProgressDAO;
import trackingapi.model.ReturnModel;
import trackingapi.util.ExceptionManagement;

@Path("trackingService")
public class ProgressResource {
	Gson gson=null; JsonObject jsonObject=null; ReturnModel returnModel=null; 
	
	@GET
	@Path("getProgressByLastuUpdate")
	@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON+";charset=UTF-8")
	public Response getProgressByLastuUpdate() throws Exception{
		String date=null; SimpleDateFormat sdf=null; Connection oConn=null; 
		try {
			sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
			date = sdf.format(new Date());
			gson = new GsonBuilder().serializeNulls().create();
			oConn=MySQLFactory.getDbCon().conn; returnModel = new ReturnModel(); 
			jsonObject=new ProgressDAO().searchProgressByLastUpdate(oConn, date);
			if(jsonObject!=null) {
				returnModel.setSuccess(true);
				jsonObject.add("detail", JsonParser.parseString(jsonObject.get("detail").getAsString()));
				returnModel.setData(jsonObject);
			}else {
				returnModel.setErrorTexts(ExceptionManagement.getException(new Exception("search not found", new Throwable(ExceptionManagement.businessException))));
			}
			return Response.ok().entity(gson.toJson(returnModel)).build();
		}catch(Exception e) {
			returnModel.setData(ExceptionManagement.getException(e));
			return Response.ok().entity(gson.toJson(returnModel)).build();
		}finally {
			sdf = null; date=null; gson=null; jsonObject=null; returnModel=null;
		}
	}
}
