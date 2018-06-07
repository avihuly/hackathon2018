package com.johnbryce.talent.hackathon.config;

import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.stereotype.Service;

@Service
public class HibernateDialect extends MySQL57Dialect {

	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
	}
}
