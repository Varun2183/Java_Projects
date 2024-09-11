package com.tnsif.bankingsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class BankingServiceImplTest {

	private BankingServiceImpl bankingService;

    @BeforeEach
    void setUp() {
        bankingService = new BankingServiceImpl();
    }

    @Test
    void testAddCustomerAndFindCustomer() {
        Customer customer = new Customer(1, "John Doe", "123 Main St", "1234567890");
        bankingService.addCustomer(customer);

        Customer foundCustomer = bankingService.findCustomerById(1);
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
    }

    @Test
    void testAddAccountAndFindAccount() {
        Account account = new Account(101, 1, "Saving", 5000.0);
        bankingService.addAccount(account);

        Account foundAccount = bankingService.findAccountById(101);
        assertNotNull(foundAccount);
        assertEquals(5000.0, foundAccount.getBalance());
    }

    @Test
    void testAddTransactionAndFindTransaction() {
        Account account = new Account(101, 1, "Saving", 5000.0);
        bankingService.addAccount(account);

        Transaction transaction = new Transaction(1, 101, "Deposit", 2000.0);
        bankingService.addTransaction(transaction);

        Transaction foundTransaction = bankingService.findTransactionById(1);
        assertNotNull(foundTransaction);
        assertEquals("Deposit", foundTransaction.getType());
    }

    @Test
    void testAddBeneficiaryAndFindBeneficiary() {
        Beneficiary beneficiary = new Beneficiary(1001, 1, "Alice", "9876543210", "XYZ Bank");
        bankingService.addBeneficiary(beneficiary);

        Beneficiary foundBeneficiary = bankingService.findBeneficiaryById(1001);
        assertNotNull(foundBeneficiary);
        assertEquals("Alice", foundBeneficiary.getName());
    }

    @Test
    void testGetAccountsByCustomerId() {
        bankingService.addAccount(new Account(101, 1, "Saving", 5000.0));
        bankingService.addAccount(new Account(102, 1, "Current", 10000.0));

        List<Account> accounts = bankingService.getAccountsByCustomerId(1);
        assertEquals(2, accounts.size());
    }
    
    @Test
    void testGetTransactionsByAccountId() {
        bankingService.addTransaction(new Transaction(1, 101, "Deposit", 2000.0));
        bankingService.addTransaction(new Transaction(2, 101, "Withdrawal", 1000.0));

        List<Transaction> transactions = bankingService.getTransactionsByAccountId(101);
        assertEquals(2, transactions.size());
    }

    @Test
    void testGetBeneficiariesByCustomerId() {
        bankingService.addBeneficiary(new Beneficiary(1001, 1, "Alice", "9876543210", "XYZ Bank"));
        bankingService.addBeneficiary(new Beneficiary(1002, 1, "Bob", "1234567890", "ABC Bank"));

        List<Beneficiary> beneficiaries = bankingService.getBeneficiariesByCustomerId(1);
        assertEquals(2, beneficiaries.size());
    }
}
