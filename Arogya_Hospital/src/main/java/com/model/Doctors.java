package com.model;

public class Doctors {
	int docId;
	String docName, qual, spec;
	int exp, wrkhrs;
	String img;

	public Doctors(int docId, String docName, String qual, String spec, int exp, int wrkhrs, String img) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.qual = qual;
		this.spec = spec;
		this.exp = exp;
		this.wrkhrs = wrkhrs;
		this.img = img;
	}

	public Doctors() {
		super();
	}

	@Override
	public String toString() {
		return "Doctors [docId=" + docId + ", docName=" + docName + ", qual=" + qual + ", spec=" + spec + ", exp=" + exp
				+ ", wrkhrs=" + wrkhrs + ", img=" + img + "]";
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getWrkhrs() {
		return wrkhrs;
	}

	public void setWrkhrs(int wrkhrs) {
		this.wrkhrs = wrkhrs;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
