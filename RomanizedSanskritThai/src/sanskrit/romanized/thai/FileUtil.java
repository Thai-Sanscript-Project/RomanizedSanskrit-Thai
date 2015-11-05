/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanskrit.romanized.thai;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thanakrit.P
 */
public class FileUtil {

    public String getFile(String fileName) {

        StringBuilder result = new StringBuilder("");
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file,"UTF-8")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {

        }

        return result.toString();
    }
    
    public List<String> getListLine(String fileName) {

        List<String> result = new ArrayList<>();
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file,"UTF-8")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.add(line);
            }
            scanner.close();
        } catch (IOException e) {

        }

        return result;
    }

}
