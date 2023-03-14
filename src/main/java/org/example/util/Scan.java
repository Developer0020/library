package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Component
public class Scan {
    public Scanner stringScan(){
        return new Scanner(System.in);
    }
    public Scanner intScan(){
        return new Scanner(System.in);
    }
}
