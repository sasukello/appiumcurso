package TestSuites;

import org.testng.annotations.*;

public class ejerciciosTestNG {


    public void metodo(){
    }
    //sirve para imprimir una sola vez
    @BeforeSuite
    public void metodo11(){
        System.out.println("Inicio de Suite");

    }
    @AfterSuite
    public void metodo2(){
        System.out.println("Termino de Suite");
    }
    @Test(priority = 1)
    public void metodo3(){
        System.out.println("Test 1");
    }
    @Test(priority = 2)
    public void metodo4(){

        System.out.println("Test 2");

    }

    @AfterMethod
    public void metodo5(){
        System.out.println("Termino de Test");

    }
}
