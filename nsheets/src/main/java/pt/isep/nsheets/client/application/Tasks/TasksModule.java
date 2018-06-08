/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.application.Tasks;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author dftsf
 */
public class TasksModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(TasksPresenter.class,
                TasksPresenter.MyView.class, TasksView.class,
                TasksPresenter.MyProxy.class);
    }
}
