package org.ghc.utils;

import org.ghc.utils.helpers.KPAUILink;

import static org.ghc.utils.KPAUIPageConstants.EveryShadeHelpSection.*;
import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.TransferPrescriptions.LINKTEXT_TRANSFER_RX_MEMBER_ID_HELP;
import static org.ghc.utils.KPAUIPageConstants.ExpectedLinksAndHeaders.TransferPrescriptions.TRANSFER_RX_MEMBER_ID_HELP_LINK_DESTINATION;
import static org.ghc.utils.KPAUIPageConstants.UnAuthenticatedHomePageTiles.DoctorsAndLocationsTile.doctorsAndLocationsTileLinkDestination;
import static org.ghc.utils.KPAUIPageConstants.UnAuthenticatedHomePageTiles.DoctorsAndLocationsTile.doctorsAndLocationsTileLinkText;
import static org.ghc.utils.KPAUIPageConstants.UnAuthenticatedHomePageTiles.ShopOurPlansTile.shopOurPlansTileLinkDestination;
import static org.ghc.utils.KPAUIPageConstants.UnAuthenticatedHomePageTiles.ShopOurPlansTile.shopOurPlansTileLinkText;

public class KPAUIPageConstants {
    public static final String baseBoth = "https://wa.*.kaiserpermanente.org";

    // Authenticated Homepage Cards Link Constants
    public static final KPAUILink SHADE_HELP_SECTION_EMAILEXPECTED_LINK = new KPAUILink(HELP_SECTION_EMAIL_LINKTEXT, HELP_SECTION_EMAIL_LINK_DESTINATION_Wa);
    public static final KPAUILink SHADE_HELP_SECTION_EMAILEXPECTED_MEM_LINK = new KPAUILink(HELP_SECTION_EMAIL_LINKTEXT, helpSectionEmailLinkDestination);

    //Tile Links
    public static final KPAUILink SHOP_HEALTH_PLANS_TILE_EXPECTED_LINK = new KPAUILink(shopOurPlansTileLinkText, shopOurPlansTileLinkDestination);
    public static final KPAUILink DOCTORS_AND_LOCATIONS_TILE_EXPECTED_LINK = new KPAUILink(doctorsAndLocationsTileLinkText, doctorsAndLocationsTileLinkDestination);

    // Transfer RX Page Links
    public static final KPAUILink TRANSFER_RX_MEMBER_ID_HELP_LINK = new KPAUILink(LINKTEXT_TRANSFER_RX_MEMBER_ID_HELP, TRANSFER_RX_MEMBER_ID_HELP_LINK_DESTINATION);

    // Form Labels
    // Transfer RX Form Labels
    public class FormLabels {
        public static final String FIRST_NAME_FORM_LABEL_EXPECTED_STRING = "FIRST NAME";
        public static final String FIRST_NAME_FORM_PLACEHOLDER = "Enter your first name";
        public static final String LAST_NAME_FORM_LABEL_EXPECTED_STRING = "LAST NAME";
        public static final String LAST_NAME_FORM_PLACEHOLDER = "Enter your last name";
        public static final String MEMBER_ID_FORM_LABEL_EXPECTED_STRING = "MEMBER ID";
        public static final String MEMBER_ID_FORM_PLACEHOLDER = "Enter your member ID number";
        public static final String DATE_OF_BIRTH_FORM_LABEL_EXPECTED_STRING = "DATE OF BIRTH";
        public static final String DATE_OF_BIRTH_FORM_PLACEHOLDER = "MM/DD/YYYY";
        public static final String PHONE_NUMBER_FORM_LABEL_EXPECTED_STRING = "PHONE";
        public static final String PHONE_NUMBER_FORM_PLACEHOLDER = "ex., 555-555-5555";
        public static final String PHONE_EXT_FORM_LABEL_EXPECTED_STRING = "EXT.";
        public static final String PERMISSION_BUTTONS_LABEL_EXPECTED_STRING = "OK TO LEAVE A DETAILED MESSAGE AT THIS NUMBER? *";
        public static final String MESSAGE_PERMS_YES_LABEL_EXPECTED_STRING = "Yes";
        public static final String MESSAGE_PERMS_NO_LABEL_EXPECTED_STRING = "No";
        public static final String CURRENT_PHARMACY_LABEL_EXPECTED_STRING = "CURRENT PHARMACY";
        public static final String CURRENT_PHARMACY_FORM_PLACEHOLDER = "Enter your current pharmacy";
        public static final String PHARMACY_PHONE_LABEL_EXPECTED_STRING = "PHARMACY PHONE";
        public static final String PHARMACY_PHONE_FORM_PLACEHOLDER = "ex., 555-555-5555";
        public static final String MEDICATION_NAME_LABEL_EXPECTED_STRING = "MEDICATION NAME";
        public static final String MEDICATION_NAME_FORM_PLACEHOLDER = "Enter the medication name";
        public static final String MEDICATION_NUMBER_LABEL_EXPECTED_STRING = "MEDICATION NUMBER";
        public static final String MEDICATION_NUMBER_FORM_PLACEHOLDER = "Enter the prescription number";
        public static final String MEDICATION_STRENGTH_LABEL_EXPECTED_STRING = "STRENGTH";
        public static final String MEDICATION_STRENGTH_FORM_PLACEHOLDER = "Enter the Strength";
        public static final String MEDICATION_SUPPLY_LABEL_EXPECTED_STRING = "SUPPLY";
        public static final String DOCTOR_NAME_LABEL_EXPECTED_STRING = "DOCTOR NAME";
        public static final String DOCTOR_NAME_FORM_PLACEHOLDER = "Enter the doctor name";
        public static final String DOCTOR_PHONE_LABEL_EXPECTED_STRING = "DOCTOR PHONE";
        public static final String CLEAR_FORM_LABEL_EXPECTED_STRING = "Clear Form";
        public static final String NEXT_BUTTON_LABEL_EXPECTED_STRING = "Next";
        public static final String CANCEL_BUTTON_EXPECTED_STRING = "Cancel";
        public static final String SUBMIT_BUTTON_EXPECTED_STRING = "Submit";
        public static final String ADD_RX_BUTTON_LABEL_EXPECTED_STRING = "Add A Prescription";

    }

