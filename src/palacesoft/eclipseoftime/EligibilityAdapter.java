package palacesoft.eclipseoftime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import palacesoft.lostundertheshade.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class EligibilityAdapter extends BaseAdapter {

	public int rowSize, columnSize;
	public ArrayList<HashMap> list;
	public Activity activity;
	
	private String[] columnTags = new String[] {"col1", "col2", "col3", "col4", "col5", "col6",
			"col7", "col8"};
	
	private int[] columnIds = new int[] {R.id.data1, R.id.data2, R.id.data3, R.id.data4, R.id.data5,
			R.id.data6, R.id.data7, R.id.data8};
	
	private class ViewHolder{
		TextView first;
		TextView second;
		TextView third;
		TextView fourth;
		TextView fifth;
		TextView sixth;
		TextView seventh;
		TextView eighth;
		
	};
	
	public EligibilityAdapter(Activity activity, ArrayList<HashMap> mapping){
		super();
		for(int i = 0; i < rowSize; i++){
			for(int j = 0; j < columnSize; j++){
			
			}
		}
	}
	
	@Override
	public int getCount() {
		return list.size();
	}
	
	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}
	
	@Override
	public long getItemId(int arg0) {
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		LayoutInflater inflater = activity.getLayoutInflater();
		
		if(convertView == null){
			convertView = inflater.inflate(R.layout.custom_list_view, null);
			holder = new ViewHolder();
			holder.first = (TextView) convertView.findViewById(R.id.data1);
			holder.second = (TextView) convertView.findViewById(R.id.data2);
			holder.third = (TextView) convertView.findViewById(R.id.data3);
			holder.fourth = (TextView) convertView.findViewById(R.id.data4);
			holder.fifth = (TextView) convertView.findViewById(R.id.data5);
			holder.sixth = (TextView) convertView.findViewById(R.id.data6);
			holder.seventh = (TextView) convertView.findViewById(R.id.data7);
			holder.eighth = (TextView) convertView.findViewById(R.id.data8);
			
		}
		else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		HashMap map = list.get(position);
		
		return convertView;
	}
}
