package com.sandhu;

import com.sandhu.Entities.Employee;
import com.sandhu.logic.AppLogic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        AppLogic appLogic = applicationContext.getBean("appLogic", AppLogic.class);
        System.out.println( "Welcome to Employee Management System" );
        System.out.println("Enter what you want to do :");
        List<Employee> employeeList= new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        do{

            menuOptions();
            choice=scan.nextInt();
            switch(choice){
                case 1:
                    var employee = appLogic.AddEmployee(applicationContext, scan);
                    employeeList.add(employee);
                    System.out.println("SuccessFully added Employee");
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Displaying all employees");
                    System.out.println("------------------------------");
                    employeeList.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Thanks !!. Exiting");
                    break;
                default:
                    System.out.println("Wrong Choice. Please try again ");


            }

        }while(choice!=0);
    }

    private static void menuOptions(){
        System.out.println("1. Enter new employee");
        System.out.println("2.Check employee");
        System.out.println("3.Delete Employee");
        System.out.println("4.Display all Employees");
        System.out.println("0.Exit");
    }
}
