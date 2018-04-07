package org.ghc.utils;

public class KPAIUTestConstants {
    public static class links {
        public static final String kpWASite =               "https://wa%s.kaiserpermanente.org/html/public/index-new?dei=true";
        public static final String kpWAMemberSite =         "https://wa-member%s.kaiserpermanente.org/home/?dei=true";
        public static final String inContextSite =          "https://incontext%s.ghc.org/secure/admin/member/index.jhtml";
        public static final String accountInfoSite =        "https://ghcservices%s.ghc.org/services/mess/identification/consumer/";
        public static final String findADoctorLandingPage = "https://wa-member%s.kaiserpermanente.org/find-a-doctor/";
        public static final String findADoctorResultsPage = "https://wa-member%s.kaiserpermanente.org/find-a-doctor/results?*=";
        public static final String findADoctorSite =        "https://wa-member%s.kaiserpermanente.org/services/fadss/search?";
        public static final String findADoctorSiteLists =   "https://wa-member%s.kaiserpermanente.org/services/fadss/list?";
    }

    public static class credentials {
        public class inContextSite {
            public static final String inContextLogin =     "cscrep1";
            public static final String inContextPass =      "winter17";
        }
    }

    public static class attributes {
        public static final String srcAttribute =            "src";
        public static final String hrefAttribute =           "href";
    }

    public static class mess{
        public static final String totalCount =             "totalCount";
        public static final String consumer =               "consumer";
        static final String firstName =                     "NAME_FIRST";
        static final String lastName =                      "NAME_LAST";
        static final String birthDate =                     "DATE_BIRTH";
        static final String ssnLast4 =                      "SOCIAL_SECURITY_NUMBER_LAST_FOUR";
        static final String areaCode =                      "RESIDENTIAL_PHONE_AREACODE";
        static final String phoneNumber =                   "RESIDENTIAL_PHONE_NUMBER";
        static final String streetAddress =                 "MAILING_ADDRESS_LINE_ONE";
        static final String cityName =                      "MAILING_ADDRESS_CITY";
        static final String stateName =                     "MAILING_ADDRESS_STATE";
        static final String zipCode =                       "MAILING_ADDRESS_ZIPCODE";
    }

    public static class logging {
        public static final String testInformation =        "--------------------------------------------\n" +
                                                            "|| Test:\t\t\t%s\n|| Class:\t\t\t%s\n|| Desc:\t\t\t%s\n" +
                                                            "|| ENV:\t\t\t\t%s\n|| Browser:\t\t\t%s\n" +
                                                            "--------------------------------------------";
        public static final String resultInformation =      "--------------------------------------------\n" +
                                                            "|| Result:\t\t\t\t%s\n" +
                                                            "--------------------------------------------";
        static final String accountInformation =            "Rest Account Information:\n%s\n" +
                                                            "--------------------------------------------";
        public static final String elementDisplayed =       "Element Displayed:\t\t%s\n" +
                                                            "--------------------------------------------\n";
        public static final String elementClickable =       "Element Clickable:\t\t%s\n" +
                                                            "--------------------------------------------\n";
        public static final String loginCredentials =       "Using Account:\t\t\t%s/%s\n" +
                                                            "--------------------------------------------\n";
    }
}
