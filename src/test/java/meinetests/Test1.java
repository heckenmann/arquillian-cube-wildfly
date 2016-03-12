package meinetests;

import javax.inject.Inject;

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
	
	@Inject
	private MeineBean meineBean;
	
	@Test
	public void testHello() {
		Assert.assertNotNull(meineBean);
	}
}
