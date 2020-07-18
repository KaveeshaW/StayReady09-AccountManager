package com.codedifferently.bankaccountlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class MainApplication {
    //the string key corresponds to which type of account (Business, Checking, Savings) and then the arraylist holds all of the different bank accounts of that type
    static HashMap<String, ArrayList<BankAccount>> accounts = new HashMap<>();
    public static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeAccountsMap();
        atmInteraction();
    }

    private static void initializeAccountsMap() {
        accounts.put("business", new ArrayList<BankAccount>());
        accounts.put("checking", new ArrayList<BankAccount>());
        accounts.put("savings", new ArrayList<BankAccount>());
     }

    private static void atmInteraction() {
        int decision = 0;
        int stopInteraction = 4;
        while(decision != stopInteraction) {
            LOGGER.info("What do you want to do? Enter a number between 1 - 4, corresponding to:\n" +
                            "1) create an account\n" +
                            "2) view an account\n" +
                            "3) delete an account\n" +
                            "4) quit");
            decision = scanner.nextInt();
            performAction(decision);
        }
    }

    private static void performAction(int decision) {
        switch(decision) {
            case 1:
                createAccount();
                break;
            case 2:
                viewAccount();
                break;
            case 3:
                deleteAccount();
                break;
            case 4:
                LOGGER.info("Thank you for using the ATM! Please come again another time.");
                break;
            default:
                LOGGER.warning("Invalid input. Please try again.");
                break;
        }
    }

    private static void createAccount() {
        String whichAccountType = askToViewCreateOrDeleteAnAccountType("create");
        addToListOfBankAccounts(whichAccountType);
    }

    private static String askToViewCreateOrDeleteAnAccountType(String createViewOrDelete) {
        LOGGER.info("What type of account do you want to " + createViewOrDelete + "?\nYou could type in:\n" +
                "business\n" +
                "checking\n" +
                "savings\n");
        String whichAccountType = scanner.next().trim();
        return whichAccountType;
    }

    private static void addToListOfBankAccounts(String whichAccount) {
        boolean successfullyCreatedAccount = false;
        String whichTypeOfAccount = "";
        switch(whichAccount) {
            case "business":
                accounts.get("business").add(new BusinessAccount());
                successfullyCreatedAccount = true;
                whichTypeOfAccount = "business";
                break;
            case "checking":
                accounts.get("checking").add(new CheckingAccount());
                successfullyCreatedAccount = true;
                whichTypeOfAccount = "checking";
                break;
            case "savings":
                accounts.get("savings").add(new SavingsAccount());
                successfullyCreatedAccount = true;
                whichTypeOfAccount = "savings";
                break;
            default:
                LOGGER.warning("You have entered an invalid account type. Please try again.");
                break;
        }
        if(successfullyCreatedAccount) {
            String congratulationMessage = "Congrats! You just created a new account of type " + whichTypeOfAccount + "!\n" +
                                           "The number of accounts that you have for that type is: " + accounts.get(whichAccount).size() + "\n";
            LOGGER.info(congratulationMessage);
        }
    }

    private static void viewAccount() {
        String whichAccountType = askToViewCreateOrDeleteAnAccountType("view");
        int maxIndexInArrayList = (accounts.get(whichAccountType).size() - 1);
        if(maxIndexInArrayList == -1) {
            accountDoesNotExistMessage("view");
        }
        else {
            String instructionsToViewAccount = "Enter a number between 0 and " + maxIndexInArrayList + ". You will receive information about that particular account of type: " + whichAccountType;
            LOGGER.info(instructionsToViewAccount);
            int whichAccount = scanner.nextInt();
            String infoAboutParticularAccount = "The account your asking for has the values of:\n" +
                    accounts.get(whichAccountType).get(whichAccount).toString() + "\n";
            LOGGER.info(infoAboutParticularAccount);
        }
    }

    private static void deleteAccount() {
        String whichAccountType = askToViewCreateOrDeleteAnAccountType("delete");
        int maxIndexInArrayList = (accounts.get(whichAccountType).size() - 1);
        if(maxIndexInArrayList == -1) {
            accountDoesNotExistMessage("delete");
        }
        else {
            String instructionsToDeleteAccount = "Which numbered account of type: " + whichAccountType + " would you like to delete? Choose a value between 0 and " + maxIndexInArrayList;
            LOGGER.info(instructionsToDeleteAccount);
            int indexOfAccountToBeDeleted = scanner.nextInt();
            accounts.get(whichAccountType).remove(indexOfAccountToBeDeleted);
            LOGGER.info("You now have " + accounts.get(whichAccountType).size() + " accounts of type " + whichAccountType + "\n");
        }
    }

    private static void accountDoesNotExistMessage(String action) {
        String accountDoesNotExist = "Sorry, you cant " + action + " the specified account type because it does not exist yet. Try again when there is at least one account of that type.\n";
        LOGGER.info(accountDoesNotExist);
    }
}
