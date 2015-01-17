package com.dessy.penjualan.common;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseAudit implements BaseAuditInt, Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "VCREABY")
	private String createBy;

	@Column(name = "VMODIBY")
	private String lastModBy;

	@Column(name = "DCREA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "DMODI")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDate;

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastModBy() {
		return this.lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Date getLastModDate() {
		return this.lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}
}
