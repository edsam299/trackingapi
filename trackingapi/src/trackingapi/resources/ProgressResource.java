package trackingapi.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import trackingapi.model.ReturnModel;

@Path("trackingService")
public class ProgressResource {
	Gson gson=null; JsonObject jsonObject=null; ReturnModel returnModel=null;
	
	@POST
	@Path("getProgressByDate")
	@Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON+";charset=UTF-8")
	public Response getProgressByDate() {
		try {
			gson = new GsonBuilder().serializeNulls().create();
			return Response.ok().entity(gson.toJson(returnModel)).build();
		}catch(Exception e) {
			return Response.ok().entity(gson.toJson(returnModel)).build();
		}finally {
			
		}
	}
}
