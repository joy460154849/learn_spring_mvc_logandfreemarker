package springmvcjdbc;

public class Region {
	
	private int id;
	private Double REGION_ID;
	private String REGION_CODE;
	private String REGION_NAME;
	private Double PARENT_ID;
	private Double REGION_LEVEL;
	private Double REGION_ORDER;
	private String REGION_NAME_EN;
	private String REGION_SHORTNAME_EN;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getREGION_ID() {
		return REGION_ID;
	}

	public void setREGION_ID(Double rEGION_ID) {
		REGION_ID = rEGION_ID;
	}

	public String getREGION_CODE() {
		return REGION_CODE;
	}

	public void setREGION_CODE(String rEGION_CODE) {
		REGION_CODE = rEGION_CODE;
	}

	public String getREGION_NAME() {
		return REGION_NAME;
	}

	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}

	public Double getPARENT_ID() {
		return PARENT_ID;
	}

	public void setPARENT_ID(Double pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}

	public Double getREGION_LEVEL() {
		return REGION_LEVEL;
	}

	public void setREGION_LEVEL(Double rEGION_LEVEL) {
		REGION_LEVEL = rEGION_LEVEL;
	}

	public Double getREGION_ORDER() {
		return REGION_ORDER;
	}

	public void setREGION_ORDER(Double rEGION_ORDER) {
		REGION_ORDER = rEGION_ORDER;
	}

	public String getREGION_NAME_EN() {
		return REGION_NAME_EN;
	}

	public void setREGION_NAME_EN(String rEGION_NAME_EN) {
		REGION_NAME_EN = rEGION_NAME_EN;
	}

	public String getREGION_SHORTNAME_EN() {
		return REGION_SHORTNAME_EN;
	}

	public void setREGION_SHORTNAME_EN(String rEGION_SHORTNAME_EN) {
		REGION_SHORTNAME_EN = rEGION_SHORTNAME_EN;
	}


	public Region() {
		super();
	}

	public Region(int id, Double rEGION_ID, String rEGION_CODE, String rEGION_NAME, Double pARENT_ID,
			Double rEGION_LEVEL, Double rEGION_ORDER, String rEGION_NAME_EN, String rEGION_SHORTNAME_EN) {
		super();
		this.id = id;
		REGION_ID = rEGION_ID;
		REGION_CODE = rEGION_CODE;
		REGION_NAME = rEGION_NAME;
		PARENT_ID = pARENT_ID;
		REGION_LEVEL = rEGION_LEVEL;
		REGION_ORDER = rEGION_ORDER;
		REGION_NAME_EN = rEGION_NAME_EN;
		REGION_SHORTNAME_EN = rEGION_SHORTNAME_EN;
	}

	public Region(Double rEGION_ID, String rEGION_CODE, String rEGION_NAME, Double pARENT_ID, Double rEGION_LEVEL,
			Double rEGION_ORDER, String rEGION_NAME_EN, String rEGION_SHORTNAME_EN) {
		REGION_ID = rEGION_ID;
		REGION_CODE = rEGION_CODE;
		REGION_NAME = rEGION_NAME;
		PARENT_ID = pARENT_ID;
		REGION_LEVEL = rEGION_LEVEL;
		REGION_ORDER = rEGION_ORDER;
		REGION_NAME_EN = rEGION_NAME_EN;
		REGION_SHORTNAME_EN = rEGION_SHORTNAME_EN;
	}
	
	
}
