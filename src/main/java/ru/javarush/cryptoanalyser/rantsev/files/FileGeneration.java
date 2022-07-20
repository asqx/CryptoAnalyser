package ru.javarush.cryptoanalyser.rantsev.files;


public class FileGeneration {
    private final String[] args;
    private String[] files;
    private int mode;
    public FileGeneration(String[] args) {
        this.args = args;
    }
    public FileGeneration(String[] files, String[] args, int mode) {
        this.args = args;
        this.files = files;
        this.mode = mode;
    }

    public void getInputFile() {
        //Working with incoming files
        CreatingFile creatingFile = new CreatingFile(args[1]);
        args[1] = creatingFile.createTxt();
    }

    public void getOutputFiles () {
            //Working with output files
            CreatingFile creatingFile = new CreatingFile( args[2], files, mode);
            args[2] = creatingFile.createStandardFile();
        }
    }