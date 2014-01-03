package palacesoft.eclipseoftime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import palacesoft.eclipseoftime.baseobjects.Person;
import palacesoft.eclipseoftime.models.Characters;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class EligibilityScreen extends ListFragment {

	SimpleAdapter eligibleActorsAdapter;
	ArrayList<Map<String, String>> arrayCharacterMaps;
	HashMap<Integer,Characters> listToCharacterObjectMap;
	String statToOrderBy;

	
	public EligibilityScreen getFragment(){
		EligibilityScreen newFrag = new EligibilityScreen();
		return newFrag;
	}

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		arrayCharacterMaps = new ArrayList<Map<String,String>>();
		listToCharacterObjectMap = new HashMap<Integer, Characters>();
		statToOrderBy = "stat";
		String[] from = new String[]{"character" , statToOrderBy};
		
		TextView text1 = new TextView(getActivity());
		TextView text2 = new TextView(getActivity());
		TextView[] to2 = new TextView[2];
		to2[0] = text1;
		to2[1] = text2;
		
		int[] to = {android.R.id.text1, android.R.id.text2};
		/* add test names to list */
		addShitToList();
		eligibleActorsAdapter = new SimpleAdapter(getActivity(), arrayCharacterMaps,
				android.R.layout.simple_list_item_2, from, to);
		setListAdapter(eligibleActorsAdapter);
		
	}
	
	private void addShitToList() {		
		arrayCharacterMaps.add(buildData("ljfsalfkjsldf", "9alksdjflakdf0"));
		arrayCharacterMaps.add(buildData("ekljewlkjqlejfwlkf", "4lkajdflaksfjdlsakfj0"));
	}
	
	private void setStatToOrderBy(String stat_){
		statToOrderBy = stat_;
	}
	
	private HashMap<String,String> buildData(String name, String stat){
		HashMap<String,String> testMappings = new HashMap<String,String>();
		testMappings.put("character", name);
		testMappings.put(statToOrderBy, stat);
		
		return testMappings;
	}

	public void updateList(ArrayList<Characters> eligibleChars){
		arrayCharacterMaps.clear();
		listToCharacterObjectMap.clear();
		int i = 0;
		
		for(Characters x : eligibleChars){
			HashMap<String,String> characterMap = new HashMap<String, String>();
			characterMap.put("character", x.getName());
			listToCharacterObjectMap.put(i, x);
			
			int stat_ = 0;
			if(statToOrderBy == "str")				
				stat_ = x.getStr();
			if(statToOrderBy == "cunning")
				stat_ = x.getCunning();
			if(statToOrderBy == "wisdom")
				stat_ = x.getWisdom();
			if(statToOrderBy == "authority")
				stat_ = x.getAuthority();
			if(statToOrderBy == "honor")
				stat_ = x.getHonor();
			if(statToOrderBy == "faith")
				stat_ = x.getFaith();
			if(statToOrderBy == "loyalty")
				stat_ = x.getLoyalty();
			if(statToOrderBy == "relations")
				stat_ = x.getFaction().getPolitics().getForeignStanding(x.getFaction());
			
			characterMap.put(statToOrderBy, String.valueOf(stat_));
			arrayCharacterMaps.add(characterMap);
			i++;
		}
		
		eligibleActorsAdapter.notifyDataSetChanged();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	
	

}

