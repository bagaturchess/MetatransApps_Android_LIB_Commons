package org.metatrans.commons.loading;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.metatrans.commons.R;
import org.metatrans.commons.app.Application_Base;
import org.metatrans.commons.cfg.colours.ConfigurationUtils_Colours;
import org.metatrans.commons.events.api.IEvent_Base;
import org.metatrans.commons.events.api.IEventsManager;
import org.metatrans.commons.loading.logic.MovingEntry;
import org.metatrans.commons.ui.ButtonAreaClick;
import org.metatrans.commons.ui.ButtonAreaClick_Image;
import org.metatrans.commons.ui.IButtonArea;
import org.metatrans.commons.ui.TextArea;
import org.metatrans.commons.ui.utils.BitmapUtils;
import org.metatrans.commons.ui.utils.DrawingUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;


public abstract class View_Loading_Base extends Activity_Loading_Base.ViewWithLeaderBoard {


	private static final int MAX_ITERS = 4;


	private List<MovingEntry> entries;

	
	private RectF rectf_main;

	private RectF rectf_leaderboards;
	private RectF rectf_button_start;
	
	private RectF rectf_button_googleplus;
	private RectF rectf_button_rate_review;
	
	private TextArea textarea_label_loading;
	private IButtonArea buttonarea_start;
	
	protected Paint paint_background;
	protected Paint paint_images;
	
	private Runnable refresher; 
	
	private boolean sent_event_one_stoped = false;
	private boolean sent_event_all_stoped = false;
	
	
	public View_Loading_Base(Context context) {
		
		super(context);
		
		rectf_main 					= new RectF();
		rectf_button_start 			= new RectF();
		
		rectf_leaderboards 			= new RectF();
		
		rectf_button_googleplus		= new RectF();
		rectf_button_rate_review	= new RectF();
		
		paint_background 			= new Paint();
		paint_images 				= new Paint();
		
		entries 					= new Vector<MovingEntry>();
		
		refresher 					= new Update(this);
	}
	
	
	public abstract void initPiecesBitmaps();
	protected abstract Bitmap[] getCommonBitmaps();
	protected abstract Bitmap getBitmapBackground();//Can be null
	
	
	public RectF getRectangle_LeaderBoards() {
		return rectf_leaderboards;
	}
	
	
	public RectF getRectangle_GooglePlus() {
		return rectf_button_googleplus;
	}
	
	
	//@Override
	protected void registerEvent_AllStopped() {
		IEventsManager eventsManager = Application_Base.getInstance().getEventsManager();
		eventsManager.register(((Activity)getContext()), eventsManager.create(IEvent_Base.LOADING, IEvent_Base.LOADING_STOPPED_PIECES, "LOADING", "LOADING_STOPPED_PIECES"));
	}
	
	
	//@Override
	protected void registerEvent_1Stopped() {
		IEventsManager eventsManager = Application_Base.getInstance().getEventsManager();
		eventsManager.register(((Activity)getContext()), eventsManager.create(IEvent_Base.LOADING, IEvent_Base.LOADING_STOPPED_PIECE, "LOADING", "LOADING_STOPPED_PIECE"));
	}
	
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		//if (!initialized) {
			
			rectf_main.left = 0;
			rectf_main.right = getMeasuredWidth();
			rectf_main.top = 0;
			rectf_main.bottom = getMeasuredHeight();
			
			int MARGIN = 10;
			int buttons_width = getMeasuredWidth() / 2;
			int buttons_height =  getMeasuredHeight() / 11;
			int buttons_distance =  (getMeasuredHeight() - 6 * buttons_height) / 7;

			if (getMeasuredWidth() > getMeasuredHeight()) {
				buttons_height *= 1.5;
				buttons_distance =  (getMeasuredHeight() - 6 * buttons_height) / 7;
			}

			rectf_button_start.left = (rectf_main.right - rectf_main.left) / 2 - buttons_width / 2;
			rectf_button_start.right = (rectf_main.right - rectf_main.left) / 2 + buttons_width / 2;
			rectf_button_start.top = (rectf_main.bottom - rectf_main.top) / 2 - buttons_height / 2;
			rectf_button_start.bottom = (rectf_main.bottom - rectf_main.top) / 2 + 2 * buttons_height / 2;


			float googleplus_button_half_size = buttons_width / 6;

