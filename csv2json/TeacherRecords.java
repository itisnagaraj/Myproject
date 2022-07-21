package com.sarvesh.business;

import java.io.IOException;
import java.util.List;

import com.sarvesh.models.Teacher;

public class TeacherRecords {
	public List<Teacher> getTeacherDetails(){
        DataServices dataServices = new DataServices();
        dataServices.readCSVData();
        return dataServices.getTeacherList();
    }

    public boolean writeIntoJSONFile(List<Teacher> studentList, String path) throws IOException {
        DataServices dataServices = new DataServices();
        return dataServices.convertJavaObjectToJsonFile(studentList, path);
    }

}
