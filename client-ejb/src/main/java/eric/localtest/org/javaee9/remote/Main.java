package eric.localtest.org.javaee9.remote;

import org.javaee9.ejb.models.Product;
import org.javaee9.ejb.services.EjbServiceRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {

    public static void main(String[] args){

        final Properties env = new Properties();
        EjbServiceRemote service = null;

//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        env.put("jboss.naming.client.ejb.context", true);

        try {
            InitialContext remoteContext = new InitialContext(env);
            service = (EjbServiceRemote) remoteContext.lookup("ejb:/ejb-remote/EjbService!org.javaee9.ejb.services.EjbServiceRemote");

            String test = service.test();
            System.out.println(test);

            Product pen = service.save(new Product("Pen"));
            System.out.println(pen);

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

}
