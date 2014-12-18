package com.ic.core.page;

/**
 * 功能：SqlServer2005~2008物理分页		--- 未测试
 * @author 郑斌	2014年7月31日 上午8:56:43
 * 修改说明：
 */
public class Mssql58Dialect extends Dialect
{
	  public String getLimitString(String sql, int offset, int limit)
	  {
	    sql = sql.trim();
	    String order = "";

	    StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

	    pagingSelect
	      .append("select * from (select row_number()over(order by tempcolumn)temprownumber,* ")
	      .append(" from (select top ").append(offset + limit - 1).append(" tempcolumn=0,* from ( ");

	    if (sql.toLowerCase().matches(".+order[^)]+$"))
	    {
	      order = sql.substring(sql.lastIndexOf("order"));
	      sql = sql.substring(0, sql.lastIndexOf("order"));
	    }

	    pagingSelect.append(sql);
	    pagingSelect.append(" ) d ").append(order).append(" ) t )tt where temprownumber>").append(offset - 1);

	    return pagingSelect.toString();
	  }
	}