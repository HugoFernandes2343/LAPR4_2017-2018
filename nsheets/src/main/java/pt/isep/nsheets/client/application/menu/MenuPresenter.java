package pt.isep.nsheets.client.application.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import pt.isep.nsheets.client.event.ContentPushEvent;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.data.component.CategoryComponent;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import java.util.List;
import javafx.scene.control.ComboBox;
import pt.isep.nsheets.client.application.CurrentMenu;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.place.NameTokens;
import pt.isep.nsheets.shared.services.NicknameDTO;
import pt.isep.nsheets.shared.services.UserDTO;
import static pt.isep.nsheets.shared.services.UserTypeDTO.ADMIN;
import static pt.isep.nsheets.shared.services.UserTypeDTO.USER;
import pt.isep.nsheets.shared.services.UsersService;
import pt.isep.nsheets.shared.services.UsersServiceAsync;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {

    private MaterialComboBox comboBoxActive;
    private MaterialComboBox comboBoxNotActive;

    @NameToken(NameTokens.menu)
    interface MyView extends View, HasUiHandlers<MenuUiHandlers> {

        void addClickHandler(ClickHandler ch);

        MaterialLink getBtnLogout();

        MaterialLink getSingUp();

        MaterialLink getBtnLogin();

        MaterialImage getUserImage();

        MaterialLabel getUserName();

        void addClicker(ClickHandler ch);

    }

    private PlaceManager placeManager;

    @Inject
    MenuPresenter(EventBus eventBus, MyView view, PlaceManager placeManager) {
        super(eventBus, view);

        getView().setUiHandlers(this);

        CurrentMenu.setMps(this);

        CurrentMenu.MenuReload();

        this.placeManager = placeManager;

        getView().addClicker((event) -> {
            editUserProfile();
        });

        getView().addClickHandler((event) -> {

            CurrentUser.logout();
            reloadUser();

        });

    }

    @Override
    public void reloadUser() {

        if (CurrentUser.isIsLoggedIn() && CurrentUser.getCurrentUser().getUserType() == USER) {
            this.getView().getUserName().setText(CurrentUser.getCurrentUser().getNickname().getNickName());
            this.getView().getUserName().setVisible(true);
            this.getView().getUserImage().setVisible(true);
            this.getView().getBtnLogin().setVisible(false);
            this.getView().getBtnLogout().setVisible(true);
            this.getView().getSingUp().setVisible(false);
        } else if (CurrentUser.isIsLoggedIn() && CurrentUser.getCurrentUser().getUserType() == ADMIN) {
            this.getView().getUserName().setText(CurrentUser.getCurrentUser().getNickname().getNickName());
            this.getView().getUserName().setVisible(true);
            this.getView().getUserImage().setVisible(true);
            this.getView().getBtnLogin().setVisible(false);
            this.getView().getBtnLogout().setVisible(true);
            this.getView().getSingUp().setVisible(false);
        } else {
            this.getView().getUserName().setText("");
            this.getView().getUserName().setVisible(false);
            this.getView().getUserImage().setVisible(false);
            this.getView().getBtnLogin().setVisible(true);
            this.getView().getBtnLogout().setVisible(false);
            this.getView().getSingUp().setVisible(true);
        }

    }

    protected void onBind() {
        super.onBind();
    }

    @Override
    public void setContentPush() {
        ContentPushEvent.fire(this);
    }

    private void editUserProfile() {

        MaterialWindow window = new MaterialWindow("Profile Editor");
        window.setMaximize(true);
        window.setSeparator(true);
        window.setOverflow(Style.Overflow.SCROLL);
        MaterialLabel lblFName = new MaterialLabel("First Name");
        MaterialLabel lblLName = new MaterialLabel("Last Name");
        MaterialLabel lblNickname = new MaterialLabel("Nickname");
        MaterialButton deleteAccountButton = new MaterialButton("Delete Account");
        MaterialButton saveOkButton = new MaterialButton("Apply Changes");
        MaterialButton saveCancelButton = new MaterialButton("Cancel");
        MaterialButton activateUsers = new MaterialButton("Activate Account");
        MaterialButton deactivateUsers = new MaterialButton("Deactivate Account");
        MaterialTextBox firstNameEditor = new MaterialTextBox(CurrentUser.getCurrentUser().getName().getFirstName());
        MaterialTextBox lastNameEditor = new MaterialTextBox(CurrentUser.getCurrentUser().getName().getLastName());
        MaterialTextBox nicknameEditor = new MaterialTextBox(CurrentUser.getCurrentUser().getNickname().getNickName());
        
        comboBoxActive = new MaterialComboBox();
        comboBoxNotActive = new MaterialComboBox();
        comboBoxActive.setLabel("Activated Users");
        comboBoxNotActive.setLabel("Deactivated Users");

        
        
        listUsers();

        saveOkButton.setSize(ButtonSize.MEDIUM);
        saveCancelButton.setSize(ButtonSize.MEDIUM);
        deleteAccountButton.setSize(ButtonSize.MEDIUM);

        saveOkButton.setRight(0);
        saveCancelButton.setRight(400);

        window.add(lblFName);
        window.add(firstNameEditor);
        window.add(lblLName);
        window.add(lastNameEditor);
        window.add(lblNickname);
        window.add(nicknameEditor);
        window.add(deleteAccountButton);
        window.add(saveOkButton);
        window.add(saveCancelButton);
        
        window.add(comboBoxActive);
        window.add(deactivateUsers);
        window.add(comboBoxNotActive);
        window.add(activateUsers);

        deactivateUsers.setPaddingRight(200);
        deactivateUsers.setPaddingLeft(200);

        activateUsers.setPaddingRight(200);
        activateUsers.setPaddingLeft(220);

        comboBoxActive.setPaddingLeft(5);
        comboBoxActive.setPaddingRight(50);
//        comboBoxActive.setPaddingTop(50);
//        comboBoxActive.setPaddingBottom(50);
//
        comboBoxNotActive.setPaddingLeft(5);
        comboBoxNotActive.setPaddingRight(50);
//        comboBoxNotActive.setPaddingTop(50);
//        comboBoxNotActive.setPaddingBottom(50);

        if (CurrentUser.getCurrentUser().getUserType() == USER) {
            comboBoxActive.setVisible(false);
            comboBoxNotActive.setVisible(false);
            deactivateUsers.setVisible(false);
            activateUsers.setVisible(false);
        }
        window.open();
        deactivateUsers.addClickHandler((event) -> {
            List<UserDTO> listuser = comboBoxActive.getSelectedValue();
            UserDTO dto = listuser.get(0);
            dto.deactivateUser();

            UsersServiceAsync usersServiceAsync = GWT.create(UsersService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error deactivating user");
                }

                @Override
                public void onSuccess(Boolean result) {
                    MaterialToast.fireToast("User deactivated");
                }
            };

            usersServiceAsync.deactivateUser(dto, callback);
        });

        activateUsers.addClickHandler((event) -> {
            List<UserDTO> listuser = comboBoxNotActive.getSelectedValue();
            UserDTO dto = listuser.get(0);
            dto.activateUser();

            UsersServiceAsync usersServiceAsync = GWT.create(UsersService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error activating user");
                }

                @Override
                public void onSuccess(Boolean result) {
                    MaterialToast.fireToast("User activated");
                }
            };

            usersServiceAsync.activateUser(dto, callback);
            comboBoxActive.reload();
            comboBoxNotActive.reload();
            listUsers();
        });

        saveOkButton.addClickHandler((event) -> {

            String firstname = firstNameEditor.getText();
            String lastname = lastNameEditor.getText();
            String nick = nicknameEditor.getText();
            NicknameDTO nickname = new NicknameDTO(nick);

            if (nick != "" || firstname != "" || lastname != "") {
                CurrentUser.getCurrentUser().setName(firstname, lastname);
                CurrentUser.getCurrentUser().setNickname(nick);

                UsersServiceAsync usersServiceAsync = GWT.create(UsersService.class);

                AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        MaterialToast.fireToast("No Changes Were Made");
                    }

                    @Override
                    public void onSuccess(UserDTO result) {
                        MaterialToast.fireToast("Profile Updated");
                    }
                };

                usersServiceAsync.updateUser(CurrentUser.getCurrentUser(), callback);

                reloadUser();

                window.close();
            } else {
                MaterialToast.fireToast("You need to fill all fields");
            }
        });

        saveCancelButton.addClickHandler((event) -> {
            window.close();
        });

        deleteAccountButton.addClickHandler((event) -> {

            UsersServiceAsync usersServiceAsync = GWT.create(UsersService.class);

            AsyncCallback<Boolean> callback = new AsyncCallback<Boolean>() {
                @Override
                public void onFailure(Throwable caught) {
                    MaterialToast.fireToast("Error Deleting Account");
                }

                @Override
                public void onSuccess(Boolean result) {
                    MaterialToast.fireToast("Account Deleted");
                    window.close();
                    PlaceRequest placeRequest = new PlaceRequest.Builder()
                            .nameToken(NameTokens.login)
                            .build();
                    placeManager.revealPlace(placeRequest);
                    CurrentUser.setIsLoggedIn(false);
                    reloadUser();

                }
            };

            usersServiceAsync.deleteUser(CurrentUser.getCurrentUser().getEmail().getEmail(), callback);
        });

    }

    public void listUsers() {

        UsersServiceAsync usersServiceAsync = GWT.create(UsersService.class);

        AsyncCallback<List<UserDTO>> callback = new AsyncCallback<List<UserDTO>>() {
            @Override
            public void onFailure(Throwable caught) {
                MaterialToast.fireToast("An internal error has occurred while loading the users." + caught.getMessage());
            }

            @Override
            public void onSuccess(List<UserDTO> result) {
                if (!result.iterator().hasNext()) {
                    MaterialToast.fireToast("There are no registered users");
                } else {
                    for (UserDTO userDTO : result) {
                        if (userDTO.isActivate() == true) {
                            comboBoxActive.addItem(userDTO);
                        } else if (userDTO.isActivate() == false) {
                            comboBoxNotActive.addItem(userDTO);
                        }
                    }

                }
            }

        };
        usersServiceAsync.getUsers(callback);
    }

}
