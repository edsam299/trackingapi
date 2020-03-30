package trackingapi.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ReturnModel")
public class ReturnModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3910535598247216998L;
	private boolean success;
	private Object data;
	private List<ExceptionBean> errorTexts;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public List<ExceptionBean> getErrorTexts() {
		return errorTexts;
	}
	public void setErrorTexts(List<ExceptionBean> errorTexts) {
		this.errorTexts = errorTexts;
	}
	@Override
	public String toString() {
		return "ReturnModel [success=" + success + ", data=" + data + ", errorTexts=" + errorTexts + "]";
	}

	
}