			if (getMeasuredHeight() > getMeasuredWidth()) {

				rectf_leaderboards.left = rectf_button_start.left;
				rectf_leaderboards.right = rectf_button_start.right;
				rectf_leaderboards.top = rectf_button_start.top / 2 - buttons_height / 2;
				rectf_leaderboards.bottom = rectf_leaderboards.top + buttons_height;

			} else {

				googleplus_button_half_size /= 2;

				rectf_leaderboards.left = rectf_button_start.left + 1 * (rectf_button_start.right - rectf_button_start.left) / 4;
				rectf_leaderboards.right = rectf_leaderboards.left + 2 * (rectf_button_start.right - rectf_button_start.left) / 4;
				rectf_leaderboards.top = rectf_button_start.top / 2 - buttons_height / 2;
				rectf_leaderboards.bottom = rectf_leaderboards.top + buttons_height;
			}


			rectf_button_googleplus.left = rectf_leaderboards.left / 2 - googleplus_button_half_size;
			rectf_button_googleplus.top = rectf_button_start.top;
			rectf_button_googleplus.right = rectf_leaderboards.left / 2 + googleplus_button_half_size;
			rectf_button_googleplus.bottom = rectf_button_start.bottom;
			
			rectf_button_rate_review.left = rectf_leaderboards.right + (rectf_main.right - rectf_leaderboards.right) / 2 - googleplus_button_half_size;
			rectf_button_rate_review.top = rectf_button_start.top + (rectf_button_start.bottom - rectf_button_start.top) / 2 - googleplus_button_half_size;
			rectf_button_rate_review.right = rectf_leaderboards.right + (rectf_main.right - rectf_leaderboards.right) / 2 + googleplus_button_half_size;
			rectf_button_rate_review.bottom = rectf_button_start.top + (rectf_button_start.bottom - rectf_button_start.top) / 2 + googleplus_button_half_size;
			
			createButtons();
			
			this.setMeasuredDimension( (int) (rectf_main.right - rectf_main.left), (int) (rectf_main.bottom - rectf_main.top) );
			
			
			//initialized = true;
		//}

