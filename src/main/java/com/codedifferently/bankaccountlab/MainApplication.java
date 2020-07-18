package com.codedifferently.bankaccountlab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
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
        int stopInteraction = 6;
        while(decision != stopInteraction) {
            LOGGER.info("What do you want to do? Enter a number between 1 - 6, corresponding to:\n" +
                            "1) create an account\n" +
                            "2) view an account\n" +
                            "3) delete an account\n" +
                            "4) deposit into an account\n" +
                            "5) withdraw from an account\n" +
                            "6) quit");
            try {
                decision = scanner.nextInt();
            }
            catch(InputMismatchException ime) {
                LOGGER.severe("Inputted the wrong type. Try again another time.");
                ime.printStackTrace();
                break;
            }
            whichActionToPerform(decision);
        }
    }

    private static void whichActionToPerform(int decision) {
        switch(decision) {
            case 1:
                createAccount();
                break;
            case 2:
                performGeneralAction("view");
                break;
            case 3:
                performGeneralAction("delete");
                break;
            case 4:
                performGeneralAction("deposit");
                break;
            case 5:
                performGeneralAction("withdrawal");
                break;
            case 6:
                LOGGER.info("Thank you for using the ATM! Please come again another time.");
                break;
            default:
                LOGGER.warning("Invalid input. Please try again.");
                break;
        }
    }

    private static void createAccount() {
        String whichAccountType = askTypeOfAccountForSpecifiedAction("create");
        String password = setUpPassword();
        addToListOfBankAccounts(whichAccountType, password);
    }

    private static String setUpPassword() {
        LOGGER.info("What is the password that you want to be associated with your account?");
        String password = scanner.next();
        return password;
    }

    private static String askTypeOfAccountForSpecifiedAction(String specificAction) {
        LOGGER.info("What type of account do you want to " + specificAction + "?\nYou could type in:\n" +
                "business\n" +
                "checking\n" +
                "savings\n");
        String whichAccountType = scanner.next().trim();
        return whichAccountType;
    }

    private static void addToListOfBankAccounts(String whichAccount, String password) {
        boolean successfullyCreatedAccount = false;
        String whichTypeOfAccount = "";
        switch(whichAccount) {
            case "business":
                accounts.get("business").add(new BusinessAccount(password));
                successfullyCreatedAccount = true;
                whichTypeOfAccount = "business";
                break;
            case "checking":
                accounts.get("checking").add(new CheckingAccount(password));
                successfullyCreatedAccount = true;
                whichTypeOfAccount = "checking";
                break;
            case "savings":
                accounts.get("savings").add(new SavingsAccount(password));
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

    private static boolean doesUserKnowPassword(String whichAccountType, int indexOfAccountToBeViewed) {
        String actualPasswordForAccount = accounts.get(whichAccountType).get(indexOfAccountToBeViewed).getPassword();
        LOGGER.info("Please enter the password associated with this account");
        String userGuessAtPassword = scanner.next();
        return actualPasswordForAccount.equals(userGuessAtPassword);
    }

    private static int returnMaxIndexOrPrintError(String whichAccountType, String action) {
        int maxIndexInArrayList = (accounts.get(whichAccountType).size() - 1);
        if(maxIndexInArrayList == -1) {
            String accountDoesNotExist = "Sorry, you can't " + action + " the specified account type because it does not exist yet. Try again when there is at least one account of that type.\n";
            LOGGER.warning(accountDoesNotExist);
            return -1;
        }
        else {
            return maxIndexInArrayList;
        }
    }

    private static int instructAndReturnInput(String whichAccountType, String action, int maxIndexInArrayList) {
        String instructionsToDeleteAccount = "Which numbered account of type: " + whichAccountType + " would you like to " + action + "? Choose a value between 0 and " + maxIndexInArrayList;
        LOGGER.info(instructionsToDeleteAccount);
        int indexOfAccount = 0;
        try {
            indexOfAccount = scanner.nextInt();
        }
        catch(InputMismatchException ime) {
            LOGGER.severe("Inputted the wrong type. Try again another time.");
            ime.printStackTrace();
            System.exit(-1);
        }
        catch(IndexOutOfBoundsException indexOutOfBounds) {
            LOGGER.severe("You tried to access an account that does not exist. Goodbye.");
            indexOutOfBounds.printStackTrace();
            System.exit(-1);
        }
        return indexOfAccount;
    }

    private static void performGeneralAction(String action) {
        String whichAccountType = askTypeOfAccountForSpecifiedAction(action);
        int maxIndexInArrayList = returnMaxIndexOrPrintError(whichAccountType,action);
        if(maxIndexInArrayList != -1) {
            int indexOfAccount = instructAndReturnInput(whichAccountType, action, maxIndexInArrayList);
            if(doesUserKnowPassword(whichAccountType, indexOfAccount)) {
                performSpecificAction(action, whichAccountType, indexOfAccount);
            }
            else {
                LOGGER.info("Sorry, you don't know the password of your account. Try again.");
            }
        }
    }

    private static void performSpecificAction(String action, String whichAccountType, int indexOfAccount) {
        switch(action) {
            case "deposit":
            case "withdrawal":
                double amountOfMoney = askForDepositOrWithdrawalAmount(action);
                String previousMoneyMessage = "You used to have " + accounts.get(whichAccountType).get(indexOfAccount).getBalance() + " money in this account.";
                LOGGER.info(previousMoneyMessage);
                if(action.equals("deposit")) {
                    accounts.get(whichAccountType).get(indexOfAccount).makeDeposit(amountOfMoney);
                }
                else if(action.equals("withdrawal")) {
                    accounts.get(whichAccountType).get(indexOfAccount).makeWithdrawal(amountOfMoney);
                }
                break;
            case "view":
                String infoAboutParticularAccount = "The account your asking for has the values of:\n" +
                        accounts.get(whichAccountType).get(indexOfAccount).toString() + "\n";
                LOGGER.info(infoAboutParticularAccount);
                break;
            case "delete":
                accounts.get(whichAccountType).remove(indexOfAccount);
                LOGGER.info("You now have " + accounts.get(whichAccountType).size() + " accounts of type " + whichAccountType + "\n");
                break;
        }
    }

    private static double askForDepositOrWithdrawalAmount(String action) {
        LOGGER.info("How much money do you want to " + action + "? Enter it as a double amount");
        double amountOfMoney = 0.0;
        try {
            amountOfMoney = scanner.nextDouble();
        }
        catch(InputMismatchException ime) {
            LOGGER.severe("You inputted the wrong type. Try again another time.");
            ime.printStackTrace();
            System.exit(-1);
        }

        return amountOfMoney;
    }

}
