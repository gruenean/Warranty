package ch.zhaw.warranty.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ch.zhaw.warranty.card.WarrantyCard;

public class TBLWarrantyConnector {
	private SQLiteDatabase db;
	private SQLiteOpenHelper dbHelper;
	
	public TBLWarrantyConnector(Context context) {
		dbHelper = new TBLWarrantyHelper(context,TBLWarrantyHelper.TBL_NAME,null,1);
	}
	
	private void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}
	
	private void close() {
		if (db != null) {
			db.close();
		}
	}
	
	public void insertWarrantyCard(WarrantyCard card){
		ContentValues values = new ContentValues();
		values.put("title", card.getTitle());
		
		open();
			db.insert(TBLWarrantyHelper.TBL_NAME, null, values);
		close();
	}

	public void updateWarrantyCard(WarrantyCard card) {
		ContentValues values = new ContentValues();
		values.put("title", card.getTitle());
		values.put("description", card.getDescription());
		
		
		open();
			db.update(TBLWarrantyHelper.TBL_NAME, values, "_id="+card.get_id(), null);
		close();
	}
	
	public void listAllCards() {
		db.query(TBLWarrantyHelper.TBL_NAME, new String[] {TBLWarrantyHelper.CLMN_TITLE, TBLWarrantyHelper.CLMN_VLDTIL}, null, null, null, null,TBLWarrantyHelper.CLMN_TITLE);
	}
	
}