		setOnTouchListener(new OnTouchListener_Loading(this));
	}
	
	
	private void createButtons() {
		
		
		textarea_label_loading = new TextArea(rectf_button_start, false, " " + getLoadingActivity().getString(R.string.loading) + " ",
				getLoadingActivity().getColoursCfg().getColour_Square_Black(),
				getLoadingActivity().getColoursCfg().getColour_Square_ValidSelection());
		
		//Color.rgb(51, 51, 51) delimeter
		//Color.rgb(153, 153, 153) white
		//Color.rgb(102, 102, 102) black
		buttonarea_start = new ButtonAreaClick(rectf_button_start, "  " + getLoadingActivity().getString(getLoadingActivity().getText_Menu0()) + "  ",
				getLoadingActivity().getColoursCfg().getColour_Square_ValidSelection(),
				getLoadingActivity().getColoursCfg().getColour_Square_Black(),
				getLoadingActivity().getColoursCfg().getColour_Square_MarkingSelection()
				//getLoadingActivity().getColoursCfg().getColour_Delimiter(),
				//getLoadingActivity().getColoursCfg().getColour_Square_ValidSelection(),
				//getLoadingActivity().getColoursCfg().getColour_Square_Black()
				);
	}
	
	
	public float getSquareSize() {
		return Math.min(rectf_main.width(), rectf_main.height()) / 5;
	}
	
	
	public boolean isOverRateButton(float x, float y) {
		return rectf_button_rate_review.contains(x, y);
	}
	
	
	public boolean isOverStartButton(float x, float y) {
		return rectf_button_start.contains(x, y) && getLoadingActivity().isDone();
	}
	
	
	public void selectButton_Start() {
		
		buttonarea_start.select();
		invalidate();
	}
	
	public void deselectButton_Start() {
		
		buttonarea_start.deselect();
		invalidate();
	}
	
	
	public synchronized void pushed(float x, float y) {
		
		RectF rectangle_pushed = new RectF();
		
		rectangle_pushed.left = x - getSquareSize() / 2;
		rectangle_pushed.right = x + getSquareSize() / 2;
		rectangle_pushed.top = y - getSquareSize() / 2;
		rectangle_pushed.bottom = y + getSquareSize() / 2;
		
		
		MovingEntry minclicks_entry = null;
		
		for (int i=0; i<entries.size(); i++) {
			
			MovingEntry entry = entries.get(i);
			
			if (rectangle_pushed.contains(entry.coordinates.x, entry.coordinates.y)) {	
				//Clicked
				if (minclicks_entry == null) {
					minclicks_entry = entry;
				} else {
					if (minclicks_entry.clicks > entry.clicks) {
						minclicks_entry = entry;
					}
				}
			}
		}
		
		if (minclicks_entry != null) {
			
			minclicks_entry.clicks++;
			
			entries.remove(minclicks_entry);
			entries.add(minclicks_entry);
		}

		
		if (!sent_event_one_stoped) {
			
			boolean one_stoped = false;
			for (int i=0; i<entries.size(); i++) {
				MovingEntry entry = entries.get(i);
				if (entry.clicks >= MAX_ITERS) {
					one_stoped = true;
					break;
				}
			}
			
			if (one_stoped) {
				sent_event_one_stoped = true;
				registerEvent_1Stopped();
			}
		}
		
		
		if (!sent_event_all_stoped) {
			
			boolean all_stoped = true;
			for (int i=0; i<entries.size(); i++) {
				MovingEntry entry = entries.get(i);
				if (entry.clicks < MAX_ITERS) {
					all_stoped = false;
					break;
				}
			}
			
			if (all_stoped) {
				sent_event_all_stoped = true;
				registerEvent_AllStopped();
			}
		}
	}
	
	
	protected void createEntry(Bitmap bitmap) {
		
		List<Bitmap> bitmaps = new ArrayList<Bitmap>();
		bitmaps.add(bitmap);
		bitmaps.add(bitmap);
		bitmaps.add(bitmap);
		for (int i=0; i<getCommonBitmaps().length; i++) {
			bitmaps.add(getCommonBitmaps()[i]);
		}
		
		float padding = 0.1f;
		float initial_x = (float) (padding * rectf_main.width() + Math.random() * (1 - 2 * padding) * rectf_main.width());
		float initial_y = (float) (padding * rectf_main.height() + Math.random() * (1 - 2 * padding) * rectf_main.height());
		
		entries.add(new MovingEntry(initial_x, initial_y, bitmaps));
	}
	
	
	private Activity_Loading_Base getLoadingActivity() {
		return (Activity_Loading_Base) getContext();
	}
	
	
	@Override
	protected synchronized void onDraw(Canvas canvas) {
		
		super.onDraw(canvas);
		
		paint_background.setColor(ConfigurationUtils_Colours.getConfigByID(Application_Base.getInstance().getUserSettings().uiColoursID).getColour_Square_Black());
		if (getBitmapBackground() != null) {
			paint_background.setAlpha(77);
			canvas.drawBitmap(getBitmapBackground(), null, rectf_main, paint_background);
		} else {
			canvas.drawRect(0, 0, rectf_main.width(), rectf_main.height(), paint_background);
		}
		
		//System.out.println("entries=" + entries.size());
		
		for (int iter=MAX_ITERS; iter >= 0; iter--) {
			for (int i=0; i<entries.size(); i++) {
				MovingEntry entry = entries.get(i);
				if (entry.clicks == iter || (entry.clicks > MAX_ITERS && iter == MAX_ITERS)) {
					DrawingUtils.drawInCenter(canvas, paint_images, getSquareSize(),
							entry.coordinates.x, entry.coordinates.y, entry.getBitmap(iter));	
				}
			}
		}
		
		//paint_background.setColor(getLoadingActivity().getColoursCfg().getColour_Delimiter());
		//DrawingUtils.drawRoundRectangle(canvas, paint_background, rectf_buttons);
		
		if (getLoadingActivity().isDone()) {
			buttonarea_start.draw(canvas);	
		} else {
			textarea_label_loading.draw(canvas);
		}
		
		updateCoordinates();
		
		getLoadingActivity().getUiHandler().post(refresher);
	}
	
	
	private void updateCoordinates() {
		
		
		for (int i=0; i<entries.size(); i++) {
			
			MovingEntry entry = entries.get(i);
			
			if (entry.clicks >= MAX_ITERS) {
				continue;
			}

			float speed_x = entry.speed_x * (1 + entry.clicks);
			float speed_y = entry.speed_y * (1 + entry.clicks);

			entry.coordinates.x += speed_x;
			entry.coordinates.y += speed_y;
			
			if (entry.coordinates.x < 0) {
				entry.coordinates.x = 0;
				entry.speed_x = -entry.speed_x;
			}
			if (entry.coordinates.x > rectf_main.width()) {
				entry.coordinates.x = rectf_main.width();
				entry.speed_x = -entry.speed_x;
			}
			if (entry.coordinates.y < 0) {
				entry.coordinates.y = 0;
				entry.speed_y = -entry.speed_y;
			}
			if (entry.coordinates.y > rectf_main.height()) {
				entry.coordinates.y = rectf_main.height();
				entry.speed_y = -entry.speed_y;
			}
		}
	}
	
	
	private static class Update implements Runnable {
		
		
		private View view;
		
		
		public Update(View _view) {
			view = _view;
		}
		
		
		@Override
		public void run() {
			
			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {}
			
			view.invalidate();
		}
	}
}
