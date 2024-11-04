package com.sandhu;

import com.sandhu.Entities.Department;
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
        List<Department> departments= new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int choice;
        do{

            menuOptions();
            choice=scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    var employee = appLogic.AddEmployee(applicationContext, scan);
                    employeeList.add(employee);

                    break;
                case 2:
                    System.out.println("Enter the id of employee");
                    int empId=scan.nextInt();
                    scan.nextLine();
                    System.out.println(appLogic.retrieveEmployeeById(empId));

                    break;
                case 3:
                    System.out.println("Enter the id of employee you want to delete");
                    appLogic.deleteEmployee(scan.nextInt());
                    scan.nextLine();
                    break;
                case 4:
                    System.out.println("Displaying all employees");
                    appLogic.retrieveAllEmployees().forEach(System.out::println);
                    break;
                case 5:
                    var department = appLogic.createDepartment(applicationContext, scan);
                    departments.add(department);
                break;
                case 6:
                    System.out.println("Displaying all departments");
                    System.out.println("------------------------------");
                    departments.forEach(System.out::println);
                    break;
                case 7:

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
        System.out.println("2.Retrieve employee using id");
        System.out.println("3.Delete Employee");
        System.out.println("4.Display all Employees");
        System.out.println("5.Create department");
        System.out.println("6.Display all department");
        System.out.println("7.Add Employee to department");
        System.out.println("0.Exit");
    }
}
