package com.folder.model;

public class DoctorSchedule {
	int doct_id;
	String dcsc_schedule;
	String dcsc_avl_from;
	String dcsc_avl_to;
	
	public DoctorSchedule() {}
	
	public DoctorSchedule(int doct_id, String dcsc_schedule, String dcsc_avl_from, String dcsc_avl_to) {
		super();
		this.doct_id = doct_id;
		this.dcsc_schedule = dcsc_schedule;
		this.dcsc_avl_from = dcsc_avl_from;
		this.dcsc_avl_to = dcsc_avl_to;
	}

	public int getDoct_id() {
		return doct_id;
	}

	public void setDoct_id(int doct_id) {
		this.doct_id = doct_id;
	}

	public String getDcsc_schedule() {
		return dcsc_schedule;
	}

	public void setDcsc_schedule(String dcsc_schedule) {
		this.dcsc_schedule = dcsc_schedule;
	}

	public String getDcsc_avl_from() {
		return dcsc_avl_from;
	}

	public void setDcsc_avl_from(String dcsc_avl_from) {
		this.dcsc_avl_from = dcsc_avl_from;
	}

	public String getDcsc_avl_to() {
		return dcsc_avl_to;
	}

	public void setDcsc_avl_to(String dcsc_avl_to) {
		this.dcsc_avl_to = dcsc_avl_to;
	}
}
