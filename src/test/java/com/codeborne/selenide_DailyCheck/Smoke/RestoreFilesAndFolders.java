package com.codeborne.selenide_DailyCheck.Smoke;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RestoreFilesAndFolders {

    @Test
    public void UserCanRestoreFilesAndFolders() {

        // entering account
        open("https://www.4shared.com"); // Open 4Shared
        $(".controls .llink").click(); //Waiting for header login
        $(".headLoginDropdown").should(); //Waiting for drop-down
        $(".jsInputLogin").val("tast");
        $(".jsInputPassword").val("1").pressEnter(); //Login

        // It should be possible to delete items in subfolders, folders and restore them to the right places

        // Creating folder1 and uploading test file in Root dir

        $("#firstDir").should(appear);
        $("#firstDir").click(); //Click Root folder
        $("#tfid1").sendKeys("C:\\For_test\\test.log"); //Upload test file
        $(byAttribute("data-element", "fm-5")).click(); //click New folder button in top menu
        $("input.jsNewName").val("our new folder1").pressEnter(); //Giving new name to a folder
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded
        sleep(500);

        // Enter folder1. creating folder2 and uploading test file in folder1

        $(byAttribute("data-element", "viewL-name")).click(); //Click the folder's name to open it
        $(byText("This folder is empty")).waitUntil(Condition.appear, 7000);
        $("#tfid1").sendKeys("C:\\For_test\\test.doc"); //Upload test file
        $(byAttribute("data-element", "fm-5")).click(); //click New folder button in top menu
        $("input.jsNewName").val("our new folder2").pressEnter(); //Giving new name to a folder
        $(byText("test.doc")).waitUntil(appear, 20000); //Assert that test file is uploaded
        sleep(500);

        // Enter folder2. uploading test file in folder2

        $(byAttribute("data-element", "viewL-name")).click(); //Click the folder's name to open it
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000);
        $("#tfid1").sendKeys("C:\\For_test\\test.txt"); //Upload test file
        $(byText("test.txt")).waitUntil(appear, 20000); //Assert that test file is uploaded
        sleep(500);

        // Delete file in folder2

        $(".jsCheckAll").click(); //Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element", "fm-m")).click(); //Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 6000); //Assert that folder is empty

        // Delete file and folder2 in folder1

        $("#backSpan").click(); //Click Back button
        $(byText("test.doc")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(".jsCheckAll").click(); //Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element", "fm-m")).click(); //Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000); //Assert that folder is empty

        // Delete file and folder1 in Root dir

        $("#backSpan").click(); //Click Back button
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded
        sleep(2500);
        $(".jsCheckAll").click(); //Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element", "fm-m")).click(); //Click More button on the top (context menu)
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000); //Assert that folder is empty

        // Open Recycle bin

        $(byAttribute("imgdirid", "StJ70-En")).click(); //click Recycle Bin image
        $(byText("This folder is empty")).waitUntil(Condition.disappear, 20000); //Assert that folder is not empty
        sleep(5000); //Just to see


        // Restore file from folder 2 (this should restore the full path to the file (folder structure)

        $(".txtFileExt").click();
        $(By.linkText("Restore")).click();
        $(".jsConfirmOk").click(); //confirm action
        $(byText("test.doc")).waitUntil(Condition.disappear, 25000);

        // And then restore all the rest items (folders that are restored in folder structure should have "name (1)"

        $(".jsCheckAll").click(); //Click "All checkbox" to mark all items selected
        $(By.linkText("Restore")).click();
        $(".jsConfirmOk").click(); //confirm action
        sleep(2500);
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000); //Assert that folder is empty

        // Now we'll assert that the deepest item is restored to the right place

        $("#firstDir").click(); //Click Root folder
        $(byText("our new folder1")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(byText("test.log")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(byText("our new folder1 (1)")).waitUntil(appear, 20000);
        $(byAttribute("data-element", "viewL-name")).click(); //Click the folder's name to open it
        $(byText("our new folder2")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(byText("our new folder2 (1)")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(byText("test.doc")).waitUntil(appear, 20000); //Assert that test file is uploaded
        $(byAttribute("data-element", "viewL-name")).click(); //Click the folder's name to open it
        $(byText("test.txt")).waitUntil(appear, 20000); //Assert that test file is uploaded

        //чистим корзину

        $("#firstDir").click(); //Click Root folder
        $(".jsCheckAll").click(); //Click "All checkbox" to mark all items selected
        $(byAttribute("data-element", "fm-m")).waitUntil(Condition.appear, 6000);
        $(byAttribute("data-element", "fm-m")).click(); //Click More button on the top (context menu)
        sleep(500);
        $(By.linkText("Delete")).click(); //Click Delete button
        $(".jsConfirmOk").click(); //Confirm deleting folder
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000); //Assert that folder is empty
        $(byAttribute("imgdirid", "StJ70-En")).click(); //click Recycle Bin image
        $(By.linkText("Empty recycle bin")).click();
        $(".jsConfirmOk").click(); //confirm action
        $(byText("This folder is empty")).waitUntil(Condition.appear, 20000); //Assert that folder is empty
    }
}



