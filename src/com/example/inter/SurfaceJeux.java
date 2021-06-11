package com.example.inter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceJeux extends SurfaceView implements Runnable {
	SurfaceHolder monHolder;
	Thread monThread = null;
	boolean marche = false;
	int x;
	Bitmap brasJoueur,bouton,energie,plant;
	public SurfaceJeux(Context context) {
		super(context);
		monHolder = getHolder();
		brasJoueur = BitmapFactory.decodeResource(getResources(), R.drawable.barre);
		bouton = BitmapFactory.decodeResource(getResources(), R.drawable.bouton);
		energie = BitmapFactory.decodeResource(getResources(), R.drawable.energie);
		plant = BitmapFactory.decodeResource(getResources(), R.drawable.plant);
	}

	public void pause(){
		marche = false;
		while(true){
			try {
				monThread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		monThread=null;
	}
	
	public void resume(){
		marche= true;
		monThread = new Thread(this);
		monThread.start();
	}
	
	@SuppressLint("NewApi")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(marche){
			if(!monHolder.getSurface().isValid())
				continue;
			x= 45;
			Canvas canvas = monHolder.lockCanvas();
			canvas.drawBitmap(plant, -100, -150, null);
			canvas.drawBitmap(energie, canvas.getWidth()-energie.getWidth(), 0, null);
			canvas.drawBitmap(bouton, canvas.getWidth()-bouton.getWidth(), canvas.getHeight()-bouton.getHeight(), null);
			canvas.rotate((0+x),(canvas.getWidth()/2), 0);			
			canvas.drawBitmap(brasJoueur, ((canvas.getWidth()/2)), 0, null);
			canvas.rotate((0-x),(canvas.getWidth()/2), 0);			
			canvas.rotate((0-x),(canvas.getWidth()/2), canvas.getHeight() );
			canvas.drawBitmap(brasJoueur, (canvas.getWidth()/2), canvas.getHeight() - brasJoueur.getHeight() , null);			
			monHolder.unlockCanvasAndPost(canvas);
		}
	}
}