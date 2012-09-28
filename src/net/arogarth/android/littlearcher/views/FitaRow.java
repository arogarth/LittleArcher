package net.arogarth.android.littlearcher.views;

import net.arogarth.android.littlearcher.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class FitaRow extends TableRow {

	public FitaRow(Context context) {
		super(context);
		
		this.initFitaRow(context, null);
	}

		
	public FitaRow(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		this.initFitaRow(context, attrs);
	}

	private void initFitaRow(Context context, AttributeSet attrs) {
		
		final LayoutInflater inflater = (LayoutInflater)
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		inflater.inflate(R.layout.fita_row, this);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FitaRow);      

		if( attrs != null ) {
			String ring = a.getString( R.styleable.FitaRow_ring );
			((TextView) findViewById(R.id.ringnumber)).setText(ring);

			if( ring.equalsIgnoreCase("10") || ring.equalsIgnoreCase("9") )
				this.setBackgroundResource(R.color.gold_ring);
			else if( ring.equalsIgnoreCase("8") || ring.equalsIgnoreCase("7") )
				this.setBackgroundResource(R.color.red_ring);
			else if( ring.equalsIgnoreCase("6") || ring.equalsIgnoreCase("5") )
				this.setBackgroundResource(R.color.blue_ring);
			else if( ring.equalsIgnoreCase("4") || ring.equalsIgnoreCase("3") )
				this.setBackgroundResource(R.color.black_ring);
			else if( ring.equalsIgnoreCase("2") || ring.equalsIgnoreCase("1") )
				this.setBackgroundResource(R.color.white_ring);
			else if( ring.equalsIgnoreCase("X") || ring.equalsIgnoreCase("M") )
				this.setBackgroundResource(R.color.white_ring);
			
			((View) findViewById(R.id.increase_ring)).setTag(ring);
			((View) findViewById(R.id.decrease_ring)).setTag(ring);
		}
	}
}