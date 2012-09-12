package net.arogarth.android.littlearcher.database;

import java.util.ArrayList;
import java.util.Date;

import net.arogarth.android.littlearcher.database.models.RingCount;

import android.text.format.DateFormat;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RingCountHandler extends DatabaseHandler {
 
	private static String TABLE_NAME = "ring_count";
	
    public RingCountHandler() {
        super(TABLE_NAME);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String ringCount = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY," +
                "training_id INTEGER, round INTEGER," +
                "ring1 INTEGER, ring2 INTEGER, ring3 INTEGER," +
                "ring4 INTEGER, ring5 INTEGER, ring6 INTEGER," +
                "ring7 INTEGER, ring8 INTEGER, ring9 INTEGER," +
                "ring10 INTEGER, X INTEGER, M INTEGER)";
        
        db.execSQL(ringCount);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS ring_count");
 
        // Create tables again
        onCreate(db);
    }
    
    public void addRingCount(RingCount rings) {
    	SQLiteDatabase db = getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put("training_id", rings.getTrainingId());
    	values.put("round", rings.getRound());
    	values.put("ring1", rings.getRing1());
    	values.put("ring2", rings.getRing2());
    	values.put("ring3", rings.getRing3());
    	values.put("ring4", rings.getRing4());
    	values.put("ring5", rings.getRing5());
    	values.put("ring6", rings.getRing6());
    	values.put("ring7", rings.getRing7());
    	values.put("ring8", rings.getRing8());
    	values.put("ring9", rings.getRing9());
    	values.put("ring10", rings.getRing10());
    	values.put("X", rings.getX());
    	values.put("M", rings.getM());
    	
    	db.insert(TABLE_NAME, null, values);
    	db.close();
    	
    }
    
    public ArrayList<RingCount> loadResults() {
    	return this.loadResults("");
    }
    
    public ArrayList<RingCount> loadResults(String where) {
    	SQLiteDatabase db = this.getReadableDatabase();
    	 
        Cursor cursor = db.query(
        		TABLE_NAME,
        		new String[]{"id", "training_id", "round",
        				"ring1", "ring2", "ring3", "ring4", "ring5",
        				"ring6", "ring7", "ring8", "ring9", "ring10", "X", "M"},
        		where,
        		null, null, null, null);
        
        if (cursor != null)
            cursor.moveToFirst();

        ArrayList<RingCount> stack = new ArrayList<RingCount>();
        do {
        	RingCount row = new RingCount();
        	row.setId(cursor.getInt(0));
        	row.setRound(cursor.getInt(2));
        	row.setRing1(cursor.getInt(3));
        	row.setRing2(cursor.getInt(4));
        	row.setRing3(cursor.getInt(5));
        	row.setRing4(cursor.getInt(6));
        	row.setRing5(cursor.getInt(7));
        	row.setRing6(cursor.getInt(8));
        	row.setRing7(cursor.getInt(9));
        	row.setRing8(cursor.getInt(0));
        	row.setRing9(cursor.getInt(11));
        	row.setRing10(cursor.getInt(12));
        	
        	stack.add(row);
        } while( cursor.moveToNext() );
        
        return stack;
    }
    
}