package meinetests;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

import de.heckenmann.meinebeans.MeineBean;

public class Test1 extends Arquillian {

    @Deployment
    public static JavaArchive getArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(Test1.class, MeineBean.class).addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private MeineBean meineBean;

    @Test
    public void testNull() {
        Assert.assertNotNull(meineBean);
    }

    @Test
    public void testHello() {
        Assert.assertEquals(meineBean.sagHallo("Tom"), "Hallo Tom");
    }

    @Test
    public void testHello2() {
        Assert.assertNotEquals(meineBean.sagHallo("Tom "), "123");
    }

    /*
	 * GETTER & SETTER
     */
    public MeineBean getMeineBean() {
        return meineBean;
    }

    public void setMeineBean(MeineBean meineBean) {
        this.meineBean = meineBean;
    }
}
