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

    HorizontalLayout menuAction = null;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSpacing(FALSE);

        HorizontalLayout menubar = new HorizontalLayout();
        setUpMenu(menubar);
        mainLayout.addComponent(menubar);
        menuAction = new HorizontalLayout();
        menuAction.setSizeFull();
        mainLayout.addComponent(menuAction);

        setContent(mainLayout);
    }

    private void setUpMenu(Layout layout) {
        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Student Registration", menuItem -> {
            menuAction.removeAllComponents();
            menuAction.addComponent(buildRegistrationForm());
        });
        menuBar.addItem("Student Inbox",menuItem -> {
            defaultTempWIPTemplate();
        });
        menuBar.addItem("Sponsers Near-By", menuItem -> {
            defaultTempWIPTemplate();
        });
        menuBar.addItem("Sponser Registration", menuItem -> {
            defaultTempWIPTemplate();
        });
        menuBar.addItem("Sponsor Inbox", menuItem -> {
            defaultTempWIPTemplate();
        });
        menuBar.addItem("Students Near-By", menuItem -> {
            defaultTempWIPTemplate();
        });
        menuBar.setStyleName(ValoTheme.MENUBAR_BORDERLESS);
        layout.addComponent(menuBar);
    }

    private void defaultTempWIPTemplate() {
        menuAction.removeAllComponents();
        menuAction.addComponent(new TextField("Work In Progress"));
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = EntryPoint.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
