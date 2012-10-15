package ch.zhaw.warranty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
        
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.BTcreateNewWarrantyCard:
        	System.out.println("foobar");
        	
        	Intent myIntent = new Intent(MainActivity.this, CardActivity.class);
        	startActivity(myIntent);
        	break;
        case R.id.BTListWarrantyCards:
        	System.out.println("baaronly");
        	
        	Intent myIntent2 = new Intent(MainActivity.this, CardListActivity.class);
        	startActivity(myIntent2);
        	break;
        }
        
      }
    
    
}
