package ch.zhaw.warranty;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import ch.zhaw.warranty.database.TBLWarrantyConnector;

public class CardListActivity extends ListActivity {
	private ArrayAdapter<String> arrayAdapter;
	private TBLWarrantyConnector tblwarranty;

	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_card_list, menu);
        return true;
    }
    
	
	@Override
	public void onCreate(Bundle saveInstanceState) {
   		super.onCreate(saveInstanceState);
		setContentView(R.layout.activity_card_list);
		tblwarranty = new TBLWarrantyConnector(this);
 
		ArrayList<String> cards = tblwarranty.getAllCards();
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cards);		
		setListAdapter(arrayAdapter);
	}
}
