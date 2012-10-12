package ch.zhaw.warranty;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText tfname; 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tfname = (EditText) findViewById(R.id.TFname);
  
    }   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
        
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.BTClear:
        	tfname.setText("");
        	break;
        case R.id.BTsubmit:
        	Editable name = tfname.getText();
        	tfname.setText("huhu" +  name);
        	break;
        case R.id.BTlwc:
        	System.out.println("foobar");
        	MyListActivity mla = new MyListActivity();
        	break;
        }
      }
    
    
}
