package palacesoft.lostundertheshade.core;

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
	
	private ResourceType resourceType;
	
	public Resource(){
		resourceType = ResourceType.NONE;
		imgOnMap = null;
		iconImage = null;
	}
	
	public Resource(ResourceType type, ImageView icon, ImageView map){
		resourceType = type;
		imgOnMap = map;
		iconImage = icon;
		
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
