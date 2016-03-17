/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import sanskrit.romanized.thai.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thanakrit.P
 */
public class spacialCaseTest {

    public spacialCaseTest() {

    }

    @Test
    public void test1() {
        convertTest("uddānam", "อุททานัม");
        convertTest("-uddānam", "-อุททานัม");
        convertTest("uddānam-uddānam", "อุททานัม-อุททานัม");
    }

    @Test
    public void test2() {
        convertTest("na-an", "นะ-อัน");
        convertTest("naan", "นะอัน");    
    }
    
    @Test
    public void test3() {     
        convertTest("bījagrāmabhūtagrāma", "พีชะครามะภูตะครามะ");    
    }
    
    @Test
    public void test4() {     
        convertTest("namaḥ", "นะมะหฺ");
        convertTest("trayaḥ", "ตระยะหฺ");
    }
     @Test
    public void test5() {     
        convertTest("daurvvalyamanāviṣkṛtvā", "เทารววัลยะมะนาวิษกฤตวา");
       
    }
     @Test
    public void test6() {     
        convertTest("maitreya", "ไมเตรยะ");
       
    }

    public static void convertTest(String param, String expected) {
        ThaiCharacterRule thaiCharacterRule = new ThaiCharacterRule();
        String actual = thaiCharacterRule.convertTrackMode(param);
        System.out.println();
        System.out.println(" param :" + param);
        System.out.println(" actual :" + actual);
        System.out.println(" expected :" + expected);

        assertEquals(expected, actual);
    }
}
