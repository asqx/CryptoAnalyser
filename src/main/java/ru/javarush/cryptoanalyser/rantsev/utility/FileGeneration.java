package ru.javarush.cryptoanalyser.rantsev.utility;

import java.util.Scanner;

public class FileGeneration {
    public void getInputFile(String[] args) {
        CreatingFile creatingFile = new CreatingFile();
        CreatingPath creatingPath = new CreatingPath();
        Scanner console = new Scanner(System.in);
        if (!creatingFile.createTxt(console, args)) {
            creatingPath.checkPathTxt(args);
        }
    }

    public void getOutputFiles (String[]files, String[]args, int mode){
            CreatingFile creatingFile = new CreatingFile();
            CreatingPath creatingPath = new CreatingPath();
            Scanner console = new Scanner(System.in);
            if (!creatingFile.createStandardFile(console, args, files, mode)) {
                creatingPath.checkPathStandard(args);
            }
        }
    }