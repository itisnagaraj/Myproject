package com.sarvesh.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.sarvesh.models.Student;
import com.sarvesh.models.Teacher;

public class DataServices {
	List<Student> studentList = new ArrayList<>();
    List<Teacher> teacherList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void readCSVData() {
        CSVParser csvParser = null;
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("master-data.csv");

        try {
            assert inputStream != null;
            try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                     BufferedReader fileReader = new BufferedReader(streamReader)) {

                csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

                for (CSVRecord csvRecord: csvParser) {

                    if(validateDate(csvRecord.get("dob")) && csvRecord.size() == 22) {
                        if (csvRecord.get("category").equals("student")) {
                            if (Integer.parseInt(csvRecord.get("total_marks")) > 0 && Integer.parseInt(csvRecord.get("total_marks")) <= 1000) {
                                Student student = new Student(
                                        Integer.parseInt(csvRecord.get("id")),
                                        generateFullName(csvRecord.get("firstname"), csvRecord.get("lastname")),
                                        genderFunction(csvRecord.get("gender")),
                                        csvRecord.get("dob"),
                                        calculateAgeAndServicePeriod(csvRecord.get("dob")),
                                        csvRecord.get("aadhar_number"),
                                        generateCityAndStream(csvRecord.get("city")),
                                        csvRecord.get("contact_number"),
                                        Integer.parseInt(csvRecord.get("roll_no")),
                                        csvRecord.get("class"),
                                        Integer.parseInt(csvRecord.get("total_marks")),
                                        calculateGrade(Integer.parseInt(csvRecord.get("sec_percent"))),
                                        Integer.parseInt(csvRecord.get("sec_percent")),
                                        generateCityAndStream(csvRecord.get("hs_stream"))
                                );
                                studentList.add(student);
                            }
                            else {
                                throw new Exception("Total marks should be in range of 0 to 1000");
                            }
                        } else if (csvRecord.get("category").equals("teacher")) {
                            Teacher teacher = new Teacher(
                                    Integer.parseInt(csvRecord.get("id")),
                                    generateFullName(csvRecord.get("firstname"), csvRecord.get("lastname")),
                                    genderFunction(csvRecord.get("gender")),
                                    csvRecord.get("dob"),
                                    calculateAgeAndServicePeriod(csvRecord.get("dob")),
                                    csvRecord.get("aadhar_number"),
                                    generateCityAndStream(csvRecord.get("city")),
                                    csvRecord.get("contact_number"),
                                    csvRecord.get("emp_no"),
                                    csvRecord.get("class_teacher_of"),
                                    csvRecord.get("previous_school"),
                                    csvRecord.get("post"),
                                    csvRecord.get("doj"),
                                    Integer.parseInt(csvRecord.get("salary")),
                                    calculateAgeAndServicePeriod(csvRecord.get("doj")),
                                    parseSubjects(csvRecord.get("subject_teaches"))
                            );
                            teacherList.add(teacher);
                        }
                    }
                    else {
                        throw new Exception("Please check the format of DOB and Number of columns");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Reading CSV Error!");
            e.printStackTrace();
        } finally {
            try {
                assert csvParser != null;
                csvParser.close();
            } catch (IOException e) {
                System.out.println("Closing fileReader/csvParser Error!");
                e.printStackTrace();
            }
        }

    }

    public boolean convertJavaObjectToJsonFile(List<?> allData, String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Files.createDirectories(Paths.get(path));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDateTime now = LocalDateTime.now();

        if(allData.get(0) instanceof Student) {
            String fileName1 = "student_record_" + dtf.format(now) + ".json";
            JSONObject obj1 = new JSONObject();
            obj1.put("studentRecordCount", allData.size());
            obj1.put("data", allData);
            writer.writeValue(new File( path + "\\" + fileName1), obj1);
            return true;
        }
        else if(allData.get(0) instanceof Teacher) {
            String fileName2 = "teacher_record_" + dtf.format(now) + ".json";
            JSONObject obj2 = new JSONObject();
            obj2.put("studentRecordCount", allData.size());
            obj2.put("data", allData);
            writer.writeValue(new File( path + "\\" + fileName2), obj2);
            return true;
        } else
        {
            return false;
        }
    }

//      Generates full name from first name and last name for both student and teacher
    static String generateFullName(String firstName, String lastName){
        return firstName + " " + lastName;
    }
//      Maps 'f' to "Female" and 'm' to "Male
    static String genderFunction(String gender){
        return gender.equals("f") ? "Female" : (gender.equals("m") ? "Male" : "Others");
    }

//      Calculates age from date of birth (dob) and service period
    static String calculateAgeAndServicePeriod(String dat) throws ParseException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d = sdf.parse(dat);
        c.setTime(d);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);
        return diff1.getYears() + " Years " + diff1.getMonths() + " Months";
    }

//      Calculates grade from secured percentage for student
    static String calculateGrade(Integer percentage){
        if(percentage >= 90)
        {
            return "A+";
        }
        else if(percentage >= 80)
        {
            return "A";
        }
        else if(percentage >= 70)
        {
            return "B+";
        }
        else if(percentage >= 60)
        {
            return "B";
        }
        else if(percentage >= 50)
        {
            return "B";
        }
        else
        {
            return "D";
        }
    }

    //      Generates City and Stream with capitalized first letter
    static String generateCityAndStream(String str){ return str.substring(0, 1).toUpperCase() + str.substring(1);}

    //      Validates date format in csv file
    static boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        }
        else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            try {
                Date javaDate = sdfrmt.parse(strDate);
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

//      Parses the subjects_teaches for teacher
    static List<String> parseSubjects(String subjects){
        String[] arrOfSubjects = subjects.split("-");
        return Arrays.asList(arrOfSubjects);
    }

}
