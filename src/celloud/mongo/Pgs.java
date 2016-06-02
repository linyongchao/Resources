/**  */
package celloud.mongo;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author <a href="mailto:liuqingxiao@celloud.cn">liuqx</a>
 * @date 2015-8-18下午2:46:03
 * @version Revision: 1.0
 */
public class Pgs extends Base {
	private static final long serialVersionUID = 1L;
	/** 文件编号 */
	private Integer fileId;
	/** 数据编号 */
	private String dataKey;
	/** 文件名字 */
	private String fileName;
	/** 大小 单位：b */
	private Long size;
	/** 文件别名 */
	private String anotherName;
	/** 提交时间 */
	private Date uploadDate;
	/** 报告创建时间 */
	private Date createDate;
	private String sd;
	private String mapRatio;
	private String mtRatio;
	private String noEnoughReads;
	private String totalReads;
	private String gcChromosomeDensityPng;
	private String duplicate;
	private String gcCountsNormalizedPng;
	private String gcCount;
	private String gcCountsRawPng;
	private String splitPng;
	private String testPng;
	private String miniPng;
	private String finalPng;
	private String note;
	private List<List<String>> detail;
	private String report;
	private String pdf;
	private String mapReads;
	private String winSize;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getDataKey() {
		return dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getAnotherName() {
		return anotherName;
	}

	public void setAnotherName(String anotherName) {
		this.anotherName = anotherName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getSd() {
		return sd;
	}

	public void setSd(String sd) {
		this.sd = sd;
	}

	public String getMapRatio() {
		return mapRatio;
	}

	public void setMapRatio(String mapRatio) {
		this.mapRatio = mapRatio;
	}

	public String getMtRatio() {
		return mtRatio;
	}

	public void setMtRatio(String mtRatio) {
		this.mtRatio = mtRatio;
	}

	public String getNoEnoughReads() {
		return noEnoughReads;
	}

	public void setNoEnoughReads(String noEnoughReads) {
		this.noEnoughReads = noEnoughReads;
	}

	public String getTotalReads() {
		return totalReads;
	}

	public void setTotalReads(String totalReads) {
		this.totalReads = totalReads;
	}

	public String getGcChromosomeDensityPng() {
		return gcChromosomeDensityPng;
	}

	public void setGcChromosomeDensityPng(String gcChromosomeDensityPng) {
		this.gcChromosomeDensityPng = gcChromosomeDensityPng;
	}

	public String getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(String duplicate) {
		this.duplicate = duplicate;
	}

	public String getGcCountsNormalizedPng() {
		return gcCountsNormalizedPng;
	}

	public void setGcCountsNormalizedPng(String gcCountsNormalizedPng) {
		this.gcCountsNormalizedPng = gcCountsNormalizedPng;
	}

	public String getGcCount() {
		return gcCount;
	}

	public void setGcCount(String gcCount) {
		this.gcCount = gcCount;
	}

	public String getGcCountsRawPng() {
		return gcCountsRawPng;
	}

	public void setGcCountsRawPng(String gcCountsRawPng) {
		this.gcCountsRawPng = gcCountsRawPng;
	}

	public String getSplitPng() {
		return splitPng;
	}

	public void setSplitPng(String splitPng) {
		this.splitPng = splitPng;
	}

	public String getTestPng() {
		return testPng;
	}

	public void setTestPng(String testPng) {
		this.testPng = testPng;
	}

	public String getMiniPng() {
		return miniPng;
	}

	public void setMiniPng(String miniPng) {
		this.miniPng = miniPng;
	}

	public String getFinalPng() {
		return finalPng;
	}

	public void setFinalPng(String finalPng) {
		this.finalPng = finalPng;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public List<List<String>> getDetail() {
		return detail;
	}

	public void setDetail(List<List<String>> detail) {
		this.detail = detail;
	}

	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getMapReads() {
		return mapReads;
	}

	public void setMapReads(String mapReads) {
		this.mapReads = mapReads;
	}

	public String getWinSize() {
		return winSize;
	}

	public void setWinSize(String winSize) {
		this.winSize = winSize;
	}

}
