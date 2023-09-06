package com.model;

public class PatientId {
	int patientId;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public PatientId(int patientId) {
		super();
		this.patientId = patientId;
	}

	public PatientId() {
		super();
	}

	@Override
	public String toString() {
		return "PatientId [patientId=" + patientId + "]";
	}
	
}
