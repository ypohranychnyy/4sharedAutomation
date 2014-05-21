package com.codeborne.selenide_DailyCheck.Smoke;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ImageWithoutReg {

    @Test

    public void AnonUserCanDownloadImage() throws FileNotFoundException {

        open("http://www.4shared.com/photo/2rwrZETMba/bm_01.htm"); //открываем 4shared

        $("#btnLink").download();

        File file = new File("D:\\4shared\\4sharedAutomation\\build\\reports\\tests\\bm_01.jpg");
        boolean isFile = file.isFile();
        System.out.println("File " + file.getPath() + " isFile: " + isFile); //проверяем, что файл существует


        try {
            File fileToDelete = new File("D:\\4shared\\4sharedAutomation\\build\\reports\\tests\\bm_01.jpg"); //удаляем файл

            if (fileToDelete.delete()) {
                System.out.println("File deleted successfully!");
            } else {
                System.out.println("File delete operation failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
