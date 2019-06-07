package tests.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import steps.account.CustomerCreationSteps;
import steps.account.CustomerSteps;
import steps.account.LoginSteps;
import steps.account.MyAccountNavigationSteps;
import steps.api.APICustomerMagentoSteps;
import steps.api.APICustomerOSCSteps;
import steps.api.APIEventsAppsSteps;
import steps.header.HeaderSteps;
import tools.entities.CustomerMagento;
import tools.entities.CustomerOSC;
import tools.factory.UserFactory;
import tools.models.UserModel;

@RunWith(SerenityRunner.class)

public class API0011CheckCustomerDetailsInOSCTest extends BaseApiTest {

	@Steps
	LoginSteps loginSteps;
	@Steps
	HeaderSteps headerSteps;
	@Steps
	CustomerSteps customerSteps;
	@Steps
	CustomerCreationSteps customerCreationSteps;
	@Steps
	MyAccountNavigationSteps myAccountNavigationSteps;
	@Steps
	APICustomerOSCSteps APICustomerOSCSteps;
	@Steps
	APICustomerMagentoSteps aPICustomerMagentoSteps;
	@Steps
	APICustomerOSCSteps apiCustomerOSCSteps;
	@Steps
	APIEventsAppsSteps apiEvents;

	// String oscID = "652362";

	public UserModel user;
	public String oscID;

	@Before
	public void dataSetup() {
		// user = UserFactory.getUserInstance();
		CustomerMagento cm = aPICustomerMagentoSteps.createMagentoCustomer();
		System.out.println(cm);
		apiEvents.triggerCustomerChange(cm.getId());
		oscID = apiCustomerOSCSteps.getOSCUserId(cm.getEmail());
	}

	@Test
	public void checkCustomerDetailsOSC() {

		
		 /*loginSteps.openMagentoPage();
		 headerSteps.selectFromAccount("Login");*/
		 /*customerCreationSteps.createUser(user);
		 
		 myAccountNavigationSteps.clickAccountInformation();
		 customerSteps.editAcountInformation(user);*/
		 
		CustomerOSC customerOSC = APICustomerOSCSteps.getCustomerById(oscID);
		System.out.println(customerOSC);
		APICustomerOSCSteps.verifyCustomerMagentoToOSC(user, customerOSC);
	}
}