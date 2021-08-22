package com.apps.mobile.android.commons.menu;


import java.util.ArrayList;
import java.util.List;

import com.apps.mobile.android.commons.Activity_Base;
import com.apps.mobile.android.commons.R;
import com.apps.mobile.android.commons.cfg.menu.IConfigurationMenu_Main;
import com.apps.mobile.android.commons.ui.Toast_Base;
import com.apps.mobile.android.commons.ui.list.ListViewFactory;
import com.apps.mobile.android.commons.ui.list.RowItem_IdTD;
import com.apps.mobile.android.commons.ui.utils.BitmapUtils;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;


public abstract class Activity_Menu_Base extends Activity_Base {
	
	
	private List<IConfigurationMenu_Main> entries;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		try {
			
			entries = getEntries();
			
			LayoutInflater inflater = LayoutInflater.from(this);
			ViewGroup frame = ListViewFactory.create_ITD_ByXML(this, inflater, buildRows(entries), new OnItemClickListener_Menu());
			
			setContentView(frame);
			
			setBackgroundPoster(R.id.commons_listview_frame, 55);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	protected int getBackgroundImageID() {
		boolean left_handed = (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
		return left_handed ? R.drawable.ic_bell_landscape : R.drawable.ic_bell_portrait;
	}
	
	
	@Override
	public void onPause() {
		
		System.out.println("Activity_Menu_Main: onPause()");
		
		super.onPause();
		
	}
	
	
	@Override
	public void onResume() {
		
		System.out.println("Activity_Menu_Main: onResume()");
		
		super.onResume();
		
	}
	
	
	protected abstract List<IConfigurationMenu_Main> getEntries();
	
	
	private List<RowItem_IdTD> buildRows(List<IConfigurationMenu_Main> entries) {
		
		List<RowItem_IdTD> rowItems = new ArrayList<RowItem_IdTD>();
		
		for (int i = 0; i < entries.size(); i++) {
			
			IConfigurationMenu_Main entry = (IConfigurationMenu_Main) entries.get(i);
			
			String title = entry.getName_String();
			String description = entry.getDescription_String();
			/*if ("".equals(description.trim())) {
				description = entry.getDescription() == 0 ? "" : getString(entry.getDescription());
			}*/
			Drawable drawable = BitmapUtils.createDrawable(this, BitmapUtils.fromResource(this, entry.getIconResID(), getIconSize()));
			
			RowItem_IdTD item = new RowItem_IdTD(drawable, title, description);
			rowItems.add(item);
		}
		
		
		return rowItems;
	}
	
	
	
	private class OnItemClickListener_Menu implements
			AdapterView.OnItemClickListener {
		
		
		private OnItemClickListener_Menu() {
		}
		
		
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			
			Runnable action = entries.get(position).getAction();
			
			if (action == null) {
				Toast_Base.showToast_InCenter_Long(Activity_Menu_Base.this, "Clicked menu item with id=" + id + ", but no action found ...");
			} else {
				action.run();
			}
		}
	}
}
