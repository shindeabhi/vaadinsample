package com.dreamchaser.registration;

import com.vaadin.ui.*;

/**
 * Created by user on 4/1/2017.
 */
public class RegistrationForm {

    public static Layout buildRegistrationForm() {
        FormLayout form = new FormLayout();
        form.setSizeFull();
        addComponent(form, getTextField("First Name:"));
        addComponent(form, getTextField("Last Name:"));
        addComponent(form, getTextField("Email:"));
        addComponent(form, getTextField("Contact No:"));
        addComponent(form, getTextField("State:"));
        addComponent(form, getTextField("City:"));
        addComponent(form, getTextField("PIN:"));
        addComponent(form, getTextArea("Address"));
        addComponent(form, getTextArea("About Me"));

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button submit = new Button("Submit");
        Button clearData = new Button("Clear Data");
        clearData.addClickListener(clickEvent -> clearAllDataFields(form));
        horizontalLayout.addComponent(submit);
        horizontalLayout.addComponent(clearData);
        addComponent(form, horizontalLayout);

        return form;
    }

    private static void clearAllDataFields(FormLayout layout) {
        int componentCount = layout.getComponentCount();
        for (Integer i = 0; i < componentCount; i++) {
            Component component = layout.getComponent(i);
            if (component instanceof TextField) {
                ((TextField) component).clear();
            }
            else if(component instanceof TextArea){
                ((TextArea) component).clear();
            }
        }
    }

    private static TextField getTextField(String caption) {
        final TextField field = new TextField();
        field.setCaption(caption);
        field.setRequiredIndicatorVisible(Boolean.TRUE);
        return field;
    }

    private static TextArea getTextArea(String caption) {
        final TextArea field = new TextArea();
        field.setCaption(caption);
        field.setRequiredIndicatorVisible(Boolean.TRUE);
        return field;
    }

    private static void addComponent(Layout layout, Component component) {
        layout.addComponent(component);
    }


}
