package main.dewalddylan.schedulegenie.data.manager.proxy;

import main.dewalddylan.schedulegenie.data.manager.PanelManager;

public abstract class Proxy {
	protected PanelManager panelManager;
	public Proxy(PanelManager panelManager) {
		this.panelManager = panelManager;
	}
	
	public abstract void update();
	
}
