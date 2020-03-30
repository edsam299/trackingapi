package trackingapi.model;

//import com.google.gson.JsonArray;

public class ExceptionBean{

	private int errorType;
	private String errorText;
//	private JsonArray errorJson;
	public int getErrorType() {
		return errorType;
	}
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
//	public JsonArray getErrorJson() {
//		return errorJson;
//	}
//	public void setErrorJson(JsonArray errorJson) {
//		this.errorJson = errorJson;
//	}


	
	
}
