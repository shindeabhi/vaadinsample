package com.dreamchaser.registration;

import com.vaadin.ui.*;

/**
 * Created by user on 4/1/2017.
 */
public class RegistrationForm {

    public static Layout buildRegistrationForm() {
        FormLayout form = new FormLayout();
        form.setSizeFull();

        final TextField firstName = new TextField();
        firstName.setCaption("First Name:");
        addComponent(form, firstName);

        final TextField lastName = new TextField();
        lastName.setCaption("Last Name:");
        addComponent(form, lastName);

        final TextField email = new TextField();
        email.setCaption("Email:");
        addComponent(form, email);

        final TextField contactNo = new TextField();
        contactNo.setCaption("Contact No:");
        addComponent(form, contactNo);

        final RichTextArea defineYou = new RichTextArea();
        defineYou.setCaption("Tell us something about yourself");
        // addComponent(form, defineYou);

        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Button submit = new Button("Submit");
        submit.addClickListener(e -> form.addComponent(new Label("Thanks " + firstName.getValue()
                + " for submitting for details!!!")));

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

        addComponent(form, horizontalLayout);

        return form;
    }

    private static void addComponent(Layout layout, Component component) {
        layout.addComponent(component);
    }


}
