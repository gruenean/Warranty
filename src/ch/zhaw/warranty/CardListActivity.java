package ch.zhaw.warranty;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CardListActivity extends ListActivity {
	private ArrayAdapter<String> arrayAdapter;
//	private TBLWarrantyConnector tblwarranty;
	private ListView list;
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_card_list, menu);
        return true;
    }
    
	
	@Override
	public void onCreate(Bundle saveInstanceState) {
   		super.onCreate(saveInstanceState);
		setContentView(R.layout.activity_card_list);
//		tblwarranty = new TBLWarrantyConnector(this);
		list = getListView();
		
		
		list.setOnItemClickListener(new OnItemClickListener() {
			  @Override
			  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Toast.makeText(getApplicationContext(),
			      "Opening Number " + position, Toast.LENGTH_LONG)
			      .show();
			  }
			});
		
		list.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getApplicationContext(),
					      "Opening Number " + position, Toast.LENGTH_LONG).show();
				return false;
				}
			
		
		
		});
		
		ArrayList<String> cards = MainActivity.tblwarranty.getAllCards();
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,cards);		
		setListAdapter(arrayAdapter);
	}

}
