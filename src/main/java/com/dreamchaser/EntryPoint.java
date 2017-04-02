package com.dreamchaser;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;

import static com.dreamchaser.registration.RegistrationForm.buildRegistrationForm;
import static java.lang.Boolean.*;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class EntryPoint extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Layout mainLayout = new HorizontalLayout();
        mainLayout.setHeight("95%");
        mainLayout.setWidth("95%");

        Layout horzLayoutForMenu = new HorizontalLayout();
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Student Registration", menuItem -> {
            mainLayout.addComponent(buildRegistrationForm());
        });
        menuBar.addItem("Student Inbox", null);
        menuBar.addItem("Sponsers Near-By", null);
        menuBar.addItem("Sponser Registration", null);
        menuBar.addItem("Sponsor Inbox", null);
        menuBar.addItem("Students Near-By", null);
        menuBar.setStyleName(ValoTheme.MENUBAR_BORDERLESS);

        horzLayoutForMenu.addComponent(menuBar);
        mainLayout.addComponent(horzLayoutForMenu);
        setContent(mainLayout);
    }


    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = EntryPoint.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
