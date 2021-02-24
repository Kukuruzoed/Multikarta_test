import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void test1(){
        List<String> mainString = Main.getIdListFromString("T1001,, T1002, ");
        assertTrue(Main.compareIds(mainString, "T1001, ,T1003, T1002"));
    }
    @Test
    public void test2(){
        List<String> mainString = Main.getIdListFromString("T1001,, T1005, ");
        assertFalse(Main.compareIds(mainString, "T1001, ,T1003, T1002"));
    }
    @Test
    public void test3(){
        List<String> mainString = Main.getIdListFromString(" ,, T1001,, T1002, ");
        assertTrue(Main.compareIds(mainString, ", ,T1003, T1002 ,T1001"));
    }
    @Test
    public void test4(){
        List<String> mainString = Main.getIdListFromString("T1001,, T1002, T1034  T1006");
        assertFalse(Main.compareIds(mainString, "T1001, ,T1003, T1002"));
    }
    @Test
    public void test5(){
        List<String> list = List.of("T1001","T1002","T1003");
        assertEquals(list, Main.getIdListFromString("T1001, ,T1002, T1003"));
    }
    @Test
    public void test6(){
        List<String> list = List.of("T2020","T1101","T1066");
        assertEquals(list, Main.getIdListFromString(", , ,,T2020,, ,T1101,  , T1066, , , "));
    }
    @Test
    public void test7(){
        List<String> list = List.of("T1001","T1002","T1003");
        assertNotEquals(list, Main.getIdListFromString("T1020,T1002,T1003"));
    }

    @Test
    public void test8(){
        String string = "T1001,, T1002, T1003";
        String[] array = new String[]{" T1002,,T1001 , ,T1003 , T1004", "T1003, ,,T1006 , , T1001 T1002,, ", "T1005, ,T1004,", " T1008, ,T1004, ,T1005,"};
        List<String> list = List.of(" T1002,,T1001 , ,T1003 , T1004", "T1003, ,,T1006 , , T1001 T1002,, ");

        assertEquals(list, Main.getArrayStrings(string, array));
    }

    @Test
    public void test9(){
        String string = " T1000 , T1001,, T1002, T1003";
        String[] array = new String[]{" T1002,,T1001 , ,T1003 , T1004", "T1003, ,,T1006 , , T1001 T1002,, ", "T1005, ,T1004,", " T1008, ,T1004, ,T1005,"};
        List<String> list = new ArrayList<>();
        assertEquals(list, Main.getArrayStrings(string, array));
    }

}
