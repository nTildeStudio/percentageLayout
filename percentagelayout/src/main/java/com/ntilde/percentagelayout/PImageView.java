package com.ntilde.percentagelayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

public class PImageView extends ImageView {
	
	private float pHeight;
	
	public void setPHeigth(float ph){
		pHeight = ph;
	}
	
	public PImageView(Context context){
		super(context);
		init(null);
	}
	
	public PImageView(Context context, AttributeSet attrs){
		super(context, attrs);
		init(attrs);
	}
	
	public PImageView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        init(attrs);
    }
	
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
		calcHeight(pHeight);
	}
	
	private void init(AttributeSet attrs){
		if(attrs==null){
			return;
		}
		TypedArray attrsArray=getContext().obtainStyledAttributes(attrs,R.styleable.PImageView);
		pHeight=attrsArray.getFloat(R.styleable.PImageView_piv_height, 0);
		//calcHeight(pHeight);
		attrsArray.recycle();
	}
	
	public void setImageBitmap(Bitmap bm){
	        super.setImageBitmap(bm);
	        calcHeight(pHeight);
	}
	
	 public void setImageDrawable(Drawable drawable){
		 super.setImageDrawable(drawable);
	     calcHeight(pHeight);
	 }
	
	
	private void calcWidth(int height) {
		try{
			Bitmap bmp = ((BitmapDrawable)getDrawable()).getBitmap();
			float aspectRatio = bmp.getWidth()/bmp.getHeight();
			int newwidth = (int)(height*aspectRatio);
			getLayoutParams().width = newwidth;
		}catch(Exception ex){
			Log.v(getClass().getName(),"Error obteniendo el ancho de la imagen porque no existe imagen", ex);
			getLayoutParams().width = getMeasuredWidth();
		}
		invalidate();
		requestLayout();
		
	}

	private void calcHeight(float pHeight){
		if(pHeight!=0){
			WindowManager wm=(WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
			Display display=wm.getDefaultDisplay();
			Point screenSize=new Point(0,0);
			display.getSize(screenSize);
			float newPixlesHeight=pHeight*screenSize.y/100;
			getLayoutParams().height = (int) newPixlesHeight;
			calcWidth( (int) newPixlesHeight);
		}
		
	}
}