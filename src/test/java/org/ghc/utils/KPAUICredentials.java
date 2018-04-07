package org.ghc.utils;

import java.util.Map;

import static org.ghc.utils.KPAIUTestConstants.logging.accountInformation;
import static org.ghc.utils.KPAIUTestConstants.mess.*;
import static org.ghc.utils.extensions.KPAUIEveryTest.ENV;
import static org.ghc.utils.helpers.KPAUIRestHelper.getRestAccountInfo;

public class KPAUICredentials {

    public enum accountName  {
        EVERYTHING                      ("3000109", "mychart12", "1869940", "Winter2016"),
        NOTHING                         ("3000905", "mychart12", "4066439", "Hello123!"),
        WITH_QUIZ                       ("2023389", "mychart12", "0000000", "invalid"),
        WITHOUT_QUIZ                    ("6090966", "mychart12", "0000000", "invalid"),
        INVALID                         ("0000000",  "invalid",  "0000000", "invalid");

        private String id;
        private String pass;

        accountName(String QA_id, String QA_pass, String PROD_id, String PROD_pass) {
            if (ENV.equals("PROD")) {
                id = PROD_id;
                pass = PROD_pass;
            } else {
                id = QA_id;
                pass = QA_pass;
            }
        }

        public String getID()           { return id; }
        public String getPass()         { return pass; }

        public KPAUIAccount getMemberInfo() {
            return new KPAUIAccount(getID(), getPass());
        }
    }

    public static class KPAUIAccount {  //defaults are for non-existent member
        private String email =          "test@test.com";
        private String secAnswer =      "abcdefg";
        private String area =           "111";
        private String phone =          "111-123-4567";
        private String id =             "00000000";
        private String pass =           "invalid";
        private String first =          "Joe";
        private String fullName =       "Joe Blow";
        private String last =           "Blow";
        private String dob =            "1970-01-01";
        private String ssn =            "1234";
        private String address =        "23 3rd St";
        private String city =           "Kathmandu";
        private String state =          "WA";
        private String zip =            "98057";


        private KPAUIAccount(String id, String pass) {
            Map info = getRestAccountInfo(id);
            System.out.printf(accountInformation, info);

            if (info != null) {
                this.id =               id;
                this.pass =             pass;
                this.first =            info.get(firstName).toString();
                this.last =             info.get(lastName).toString();
                this.fullName =         String.format("%s %s", first, last);
                this.dob =              info.get(birthDate).toString();
                this.ssn =              info.get(ssnLast4).toString();
                this.area =             info.get(areaCode).toString();
                this.phone =            info.get(phoneNumber).toString();
                this.address =          info.get(streetAddress).toString();
                this.city =             info.get(cityName).toString();
                this.state =            info.get(stateName).toString();
                this.zip =              info.get(zipCode).toString();
            }
        }

        public String getFirst()        { return this.first; }
        public String getID()           { return this.id; }
        public String getPass()         { return this.pass; }
        public String getDOB()          { return this.dob; }
        public String getLast()         { return this.last; }
        public String getFullName()     { return this.fullName; }
        public String getSSN()          { return this.ssn; }
        public String getEmail()        { return this.email; }
        public String getSecAnswer()    { return this.secAnswer; }
        public String getArea()         { return this.area; }
        public String getPhone()        { return this.phone; }
        public String getAddress()      { return this.address; }
        public String getCity()         { return this.city; }
        public String getState()        { return this.state; }
        public String getZip()          { return this.zip; }
    }
}
