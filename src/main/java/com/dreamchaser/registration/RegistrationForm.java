package com.dreamchaser.registration;

import com.vaadin.ui.*;

/**
 * Created by user on 4/1/2017.
 */
public class RegistrationForm {

    public static Layout buildRegistrationForm() {
        FormLayout formLayout = new FormLayout();
        final TextField firstName = new TextField();
        firstName.setCaption("First Name:");
        addComponent(formLayout, firstName);

        final TextField lastName = new TextField();
        lastName.setCaption("Last Name:");
        addComponent(formLayout, lastName);

        final TextField email = new TextField();
        email.setCaption("Email:");
        addComponent(formLayout, email);

        final TextField contactNo = new TextField();
        contactNo.setCaption("Contact No:");
        addComponent(formLayout, contactNo);

        final RichTextArea defineYou = new RichTextArea();
        defineYou.setCaption("Tell us something about yourself");
        addComponent(formLayout, defineYou);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Button submit = new Button("Submit");
        submit.addClickListener(e -> {
            formLayout.addComponent(new Label("Thanks " + firstName.getValue()
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

        addComponent(formLayout, horizontalLayout);

        return formLayout;
     }

    private static void addComponent(Layout layout, Component component) {
        layout.addComponent(component);
    }


}
