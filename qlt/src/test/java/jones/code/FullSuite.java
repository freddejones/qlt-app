package jones.code;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { TestSuiteInputHandler.class,
	TestSuiteTimerTest.class,
	TestSuiteQLTimerHandler.class,
	TestQLPickupItem.class,
	TestQLPickupItemsHandler.class})
public class FullSuite extends TestSuite {
}
