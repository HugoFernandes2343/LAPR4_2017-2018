package eapli.framework.authz;

/**
 * TODO should this interface exist? This interface would enforce authorisation
 * over actions on the UI.
 *
 * Created by nuno on 20/03/16.
 */
public interface Authorisable<T> {

    public boolean isAuthorizedTo(T action);
}
