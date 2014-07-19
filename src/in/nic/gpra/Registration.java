package in.nic.gpra;

public class Registration {
	private String _regno;
	private String _name;
	private String _dob;
	private String _doj;
	private String _dor;
	
	public Registration() {
		_regno = "";
		_name = "";
		_dob = "";
		_doj = "";
		_dor = "";
	}
	
	public void setData(String key, String val) {
		if (key.equals("regno")) {
			_regno = val;
		}
		else if (key.equals("name")) {
			_name = val;
		}
		else if (key.equals("dob")) {
			_dob = val;
		}
		else if (key.equals("doj")) {
			_doj = val;
		}
		else if (key.equals("dor")) {
			_dor = val;
		}
	}
	
	public String getData(String key) {
		if (key.equals("regno")) {
			return _regno;
		}
		else if (key.equals("name")) {
			return _name;
		}
		else if (key.equals("dob")) {
			return _dob;
		}
		else if (key.equals("doj")) {
			return _doj;
		}
		else if (key.equals("dor")) {
			return _dor;
		}
		else return "";
	}
}
