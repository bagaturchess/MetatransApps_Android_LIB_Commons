package com.apps.mobile.android.commons.cfg.publishedapp;


import java.util.ArrayList;
import java.util.List;

import com.apps.mobile.android.commons.app.Application_Base;
import com.apps.mobile.android.commons.cfg.appstore.IAppStore;


public class PublishedApplication_Utils {
	
	
	//Published applications per each store
	public static final List<IPublishedApplication> APPSLIST_GOOGLE_ALL 			= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_SAMSUNG_ALL 			= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_OPERA_ALL 				= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_AMAZON_ALL 			= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_YANDEX_ALL 			= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_HUAWEI_ALL 			= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_FDROID_OWN_ALL 		= new ArrayList<IPublishedApplication>();
	public static final List<IPublishedApplication> APPSLIST_FDROID_OFFICIAL_ALL	= new ArrayList<IPublishedApplication>();
	
	
	//Init Google store published applications
	static {
		
		IPublishedApplication app_cafk 		= new PublishedApplication_CAFK(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_cafk_paid	= new PublishedApplication_CAFK_Paid(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_mafk 		= new PublishedApplication_MAFK(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_mafk_paid	= new PublishedApplication_MAFK_Paid(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_ec 		= new PublishedApplication_EC(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_ec_paid	= new PublishedApplication_EC_Paid(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_mos 		= new PublishedApplication_MOS(IAppStore.OBJ_GOOGLE);
		IPublishedApplication app_mos_paid  = new PublishedApplication_MOS_Paid(IAppStore.OBJ_GOOGLE);
		
		IPublishedApplication app_bagaturchess = new PublishedApplication_BagaturChess(IAppStore.OBJ_GOOGLE);
		
		IPublishedApplication app_stoptheballs = new PublishedApplication_StopTheBalls(IAppStore.OBJ_GOOGLE);
		
		IPublishedApplication app_gravityfinger137 = new PublishedApplication_GravityFinger137(IAppStore.OBJ_GOOGLE);
		
		IPublishedApplication app_wisconsin = new PublishedApplication_Wisconsin(IAppStore.OBJ_GOOGLE);
		
		IPublishedApplication app_chessboardscanner = new PublishedApplication_CBS(IAppStore.OBJ_GOOGLE);
		
		app_mos.setPaidVersion(app_mos_paid);
		app_ec.setPaidVersion(app_ec_paid);
		app_mafk.setPaidVersion(app_mafk_paid);
		app_cafk.setPaidVersion(app_cafk_paid);
		
		
		APPSLIST_GOOGLE_ALL.add(app_chessboardscanner);
		APPSLIST_GOOGLE_ALL.add(app_wisconsin);
		APPSLIST_GOOGLE_ALL.add(app_gravityfinger137);
		APPSLIST_GOOGLE_ALL.add(app_stoptheballs);
		APPSLIST_GOOGLE_ALL.add(app_bagaturchess);
		APPSLIST_GOOGLE_ALL.add(app_mos);
		APPSLIST_GOOGLE_ALL.add(app_mos_paid);
		APPSLIST_GOOGLE_ALL.add(app_cafk);
		APPSLIST_GOOGLE_ALL.add(app_cafk_paid);
		APPSLIST_GOOGLE_ALL.add(app_mafk);
		APPSLIST_GOOGLE_ALL.add(app_mafk_paid);
		APPSLIST_GOOGLE_ALL.add(app_ec);
		APPSLIST_GOOGLE_ALL.add(app_ec_paid);
		
	}
	
	
	//Init Samsung store published applications
	static {
		
		//APPSLIST_SAMSUNG_NON_SOCIAL.add(new PublishedApplication_EC(IAppStore.OBJ_SAMSUNG, "000001002742"));
		IPublishedApplication app_cafk 	= new PublishedApplication_CAFK(IAppStore.OBJ_SAMSUNG, "000000806963");
		
		APPSLIST_SAMSUNG_ALL.add(app_cafk);
		
	}
	
	
	//Init Opera store published applications
	static {
		
		IPublishedApplication app_cafk 		= new PublishedApplication_CAFK(IAppStore.OBJ_OPERA, 	"718528");
		IPublishedApplication app_mafk 		= new PublishedApplication_MAFK(IAppStore.OBJ_OPERA, 	"721004");
		IPublishedApplication app_ec 		= new PublishedApplication_EC(IAppStore.OBJ_OPERA, 	 	"721082");
		IPublishedApplication app_mos 		= new PublishedApplication_MOS(IAppStore.OBJ_OPERA, 	"786014");
		
		APPSLIST_OPERA_ALL.add(app_mos);
		APPSLIST_OPERA_ALL.add(app_cafk);
		APPSLIST_OPERA_ALL.add(app_mafk);
		APPSLIST_OPERA_ALL.add(app_ec);
	}
	
	
	//Init Amazon store published applications
	static {
		
		IPublishedApplication app_cafk 	= new PublishedApplication_CAFK(IAppStore.OBJ_AMAZON, 	"B00IWB69ZY"); 
		IPublishedApplication app_mafk 	= new PublishedApplication_MAFK(IAppStore.OBJ_AMAZON,  	"B00TII2X3M");
		IPublishedApplication app_ec 	= new PublishedApplication_EC(IAppStore.OBJ_AMAZON, 	"B00TIEQ7TW");
		IPublishedApplication app_mos 	= new PublishedApplication_MOS(IAppStore.OBJ_AMAZON, 	"B017IVKW0G");
		
		APPSLIST_AMAZON_ALL.add(app_mos);
		APPSLIST_AMAZON_ALL.add(app_cafk);
		APPSLIST_AMAZON_ALL.add(app_mafk);
		APPSLIST_AMAZON_ALL.add(app_ec);
	}
	
	
	//Init Yandex store published applications
	static {
		
		IPublishedApplication app_cafk 	= new PublishedApplication_CAFK(IAppStore.OBJ_YANDEX, 	(String) null); 
		IPublishedApplication app_mafk 	= new PublishedApplication_MAFK(IAppStore.OBJ_YANDEX,  	(String) null);
		IPublishedApplication app_ec 	= new PublishedApplication_EC(IAppStore.OBJ_YANDEX, 	(String) null);
		IPublishedApplication app_mos 	= new PublishedApplication_MOS(IAppStore.OBJ_YANDEX, 	(String) null);
		
		APPSLIST_YANDEX_ALL.add(app_mos);
		APPSLIST_YANDEX_ALL.add(app_cafk);
		APPSLIST_YANDEX_ALL.add(app_mafk);
		APPSLIST_YANDEX_ALL.add(app_ec);
	}


	//Init Huawei store published applications
	static {

		IPublishedApplication app_cafk 				= new PublishedApplication_CAFK(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_mafk 				= new PublishedApplication_MAFK(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_ec 				= new PublishedApplication_EC(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_mos 				= new PublishedApplication_MOS(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_bagaturchess		= new PublishedApplication_BagaturChess(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_stoptheballs 		= new PublishedApplication_StopTheBalls(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_gravityfinger137 	= new PublishedApplication_GravityFinger137(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_wisconsin 		= new PublishedApplication_Wisconsin(IAppStore.OBJ_HUAWEI);
		IPublishedApplication app_chessboardscanner = new PublishedApplication_CBS(IAppStore.OBJ_HUAWEI);

		APPSLIST_HUAWEI_ALL.add(app_cafk);
		APPSLIST_HUAWEI_ALL.add(app_mafk);
		APPSLIST_HUAWEI_ALL.add(app_ec);
		APPSLIST_HUAWEI_ALL.add(app_mos);
		APPSLIST_HUAWEI_ALL.add(app_bagaturchess);
		APPSLIST_HUAWEI_ALL.add(app_stoptheballs);
		APPSLIST_HUAWEI_ALL.add(app_gravityfinger137);
		APPSLIST_HUAWEI_ALL.add(app_wisconsin);
		APPSLIST_HUAWEI_ALL.add(app_chessboardscanner);
	}


	//Init FDROID own store published applications
	static {

		IPublishedApplication app_cafk 				= new PublishedApplication_CAFK(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_mafk 				= new PublishedApplication_MAFK(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_ec 				= new PublishedApplication_EC(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_mos 				= new PublishedApplication_MOS(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_bagaturchess		= new PublishedApplication_BagaturChess(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_stoptheballs 		= new PublishedApplication_StopTheBalls(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_gravityfinger137 	= new PublishedApplication_GravityFinger137(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_wisconsin 		= new PublishedApplication_Wisconsin(IAppStore.OBJ_FDROID_OWN);
		IPublishedApplication app_chessboardscanner = new PublishedApplication_CBS(IAppStore.OBJ_FDROID_OWN);

		APPSLIST_FDROID_OWN_ALL.add(app_cafk);
		APPSLIST_FDROID_OWN_ALL.add(app_mafk);
		APPSLIST_FDROID_OWN_ALL.add(app_ec);
		APPSLIST_FDROID_OWN_ALL.add(app_mos);
		APPSLIST_FDROID_OWN_ALL.add(app_bagaturchess);
		APPSLIST_FDROID_OWN_ALL.add(app_stoptheballs);
		APPSLIST_FDROID_OWN_ALL.add(app_gravityfinger137);
		APPSLIST_FDROID_OWN_ALL.add(app_wisconsin);
		APPSLIST_FDROID_OWN_ALL.add(app_chessboardscanner);
	}


	//Init FDROID official store published applications
	static {

		IPublishedApplication app_cafk 				= new PublishedApplication_CAFK(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_mafk 				= new PublishedApplication_MAFK(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_ec 				= new PublishedApplication_EC(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_mos 				= new PublishedApplication_MOS(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_bagaturchess		= new PublishedApplication_BagaturChess(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_stoptheballs 		= new PublishedApplication_StopTheBalls(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_gravityfinger137 	= new PublishedApplication_GravityFinger137(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_wisconsin 		= new PublishedApplication_Wisconsin(IAppStore.OBJ_FDROID_OFFICIAL);
		IPublishedApplication app_chessboardscanner = new PublishedApplication_CBS(IAppStore.OBJ_FDROID_OFFICIAL);

		APPSLIST_FDROID_OFFICIAL_ALL.add(app_cafk);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_mafk);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_ec);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_mos);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_bagaturchess);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_stoptheballs);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_gravityfinger137);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_wisconsin);
		APPSLIST_FDROID_OFFICIAL_ALL.add(app_chessboardscanner);
	}


	public static List<IPublishedApplication> getStoreApps(IAppStore store) {
		
		List<IPublishedApplication> all = new ArrayList<IPublishedApplication>();
		
		switch (store.getID()) {
			
			case IAppStore.ID_GOOGLE:
				
				all.addAll(APPSLIST_GOOGLE_ALL);
				break;
				
			case IAppStore.ID_SAMSUNG:
				
				all.addAll(APPSLIST_SAMSUNG_ALL);
				break;
				
			case IAppStore.ID_AMAZON:
				
				all.addAll(APPSLIST_AMAZON_ALL);
				break;
				
			case IAppStore.ID_YANDEX:
				
				all.addAll(APPSLIST_YANDEX_ALL);
				break;
				
			case IAppStore.ID_OPERA:
				
				all.addAll(APPSLIST_OPERA_ALL);
				break;

			case IAppStore.ID_HUAWEI:

				all.addAll(APPSLIST_HUAWEI_ALL);
				break;

			case IAppStore.ID_FDROID_OWN:

				all.addAll(APPSLIST_FDROID_OWN_ALL);
				break;

			case IAppStore.ID_FDROID_OFFICIAL:

				all.addAll(APPSLIST_FDROID_OFFICIAL_ALL);
				break;
		}
		
		return all;
	}
	
	
	/*
	private static IPublishedApplication getApplication(IAppStore store, String packageName) {
		
		List<IPublishedApplication> all = getStoreApps(store);
		for (IPublishedApplication cur: all) {
			if (cur.getPackage().equals(packageName)) {
				return cur;
			}
		}
		
		return null;
	}
	*/
	
	
	/*
	public static List<IPublishedApplication> getMarketingList(IPublishedApplication app) {
		
		if (app.getSocialVersion() != null) {
			
			List<IPublishedApplication> result = new ArrayList<IPublishedApplication>();
			result.add(app.getSocialVersion());
			return result;
			
		} else {
			return getStoreApps_PreferSocial(app.getAppStore());
		}
	}
	*/
	
	
	/*
	public static List<IPublishedApplication> getStoreApps_PreferSocial(IAppStore store) {
		
		if (true) {
			return getStoreApps(store);
		}
		
		List<IPublishedApplication> all = getStoreApps(store);
		
		List<IPublishedApplication> filtered = new ArrayList<IPublishedApplication>();
		
		for (IPublishedApplication cur: all) {
			if (cur.getSocialVersion() == null){
				filtered.add(cur);
			}
		}
		
		
		return filtered;
	}
	*/
	
	
	public static List<IPublishedApplication> getStoreApps_FreeOnly(IAppStore store) {
		
		List<IPublishedApplication> all = getStoreApps(store);
		
		List<IPublishedApplication> filtered = new ArrayList<IPublishedApplication>();
		
		boolean preferSocial = Application_Base.getInstance().getApp_Me().isSocial();
		
		for (IPublishedApplication cur: all) {
			
			//Add only if there is no paid version.
			if (!cur.isPaid()) {
				
				if (preferSocial) {
					
					if (cur.isSocial()) {
						filtered.add(cur);
					}
					
				} else {
					
					if (!cur.isSocial()) {
						filtered.add(cur);
					}
					
				}
			}
		}
		
		
		return filtered;
	}
	
	
	public static List<IPublishedApplication> getStoreApps_PreferPaid(IAppStore store) {
		
		List<IPublishedApplication> all = getStoreApps(store);
		
		List<IPublishedApplication> filtered = new ArrayList<IPublishedApplication>();
		
		for (IPublishedApplication cur: all) {
			//Add only if there is no paid version. Otherwise the paid version will be added anyway.
			if (cur.getPaidVersion() == null) {
				filtered.add(cur);
			}
		}
		
		
		return filtered;
	}
}
