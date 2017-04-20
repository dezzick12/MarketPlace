//LAST UPDATED: 4/14/2017 2:17p.m.

/**
 * @author David Hume, Yonghoon Park, Derek Frasur
 *
 * This class will combine add seller's inventories with items of category "toy" to a toy inventory to
 * be used by the marketplace. 
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ToyInventory extends Inventory {

	private ArrayList<Item> toyInventory = new ArrayList<Item>(); //the ArrayList to contain all inventory items of category "toy"
	private File toyInventoryFile;
	
	public ToyInventory(String fileName) throws ClassNotFoundException, IOException {
		super(fileName);
	}
	
	//This method will add the items from the sellers inventories of category toy that haven't already been added
	//to the total inventory arraylist.
	public void addItem(Item addItem){
		toyInventory.add(addItem);
	}
	
	//This method will delete an item from the toy inventory when a toy item is sold
	public void deleteItem(Item deleteItem){
		toyInventory.remove(deleteItem);
	}
		
	//method to return the toyInventory
	public ArrayList<Item> getTotalInventory(){
		return toyInventory;
	}
	
	//This method will needed to be done at the end of each run of the program,
	//sets the current arraylist to the file
	public void updateFile(){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try{
			fout = new FileOutputStream("FILE NAME/LOCATION");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(toyInventory);
			System.out.println("Completed");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(fout != null){
				try{
					fout.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			if(oos != null){
				try{
					oos.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}	
}
