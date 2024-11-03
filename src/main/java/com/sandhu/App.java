package com.sandhu;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Employee Management System" );
        System.out.println("Enter what you want to do :");
        Scanner scan = new Scanner(System.in);
        int choice;
        do{

            menuOptions();
            choice=scan.nextInt();
            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Thanks !!. Exiting");
                    break;
                case 5:
                    System.out.println("Wrong Choice. Please try again ");


            }

        }while(choice!=4);
    }

    private static void menuOptions(){
        System.out.println("1. Enter new employee");
        System.out.println("2.Check employee");
        System.out.println("3.Delete Employee");
        System.out.println("4.Exit");
    }
}
