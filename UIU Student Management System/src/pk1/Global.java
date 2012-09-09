package pk1;

import java.io.Serializable;

public class Global implements Serializable {
	public int year = 0;
	public String semester;
	public String des;
	public int cin;
	public int msin;
	public int bbin;
	public int eein;
	public int cindex;
	public int loggedin;

	public Global() {

	}

	public Global(String sem, int y, int csin, int mscsin, int bbain,
			int eeein, int cindex, String des, int loggedin) {
		year = y;
		semester = sem;
		this.cin = csin;
		this.msin = mscsin;
		this.eein = eeein;
		this.bbin = bbain;
		this.cindex = cindex;
		this.des = des;
		this.loggedin = loggedin;
	}

}
