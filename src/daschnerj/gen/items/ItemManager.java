package daschnerj.gen.items;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import daschnerj.gen.Handler;

public class ItemManager {

	private Handler handler;
	private ArrayList<Item> items;

	public ItemManager(Handler handler) {
		this.handler = handler;
		items = new ArrayList<Item>();
	}

	public void tick() {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item i = it.next();
			i.tick();
			if (i.isPickedUp())
				it.remove();
		}
	}

	public void render(Graphics g) {
		for (Item i : items)
			i.render(g);
	}

	public void addIem(Item i) {
		i.setHandler(handler);
		items.add(i);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

}
