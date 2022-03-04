package com.automation.common;

public enum UiLabel {

    MYACCOUNT ("My account"),
    ALREADYREGISTERED("Already registered?"),
    WelcomeToYourAccount("Welcome to your account. Here you can manage all of your personal information and orders."),
    ProductName("Faded Short Sleeve T-shirts"),
   ProceedToCheckoutButtonName("Proceed to checkout");

    private final String definition;

UiLabel (String definition)
{
    this.definition = definition;
}

    public String getDefinition() {
        return definition;
    }
}
