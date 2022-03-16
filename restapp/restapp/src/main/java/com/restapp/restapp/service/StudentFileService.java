package com.restapp.restapp.service;

import com.restapp.restapp.data.Student;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class StudentFileService {
    public void writeToFile( List<Student> students ) throws IOException {
        File f = new File("C:/Users/Antti/OneDrive/Asiakirjat/KouluK2022/java/restapp/students.txt");
        FileWriter  fw = new FileWriter(f,false); //oletuspolku on projektin juurikansio
        var list = new ArrayList<>(students);
        System.out.println(list);

        fw.write(String.valueOf(list)); //yms, logiikka miten kirjoitetaan tiedostoon
    }
    public List<Student> readStudentsFromFile() throws FileNotFoundException {
        Scanner sc = new Scanner( new File("students.txt") );
        List<Student> students = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.next();
            String[] fields = line.split(",");
            //students.add(new Student());
        }
        return students;
    }
}
