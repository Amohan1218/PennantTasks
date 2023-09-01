package com.folder.model;

public class DoctorList {
	int doctorId;
	String fullName;
	int specializationId;
	String qualification;
	int experience;
	String designation;
	String imageUrl;
	
	public DoctorList() {}
	
	public DoctorList(int doctorId, String fullName, int specializationId, String qualification, int experience,
			String designation, String imageUrl) {
		super();
		this.doctorId = doctorId;
		this.fullName = fullName;
		this.specializationId = specializationId;
		this.qualification = qualification;
		this.experience = experience;
		this.designation = designation;
		this.imageUrl = imageUrl;
	}
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "DoctorList [doctorId=" + doctorId + ", fullName=" + fullName + ", specializationId=" + specializationId
				+ ", qualification=" + qualification + ", experience=" + experience + ", designation=" + designation
				+ ", imageUrl=" + imageUrl + "]";
	}
}
