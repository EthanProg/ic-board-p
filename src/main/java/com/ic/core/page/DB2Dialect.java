package com.ic.core.page;

/**
 * 功能：DB2物理分页
 * @author 郑斌	2014年7月31日 上午8:51:20
 * 修改说明：
 */
public class DB2Dialect extends Dialect {
	
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect
				.append("SELECT * FROM (SELECT PAGE_B.*, ROWNUMBER() OVER() AS RN FROM ( ");

		pagingSelect.append(sql);

		pagingSelect.append(" ) AS PAGE_B )AS PAGE_A WHERE PAGE_A.RN BETWEEN ")
				.append(offset).append(" AND ").append(offset + limit - 1);

		return pagingSelect.toString();
	}
}