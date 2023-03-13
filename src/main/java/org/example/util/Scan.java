package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class Scan {
    public Scanner stringScan(){
        return new Scanner(System.in);
    }
    public Scanner intScan(){
        return new Scanner(System.in);
    }
}
