package ru.javarush.cryptoanalyser.rantsev.picocli;

import picocli.CommandLine;

import static ru.javarush.cryptoanalyser.rantsev.picocli.Messages.*;
@CommandLine.Command (name = APP_NAME, description = WELCOME,
                mixinStandardHelpOptions = true)
public class Picocli implements Runnable {
    private final PicocliApp application;
    public Picocli(PicocliApp application) {
        this.application = application;
    }
    @CommandLine.Spec
    CommandLine.Model.CommandSpec commandSpec;
    @CommandLine.Option(names = {"-e", "--" + ENCODE}, description = COMMAND_HELP + "\s" + ENCODE + ".")
    String en = ENCODE;

    @CommandLine.Option(names = {"-d", "--" + DECODE}, description = COMMAND_HELP + "\s" + DECODE + ".")
    String de = DECODE;
    @CommandLine.Option(names = {"-b", "--" + BRUTEFORCE}, description = COMMAND_HELP + "\s" + BRUTEFORCE + ".")
    String bf = BRUTEFORCE;

    @CommandLine.Option(names = {"-a", "--" + ANALYSE}, description = COMMAND_HELP + "\s" + ANALYSE + ".")
    String an = ANALYSE;
    @CommandLine.Command(name = ENCODE, description = ENCODE_HELP)
    void encode(
            @CommandLine.Parameters(paramLabel = SOURCE_FILE, description = FILE_HELP) String source,
            @CommandLine.Parameters(paramLabel = DESTINATION_FILE, description = FILE_HELP) String destination,
            @CommandLine.Parameters(paramLabel = KEY, description = KEY_HELP) String key) {
        String[] args = {ENCODE, source, destination, key};
        application.run(args);
        System.out.println(ANSI_GREEN + PERFORMED + "\s" + ENCODE);
    }
    @CommandLine.Command(name = DECODE, description = DECODE_HELP)
    void decode(
            @CommandLine.Parameters(paramLabel = SOURCE_FILE, description = FILE_HELP) String source,
            @CommandLine.Parameters(paramLabel = DESTINATION_FILE, description = FILE_HELP) String destination,
            @CommandLine.Parameters(paramLabel = KEY, description = KEY_HELP) String key) {
        String[] args = {DECODE, source, destination, key};
        application.run(args);
        System.out.println(ANSI_GREEN + PERFORMED + "\s" + DECODE);
    }
    @CommandLine.Command(name = BRUTEFORCE, description = BRUTEFORCE_HELP)
    void bruteforce(
            @CommandLine.Parameters(paramLabel = SOURCE_FILE, description = FILE_HELP) String source,
            @CommandLine.Parameters(paramLabel = DESTINATION_FILE, description = FILE_HELP) String destination) {
        String[] args = {BRUTEFORCE, source, destination};
        application.run(args);
        System.out.println(ANSI_GREEN + PERFORMED + "\s" + BRUTEFORCE);
    }

    @CommandLine.Command(name = ANALYSE, description = ANALYSE_HELP)
    void analyse(
            @CommandLine.Parameters(paramLabel = SOURCE_FILE, description = FILE_HELP) String source,
            @CommandLine.Parameters(paramLabel = DESTINATION_FILE, description = FILE_HELP) String destination) {
        String[] args = {ANALYSE, source, destination};
        application.run(args);
        System.out.println(ANSI_GREEN + PERFORMED + "\s" + ANALYSE);
    }
    @Override
    public void run() {
        throw new CommandLine.ParameterException(commandSpec.commandLine(), ENTER);
    }
}
