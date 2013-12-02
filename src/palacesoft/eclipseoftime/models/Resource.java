package palacesoft.eclipseoftime.models;

import palacesoft.eclipseoftime.utils.BitmapCollection;
import android.widget.ImageView;


/**
 * The Resource class manages any bonus terrain tiles under player control.
 * @author DaPalacios
 *
 */
public class Resource {

	public static enum ResourceType{
		NONE,
		ANCIENT_RELIC,
		RUBIES,
		POISON_PLANT,
		STONE
		
	};
	
	private ImageView imgOnMap;
	private ImageView iconImage;
	private int supply;
	private ResourceType resourceType;
	
	public Resource(){
		resourceType = ResourceType.NONE;
		imgOnMap = null;
		iconImage = null;
		supply = 0;
	}
	public Resource(ResourceType type, int m_supply){
		resourceType = type;
		switch(type){
//		case NONE:
//			imgOnMap = BitmapCollection.STANDARD_RES_MAP;
//			iconImage = BitmapCollection.STANDARD_RES_ICON;
//			break;
//		case ANCIENT_RELIC:
//			imgOnMap = BitmapCollection.ANCIENT_RELIC_MAP;
//			iconImage = BitmapCollection.ANCIENT_RELIC_ICON;
//			break;
//		case RUBIES:
//			imgOnMap = BitmapCollection.RUBIES_MAP;
//			iconImage = BitmapCollection.RUBIES_ICON;
//			break;
//		case POISON_PLANT:
//			imgOnMap = BitmapCollection.POISON_PLANT_MAP;
//			iconImage = BitmapCollection.POISON_PLANT_ICON;
//			break;
//		case STONE:
//			imgOnMap = BitmapCollection.STONE_RES_MAP;
//			iconImage = BitmapCollection.STONE_RES_ICON;
//			break;
		}
		supply = m_supply;
	}
	
	public Resource(ResourceType type, ImageView icon, ImageView map){
		resourceType = type;
		imgOnMap = map;
		iconImage = icon;
		supply = 1;
	}
	
	
	public void determineBoost(Kingdom kingdom){
		boolean alreadyHas = false;
		for(Resource x : kingdom.getHomeCity().getResources()){
			if(x.resourceType == resourceType){
				alreadyHas = true;
				break;
			}
		}
		
		if(!alreadyHas){
			kingdom.getHomeCity().addNewResource(this);		
		}
	}
	
	/**
	 * Getters and setters *****************************
	 */

	public int getSupply(){
		return supply;
	}
	
	public ImageView getImgOnMap() {
		return imgOnMap;
	}

	public void setImgOnMap(ImageView imgOnMap) {
		this.imgOnMap = imgOnMap;
	}

	public ImageView getIconImage() {
		return iconImage;
	}

	public void setIconImage(ImageView iconImage) {
		this.iconImage = iconImage;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}
	

	
	
}
