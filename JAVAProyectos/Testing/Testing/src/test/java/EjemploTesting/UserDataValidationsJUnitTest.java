/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EjemploTesting;

import com.mycompany.testing.UserDataValidations;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author julioarrtor
 */
public class UserDataValidationsJUnitTest {
    
    public UserDataValidationsJUnitTest() {
    }

//    @org.junit.jupiter.api.BeforeAll
//    public static void setUpClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterAll
//    public static void tearDownClass() throws Exception {
//    }
//
//    @org.junit.jupiter.api.BeforeEach
//    public void setUp() throws Exception {
//    }
//
//    @org.junit.jupiter.api.AfterEach
//    public void tearDown() throws Exception {
//    }
  
    @BeforeAll
   public static void setUpClass() {
   }
   
    @AfterAll
   public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void TestCheckIdNum1(){
        System.out.println("TestCheckIdNum1");
        int TypeDoc = 1;
        String id = "78014527D";
        boolean expResult = true;
        boolean result = UserDataValidations.checkId(TypeDoc, id);
        //assertEquals(expResult, result,"NIF incorrecto");
        assertFalse(result);
    }
}
