package com.yljv.alarmapp.client.ui.alarm;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.yljv.alarmapp.R;
import com.yljv.alarmapp.client.helper.ApplicationSettings;
import com.yljv.alarmapp.client.ui.addpicture.AddPicForPartnerActivity;
import com.yljv.alarmapp.server.alarm.Alarm;
import com.yljv.alarmapp.server.alarm.AlarmInstance;
import com.yljv.alarmapp.server.alarm.MyAlarmManager;

public class PartnerAlarmFragment extends Fragment {

	public ListView listView; 
	ArrayList<Alarm> list = new ArrayList<Alarm>();
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.partner_clock_layout, container, false);
		listView = (ListView) view.findViewById(R.id.partner_clock_list);
		getActivity().getActionBar().setTitle(R.string.partner_alarms);
		listView.setAdapter(MyAlarmManager.getPartnerClockAdapter(this.getActivity()));
		if(ApplicationSettings.hasPartner() == true) {
			listView.setEmptyView(view.findViewById(R.id.empty_list));
		}
		else{
			listView.setEmptyView(view.findViewById(R.id.no_buddy));
		}
		listView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				// TODO Auto-generated method stub
				AlarmInstance ai = (AlarmInstance) listView.getAdapter().getItem(position);
				Intent intent = new Intent(getActivity(), AddPicForPartnerActivity.class);
				intent.putExtra(AlarmInstance.COLUMN_OBJECT_ID, ai.getObjectId());
				listView.setItemChecked(position, false);
				startActivity(intent);
				/*
				if (getActivity() instanceof MenuMainActivity) {
					MenuMainActivity mma = (MenuMainActivity) getActivity();
					mma.switchContent(newContent);
				} 
				*/
			}
		});
		
		
		return view;
	}
		
		//Button on action bar to add a photo
		

}


	
