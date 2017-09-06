package com.niu.yumao.config;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

import java.sql.Types;

public class DialectForInkfish extends MySQL5Dialect {
	public DialectForInkfish() {
		super();
		registerHibernateType(Types.LONGVARCHAR, Hibernate.TEXT.getName());
		registerFunction("convert", new SQLFunctionTemplate(Hibernate.STRING, "convert(?1 using utf8)"));
	}

	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
