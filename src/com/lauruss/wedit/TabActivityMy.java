package com.lauruss.wedit;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

public class TabActivityMy extends TabActivity{

	static TabHost tabHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);
		setTab();
		
	}
	public void setTab(){
		addTab("setting", R.drawable.tab_setting, SettingActivity.class);
		addTab("invitemanagement", R.drawable.tab_invitemanagemant, InviteManagementActivity.class);
		
		addTab("home", R.drawable.tab_home, HomeActivity.class);
		addTab("temp", R.drawable.tab_temp, MainActivity.class);
		addTab("task", R.drawable.tab_task, TaskActivity.class);
	}
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
}
