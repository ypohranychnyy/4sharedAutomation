@image

Feature: Image without registration

 Scenario: User can download image w/o registration

     Given user search for some image
     When he click download button
     Then the file should be downloaded
