package main.com.anz.reporting;

import main.com.anz.core.BaseMethods;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class GenerateReports extends TestListenerAdapter {

    public static void runBatReportChrome() {

        System.out.println("******* Generating Chrome Browser HTML Reports *******");

        String dirPath = System.getProperty("user.dir");
        try {
            Runtime.getRuntime().exec("cmd.exe /c" + dirPath + "/batFiles/generateChromeReport.bat");

        } catch (IOException e) {
            System.out.println("Error in running chrome .bat file");
            e.printStackTrace();
        }
        System.out.println("******* Chrome Browser HTML Report Generated *******");
    }

    public static void runShReportChrome() {

        System.out.println("******* Generating Chrome Browser HTML Reports *******");

        String dirPath = System.getProperty("user.dir");
        try {

            Runtime.getRuntime().exec("/bin/bash /" + dirPath + "/batFiles/generateChromeReport.sh");
            System.out.println("Generating Chrome Browser Execution report !!!");
        } catch (IOException e) {
            System.out.println("Error in running chrome .sh file");
            e.printStackTrace();
        }
        System.out.println("******* Chrome Browser HTML Report Generated *******");

    }

    public static void runShReportEdge() {

        System.out.println("******* Generating Edge Browser HTML Reports *******");

        String dirPath = System.getProperty("user.dir");
        try {
            Runtime.getRuntime().exec("/bin/bash /" + dirPath + "/batFiles/generateEdgeReport.sh");

        } catch (IOException e) {
            System.out.println("Error in running Edge .sh file");
            e.printStackTrace();
        }
        System.out.println("******* Edge Browser HTML Report Generated *******");

    }

    public static void runBatReportEdge() {

        System.out.println("******* Generating Edge Browser HTML Reports *******");

        String dirPath = System.getProperty("user.dir");
        try {
            Runtime.getRuntime().exec("cmd.exe /c" + dirPath + "/batFiles/generateEdgeReport.bat");

        } catch (IOException e) {
            System.out.println("Error in running Edge .bat file");
            e.printStackTrace();
        }

        System.out.println("******* Edge Browser HTML Report Generated *******");

    }

    @Override
    public void onFinish(ITestContext context) {

        if (BaseMethods.browserName.get().equalsIgnoreCase("Chrome")) {
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                runShReportChrome();
            } else {
                runBatReportChrome();
            }
        } else if (BaseMethods.browserName.get().equalsIgnoreCase("Edge")) {
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                runShReportEdge();
            } else {
                runBatReportEdge();
            }
        }
    }
}
