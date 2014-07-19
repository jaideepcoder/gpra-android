package in.nic.gpra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        setContentView(R.layout.activity_main);
    }
    
    public void onClickAllotment(View view) {
    	String regNo;
    	EditText input = (EditText) findViewById(R.id.regNo);
    	regNo = input.getText().toString();
    	if(regNo.isEmpty()) {
    		Toast.makeText(this, "Loading", Toast.LENGTH_LONG);
	        String allotmentFeed = readJSONFeed("allotment", regNo);
	        
	        try {
	        	JSONArray jsonArray = new JSONArray(allotmentFeed);
	        	Log.i(MainActivity.class.getName(), "Number of Entries " + jsonArray.length());
	        	Allotment[] allotment = new Allotment[jsonArray.length()];
	        	for (int i = 0; i < jsonArray.length(); i++) {
	        		JSONObject jsonObject = jsonArray.getJSONObject(i);
	        		
	        		allotment[i].setData("doa", jsonObject.getString("DOA"));
	        		allotment[i].setData("category", jsonObject.getString("alt_catg"));
	        		allotment[i].setData("pool", jsonObject.getString("pool"));
	        		//allotment[i].setData("status", jsonObject.getString("DOA"));
	        		allotment[i].setData("type", jsonObject.getString("qtr_type"));
	        		allotment[i].setData("locale", jsonObject.getString("locality"));
	        		allotment[i].setData("sector", jsonObject.getString("sector"));
	        		allotment[i].setData("block", jsonObject.getString("block"));
	        		allotment[i].setData("houseno", jsonObject.getString("houseno"));
	        		allotment[i].setData("floor", jsonObject.getString("floor"));
	        		
	        	}
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
    	}
    	else {
    		Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_LONG).show();
    	}
    }
    
    public void onClickWaiting(View view) {
    	String regNo;
    	EditText input = (EditText) findViewById(R.id.regNo);
    	regNo = input.getText().toString();
    	if(regNo.length() != 0) {
    		Toast.makeText(this, "Loading", Toast.LENGTH_LONG);
	        String waitingFeed = readJSONFeed("registration", regNo);
	        
	        try {
	        	JSONArray jsonArray = new JSONArray(waitingFeed);
	        	Log.i(MainActivity.class.getName(), "Number of Entries " + jsonArray.length());
	        	Waiting[] waiting  = new Waiting[jsonArray.length()];
	        	
	        	for (int i = 0; i < jsonArray.length(); i++) {
	        		JSONObject jsonObject = jsonArray.getJSONObject(i);
	        		waiting[i].setData("type", jsonObject.getString("type"));
	        		waiting[i].setData("pool", jsonObject.getString("pool"));
	        		waiting[i].setData("waitno", jsonObject.getString("waitno"));
	        		waiting[i].setData("category", jsonObject.getString("alt_catg"));
	        	}
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
    	}
    	else {
    		Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_LONG).show();
    	}
    }
    
    public void onClickRegistration(View view) {
    	String regNo;
    	EditText input = (EditText) findViewById(R.id.regNo);
    	regNo = input.getText().toString();
    	if(regNo.length() != 0) {
    		Toast.makeText(this, "Loading", Toast.LENGTH_LONG);
	        String registrationFeed = readJSONFeed("registration", regNo);
	        
	        try {
	        	JSONArray jsonArray = new JSONArray(registrationFeed);
	        	Log.i(MainActivity.class.getName(), "Number of Entries " + jsonArray.length());
	        	Registration registration = new Registration();
	        	
	        	for (int i = 0; i < jsonArray.length(); i++) {
	        		JSONObject jsonObject = jsonArray.getJSONObject(i);
	        		registration.setData("regno", jsonObject.getString("regno"));
	        		registration.setData("name", jsonObject.getString("regno"));
	        		registration.setData("regno", jsonObject.getString("regno"));
	        		registration.setData("regno", jsonObject.getString("regno"));
	        	}
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
    	}
    	else {
    		Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_LONG).show();
    	}
    }

    public String readJSONFeed(String table, String regNo) {
    	StringBuilder builder = new StringBuilder();
    	HttpClient client = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet("http://gpra.herokuapp.com/"+table+"/"+regNo);
    	try {
    		HttpResponse response = client.execute(httpGet);
    		StatusLine statusLine = response.getStatusLine();
    		int statusCode = statusLine.getStatusCode();
    		if (statusCode == 200) {
    			HttpEntity entity = response.getEntity();
    			InputStream content = entity.getContent();
    			BufferedReader reader = new BufferedReader(new InputStreamReader(content));
    			String line;
    			while ((line = reader.readLine()) != null) {
    				builder.append(line);
    			}
    		}
    		else {
    			Log.e(MainActivity.class.toString(), "Failed to read data stream");
    		}
    	}
    	catch (ClientProtocolException e) {
    		e.printStackTrace();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	return builder.toString();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
