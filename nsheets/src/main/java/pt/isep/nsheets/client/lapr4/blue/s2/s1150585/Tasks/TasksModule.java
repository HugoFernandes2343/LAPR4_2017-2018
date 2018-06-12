/**
 * Date Created: 7/jun/2018
 *
 */
package pt.isep.nsheets.client.lapr4.blue.s2.s1150585.Tasks;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 *
 * @author Daniel Fernandes 1150585
 */
public class TasksModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        bindPresenter(TasksPresenter.class,
                TasksPresenter.MyView.class, TasksView.class,
                TasksPresenter.MyProxy.class);
    }
}
