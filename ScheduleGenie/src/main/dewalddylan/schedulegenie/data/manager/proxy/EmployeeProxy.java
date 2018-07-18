package main.dewalddylan.schedulegenie.data.manager.proxy;


import main.dewalddylan.schedulegenie.data.manager.PanelManager;

public class EmployeeProxy extends Proxy{

	public EmployeeProxy(PanelManager panelManager) {
		super(panelManager);
	}

	@Override
	public void update() {
		panelManager.updateInfoPanel();
	}
	

}
