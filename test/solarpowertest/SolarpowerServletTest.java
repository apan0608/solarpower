package solarpowertest;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Test;

import solarpower.SolarpowerServlet;

public class SolarpowerServletTest {
    
    @Test
    public void DemoTest() {
        LinkedHashMap<String, Double> sizes = SolarpowerServlet.BuildSystemSizes();
        assertEquals((Double)1.0, sizes.get("1kW"));
    }
}
