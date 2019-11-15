package control;

import model.MPersonalInfo;
import valueObject.VCPersonalInfo;
import valueObject.VMPersonalInfo;

public class CPersonalInfo {
	private MPersonalInfo mPersonalInfo;

	public CPersonalInfo() {

		this.mPersonalInfo = new MPersonalInfo();

	}

	public VCPersonalInfo getPersonalInfo(String ID) {
		VMPersonalInfo vMPersonalInfo = this.mPersonalInfo.getPersonalInfo(ID);
		VCPersonalInfo vCPersonalInfo = new VCPersonalInfo();
		vCPersonalInfo.setID(vMPersonalInfo.getID());
		vCPersonalInfo.setName(vMPersonalInfo.getName());
		return vCPersonalInfo;
	}
}
