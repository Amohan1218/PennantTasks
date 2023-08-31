package com.folder.dao;

import java.util.List;

import com.folder.model.DoctorSchedule;

public interface DocSchedDAO {
	boolean createDoctorSchedule(List<DoctorSchedule> L);
}
