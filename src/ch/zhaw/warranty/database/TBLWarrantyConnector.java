package ch.zhaw.warranty.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ch.zhaw.warranty.card.WarrantyCard;

/**
 * This class manages all calls to the database table 'warranty'
 */
public class TBLWarrantyConnector {
	private SQLiteDatabase db;
	private SQLiteOpenHelper dbHelper;
	
	public TBLWarrantyConnector(Context context) {
		dbHelper = new TBLWarrantyHelper(context,TBLWarrantyHelper.TBL_NAME,null,1);
	}
	
	/**
	 * Opens an r/w connection to the sqlite db
	 * @throws SQLException
	 */
	private void openDB() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}
	
	/**
	 * closes the connection to the sqlite db
	 */
	private void closeDB() {
		if (db != null) {
			db.close();
		}
	}
	
	/**
	 * This method will be called each time a new warranty card is created
	 * @param card	newly created warranty card
	 */
	public void insertWarrantyCard(WarrantyCard card){
		ContentValues values = new ContentValues();
		values.put(TBLWarrantyHelper.CLMN_TITLE, card.getTitle());
		values.put(TBLWarrantyHelper.CLMN_DESC, card.getDescription());
		values.put(TBLWarrantyHelper.CLMN_CREATEDAT, card.getCreatedAt());
		values.put(TBLWarrantyHelper.CLMN_VLDTIL, card.getValidUntil());
		values.put(TBLWarrantyHelper.CLMN_PRICE, card.getPrice());
		values.put(TBLWarrantyHelper.CLMN_RESSELLER,card.getReseller());
		
		openDB();
			db.insert(TBLWarrantyHelper.TBL_NAME, null, values);
		closeDB();
	}

	/**
	 * This method is used to update a particular warranty card
	 * @param card	card to update
	 */
	public void updateWarrantyCard(WarrantyCard card) {
		ContentValues values = new ContentValues();
		values.put("title", card.getTitle());
		values.put("description", card.getDescription());
		
		openDB();
			db.update(TBLWarrantyHelper.TBL_NAME, values, "_id="+card.get_id(), null);
		closeDB();
	}
	
	/**
	 * This method will return all saved warranty cards
	 * @return	all saved warranty cards
	 */
	public ArrayList<String> getAllCards() {
		System.out.println("list all cards");
		openDB();

//		ArrayList<WarrantyCard> cards = new ArrayList<WarrantyCard>();
		ArrayList<String> cards = new ArrayList<String>();
//		Cursor cursor = db.query(TBLWarrantyHelper.TBL_NAME, new String[] {TBLWarrantyHelper.CLMN_TITLE, TBLWarrantyHelper.CLMN_VLDTIL}, null, null, null, null,TBLWarrantyHelper.CLMN_TITLE);
		Cursor cursor = db.query(TBLWarrantyHelper.TBL_NAME, new String[] {TBLWarrantyHelper.CLMN_TITLE} , null, null, null, null,TBLWarrantyHelper.CLMN_TITLE);
		cursor.moveToFirst();

		while(!cursor.isAfterLast()) {
			cards.add(cursor.getString(0));
			cursor.moveToNext();
		}
		cursor.close();
		closeDB();
		return cards;
	}
	
	/**
	 * Deletes all saved cards
	 */
	public void deleteAllCards() {
		openDB();
		db.delete(TBLWarrantyHelper.TBL_NAME, null, null);
		closeDB();
		
	}
	
	public void deleteCard(WarrantyCard card) {
		openDB();
		db.delete(TBLWarrantyHelper.TBL_NAME, "_id = " + card.get_id(), null);
		closeDB();
	}
}
