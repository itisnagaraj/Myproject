package com.sarvesh.csvjson;

import java.io.IOException;
import java.util.Scanner;

import com.sarvesh.business.StudentRecords;
import com.sarvesh.business.TeacherRecords;

public class Main {
	public static void main(String[] args) throws IOException {
        StudentRecords studentRecords = new StudentRecords();
        TeacherRecords teacherRecords = new TeacherRecords();

        System.out.println("Please enter the path to save json files: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        if (studentRecords.writeIntoJSONFile(studentRecords.getStudentDetails(), path) &&
                teacherRecords.writeIntoJSONFile(teacherRecords.getTeacherDetails(), path)) {
            System.out.println("2 JSON files are successfully created");
        }
        else {
            System.out.println("There is an error while creating JSON files!!");
        }
    }

}
