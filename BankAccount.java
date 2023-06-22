import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    String getAccountNumber();
    String getAccountPin();
}









