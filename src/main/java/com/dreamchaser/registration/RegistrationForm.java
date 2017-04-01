package com.dreamchaser.registration;

import com.vaadin.ui.*;

/**
 * Created by user on 4/1/2017.
 */
public class RegistrationForm {

    public static void buildRegistrationForm(Layout layout) {
        final TextField firstName = new TextField();
        firstName.setCaption("First Name:");
        addComponent(layout, firstName);

        final TextField lastName = new TextField();
        lastName.setCaption("Last Name:");
        addComponent(layout, lastName);

        final TextField email = new TextField();
        email.setCaption("Email:");
        addComponent(layout, email);

        final TextField contactNo = new TextField();
        contactNo.setCaption("Contact No:");
        addComponent(layout, contactNo);

        final RichTextArea defineYou = new RichTextArea();
        defineYou.setCaption("Tell us something about yourself");
        addComponent(layout, defineYou);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Button submit = new Button("Submit");
        submit.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + firstName.getValue()
                    + " for submitting for details!!!"));
        });

        Button clearData = new Button("Clear Data");
        clearData.addClickListener(clickEvent -> {
            firstName.clear();
            lastName.clear();
            email.clear();
            contactNo.clear();
            defineYou.clear();
        });

        horizontalLayout.addComponent(submit);
        horizontalLayout.addComponent(clearData);

        addComponent(layout,horizontalLayout);

        // addComponent(layout, submit);
        // addComponent(layout,clearData);

    }

    private static void addComponent(Layout layout, Component component) {
        layout.addComponent(component);
    }


}
