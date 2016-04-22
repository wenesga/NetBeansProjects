package br.com.vendadireta.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @Cometario: Fábrica de sessões para o Hibernate conectar com o bando
 * @author Wenes Gomes Aquino <wenesga@gmail.com>
 * @date 02/04/2016 - Classe: HibernateUtil
 */
public class HibernateUtil {

    private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

    public static SessionFactory getFabricaDeSessoes() {
        return fabricaDeSessoes;
    }

    private static SessionFactory criarFabricaDeSessoes() {
        try {
            Configuration configuracao = new Configuration().configure();

            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

            SessionFactory fabrica = configuracao.buildSessionFactory(registro);

            return fabrica;
        } catch (Throwable ex) {
            System.err.println("A fábrica de sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
