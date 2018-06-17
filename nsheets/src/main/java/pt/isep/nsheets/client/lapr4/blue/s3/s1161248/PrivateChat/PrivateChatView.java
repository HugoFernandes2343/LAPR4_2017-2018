
package pt.isep.nsheets.client.lapr4.blue.s3.s1161248.PrivateChat;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.*;
import pt.isep.nsheets.client.application.CurrentUser;
import pt.isep.nsheets.client.lapr4.green.s1.s1160570.application.login.LoginModule;
import pt.isep.nsheets.shared.services.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PrivateChatView extends ViewImpl implements PrivateChatPresenter.MyView {


    @UiField
    MaterialCard card;

    @UiField
    MaterialLink openChat;

    @UiField
    MaterialLink deleteChat;

    @UiField
    MaterialButton changeChat;

    @UiField
    MaterialButton newChat;

    @UiField
    MaterialButton invites;

    @UiField
    MaterialButton addFriends;

    @UiField
    HTMLPanel htmlPanel;


    interface Binder extends UiBinder<Widget, PrivateChatView> {
    }


    @Inject
    PrivateChatView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        UserDTO user = CurrentUser.getCurrentUser();
        if (!user.getChatList().isEmpty()) {
            for (ChatDTO chat : user.getChatList()) {
                if (!chat.isAccepted()) {
                    invites.setBackgroundColor(Color.RED);
                }
            }
        }

        newChat.addClickHandler(clickEvent ->
        {
            NewChatView newChat = new NewChatView(user);
        });
        invites.addClickHandler(clickEvent ->
        {
            PendingInvitesView pendingInvites = new PendingInvitesView(user);
        });
    }

    //antigo código

    /**
     * UserDTO user = CurrentUser.getCurrentUser();
     * MaterialRow chatRow = new MaterialRow();
     * <p>
     * for(
     * ChatDTO chat :user.getChatList())
     * <p>
     * {
     * MaterialColumn chatCol = new MaterialColumn();
     * chatCol.setGrid("14");
     * MaterialCard card = new MaterialCard();
     * card.setBackgroundColor(Color.GREEN_DARKEN_1);
     * MaterialCardContent cardContent = new MaterialCardContent();
     * cardContent.setTextColor(Color.WHITE);
     * MaterialCardTitle title = new MaterialCardTitle();
     * title.setText(chat.getName());
     * MaterialLink open = new MaterialLink();
     * open.setText("Open");
     * MaterialLink remove = new MaterialLink();
     * remove.setText("Remove");
     * cardContent.add(title);
     * cardContent.add(open);
     * cardContent.add(remove);
     * card.add(cardContent);
     * chatCol.add(card);
     * chatRow.add(chatCol);
     * chatPanel.add(chatRow);
     * }
     * <p>
     * <p>
     * if(!user.getChatList().
     * <p>
     * isEmpty())
     * <p>
     * {
     * for (ChatDTO chat : user.getChatList()) {
     * if (!chat.isAccepted()) {
     * invites.setBackgroundColor(Color.RED);
     * }
     * }
     * }
     * newChat.addClickHandler(clickEvent ->
     * <p>
     * {
     * NewChatView newChat = new NewChatView(user);
     * <p>
     * });
     * <p>
     * invites.addClickHandler(clickEvent ->
     * <p>
     * {
     * PendingInvitesView pendingInvites = new PendingInvitesView(user);
     * });
     * <p>
     * /**
     * open.addClickHandler(clickEvent -> {
     * ChatView pendingInvites = new ChatView(user, "chat");
     * });
     */


    @Override
    protected void onAttach() {
        super.onAttach();
    }


    private MaterialCard createCard(ChatDTO chat) {
        UserDTO user = CurrentUser.getCurrentUser();
        MaterialCard card = new MaterialCard();
        card.setBackgroundColor(Color.GREEN_DARKEN_1);
        MaterialCardContent cardContent = new MaterialCardContent();
        cardContent.setTextColor(Color.WHITE);

        MaterialCardTitle cardTitle = new MaterialCardTitle();
        cardTitle.setText(chat.getName());
        cardTitle.setIconType(IconType.DONE);
        cardTitle.setIconPosition(IconPosition.RIGHT);


        MaterialLabel labelDescritpion = new MaterialLabel();
        labelDescritpion.setText("Number of Messages " + chat.getMessages().size());

        MaterialCardAction cardAction = new MaterialCardAction();


        MaterialLink editLink = new MaterialLink();
        editLink.setText("Open");
        editLink.setIconType(IconType.EDIT);
        editLink.setIconColor(Color.INDIGO);
        editLink.setTextColor(Color.WHITE);

        editLink.addClickHandler(event -> {
            MaterialWindow window = new MaterialWindow(chat.getName());

            for (MessageDTO dto : chat.getMessages()) {

                MaterialCard massageCard = new MaterialCard();
                MaterialLabel userLabel = new MaterialLabel();
                MaterialLabel dateLabel = new MaterialLabel();
                MaterialLabel message = new MaterialLabel();
                message.setFontSize("1.2em");
                dateLabel.setFontSize("0.5em");
                userLabel.setText(dto.getUser());
                dateLabel.setText(dto.getDate().toString());
                message.setText(dto.getText());
                massageCard.add(userLabel);
                massageCard.add(dateLabel);
                massageCard.add(message);
                if(userLabel.getText().equals(user.getName().getFirstName())){
                    massageCard.setBackgroundColor(Color.GREEN_DARKEN_1);
                }
                window.add(massageCard);

            }

            MaterialTextArea textArea = new MaterialTextArea();
            window.add(textArea);
            MaterialButton sendButton = new MaterialButton("Send");
            window.add(sendButton);
            //aqui vai ser para guardar as mensagens inseridas pelo utilizador
            sendButton.addClickHandler(sendEvet -> {
                if (!textArea.getText().isEmpty()) {
                    MessageDTO message = new MessageDTO(user.getName().getFirstName(), textArea.getText(), new Date());
                    chat.getMessages().add(message);

                    UsersServiceAsync userSvc = GWT.create(UsersService.class);
                    // Set up the callback object.
                    AsyncCallback<UserDTO> callback = new AsyncCallback<UserDTO>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(UserDTO user) {
                            MaterialToast.fireToast("Message", "rounded");
                            textArea.clear();
                        }
                    };

                    userSvc.saveUser(user, callback);


                    // Set up the callback object.
                    AsyncCallback<List<UserDTO>> callback1 = new AsyncCallback<List<UserDTO>>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            MaterialToast.fireToast("Error Aqui! " + caught.getMessage());
                        }

                        @Override
                        public void onSuccess(List<UserDTO> users) {
                            MaterialToast.fireToast("Message", "rounded");
                            for (UserDTO u : users) {
                                if (!u.equals(user)) {
                                    for (ChatDTO c : u.getChatList()) {
                                        if (c.equals(chat)) {
                                            c.getMessages().add(message);
                                            AsyncCallback<UserDTO> callbackU = new AsyncCallback<UserDTO>() {
                                                @Override
                                                public void onFailure(Throwable caught) {
                                                    MaterialToast.fireToast("Error! " + caught.getMessage());
                                                }

                                                @Override
                                                public void onSuccess(UserDTO user) {
                                                    MaterialToast.fireToast("Outro Chat", "rounded");
                                                }
                                            };

                                            userSvc.saveUser(u, callbackU);

                                        }
                                    }
                                }
                            }
                        }
                    };

                    userSvc.getAllUser(callback1);
                }
            });
            /**saveEditorButton.addClickHandler(event2 -> {
             TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

             AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
            @Override public void onFailure(Throwable caught) {
            MaterialToast.fireToast("Error Saving Task ");
            }

            @Override public void onSuccess(TaskDTO result) {
            MaterialToast.fireToast("Task Edited");

            }
            };

             TaskDTO editedTask = new TaskDTO(titleEditor.getValue(), descEditor.getValue(), Integer.parseInt(listPriority.getValue()), Integer.parseInt(perceEditor.getValue()));
             tasksServiceAsync.editTask(editedTask, oldName, callback);

             cardTitle.setText(editedTask.getTitle());
             labelDescritpion.setText(editedTask.getDescription());
             labelPriority.setText("Priority:" + editedTask.getPriority());
             labelPercentage.setText("Percentage of completion: " + editedTask.getPercentage() + "%");
             window.close();
             });*/
            window.open();

        });
        MaterialLink deleteLink = new MaterialLink();
        deleteLink.setText("Delete");
        deleteLink.setIconType(IconType.DELETE);
        deleteLink.setIconColor(Color.GREY);
        deleteLink.setTextColor(Color.WHITE);
        deleteLink.addClickHandler(event -> {

            //aqui vai ser para remover o chat da lista do utilizador
            /** TasksServiceAsync tasksServiceAsync = GWT.create(TasksService.class);

             AsyncCallback<TaskDTO> callback = new AsyncCallback<TaskDTO>() {
            @Override public void onFailure(Throwable caught) {
            MaterialToast.fireToast("Error deleting Task ");
            }

            @Override public void onSuccess(TaskDTO result) {
            MaterialToast.fireToast(task.getTitle() + " deleted");
            card.setVisible(false);
            }
            };

             tasksServiceAsync.deleteTask(task, callback);*/
        });

        cardContent.add(cardTitle);
        cardContent.add(labelDescritpion);

        cardAction.add(editLink);
        cardAction.add(deleteLink);

        card.add(cardContent);
        card.add(cardAction);


        return card;
    }

    @Override
    public void setContents(List<ChatDTO> contents) {
        int colCount = 1;

        MaterialRow row = null;

        htmlPanel.clear();

        for (ChatDTO chat : contents) {
            MaterialCard card = createCard(chat);


            if (colCount == 1) {
                row = new MaterialRow();
                htmlPanel.add(row);
                ++colCount;
                if (colCount >= 4) {
                    colCount = 1;
                }
            }

            MaterialColumn col = new MaterialColumn();
            col.setGrid("l4");
            row.add(col);

            col.add(card);
        }
    }

    @Override
    public void clearView() {
        htmlPanel.clear();
    }


}


