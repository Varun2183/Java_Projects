package com.tnsif.bankingsystem;

import java.util.Scanner;
import java.util.List;

public class BankingSystemApp {

	private static BankingServiceImpl bankingService = new BankingServiceImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Banking System");
            System.out.println("1. Add Customers");
            System.out.println("2. Add Accounts");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all transactions of specific Account");
            System.out.println("8. List all beneficiaries of specific customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
            case 1: addCustomer(scanner); break;
            case 2: addAccount(scanner); break;
            case 3: addBeneficiary(scanner); break;
            case 4: addTransaction(scanner); break;
            case 5: findCustomer(scanner); break;
            case 6: listAccountsOfCustomer(scanner); break;
            case 7: listTransactionsOfAccount(scanner); break;
            case 8: listBeneficiariesOfCustomer(scanner); break;
            case 9: System.out.println("Thank you!"); return;
            default: System.out.println("Invalid choice. Please try again.");
        }
    }
}

private static void addCustomer(Scanner scanner) {
    System.out.println("Enter Customer Details:");
    System.out.print("Customer ID: ");
    int customerId = scanner.nextInt();
    scanner.nextLine();  // consume newline
    System.out.print("Name: ");
    String name = scanner.nextLine();
    System.out.print("Address: ");
    String address = scanner.nextLine();
    System.out.print("Contact: ");
    String contact = scanner.nextLine();

    Customer customer = new Customer(customerId, name, address, contact);
    bankingService.addCustomer(customer);
    System.out.println("Customer added successfully!");
}

private static void addAccount(Scanner scanner) {
    System.out.println("Enter Account Details:");
    System.out.print("Account ID: ");
    int accountId = scanner.nextInt();
    System.out.print("Customer ID: ");
    int customerId = scanner.nextInt();
    scanner.nextLine();  // consume newline
    System.out.print("Account Type (Saving/Current): ");
    String type = scanner.nextLine();
    System.out.print("Balance: ");
    double balance = scanner.nextDouble();

    Account account = new Account(accountId, customerId, type, balance);
    bankingService.addAccount(account);
    System.out.println("Account added successfully!");
}

private static void addBeneficiary(Scanner scanner) {
    System.out.println("Enter Beneficiary Details:");
    System.out.print("Beneficiary ID: ");
    int beneficiaryId = scanner.nextInt();
    System.out.print("Customer ID: ");
    int customerId = scanner.nextInt();
    scanner.nextLine();  // consume newline
    System.out.print("Beneficiary Name: ");
    String name = scanner.nextLine();
    System.out.print("Account Number: ");
    String accountNumber = scanner.nextLine();
    System.out.print("Bank Details: ");
    String bankDetails = scanner.nextLine();

    Beneficiary beneficiary = new Beneficiary(beneficiaryId, customerId, name, accountNumber, bankDetails);
    bankingService.addBeneficiary(beneficiary);
    System.out.println("Beneficiary added successfully!");
}

private static void addTransaction(Scanner scanner) {
    System.out.println("Enter Transaction Details:");
    System.out.print("Transaction ID: ");
    int transactionId = scanner.nextInt();
    System.out.print("Account ID: ");
    int accountId = scanner.nextInt();
    scanner.nextLine();  // consume newline
    System.out.print("Type (Deposit/Withdrawal): ");
    String type = scanner.nextLine();
    System.out.print("Amount: ");
    double amount = scanner.nextDouble();

    Transaction transaction = new Transaction(transactionId, accountId, type, amount);
    bankingService.addTransaction(transaction);
    System.out.println("Transaction added successfully!");
}

private static void findCustomer(Scanner scanner) {
    System.out.print("Enter Customer ID to find: ");
    int customerId = scanner.nextInt();
    Customer customer = bankingService.findCustomerById(customerId);
    if (customer != null) {
        System.out.println("Customer found: " + customer);
    } else {
        System.out.println("Customer not found.");
    }
}

private static void listAccountsOfCustomer(Scanner scanner) {
    System.out.print("Enter Customer ID to list accounts: ");
    int customerId = scanner.nextInt();
    List<Account> accounts = bankingService.getAccountsByCustomerId(customerId);
    if (!accounts.isEmpty()) {
        for (Account account : accounts) {
            System.out.println(account);
        }
    } else {
        System.out.println("No accounts found for this customer.");
    }
}

private static void listTransactionsOfAccount(Scanner scanner) {
    System.out.print("Enter Account ID to list transactions: ");
    int accountId = scanner.nextInt();
    List<Transaction> transactions = bankingService.getTransactionsByAccountId(accountId);
    if (!transactions.isEmpty()) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    } else {
        System.out.println("No transactions found for this account.");
    }
}

private static void listBeneficiariesOfCustomer(Scanner scanner) {
    System.out.print("Enter Customer ID to list beneficiaries: ");
    int customerId = scanner.nextInt();
    List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(customerId);
    if (!beneficiaries.isEmpty()) {
        for (Beneficiary beneficiary : beneficiaries) {
            System.out.println(beneficiary);
        }
    } else {
        System.out.println("No beneficiaries found for this customer.");
    }
}
}
