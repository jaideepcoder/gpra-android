package in.nic.gpra;

public class Waiting {
	private String _type;
	private String _pool;
	private String _waitno;
	private String _category;
	
	public Waiting() {
		_type = "";
		_pool = "";
		_waitno = "";
		_category = "";
	}
	
	public void setData(String key, String val) {
		if (key.equals("type")) {
			_type = val;
		}
		else if (key.equals("pool")) {
			_pool = val;
		}
		else if (key.equals("waitno")) {
			_waitno = val;
		}
		else if (key.equals("category")) {
			_category = val;
		}
	}
	
	public String getData(String key) {
		if (key.equals("type")) {
			return _type;
		}
		else if (key.equals("pool")) {
			return _pool;
		}
		else if (key.equals("waitno")) {
			return _waitno;
		}
		else if (key.equals("category")) {
			return _category;
		}
		else return "";
	}
}
