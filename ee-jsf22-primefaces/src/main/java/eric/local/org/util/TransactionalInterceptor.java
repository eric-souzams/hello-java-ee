package eric.local.org.util;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Interceptor
@Transactional
@Priority(Interceptor.Priority.APPLICATION) //para não precisar inserir o interceptor la no beans.xml
public class TransactionalInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        boolean criador = false;

        try {
            if (!transaction.isActive()) {
                transaction.begin(); //fazer rollback em tudo que já passou
                transaction.rollback(); // evitar fazer commits que não precisam de transação

                transaction.begin(); //começar a transação
                criador = true;
            }

            return context.proceed();
        } catch (Exception exception) {
            if (transaction != null && criador) {
                transaction.rollback();
            }
            throw exception;
        } finally {
            if (transaction != null && transaction.isActive() && criador) {
                transaction.commit();
            }
        }
    }

}