    // Form Warning Messages
    public class FormWarnings {
        public static final String INVALID_CHARS_IN_STRING = "Invalid entry";
        public static final String SHORT_STRING_WARNING = "Doesn’t meet minimum length";
        public static final String LONG_STRING_WARNING = "Exceeds maximum length";

    }

    public class ExpectedLinksAndHeaders {
        public class EveryAuthenticatedPageHeader {
            public static final String btnSignOut = "//core-header/div[1]/div/div[2]/div[1]/div/span[2]/button";
        }

        public class EveryUnAuthenticatedPageHeader {
            public static final String forgotPasswordLink = ".header-right .body-3";
            public static final String signOnButtonText = "Sign on";
        }

        public class TransferPrescriptions {
            public static final String TRANSFER_PRESCRIPTION_PAGE_HEADER_EXPECTED_STRING = "Prescription Transfer Request";
            public static final String TRANSFER_PRESCRIPTION_PAGE_SUBHEADER_EXPECTED_STRING = "Transfer your prescriptions in a few easy steps.";
            public static final String TRANSFER_PRESCRIPTION_PAGE_BODY_EXPECTED_STRING = "Do you use a non-Kaiser Permanente pharmacy? Use this form to transfer your prescriptions to Kaiser Permanente.";
            public static final String LINKTEXT_TRANSFER_RX_LEARN_MORE = "LEARN MORE";
            public static final String TRANSFER_RX_LEARN_MORE_LINK_DESTINATION = baseBoth + "/html/public/pharmacy";
            public static final String LINKTEXT_TRANSFER_RX_MEMBER_ID_HELP = "Where can I find my member ID?";
            public static final String TRANSFER_RX_MEMBER_ID_HELP_LINK_DESTINATION = "";
            public static final String LINKTEXT_TRANSFER_RX_FAIL_MEMBER_SERVICES = "LEARN MORE";
            public static final String TRANSFER_RX_FAIL_MEMBER_SERVICES_LINK_DESTINATION = baseBoth + "/html/public/pharmacy";
            public static final String DRUGS_YOUVE_ADDED_HEADER_EXPECTED_TEXT = "Prescriptions You've added";
        }
    }

    public class EveryShadeHelpSection {
        public static final String HELP_SECTION_EMAIL_LINKTEXT = "Or send Us an Email";
        public static final String helpSectionEmailLinkDestination = baseBoth + "/html/public/customer-service/e-mail";
        public static final String HELP_SECTION_EMAIL_LINK_DESTINATION_Wa = baseBoth + "/html/public/customer-service/e-mail";

    }

    public class UnAuthenticatedHomePageTiles {
        public class ShopOurPlansTile {
            public static final String shopOurPlansTileLinkText = "Shop health plans";
            public static final String shopOurPlansTileLinkDestination = baseBoth + "/html/public/health-plans";
        }

        public class DoctorsAndLocationsTile {
            public static final String doctorsAndLocationsTileLinkText = "Find doctors and locations";
            public static final String doctorsAndLocationsTileLinkDestination = "^https://wa-member-?\\w{0,3}.kaiserpermanente.org/find-a-doctor$";
        }
    }

    public class EveryPageHeader {
        public static final String signOffButtonText = "Sign off";
        public static final String searchButtonText = "Search";
    }

    public class BenefitsUsageStatusAndCovDocsPage {
        public static final String groupNameRegex = ".+";
        public static final String groupNumberRegex = "^^(\\d|\\w)+$";
    }

    public class OnBoardingPages {
        public class SvaQuizPage {
            public static final String svaRightAnswer1 = ".onboarding-input:first-child .form-check:last-child input";
            public static final String svaRightAnswer2 = ".onboarding-input:nth-child(2) .form-check:last-child input";
            public static final String svaRightAnswer3 = ".onboarding-input:nth-child(3) .form-check:last-child input";
            public static final String svaRightAnswer4 = ".form-check:nth-child(5) .form-check-input";
            public static final String svaWrongAnswer1 = ".onboarding-input:first-child .form-check:first-child input";
            public static final String svaWrongAnswer2 = ".onboarding-input:nth-child(2) .form-check:first-child input";
            public static final String svaWrongAnswer3 = ".onboarding-input:nth-child(3) .form-check:first-child input";
            public static final String svaWrongAnswer4 = ".form-check:first-child .form-check-input";
        }
    }
}
