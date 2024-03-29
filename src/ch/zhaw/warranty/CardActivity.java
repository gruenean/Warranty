package ch.zhaw.warranty;

import java.net.DatagramPacket;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import ch.zhaw.warranty.card.WarrantyCard;

public class CardActivity extends Activity {
	private EditText tbtitle,tbdesc,tbcreatedat,tbvalidtil,tbprice,tbreseller;
//	private TBLWarrantyConnector tblwarranty;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        tbtitle = (EditText) findViewById(R.id.card_TBtitle);
        tbdesc = (EditText) findViewById(R.id.card_TBdesc);
        tbcreatedat = (EditText) findViewById(R.id.card_TBcreatedAt);
        tbvalidtil = (EditText) findViewById(R.id.card_TBvalidTil);
        tbprice = (EditText) findViewById(R.id.card_TBprice);
        tbreseller = (EditText) findViewById(R.id.card_TBreseller);
//        tblwarranty = new TBLWarrantyConnector(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_card, menu);
        return true;
    }
    
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.card_BTadd:
        	createNewCard();
        	break;
        case R.id.card_BTClear:
        	clearAllFields();
        	break;
        }
      }
    
    /**
     * grabs text from input fields and creates a new card
     */
    private void createNewCard() {
    	WarrantyCard card = new WarrantyCard(tbtitle.getText().toString(), 
    			tbdesc.getText().toString(), "/foobar/", tbcreatedat.getText().toString(), 
    			tbvalidtil.getText().toString(), tbprice.getText().toString(), tbreseller.getText().toString());
    	MainActivity.tblwarranty.insertWarrantyCard(card);
    	clearAllFields();
    	//TODO: listAllCards() - testing only.
    	listAllCards();
    }
    
    /**
     * Clears all fields in the CardActivity.
     */
    private void clearAllFields() {
    	//TODO: there is probably a nicer way to clear all fields... 
    	tbtitle.setText("");
    	tbdesc.setText("");
    	tbcreatedat.setText("");
    	tbvalidtil.setText("");
    	tbprice.setText("");
    	tbreseller.setText("");
    }
    
    /**
     * currently only syso's all cards
     */
    private void listAllCards() { 
    	ArrayList<String> cards = MainActivity.tblwarranty.getAllCards();
    	
    	for (String card : cards) {
			System.out.println("Card title is: " + card);
		}
    }
    

}
