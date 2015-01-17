package com.dessy.penjualan.common;

import java.util.Date;

public interface BaseAuditInt {

	public abstract String getCreateBy();

	public abstract void setCreateBy(String paramString);

	public abstract Date getCreateDate();

	public abstract void setCreateDate(Date paramDate);

	public abstract String getLastModBy();

	public abstract void setLastModBy(String paramString);

	public abstract Date getLastModDate();

	public abstract void setLastModDate(Date paramDate);

}
