package com.ic.core.page;

/**
 * 功能：Mysql物理分页		--- 未测试
 * @author 郑斌	2014年7月31日 上午8:51:51
 * 修改说明：
 */
public class MySql5Dialect extends Dialect{
	
	protected static final String SQL_END_DELIMITER = ";";
	
	public String getLimitString(String sql, boolean hasOffset) {
		return MySql5PageHepler.getLimitString(sql,-1,-1);
	}

	public String getLimitString(String sql, int offset, int limit) {
		return MySql5PageHepler.getLimitString(sql, offset, limit);
	}

	public boolean supportsLimit() {
		return true;
	}
	
	//使用者一个方法就可以
//	public String getLimitString(String sql, int offset, int limit)
//	  {
//	    sql = sql.trim();
//	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
//
//	    pagingSelect.append(sql);
//
//	    pagingSelect.append(" limit ").append(offset - 1).append(" , ").append(limit);
//
//	    return pagingSelect.toString();
//	  }
}
