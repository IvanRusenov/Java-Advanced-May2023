package DefiningClassesLab.A03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String END = "End";
    private static Map<Integer, BankAccount> accounts;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        accounts =  new HashMap<>();



        while (!input.equals(END)){


            String[] inputData = input.split("\\s+");

            String command = inputData[0];
            String result = "";

            if (command.equals("Create")){

                result =  createAccount();

            } else if (command.equals("Deposit")) {

                result = deposit(inputData);

            } else if (command.equals("SetInterest")) {

                result = SetInterest(inputData);
            } else if (command.equals("GetInterest")) {
                result = getInterest(inputData);
            }

            if (!result.isEmpty()) {
                System.out.println(result);
            }


            input = scan.nextLine();
            
        }



    }

    private static String getInterest(String[] inputData) {

        int id = Integer.parseInt(inputData[1]);
        int years = Integer.parseInt(inputData[2]);

        if (!accounts.containsKey(id)){

            return "Account does not exist";

        }

        double interest = accounts.get(id).getInterest(years);

        return String.format("%.2f", interest);

    }

    private static String SetInterest(String[] inputData) {

        double interest = Double.parseDouble(inputData[1]);
        BankAccount.setInterestRate(interest);

        return "";
    }

    private static String deposit(String[] inputData) {

        int id = Integer.parseInt(inputData[1]);
        double amount = Double.parseDouble(inputData[2]);

        if (!accounts.containsKey(id)){

            return "Account does not exist";

        }
        accounts.get(id).deposit(amount);

        return String.format("Deposited %.0f to ID%d", amount, id);


    }

    private static String createAccount() {
       BankAccount bankAccount= new BankAccount();
        int id = bankAccount.getId();

        accounts.put(id,bankAccount);

       return String.format("Account ID%d created", id);

    }


}
