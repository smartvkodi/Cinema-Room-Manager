package my.hyperskill.menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractOption {

    String name;
    Map<Integer, AbstractOption> options = new LinkedHashMap<>();
    OptionAbstractStrategy optionAbstractStrategy;

    public AbstractOption(String name) {
        this.name = name;
    }

    public String getOptionName() {
        return this.name;
    }

    public void put(int key, AbstractOption option) {
        options.putIfAbsent(key, option);
    }

    public void add(AbstractOption option) {
        options.putIfAbsent(options.size() + 1, option);
    }

    private void printOptions(boolean showOptionName, boolean showOptionIndex) {

        System.out.println();
        if (showOptionName) {
            System.out.println(name);
        }

        for (Map.Entry<Integer, AbstractOption> optionEntry : this.options.entrySet()) {
            if (showOptionIndex) {
                System.out.printf("%d) %s\n", optionEntry.getKey(), optionEntry.getValue().name);
            } else {
                System.out.printf("%s\n", optionEntry.getValue().name);
            }

        }
    }

    private AbstractOption chooseOption(Scanner scanner) {

        AbstractOption optionResult = null;

        try {
            int key = Integer.parseInt(scanner.nextLine());
            if (options.containsKey(key))
                optionResult = options.get(key);
        } catch (NumberFormatException e) {
            // don't worry
        }

        if (optionResult != null && optionResult.optionAbstractStrategy != null) {
            optionResult.optionAbstractStrategy.computeStrategy(optionResult);
        }

        return optionResult;
    }

    public AbstractOption chooseAndCompute(Scanner scanner, boolean showOptionName, boolean showOptionIndex) {
        AbstractOption optionResult;
        do {
            printOptions(showOptionName, showOptionIndex);
            optionResult = this.chooseOption(scanner);
        } while (optionResult == null);

        return optionResult;
    }

    public Map<Integer, AbstractOption> getOptions() {
        return options;
    }

}

