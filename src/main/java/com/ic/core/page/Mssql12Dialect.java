package com.ic.core.page;

/**
 * 功能：SqlServer2012物理分页
 * @author 郑斌	2014年7月31日 上午8:55:16
 * 修改说明：
 */
public class Mssql12Dialect extends Dialect
{
	  public String getLimitString(String sql, int offset, int limit)
	  {
	    sql = sql.trim();

	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

	    pagingSelect.append(sql);
	    pagingSelect.append(" OFFSET ").append(offset).append(" ROW FETCH NEXT ").append(limit).append(" ROWS ONLY ");

	    return pagingSelect.toString();
	  }
	}