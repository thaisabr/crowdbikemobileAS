package com.example.crowdbikemobile.test;

import android.widget.Spinner;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class SendMyLocationTest extends UiAutomatorTestCase {
	public void test() throws UiObjectNotFoundException {
		addNewIssue();
		sendIssue("");
	}

	private void addNewIssue() throws UiObjectNotFoundException {
		UiObject newIssueButton = new UiObject(new UiSelector().resourceId("@+id/btn_send_notification"));
		newIssueButton.clickAndWaitForNewWindow();
	}

	private void sendIssue(String spinnerOption) throws UiObjectNotFoundException {

		UiObject newSpinnerType = new UiObject(new UiSelector().resourceId("@+id/menu_spinner"));
		newSpinnerType.click();
		UiScrollable issueOptions = new UiScrollable(new UiSelector().scrollable(true));
		UiObject issue = issueOptions.getChildByText(new UiSelector().className("android.widget.CheckedTextView"), spinnerOption);
		issue.click();

		UiObject newSendButton = new UiObject(new UiSelector().className(android.widget.ImageButton.class.getName()));
		newSendButton.clickAndWaitForNewWindow();
	}
}
