package com.common.constants;

public class Constants {

	public static final String BEARER = "Bearer ";

	public static final int SUCCESS = 1;
	public static final long EXPIRES_IN = 432000000;

	public static final int YES = 1;
	public static final int NO = 0;

	public static final String YESSTR = "1";
	public static final String NOSTR = "0";

	public final static Integer STATUS_YES = 1;
	public final static Integer STATUS_NO = 0;

	public final static String REJECT = "REJECT";
	public final static String PASS = "PASS";

	public final static String USER_TYPE = "1";// C端用户

	public final static Integer TREE_ROOT = 0;
	public final static Integer SEQ_INIT = 0;
	
	public final static String CONF_DEAPRTMENT_CODE = "D100053"; //独立配置专属

	public enum DIC_CERTTYPE {
		C00("00", "身份证");
		private String cvalue;
		private String cname;

		private DIC_CERTTYPE(String cvalue, String cname) {
			this.cvalue = cvalue;
			this.cname = cname;
		}

		public String getCvalue() {
			return cvalue;
		}

		public void setCvalue(String cvalue) {
			this.cvalue = cvalue;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: SYSTEM_CODES
	 * </p>
	 * 
	 * <p>
	 * Description: 系统编码
	 * </p>
	 * 
	 * @author sine
	 * 
	 * @date 2018年4月2日
	 */
	public enum SYSTEM_CODES {
		S01("01", "系统"),
		S02("02", "客户系统"),
		S03("03", "审批系统"),
		S07("07", "库存融资系统");
		private String cvalue;
		private String cname;

		private SYSTEM_CODES(String cvalue, String cname) {
			this.cvalue = cvalue;
			this.cname = cname;
		}

		public String getCvalue() {
			return cvalue;
		}

		public void setCvalue(String cvalue) {
			this.cvalue = cvalue;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public static SYSTEM_CODES getCode(String code) {
			if (code != null) {
				for (SYSTEM_CODES entry : SYSTEM_CODES.values()) {
					if (entry.name().equals(code)) {
						return entry;
					}
				}
			}
			return null;
		}
	}

	/**
	 * 
	 * 
	 * <p>
	 * Title: CREATE_FROM_CODES
	 * </p>
	 * 
	 * <p>
	 * Description: 注册来源编码
	 * </p>
	 * 
	 * @author sine
	 * 
	 * @date 2018年4月2日
	 */
	public enum CREATE_FROM_CODES {
		C01("01", "客户注册"),
		C02("02", "员工后台注册");
		private String cvalue;
		private String cname;

		private CREATE_FROM_CODES(String cvalue, String cname) {
			this.cvalue = cvalue;
			this.cname = cname;
		}

		public String getCvalue() {
			return cvalue;
		}

		public void setCvalue(String cvalue) {
			this.cvalue = cvalue;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public static CREATE_FROM_CODES getCode(String code) {
			if (code != null) {
				for (CREATE_FROM_CODES entry : CREATE_FROM_CODES.values()) {
					if (entry.name().equals(code)) {
						return entry;
					}
				}
			}
			return null;
		}
	}

	public enum RESOURCE_TYPE {
		T0("0", "目录"),
		T1("1", "菜单"),
		T2("2", "按钮");
		private String cvalue;
		private String cname;

		private RESOURCE_TYPE(String cvalue, String cname) {
			this.cvalue = cvalue;
			this.cname = cname;
		}

		public String getCvalue() {
			return cvalue;
		}

		public void setCvalue(String cvalue) {
			this.cvalue = cvalue;
		}

		public String getCname() {
			return cname;
		}

		public void setCname(String cname) {
			this.cname = cname;
		}

		public static RESOURCE_TYPE getCode(String code) {
			if (code != null) {
				for (RESOURCE_TYPE entry : RESOURCE_TYPE.values()) {
					if (entry.name().equals(code)) {
						return entry;
					}
				}
			}
			return null;
		}
	}

}
