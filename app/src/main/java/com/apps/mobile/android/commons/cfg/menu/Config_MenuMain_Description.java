package com.apps.mobile.android.commons.cfg.menu;


import android.app.Activity;
import android.content.Intent;

import com.apps.mobile.android.commons.R;
import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.events.api.IEvent_Base;
import com.apps.mobile.android.commons.events.api.IEventsManager;
import com.apps.mobile.android.commons.web.Activity_WebView_StatePreservingImpl_With_VideoPlayer;


public class Config_MenuMain_Description extends Config_MenuMain_Base {
	
	
	@Override
	public int getID() {
		return CFG_MENU_DESCRIPTION;
	}
	
	
	@Override
	public int getName() {
		return R.string.description;
	}
	
	
	@Override
	public int getIconResID() {
		return R.drawable.ic_description;
	}
	
	
	@Override
	public int getDescription() {
		return 0;
	}


	@Override
	public Runnable getAction() {
		
		return new Runnable() {
			
			@Override
			public void run() {
				Activity currentActivity = Application_Base.getInstance().getCurrentActivity();
				if (currentActivity != null) {
		           	Intent intent = new Intent(currentActivity, Activity_WebView_StatePreservingImpl_With_VideoPlayer.class);
	            	intent.putExtra("URL", "file:///android_asset/www/games.html#" + Application_Base.getInstance().getAppConfig().getTag_Description());
	            	intent.putExtra("titleID", getName());
	            	currentActivity.startActivity(intent);
	            	
	            	IEventsManager eventsManager = Application_Base.getInstance().getEventsManager();
	            	eventsManager.register(Application_Base.getInstance(), eventsManager.create(IEvent_Base.MENU_OPERATION, IEvent_Base.MENU_OPERATION_OPEN_DESCRIPTION,
							"MENU_OPERATION", "OPEN_DESCRIPTION"));
				}
			}
		};
	}
}
