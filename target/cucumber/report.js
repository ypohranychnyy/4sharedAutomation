$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Ads.feature");
formatter.feature({
  "id": "advertisment",
  "tags": [
    {
      "name": "@DailyCheck",
      "line": 1
    },
    {
      "name": "@All",
      "line": 2
    }
  ],
  "description": "",
  "name": "Advertisment",
  "keyword": "Feature",
  "line": 4
});
formatter.scenario({
  "id": "advertisment;ads-is-present-for-free-user",
  "description": "",
  "name": "Ads is present for free user",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "User go to 4shared",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User go to search page",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "there should be ads on search",
  "keyword": "Then ",
  "line": 9
});
formatter.step({
  "name": "he go to D-one page of some file",
  "keyword": "When ",
  "line": 10
});
formatter.step({
  "name": "there should be ads",
  "keyword": "Then ",
  "line": 11
});
formatter.step({
  "name": "he press Download button on D-one",
  "keyword": "When ",
  "line": 12
});
formatter.step({
  "name": "he goes to D-two",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "there should be ads",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "CommonSteps.user_go_to_shared()"
});
formatter.result({
  "duration": 9900386546,
  "status": "passed"
});
formatter.match({
  "location": "Search_Cuke.User_go_to_search_page()"
});
formatter.result({
  "duration": 119486019,
  "status": "passed"
});
formatter.match({
  "location": "Ads_Cuke.there_should_be_ads_on_serch()"
});
formatter.result({
  "duration": 3575873286,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_go_to_D_one_page_of_this_file()"
});
formatter.result({
  "duration": 4312823535,
  "status": "passed"
});
formatter.match({
  "location": "Ads_Cuke.there_should_be_ads()"
});
formatter.result({
  "duration": 111971977,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_press_Download_button_on_D_one()"
});
formatter.result({
  "duration": 89766897,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_goes_to_D_two_and_press_Free_Download_there()"
});
formatter.result({
  "duration": 2335485185,
  "status": "passed"
});
formatter.match({
  "location": "Ads_Cuke.there_should_be_ads()"
});
formatter.result({
  "duration": 122346950,
  "status": "passed"
});
formatter.uri("Registration.feature");
formatter.feature({
  "id": "registration",
  "tags": [
    {
      "name": "@DailyCheck",
      "line": 1
    },
    {
      "name": "@All",
      "line": 2
    }
  ],
  "description": "",
  "name": "Registration",
  "keyword": "Feature",
  "line": 4
});
formatter.scenario({
  "id": "registration;user-can-register-new-account-with-correct-credentials",
  "description": "",
  "name": "User can register new account with correct credentials",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "fake email site",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User enter correct data into registration form",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "he submit it",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "the second step of registration should appear",
  "keyword": "Then ",
  "line": 10
});
formatter.step({
  "name": "he have to verify his email",
  "keyword": "And ",
  "line": 11
});
formatter.step({
  "name": "the third step of registration should appear",
  "keyword": "And ",
  "line": 12
});
formatter.step({
  "name": "User enters account",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "he delete his account",
  "keyword": "Then ",
  "line": 14
});
formatter.match({
  "location": "Registration_Cuke.Fake_email_site()"
});
formatter.result({
  "duration": 1099948847,
  "status": "passed"
});
formatter.match({
  "location": "Registration_Cuke.User_enter_correct_data_into_registration_form()"
});
formatter.result({
  "duration": 6910417849,
  "status": "passed"
});
formatter.match({
  "location": "Registration_Cuke.He_submit_it()"
});
formatter.result({
  "duration": 147119286,
  "status": "passed"
});
formatter.match({
  "location": "Registration_Cuke.the_second_step_of_registration_should_appear()"
});
formatter.result({
  "duration": 4335519949,
  "status": "failed",
  "error_message": "Element not found {By.selector: #resend}\nExpected: visible\nScreenshot: file:/D:/4shared/4sharedAutomation/build/reports/tests/1398874529769.0.png\nTimeout: 4 s.\nCaused by: NoSuchElementException: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#resend\"}\r\n\tat com.codeborne.selenide.impl.AbstractSelenideElement.waitUntil(AbstractSelenideElement.java:441)\r\n\tat com.codeborne.selenide.impl.AbstractSelenideElement.should(AbstractSelenideElement.java:309)\r\n\tat com.codeborne.selenide.impl.AbstractSelenideElement.invoke(AbstractSelenideElement.java:88)\r\n\tat com.codeborne.selenide.impl.WaitingSelenideElement.invoke(WaitingSelenideElement.java:17)\r\n\tat com.sun.proxy.$Proxy20.should(Unknown Source)\r\n\tat com.codeborne.selenide_DailyCheck.Registration_Cuke.the_second_step_of_registration_should_appear(Registration_Cuke.java:49)\r\n\tat ✽.Then the second step of registration should appear(Registration.feature:10)\r\n"
});
formatter.match({
  "location": "Registration_Cuke.he_have_to_verify_his_email()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration_Cuke.the_third_step_of_registration_should_appear()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration_Cuke.User_enters_account()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Registration_Cuke.he_delete_his_account()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("Search.feature");
formatter.feature({
  "id": "search",
  "tags": [
    {
      "name": "@DailyCheck",
      "line": 1
    },
    {
      "name": "@All",
      "line": 2
    }
  ],
  "description": "",
  "name": "Search",
  "keyword": "Feature",
  "line": 4
});
formatter.scenario({
  "id": "search;confirm-that-the-search-results-are-present",
  "description": "",
  "name": "Confirm that the search results are present",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "User go to 4shared",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User go to search page",
  "keyword": "When ",
  "line": 8
});
formatter.step({
  "name": "there should be some results",
  "keyword": "Then ",
  "line": 9
});
formatter.match({
  "location": "CommonSteps.user_go_to_shared()"
});
formatter.result({
  "duration": 1613951387,
  "status": "passed"
});
formatter.match({
  "location": "Search_Cuke.User_go_to_search_page()"
});
formatter.result({
  "duration": 138856985,
  "status": "passed"
});
formatter.match({
  "location": "Search_Cuke.there_should_be_some_results()"
});
formatter.result({
  "duration": 6002158032,
  "status": "passed"
});
formatter.uri("Social_download.feature");
formatter.feature({
  "id": "social-download",
  "tags": [
    {
      "name": "@DailyCheck",
      "line": 1
    },
    {
      "name": "@All",
      "line": 2
    }
  ],
  "description": "",
  "name": "Social_download",
  "keyword": "Feature",
  "line": 4
});
formatter.scenario({
  "id": "social-download;social-download-fb",
  "description": "",
  "name": "Social_download_FB",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "User go to 4shared",
  "keyword": "Given ",
  "line": 8
});
formatter.step({
  "name": "User go to search page",
  "keyword": "And ",
  "line": 9
});
formatter.step({
  "name": "he searches for the \"gta test.mp3\" file",
  "keyword": "And ",
  "line": 10
});
formatter.step({
  "name": "he found what he wants",
  "keyword": "When ",
  "line": 11
});
formatter.step({
  "name": "he go to D-one page of some file",
  "keyword": "Then ",
  "line": 12
});
formatter.step({
  "name": "he press Download button on D-one",
  "keyword": "And ",
  "line": 13
});
formatter.step({
  "name": "he goes to D-two",
  "keyword": "When ",
  "line": 14
});
formatter.step({
  "name": "press Free Download there",
  "keyword": "And ",
  "line": 15
});
formatter.step({
  "name": "One-click download popup should appear",
  "keyword": "Then ",
  "line": 16
});
formatter.step({
  "name": "he clicks on fb button",
  "keyword": "And ",
  "line": 17
});
formatter.step({
  "name": "he login to fb",
  "keyword": "And ",
  "line": 18
});
formatter.step({
  "name": "the timer stops counting",
  "keyword": "When ",
  "line": 19
});
formatter.step({
  "name": "the file starts downloading and user goes to D-three",
  "keyword": "Then ",
  "line": 20
});
formatter.match({
  "location": "CommonSteps.user_go_to_shared()"
});
formatter.result({
  "duration": 2001814693,
  "status": "passed"
});
formatter.match({
  "location": "Search_Cuke.User_go_to_search_page()"
});
formatter.result({
  "duration": 101598328,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "gta test.mp3",
      "offset": 21
    }
  ],
  "location": "Search_Cuke.he_searchs_for_the_file(String)"
});
formatter.result({
  "duration": 2208835415,
  "status": "passed"
});
formatter.match({
  "location": "Search_Cuke.he_found_what_he_wants()"
});
formatter.result({
  "duration": 1415941556,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_go_to_D_one_page_of_this_file()"
});
formatter.result({
  "duration": 2323790163,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_press_Download_button_on_D_one()"
});
formatter.result({
  "duration": 125472753,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_goes_to_D_two_and_press_Free_Download_there()"
});
formatter.result({
  "duration": 2400492328,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.press_Free_Download_there()"
});
formatter.result({
  "duration": 170367955,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.One_click_download_popup_should_appear()"
});
formatter.result({
  "duration": 525321114,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_click_fb_button()"
});
formatter.result({
  "duration": 172000550,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.he_login_to_fb()"
});
formatter.result({
  "duration": 4774652565,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.the_timer_stops_counting()"
});
formatter.result({
  "duration": 26728882296,
  "status": "passed"
});
formatter.match({
  "location": "SocialDownload_Cuke.User_goes_to_D_three()"
});
formatter.result({
  "duration": 130617198,
  "status": "passed"
});
formatter.uri("Upload.feature");
formatter.feature({
  "id": "upload",
  "tags": [
    {
      "name": "@DailyCheck",
      "line": 1
    },
    {
      "name": "@All",
      "line": 2
    }
  ],
  "description": "",
  "name": "Upload",
  "keyword": "Feature",
  "line": 4
});
formatter.scenario({
  "id": "upload;user-can-upload-a-file",
  "description": "",
  "name": "User can upload a file",
  "keyword": "Scenario",
  "line": 6,
  "type": "scenario"
});
formatter.step({
  "name": "User go to 4shared",
  "keyword": "Given ",
  "line": 7
});
formatter.step({
  "name": "User logs in from main with correct credentials \"test2@deng.4shared.com\" and \"1\"",
  "keyword": "And ",
  "line": 8
});
formatter.step({
  "name": "he uploads some file",
  "keyword": "When ",
  "line": 9
});
formatter.step({
  "name": "the file should be present in account",
  "keyword": "Then ",
  "line": 10
});
formatter.step({
  "name": "We need to delete that file",
  "keyword": "But ",
  "line": 11
});
formatter.match({
  "location": "CommonSteps.user_go_to_shared()"
});
formatter.result({
  "duration": 1602254047,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test2@deng.4shared.com",
      "offset": 49
    },
    {
      "val": "1",
      "offset": 78
    }
  ],
  "location": "CommonSteps.User_logs_in_with_correct_and(String,String)"
});
