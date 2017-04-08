package fsocg;

public class FSocgDB {
	/**
	 * 基因
	 */
	private String gene;
	/**
	 * COSMIC
	 */
	private String cosm;
	/**
	 * 氨基酸变化
	 */
	private String aaMutSyntax;
	/**
	 * 碱基变化
	 */
	private String cdsMutSyntax;
	/**
	 * Amplicon_id
	 */
	private String ampliconId;
	/**
	 * Insert
	 */
	private String insert;

	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public String getCosm() {
		return cosm;
	}

	public void setCosm(String cosm) {
		this.cosm = cosm;
	}

	public String getAaMutSyntax() {
		return aaMutSyntax;
	}

	public void setAaMutSyntax(String aaMutSyntax) {
		this.aaMutSyntax = aaMutSyntax;
	}

	public String getCdsMutSyntax() {
		return cdsMutSyntax;
	}

	public void setCdsMutSyntax(String cdsMutSyntax) {
		this.cdsMutSyntax = cdsMutSyntax;
	}

	public String getAmpliconId() {
		return ampliconId;
	}

	public void setAmpliconId(String ampliconId) {
		this.ampliconId = ampliconId;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

}
