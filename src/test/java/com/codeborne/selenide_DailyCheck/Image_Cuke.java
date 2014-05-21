package com.codeborne.selenide_DailyCheck;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by User on 06.05.2014.
 */
public class Image_Cuke {
    @Given("^user search for some image$")
    public void user_search_for_some_image()  {

        open("http://www.4shared.com/photo/2rwrZETMba/bm_01.htm");

    }

    @When("^he click download button$")
    public void he_click_download_button() throws FileNotFoundException {

        $("#btnLink").download();

    }


    @Then("^the file should be downloaded$")
    public void the_file_should_be_downloaded() {

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
