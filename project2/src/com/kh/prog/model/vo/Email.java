package com.kh.prog.model.vo;

import java.util.Objects;

class EmailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EmailException() {}
	public EmailException(String msg) {
		super(msg);
	}
}

public class Email {
	private String name;
	private String domain;
	
	public static final boolean isValid(String email) {
		if(!email.contains("@")) {
			return false;
		}
		int cnt = email.split("\\.").length;
		if(!(cnt >= 2 && cnt <= 3)) {
			return false;
		}
		return true;
	}
	
	public Email(String email) {
		this.setEmail(email);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDomain() {
		return this.domain;
	}
	
	public void setDomain(String domain) {
		int cnt = domain.split("\\.").length;
		if(!(cnt >= 2 && cnt <= 3)) {
			throw new EmailException("도메인 주소 형식이 올바르지 않습니다.");
		}
		this.domain = domain;
	}
	
	public String getEmail() {
		return String.format("%s@%s", this.name, this.domain);
	}
	
	public void setEmail(String email) {
		if(!email.contains("@")) {
			throw new EmailException("이메일 주소 형식이 올바르지 않습니다.");
		}
		this.name = email.substring(0, email.indexOf("@"));
		this.setDomain(email.substring(email.indexOf("@") + 1, email.length()));
	}

	@Override
	public int hashCode() {
		return Objects.hash(domain, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		return Objects.equals(domain, other.domain)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.getEmail();
	}
	
	public static void main(String[] args) {
		Email e = new Email("username@gmail.com");
		System.out.println("이메일 계정: " + e.getName());
		System.out.println("이메일 도메인: " + e.getDomain());
		System.out.println("이메일 주소: " + e.getEmail());
	}
	
}
