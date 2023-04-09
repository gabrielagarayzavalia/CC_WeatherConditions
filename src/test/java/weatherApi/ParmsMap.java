package weatherApi;

public class ParmsMap {
	
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public ParmsMap(String k, String v) {
		super();
		this.key = k;
		this.value = v;
		
	}
	

}
