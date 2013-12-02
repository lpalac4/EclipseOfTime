package palacesoft.eclipseoftime.models;

import android.widget.ImageView;

/**
 * Building class is the base class for all buildings in the world including castles.
 * @author DaPalacios
 *
 */
public class Building {
	
	private int hp;
	private ImageView mapImage;
	private ImageView cityImage;
	public static enum BuildingType{
		WALL,
		PYRAMID,
		ARMORY,
		MARKET,
		TEMPLE,
		CITY,
		NONE
	}
	
	private BuildingType buildingType;
	
	public Building(){
		hp = 100;
		buildingType = BuildingType.NONE;
		
	}
	
	public Building(int startinghp, ImageView mapView, ImageView cityView, BuildingType btype){
		hp = startinghp;
		mapImage = mapView;
		cityImage = cityView;
		buildingType = btype;
	}

	
	/**
	 * Getters and setters*******************************
	 */
	
	
	public int getHp() {
		return hp;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ImageView getMapImage() {
		return mapImage;
	}

	public void setMapImage(ImageView mapImage) {
		this.mapImage = mapImage;
	}

	public ImageView getCityImage() {
		return cityImage;
	}

	public void setCityImage(ImageView cityImage) {
		this.cityImage = cityImage;
	}
	
	

}
