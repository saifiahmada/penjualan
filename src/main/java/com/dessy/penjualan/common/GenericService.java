package com.dessy.penjualan.common;

import java.util.Date;

public class GenericService {
	protected void updateCreationInfo(BaseAuditInt entity, String user) {
		Date currentTime = new Date();
		entity.setCreateBy(user);
		entity.setCreateDate(currentTime);
	}

	protected void updateLastModInfo(BaseAuditInt entity, String user) {
		Date currentTime = new Date();
		entity.setLastModBy(user);
		entity.setLastModDate(currentTime);
	}
}
