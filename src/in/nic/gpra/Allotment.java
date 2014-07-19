package in.nic.gpra;

public class Allotment {
	private String _doa;
	private String _category;
	private String _pool;
	//private String _status;
	private String _type;
	private String _locale;
	private String _sector;
	private String _block;
	private String _houseno;
	private String _floor;
	
	public Allotment() {
		_doa = "";
		_category = "";
		_pool = "";
		//_status = "";
		_type = "";
		_locale = "";
		_sector = "";
		_block = "";
		_houseno = "";
		_floor = "";
	}
	
	public void setData(String key, String val) {
		if (key.equals("doa")) {
			_doa = val;
		}
		else if (key.equals("category")) {
			_category = val;
		}
		else if (key.equals("pool")) {
			_pool = val;
		}
		//else if (key.equals("status")) {
		//	_status = val;
		//}
		else if (key.equals("type")) {
			_type = val;
		}
		else if (key.equals("locale")) {
			_locale = val;
		}
		else if (key.equals("sector")) {
			_sector = val;
		}
		else if (key.equals("block")) {
			_block = val;
		}
		else if (key.equals("houseno")) {
			_houseno = val;
		}
		else if (key.equals("floor")) {
			_floor = val;
		}
	}
	
	public String getData(String key) {
		if (key.equals("doa")) {
			return _doa;
		}
		else if (key.equals("category")) {
			return _category;
		}
		else if (key.equals("pool")) {
			return _pool;
		}
		//else if (key.equals("status")) {
		//	return _status;
		//}
		else if (key.equals("type")) {
			return _type;
		}
		else if (key.equals("locale")) {
			return _locale;
		}
		else if (key.equals("sector")) {
			return _sector;
		}
		else if (key.equals("block")) {
			return _block;
		}
		else if (key.equals("houseno")) {
			return _houseno;
		}
		else if (key.equals("floor")) {
			return _floor;
		}
		else return "";
	}
	
}
