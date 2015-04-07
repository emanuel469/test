package models;
import java.util.ArrayList;


public class GemList {
	
	private SortedList<Gem> gemList;
	int counter = 1;
	
	private GemList(){
		this.gemList = new SortedCircularDoublyLinkedList<Gem>();
	}
	
	public Gem addGem(Gem obj){
		long id = this.counter++;
		obj.setId(id);
		this.gemList.add(obj);
		return obj;
	}
	
	public Gem getGemById(long id){
		for (Gem g : this.gemList){
			if (g.getId() == id){
				return g;
			}
		}
		return null;
	}
	
	public Gem[] getAllGems(){
		Gem result[] = new Gem[this.gemList.size()];
		for (int i=0; i < this.gemList.size(); ++i){
			result[i] = this.gemList.get(i);
		}
		return result;
	}
	
 
	
	public boolean deleteGem(long id){
		int target = -1;
		
		for (int i=0; i< this.gemList.size(); ++i){
			if (this.gemList.get(i).getId() == id){
				target = i;
				break;
			}
		}
		if (target == -1){
			return false;
		}
		else {
			this.gemList.remove(target);
			return true;
		}
	}
	
	public Gem updateGem(Gem obj){
		int target = -1;
		
		for (int i=0; i< this.gemList.size(); ++i){
			if (this.gemList.get(i).getId() == obj.getId()){
				target = i;
				break;
			}
		}
		if (target != -1){
			Gem gem = this.gemList.get(target);
			gem.setName(obj.getName());
			gem.setQuantity(obj.getQuantity());
			gem.setShine(obj.getShine());
			gem.setDescription(obj.getDescription());
			gem.setColor(obj.getColor());
			gem.setFaces(obj.getFaces());
			gem.setPrice(obj.getPrice());
			gem.setRarity(obj.getRarity());
			return gem;
		}
		return null; 
	}
	
	private static GemList singleton = new GemList();
	
	public static GemList getInstance(){
		return singleton;
	}
}