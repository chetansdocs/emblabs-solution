package com.emblabs.assignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MouseCheeseProblem {
    private static final Logger logger = LogManager.getLogger(MouseCheeseProblem.class);

    public static void main(String[] args) {
        MouseCheeseProblem mouseCheeseProblem = new MouseCheeseProblem();
        int[][] userInput = mouseCheeseProblem.getInputRecords();
        for(int counter = 0; counter < userInput.length; counter++) {
            int maxSum = getMaximumCheese(userInput[counter]);
            logger.info("Maximum cheese for record {} is {}", counter + 1, maxSum);
        }
    }

    public static int getMaximumCheese(int[] inputArrayElements) {
        int arrayLength = inputArrayElements.length;
        if (arrayLength == 1) {
            return inputArrayElements[0];
        }
        int[] temporaryArray = new int[arrayLength];
        temporaryArray[0] = inputArrayElements[0];
        temporaryArray[1] = Integer.max(inputArrayElements[0], inputArrayElements[1]);

        for (int i = 2; i < arrayLength; i++) {
            temporaryArray[i] = Integer.max(temporaryArray[i - 1], temporaryArray[i - 2] + inputArrayElements[i]);
            temporaryArray[i] = Integer.max(temporaryArray[i], inputArrayElements[i]);
        }
        return temporaryArray[arrayLength - 1];
    }

    public int[][] getInputRecords() {
        Scanner inputScanner = new Scanner(System.in);
        logger.info("Enter number of test cases:");
        int numberOfTestCases = inputScanner.nextInt();

        int[][] inputArrays = new int[numberOfTestCases][];
        for(int i = 0; i < numberOfTestCases; i++) {
            inputArrays[i] = getArray(i + 1);
        }

        return inputArrays;
    }

    public int[] getArray(int arrayCounter) {
        Scanner inputScanner = new Scanner(System.in);
        logger.info("Enter elements count for record number {}", arrayCounter);
        int elementCount = inputScanner.nextInt();
        logger.info("Enter array elements {} for record {}", elementCount, arrayCounter);
        String inputElements = inputScanner.nextLine();
        inputElements = inputScanner.nextLine();
        int[] currentArray = new int[elementCount];
        while(!getArrayElements(currentArray, inputElements, elementCount)) {
            inputElements = inputScanner.nextLine();
        }
        return currentArray;
    }

    public boolean getArrayElements(int[]currentArray, String inputElements, int elementCount) {
        String[] numberAsString = inputElements.replace("\\s", " ").split(" ");
        if(numberAsString.length != elementCount) {
            logger.error("Number of elements mentioned does not match with the input count");
            return false;
        }

        for (int i = 0; i < numberAsString.length; i++) {
            currentArray[i] = Integer.parseInt(numberAsString[i]);
            if(currentArray[i] < 1 || currentArray[i] > 10000) {
                logger.error("Enter positive numbers less than equal to 10000");
                return false;
            }
        }
        return true;
    }
}
