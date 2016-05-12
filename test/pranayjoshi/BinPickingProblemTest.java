/**
 * 
 */
package pranayjoshi;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author PJoshi
 *
 */
public class BinPickingProblemTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private BinPickingProblem binPickingProblem;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 BasicConfigurator.configure();
		binPickingProblem = new BinPickingProblem();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link pranayjoshi.BinPickingProblem#getMinimumBinRequired(int[], int)}.
	 */
	@Test
	public void testGetMinimumBinRequired1() {
		int[] weights = {4, 8, 1, 4, 2, 1};
		int requiredBin = binPickingProblem.getMinimumBinRequired(weights, 10);
		assertEquals(2, requiredBin);
	}
	
	@Test
	public void testGetMinimumBinRequired2() {
		int[] weights = {9, 8, 2, 2, 5, 4};
		int requiredBin = binPickingProblem.getMinimumBinRequired(weights, 10);
		assertEquals(4, requiredBin);
	}
	
	@Test
	public void testGetMinimumBinRequired3() {
		int[] weights = {2, 5, 4, 7, 1, 3, 8}; 
		int requiredBin = binPickingProblem.getMinimumBinRequired(weights, 10);
		assertEquals(3, requiredBin);
	}
	
	@Test
	public void testGetMinimumBinRequiredNishantTestCase() {
		int[] weights = {6,5,4,4,3,2}; 
		int requiredBin = binPickingProblem.getMinimumBinRequired(weights, 12);
		assertEquals(2, requiredBin);
	}

}
