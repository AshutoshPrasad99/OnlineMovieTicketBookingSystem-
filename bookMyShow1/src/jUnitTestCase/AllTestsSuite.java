package jUnitTestCase;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminDaoTest.class, AdminServiceTest.class, CustomerDaoTest.class, CustomerServiceTest.class,
		UserDaoTest.class, UserServiceTest.class })
public class AllTestsSuite {

}
