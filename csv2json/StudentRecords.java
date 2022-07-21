package com.sarvesh.business;

import java.io.IOException;
import java.util.List;

import com.sarvesh.models.Student;

public class StudentRecords {
	public List<Student> getStudentDetails() {
        DataServices dataServices = new DataServices();
        dataServices.readCSVData();
        return dataServices.getStudentList();
    }

    public boolean writeIntoJSONFile(List<Student> studentList, String path) throws IOException {
        DataServices dataServices = new DataServices();
        return dataServices.convertJavaObjectToJsonFile(studentList, path);
    }

}
