package com.apps.mobile.android.commons.cfg.difficulty;


import com.apps.mobile.android.commons.R;
import com.apps.mobile.android.commons.cfg.ConfigurationEntry_Base;


public abstract class Config_Difficulty_7 extends ConfigurationEntry_Base implements IConfigurationDifficulty {
	
	
	@Override
	public int getID() {
		return MODE_COMPUTER_ENGINE_3SEC;
	}

	@Override
	public int getName() {
		return R.string.menu_difficulty_7;
	}

	@Override
	public int getIconResID() {
		return R.drawable.ic_difficulty_v2_l3;
	}
}
