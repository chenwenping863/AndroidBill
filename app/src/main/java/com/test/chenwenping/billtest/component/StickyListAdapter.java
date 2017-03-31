package com.test.chenwenping.billtest.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.chenwenping.billtest.R;

import java.util.ArrayList;

public class StickyListAdapter extends BaseAdapter implements StickyListHeadersAdapter {

	private ArrayList<String> list;
	private Context mContext;
	private static LayoutInflater inflater=null;


	public void init(Context context, ArrayList<String> list) {
		this.list = list;
		this.mContext = context;
		mContext = context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if(convertView == null) {
			vi = inflater.inflate(R.layout.item_ly, null);
		}

		TextView tvDate = (TextView) vi.findViewById(R.id.bill_list_item_date);
		tvDate.setText("Item--:" + position);
		tvDate.setTextSize(20);
		return vi;
	}

	@Override
	public View getHeaderView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		if(convertView == null) {
			vi = inflater.inflate(R.layout.header_ly, null);
		}

		TextView tvDate = (TextView) vi.findViewById(R.id.bill_list_month_item_month_tx);
		tvDate.setText("Header--:" + position);
		tvDate.setTextSize(20);
		return vi;
	}


	@Override
	public long getHeaderId(int position) {
		return position/10 + 0x1234;
	}
}
